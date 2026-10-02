from argparse import ArgumentParser, Namespace
from os.path  import isfile
from typing   import TextIO, List

def gestionDesArguments()-> Namespace :
    """ Gestion des arguments via argparse

    Returns:
        ArgumentParser: 
    """

    parser : ArgumentParser = ArgumentParser()
    parser.add_argument("nomFichier",      help="Chemin vers un fichier PCC")
    parser.add_argument("-v", "--verbose", help="Activation du mode verbeux", action="store_true")
    
    return parser.parse_args()

if __name__ == "__main__":
        
    arguments : Namespace = gestionDesArguments()
    
    nomFichier  : str = arguments.nomFichier
    modeVerbeux : str = arguments.verbose
    
    print()
    print("Configuration:")
    print("\tChemin vers le fichier PCC =",nomFichier)
    print("\tMode verbeux               =",modeVerbeux)
    
    print()
    
    if not isfile(nomFichier):
        print(f"{nomFichier} n'est pas un nom de fichier valide")
        exit(10)
    
    description : TextIO = open(nomFichier)
    ligne : str = ""
    for ligne in description:
        valeurs : List[str] = ligne.split()
        if modeVerbeux:
            valeur : str = ""
            for valeur in valeurs:
                print(valeur,end=" ")
            print()
    description.close()
        
    exit(0)