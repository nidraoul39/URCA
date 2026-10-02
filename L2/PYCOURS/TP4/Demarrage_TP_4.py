# On importe le parser qui va analyser sys.argv et le type Namespace
from argparse import ArgumentParser, Namespace

# On importe ce qu'il faut pour tester l'existence d'un fichier
# et pour extraire le nom de fichier d'un chemin
from os.path import isfile, basename, splitext

# On importe sys pour afficher la version de Python utilisée
import sys

import math

def check_extension(parser : ArgumentParser, parameter : str, authorized_extensions : list[str]) -> str : 
    """ Tool function for an instance of ArgumentParser

    Args:
        parser (ArgumentParser): the current instance of ArgumentParser (no global variable)
        parameter (str): the current value to check
        authorized_extensions (list[str]): list of valid extensions with the forme ".name"

    Returns:
        str: parameter if valid
    """
    extension = splitext(parameter)[1]

    if not extension in authorized_extensions:
        parser.error(f"The extension {extension} is not valid, only these ones are authorized {authorized_extensions}")
   
    return parameter

def manageArguments() -> Namespace:
    """ Tool function to manage the arguments with the argparse library
    
        Returns:
            Namespace: the couples name/value of the parameters (from sys.argv)
    """

    # Initialisation du parser d'arguments
    parser : ArgumentParser = ArgumentParser()

    # Création d'un paramètre obligatoire (pas de -) qui sera un str (c'est le type par défaut)
    # Remarquez l'option type qui appelle une méthode spécifique
    # en vrai, type peut prendre n'importe quoi de "callable" (fonction)
    # qui prend un str en entrée et renvoie une valeur en sortie
    # c'est l'occasion de faire des tests et lancer une exception au besoin
    # lambda sert juste à cacher une déclaration complémentaire
    # ce qui est après lambda est une fonction anonyme jetable
    parser.add_argument("database",
                        help="Path to a WFX file",
                        type=lambda p:check_extension(parser,p,[".wfx"])
                        )
    
    # Création d'une option booléenne (option courte avec un - et/ou option longue avec --)
    # d'après le paramètre action, si l'option est fournie, sa valeur est True sinon False
    parser.add_argument("-v", "--verbose",
                        help="Activating verbose mode",
                        action="store_true")

    # On retourne le resultat du parsing
    # C'est l'appel à parse_args qui déclenche l'analyse de sys.argv
     # La structure obtenue est un namespace (espace de nom)
    return parser.parse_args()

def chercherelement(name,fichier):
    position : int = -1

    with open(fichier) as file:

        while line := file.readline():
            if f"<{name}>" in line:
                position=file.tell()
                break
    return position

def afficherelement(position,fichier):
    with open(fichier) as file:

        # Si position a été fixée (au moins au début)
        if position >= 0:            
            # Je mets déplace sur la position choisie
            file.seek(position)
            # Je lis la prochaine ligne
            print(f"The content of the line next to <{section_name}> is:")
            data = file.readline().replace("\n"," ")
            print(f"==>{data}<==")
            return data
        else:
            print("cette balise existe pas ! ")
        


def recup(x,database):
    with open(database) as file:
        prim = []

        line = file.seek(chercherelement(x,database))
        for i in range(math.ceil(data[2]/5)):
            if line := file.readline():
                temp = [int(k) for k in line.split()]
                for k in temp:
                    prim.append(k)

        return prim

# Code principal
if __name__ == "__main__":

    # Les 3 premiers éléments du tuple version_info
    # sont les versions majeure, mineure et micro de l'installation
    # tout le reste est anonyme donc en _
    major, minor, micro, *_ = sys.version_info
   

    print()
    print(f"Current version of Python: {major}.{minor}.{micro}")
    print()

    # arguments contient le résultat du parsing    
    arguments : Namespace = manageArguments()

    # le nom à utiliser est celui du/des paramètre(s) obligatoire(s) ou le nom long de l'/des options
    database     : str  = arguments.database
    verbose_mode : bool = arguments.verbose
      
    print()
    print("Configuration:")
    print("\tWFX file name =",basename(database))
    print("\tVerbose mode  =",verbose_mode)
    print()
     
    if not isfile(database):
        print(f"{database} is not a valid file name.")
        exit(10)

    section_name : tuple = ("Number of Nuclei","Number of Occupied Molecular Orbitals","Number of Primitives")
    elmentchercher= {}
    data = []
    for i in section_name:
        elmentchercher[i] = int(chercherelement(i,database))
        data.append(int(afficherelement(elmentchercher[i],database)))
    print(data)
    print(elmentchercher)
    name = []
    dictionnairecoordonne = {}
    with open(database) as file:

        line = file.seek(chercherelement("Nuclear Names",database))
        for i in range(data[0]):
            if line := file.readline():
                name.append(line.replace(" ","").replace("\n",""))

        line = file.seek(chercherelement("Nuclear Cartesian Coordinates",database))
        for i in range(data[0]):
            if line := file.readline():
                dictionnairecoordonne[name[i]] = [float(k) for k in line.split()]

    
        # fonction car possible ici
        primitivecentre = recup("Primitive Centers",database)
        primitivetypes = recup("Primitive Types",database)

        ''' le type change on est en float plus en int j'y pense maintant mais manque de temps
        jaurais pu faire une fonction pour tous et apres faire mon grand tableau et enfin bouclé
        pour transformer en int int et float'''
         
        primitiveexpo =[]
        line = file.seek(chercherelement("Primitive Exponents",database))
        for i in range(math.ceil(data[2]/5)):
            if line := file.readline():
                temp = [float(k) for k in line.split()]
                for k in temp:
                    primitiveexpo.append(k)
        primitive = []
        for i in range(data[2]):
            primitive.append([primitivecentre[i],primitivetypes[i],primitiveexpo[i]])

    
    print(name)
    print(dictionnairecoordonne)
    print(primitive)
    sys.exit(0)