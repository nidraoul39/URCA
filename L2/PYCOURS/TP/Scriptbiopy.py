from Bio.PDB import PDBParser


parser = PDBParser()
structure = parser.get_structure("PHA-L", "7jrh.pdb")

Atom = structure.get_atoms()
try:
    file = open("RES2","w")
except PermissionError :
    print("erreur pas les permission nécéssaire")
    exit(3)


for i in Atom:
    file.write(i.get_name()+" "+(((str(i.get_coord())).strip("[")).strip("]").strip(" "))+"\n")

