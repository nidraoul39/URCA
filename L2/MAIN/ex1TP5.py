"""
TP5 - Exercice 1 : Répartition des notes dans « Au clair de la lune »
Statistiques pour l'Informatique (MAINO0301) - Mme I. Yahiaoui
"""

import numpy as np
import matplotlib.pyplot as plt

# 1. Échantillon issu de la chaîne de caractères
partition = "Do Do Do Ré Mi Mi Ré Do Ré Mi Fa Fa Fa Mi Ré Mi Fa Sol Sol Sol Mi Fa Sol La Sol Fa Mi Ré Do Do Do"
echantillon = np.array(partition.split())
print("1. Échantillon :")
print(echantillon)

# 2. Modalités et effectifs avec np.unique()
modalites, effectifs = np.unique(echantillon, return_counts=True)
print("\n2. Modalités et effectifs :")
print("Modalités :", modalites)
print("Effectifs :", effectifs)

# 3. Fréquences et pourcentages
total = np.sum(effectifs)
frequences = effectifs / total
pourcentages = frequences * 100

print("\n3. Fréquences et pourcentages :")
print("Fréquences :", np.round(frequences, 4))
print("Pourcentages (%) :", np.round(pourcentages, 2))

# 4. Assemblage avec np.column_stack()
tableau_statistique = np.column_stack((
    modalites,
    effectifs.astype(str),
    np.round(frequences, 4).astype(str),
    np.round(pourcentages, 2).astype(str)
))

# 5. Affichage du tableau statistique
print("\n5. Tableau statistique :")
print(f"{'Note':<10} {'Effectif':<10} {'Fréquence':<12} {'Pourcentage (%)':<15}")
print("-" * 50)
for ligne in tableau_statistique:
    print(f"{ligne[0]:<10} {ligne[1]:<10} {ligne[2]:<12} {ligne[3]:<15}")
print("-" * 50)
print(f"{'Total':<10} {total:<10} {np.sum(frequences):<12.2f} {np.sum(pourcentages):<15.2f}")

# 6. Identifier le mode avec np.argmax()
idx_mode = np.argmax(effectifs)
print(f"\n6. Mode (np.argmax) : {modalites[idx_mode]} (effectif = {effectifs[idx_mode]})")

# 7. Identifier tous les modes avec np.where() et np.max()
max_eff = np.max(effectifs)
indices_modes = np.where(effectifs == max_eff)[0]
modes = modalites[indices_modes]
print(f"7. Tous les modes (np.where + np.max) : {modes} (effectif maximal = {max_eff})")

# 8. Représentation graphique Matplotlib
plt.figure(figsize=(12, 5))

# Tuyaux d'orgues (barres)
plt.subplot(1, 2, 1)
plt.bar(modalites, effectifs, color="skyblue", edgecolor="navy")
plt.title("Diagramme en tuyaux d'orgues (Notes)")
plt.xlabel("Notes")
plt.ylabel("Effectif")
plt.grid(axis="y", linestyle="--", alpha=0.7)

# Diagramme circulaire
plt.subplot(1, 2, 2)
plt.pie(effectifs, labels=modalites, autopct="%1.1f%%", startangle=90)
plt.title("Diagramme circulaire (Proportions)")

plt.tight_layout()
plt.show()