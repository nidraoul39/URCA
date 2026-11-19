"""
TP5 - Exercice 3 : Nombre d'erreurs d'exécution (variable quantitative discrète)
Statistiques pour l'Informatique (MAINO0301) - Mme I. Yahiaoui
"""

import numpy as np
import matplotlib.pyplot as plt

# 1. Échantillon de 20 musiciens (valeurs entières de 0 à 4 inclus)
np.random.seed(42)  # Reproductibilité
echantillon = np.random.randint(0, 5, size=20)
print("1. Échantillon du nombre d'erreurs :")
print(echantillon)

# 2. Modalités, effectifs, fréquences et pourcentages
modalites, effectifs = np.unique(echantillon, return_counts=True)
total = np.sum(effectifs)
frequences = effectifs / total
pourcentages = frequences * 100

# 3. Cumuls avec np.cumsum()
effectifs_cum = np.cumsum(effectifs)
frequences_cum = np.cumsum(frequences)
pourcentages_cum = np.cumsum(pourcentages)

# 4. Assemblage dans un tableau 2D et affichage
tableau_statistique = np.column_stack((
    modalites,
    effectifs,
    np.round(frequences, 4),
    np.round(pourcentages, 2),
    effectifs_cum,
    np.round(frequences_cum, 4),
    np.round(pourcentages_cum, 2)
))

print("\n4. Tableau statistique :")
print(f"{'Erreurs':<8} {'Eff.':<6} {'Fréq.':<8} {'Pourc.(%)':<11} {'Eff.Cum':<10} {'Fréq.Cum':<10} {'Pourc.Cum(%)':<14}")
print("-" * 70)
for ligne in tableau_statistique:
    print(f"{int(ligne[0]):<8} {int(ligne[1]):<6} {ligne[2]:<8.4f} {ligne[3]:<11.2f} "
          f"{int(ligne[4]):<10} {ligne[5]:<10.4f} {ligne[6]:<14.2f}")
print("-" * 70)

# 5. Mesures statistiques
print("\n5. Mesures statistiques :")
print(f"Minimum             : {np.min(echantillon)}")
print(f"Maximum             : {np.max(echantillon)}")
print(f"Moyenne             : {np.mean(echantillon):.2f}")
print(f"Médiane             : {np.median(echantillon):.2f}")
print(f"Variance            : {np.var(echantillon):.4f}")
print(f"Écart-type          : {np.std(echantillon):.4f}")
print(f"1er quartile (Q1)   : {np.percentile(echantillon, 25):.2f}")
print(f"2ème quartile (Q2)  : {np.percentile(echantillon, 50):.2f}")
print(f"3ème quartile (Q3)  : {np.percentile(echantillon, 75):.2f}")

# 6. Représentations graphiques (plt.bar et plt.boxplot)
plt.figure(figsize=(12, 5))

# Diagramme en bâtons
plt.subplot(1, 2, 1)
plt.bar(modalites, effectifs, width=0.4, color="teal", edgecolor="black")
plt.title("Diagramme en bâtons (Nombre d'erreurs)")
plt.xlabel("Nombre d'erreurs")
plt.ylabel