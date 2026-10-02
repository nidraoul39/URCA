# le mode = film d'action
modalite = ("action","comedie","drame","science-fiction","romance")
stat = {"action":[500*0.45,0.45,45],"comedie":[500*0.16,0.16,16],"drame":[500*0.088,0.088,8.8],"science-fiction":[500*0.222,0.222,22.2],"romance":[500*0.08,0.08,8]}
def afficher(stat):
    return "effectif : "+str(stat[0])+" frequance : "+str(stat[1])+" frequance en pourcentage : "+str(stat[2])+"%"

for k in modalite:
    print(k+" : "+afficher(stat[k]))

import matplotlib.pyplot as plt
# Création du diagramme à bandes
data = [stat[k][0] for k in modalite] # Exemple d'un tableau des effectifs
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