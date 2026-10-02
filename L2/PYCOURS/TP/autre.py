from collections import Counter


# def distance(pointa,pointb): 
# pas le temps



ligne = []
nAtom = []
point = []
x = 0
with open("resultat","r") as file:
    for i in file:
        ligne.append([k for k in i.split()])
        nAtom.append(ligne[x][0])
        point.append((ligne[x][1],ligne[x][2],ligne[x][3]))
        x+=1
    print("il y a "+ str(len(ligne))+" atome")
    compter = Counter(nAtom) #https://www.geeksforgeeks.org/python/counters-in-python-set-1/
    for element,total in compter.items():
        print(f"{total} -> {element}")
lsblk