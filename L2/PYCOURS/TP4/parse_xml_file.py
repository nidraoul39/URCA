from argparse import ArgumentParser, Namespace
from os.path import isfile, splitext

import xml.etree.ElementTree as ET

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

def print_node(root: ET.Element, depth: int, max_dept: int, verbose: bool = False):
    """ Print the information of a specific node in a XML file

    Args:
        root (ET.Element): The current node to analyse
        depth (int): The current depth in the parsing process
        max_dept (int): The max authorized depth
        verbose (bool, optional): print more data about the current node if True. Defaults to False.
    """

    if depth > max_dept:
        return
    
    for node in root:
        print(f"{depth:>{depth}}",end=" ")
        if verbose:
            print(f"{node.tag} {node.text}".strip())
        else:
            print(f"{node.tag}")
        print_node(node,depth+1, max_dept,verbose)

def parse_file(file_name: str, max_depth: int, verbose: bool = False):
    """ Tool method to launch the parsing

    Args:
        file_name (str): The XML file
        max_depth (int): The maximum authorized depth
        verbose (bool, optional): Activation of verbose mode. Defaults to False.
    """
    print_node(ET.parse(file_name).getroot(),1, max_depth,verbose)

def manageArguments() -> Namespace:
    parser: ArgumentParser = ArgumentParser()
    parser.add_argument("database",
                        help="Path to a XML file",
                        type=lambda p:check_extension(parser,p,[".xml"]))
    parser.add_argument("-v", "--verbose", help="Activating verbose mode", action="store_true")
    parser.add_argument("-d", "--max_depth",   help="Indicate the maximum depth for the parsing", type=int, default=2)
    
    return parser.parse_args()

if __name__ == "__main__":
        
    arguments    : Namespace = manageArguments()
    
    database     : str  = arguments.database
    verbose_mode : bool = arguments.verbose
    max_depth    : int  = arguments.max_depth
        
    print()
    print("Configuration:")
    print("\tXML file name =",database)
    print("\tVerbose mode  =",verbose_mode)
    print("\tDepth         =",max_depth)
    print()
    
    if not isfile(database):
        print(f"{database} is not a valid file name.")
        exit(10)
        
    parse_file(database, max_depth, verbose_mode)
    
    exit(0)
