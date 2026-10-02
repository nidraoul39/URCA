# On importe le parser qui va analyser sys.argv
from argparse import ArgumentParser

# On importe ce qu'il faut pour tester l'existence d'un fichier
from os.path  import isfile 

# Pour le FASTA, c'est SeqIO (de Biopython) notre meilleur ami
from Bio import SeqIO

from os import makedirs
import csv
import re
import datetime as dt

# Gestion automatisée des arguments
# C'est une fonction sans paramètre
def manageArguments():
    # Initialisation du parser d'arguments
    parser = ArgumentParser()

    # Création d'un paramètre obligatoire (pas de -) qui sera un str (c'est le type par défaut)
    parser.add_argument("filename",        help="Path to a FASTA file")

    # Création d'une option booléenne (option courte avec un - et/ou option longue avec --)
    # d'après le paramètre action, si l'option est fournie, sa valeur est True sinon False
    parser.add_argument("-v", "--verbose", help="Activating verbose mode", action="store_true")

    parser.add_argument("--minN",help="option qui permet à l'utilisateur d'indiquer un filtre sur le nombre d'acides aminées minimal des séquences qu'il cherche" , type=int)
    parser.add_argument("--specie",help="option qui permet à l'utilisateur d'indiquer un filtre d'espèce dans ces recherches",type=str)
    parser.add_argument("--maxN",help="option qui permet à l'utilisateur d'indiquer un filtre sur le nombre d'acides aminées maximal des séquences qu'il cherche", type=int)
    parser.add_argument("--minW",help="minimum poids",type=float)
    parser.add_argument("--maxW",help="maximum de poids",type=float)
    # On retourne le resultat du parsing
    # C'est l'appel à parse_args qui déclenche l'analyse de sys.argv
    # La structure obtenue est un namespace (espace de nom)
    return parser.parse_args()

# Code principal
if __name__ == "__main__":

    # arguments contient le résultat du parsing
    options = manageArguments()

    # le nom à utiliser est celui du/des paramètre(s) obligatoire ou le nom long de l'/des options
    filename      = options.filename
    verbose_mode  = options.verbose
    minN          = options.minN
    maxN          = options.maxN
    specie        = options.specie
    minW          = options.minW
    maxW          = options.maxW
    
    makedirs("./log", exist_ok=True)
    try:
        logs = open("./log/"+dt.datetime.now().strftime("%Y%m%d-%H%M%S")+".log","w")
    except PermissionError:
        print("erreur de permission sur les fichier")
        exit(1)    


    config = (
        f"Configuration: \n\tFasta file name = {filename} \n\tVerbose mode = {verbose_mode} \n\t "
        + (f"le minimum est {minN}" if minN is not None else " ")
        + (f"le maximum est {maxN}" if maxN is not None else " ")
        + (f"{specie} est spécifié " if specie is not None else "")
        + (f"{minW} est le poids minimum accepté " if minW is not None else "")
        + (f"{maxW} est le poids maximum accepté " if maxW is not None else "")
    )
    print(config)
    logs.write(config+"\n")
    # \t rajoute une tabulation à l'affichage
    # On aurait pu écrire print(f"\tFASTA file name = {filename}")

    # verbose un paramètre qui existe toujours (True ou False)
    # par contre, un paramètre sans valeur par défaut n'existerait pas
    # dans l'espace de nom et vaudrait None s'il n'était pas fourni par l'utilisateur

    
    # verif des parametre : 

    if minN is not None and maxN is not None :
        if minN>maxN:
            errormin =" Erreur le minimum est supérieur au maximum !! "
            print(errormin)  
            logs.write(errormin+" : erreur de parametre : Le programme c'est donc arreter")
            exit(10)

    if minW is not None and maxW is not None :
        if minW>maxW:
            errorminw =" Erreur le minimum poids est supérieur au maximum  poids!! "
            print(errorminw)  
            logs.write(errorminw+" : erreur de parametre : Le programme c'est donc arreter")
            exit(10)



    # Si le résultat de isfile est faux ... ==> on arrête là
    if not isfile(filename):
        print(f"{filename} is not a valid file name")
        logs.write(f"{filename} est pas un fichier présent sur le system Le programme c'est donc arreter")
        exit(10)
    # Pour log
    n = 0
    

    # Dictionnaire des poids atomiques fournis
    poids_atomes = {"H" : 1.0078, "C" : 12.011, "N" : 14.007, "O" : 15.999, "S" : 32.065}

    def calculer_poids(formule):
        elements = re.findall(r'([A-Z][a-z]?)([0-9]*)', formule)
        total = 0
        for atome, quantite in elements:
            nombre = int(quantite) if quantite else 1
            total += poids_atomes[atome] * nombre
            
        return round(total)

    masseM = {}

    # Ouvrir et lire le fichier CSV
    with open('aa.csv', 'r') as fichier:
        lecteur = csv.reader(fichier, delimiter=',')
        next(lecteur, None)  
        
        for ligne in lecteur:
            if len(ligne) >= 4:
                nom_court = ligne[0]  
                formule = ligne[3]   
                masseM[nom_court] = calculer_poids(formule)




    # On lance la lecture en mode FASTA
    # avec numérotation <=> merci enumerate
    for index, entry  in enumerate(SeqIO.parse(filename,"fasta")):
        long = len(entry.seq)
        if minN is not None:
            if long<minN:
                continue

        if maxN is not None:
            if long>maxN:
                continue
        
        if specie is not None:
            if specie not in entry.description:
                continue
        poids=sum([masseM[entry.seq[i]] for i in range(long)])
        if minW is not None:
            if minW>poids:
                continue
        if maxW is not None:
            if maxW>poids:
                continue
        

        # on affiche l'identifiant de chaque entrée précédé de sa position dans la base de données
        # attention l'affichage est décalé de 1
        print(f"Entrée {index+1} : {entry.id}")
        
        # si le mode verbose est activé
        # le test est équivalent à : versbose_mode == True
        if verbose_mode:

            # Affichage de la description complète
            print(f"\tDescription : {entry.description}")

            # Affichage de la séquence
            print(f"\tSequence    : {entry.seq}")

        # Une ligne vide pour séparer les entrées
        print()
        logs.write(entry.id+"\n")
        n+=1
    
    logs.write(f"il y a {n} élément qui ont élé lue ! ")
    # Tout s'est bien passé
    exit(0)