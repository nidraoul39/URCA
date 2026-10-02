import random

def afficher(stat):
    return "effectif : "+str(stat[0])+" frequance : "+str(stat[1])+" frequance en pourcentage : "+str(stat[2])+"%"


modalite = ("voiture","transport en commun","velo","moto","trottinette","pied")
echantillon = random.choices(modalite, k=100,weights=[random.randint(0,100) for k in range(len(modalite))])
print(echantillon)
statistique = dict()
for i in modalite:
    print(i)
    n = echantillon.count(i)
    statistique[i] = [n,n/len(echantillon),n/len(echantillon)*100]

for i in modalite:
    print(i+" "+afficher(statistique[i]))


import matplotlib.pyplot as plt
# Création du diagramme à bandes
data = [statistique[k][0] for k in modalite] # Exemple d'un tableau des effectifs
plt.figure(figsize=(8, 4)) # Taille de la figure
plt.bar(modalite,data, color='blue') # Création des 
# Ajout de titres et labels
plt.title('transport')
plt.ylabel ("les effectifs ni")
plt.xticks(range(len(data)),modalite)
# Affichage du diagramme
plt.show()

import matplotlib.pyplot as plt
# Création du diagramme circulaire
plt.figure(figsize=(8, 4)) # Taille de la figure
plt.pie(data,labels=modalite,autopct='%1.1f%%') # création du camembert
# Ajout du titre
plt.title('diagramme rond')
# Affichage du diagramme
plt.show()