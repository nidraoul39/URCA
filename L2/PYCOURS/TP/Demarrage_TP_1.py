# On va utiliser des méthodes du module sys
import sys
# On récupère le nom de fichier donné en argument
# en ligne de commande depuis la liste argv
try : 
    file_name = sys.argv[1]
except IndexError:
    print("il manque un argument ")
    exit(1)

# On récupère une tête de lecture sur le fichier file_name
try :
    file = open(file_name)
except FileNotFoundError:
    print("impossible d'ouvrir le fichier nom incorrect ")
    exit(2)

Atome = []
Hetatm = []
Tous = []
i = 0
k=0
# On parcours le fichier file_name ligne à ligne ==> str
for line in file:
    # Si le str line commence par la chaîne ATOM
    if line.startswith("ATOM"):
        Atome.append(line.strip())
        Tous.append((str(Atome[i][12:16]).strip(" ") ,str(Atome[i][30:37]).strip(" "),str(Atome[i][38:45]).strip(" ") ,str(Atome[i][46:54]).strip(" ") ))
        print(Atome[i])
        i+=1
    if line.startswith("HETATM"):

        Hetatm.append(line.strip())
        print(Hetatm[k])
        Tous.append((str(Hetatm[k][12:16]).strip(" ") ,str(Hetatm[k][30:37]).strip(" ") ,str(Hetatm[k][38:45]).strip(" ") ,str(Hetatm[k][46:54]).strip(" ") ))
        k+=1


try : 
    file2 = open("resultat","w")
except PermissionError:
    print("erreur impossible de crée le fichier pas les permission nécéssaire")
    exit(3)

for i in Tous:
    k =i[0]+" "+i[1]+" "+i[2]+" "+i[3]
    file2.write(k+"\n")
    