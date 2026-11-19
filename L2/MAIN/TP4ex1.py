import math
import random
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from scipy.stats import chi2_contingency

# ==============================================================================
# Question 1 : Échantillon
# ==============================================================================
random.seed(42)  # graine fixée pour reproductibilité
N = random.randint(500, 1000)
echantillon = [[random.randint(10, 70), random.randint(0, 100)] for _ in range(N)]
df = pd.DataFrame(echantillon, columns=['Prix', 'Unites'])

# ==============================================================================
# Question 2 : Classes et centres (Règle de Yule)
# Les variables Prix (X) et Unités (Y) sont quantitatives continues/discrètes à large étendue.
# ==============================================================================
k = math.ceil(2.5 * (len(df) ** 0.25))

# Bornes régulières
bornes_x = np.linspace(df['Prix'].min(), df['Prix'].max(), k + 1)
bornes_y = np.linspace(df['Unites'].min(), df['Unites'].max(), k + 1)

# Centres de classes : (borne_inf + borne_sup) / 2
centres_x = [round((bornes_x[i] + bornes_x[i + 1]) / 2, 2) for i in range(k)]
centres_y = [round((bornes_y[i] + bornes_y[i + 1]) / 2, 2) for i in range(k)]

df['X_classe'] = pd.cut(df['Prix'], bins=bornes_x, labels=centres_x, include_lowest=True)
df['Y_classe'] = pd.cut(df['Unites'], bins=bornes_y, labels=centres_y, include_lowest=True)

# ==============================================================================
# Question 3 : Structure de données adéquate
# Choix : pd.DataFrame (ou matrice numpy 2D indexée).
# Motivation : indexation explicite par les centres de classes, calculs vectorisés,
# fonctions natives de calcul de marges, fréquences et filtrage conditionnel.
# ==============================================================================

# ==============================================================================
# Question 4 : Tableau des effectifs n_ij
# ==============================================================================
tab_nij = pd.crosstab(df['X_classe'], df['Y_classe'])

# ==============================================================================
# Question 5 : Tableau des fréquences f_ij = n_ij / N
# ==============================================================================
tab_fij = pd.crosstab(df['X_classe'], df['Y_classe'], normalize=True)

# ==============================================================================
# Question 6 : Séries marginales
# ==============================================================================
# Marges en effectifs
n_i_point = tab_nij.sum(axis=1)  # effectifs marginaux de X
n_point_j = tab_nij.sum(axis=0)  # effectifs marginaux de Y

# Marges en fréquences
f_i_point = tab_fij.sum(axis=1)  # fréquences marginales de X
f_point_j = tab_fij.sum(axis=0)  # fréquences marginales de Y

# ==============================================================================
# Question 7 : Étude statistique des séries marginales
# ==============================================================================
def stats_marginale(valeurs, effectifs, nom):
    valeurs = np.array(valeurs, dtype=float)
    total_eff = effectifs.sum()
    
    moyenne = np.sum(valeurs * effectifs) / total_eff
    variance = np.sum(effectifs * (valeurs - moyenne) ** 2) / total_eff
    ecart_type = np.sqrt(variance)
    
    print(f"--- Statistique marginale de {nom} ---")
    print(f"Moyenne : {moyenne:.2f}")
    print(f"Variance : {variance:.2f}")
    print(f"Écart-type : {ecart_type:.2f}\n")

stats_marginale(centres_x, n_i_point, "X (Prix)")
stats_marginale(centres_y, n_point_j, "Y (Unités)")

# ==============================================================================
# Question 8 : Série conditionnelle X / (Y = y_j)
# ==============================================================================
def etude_conditionnelle_X_sachant_Y(j):
    # j correspond à l'index de la modalité de Y
    modalite_y = centres_y[j]
    effectifs_cond = tab_nij.iloc[:, j]
    total_cond = effectifs_cond.sum()
    freq_cond = effectifs_cond / total_cond
    
    moyenne_cond = np.sum(np.array(centres_x, dtype=float) * freq_cond)
    print(f"Distribution de X conditionnellement à Y = {modalite_y} (j={j}) :")
    print(f"Moyenne conditionnelle E[X | Y={modalite_y}] : {moyenne_cond:.2f}\n")

etude_conditionnelle_X_sachant_Y(0)

# ==============================================================================
# Question 9 : Série conditionnelle Y / (X = x_i)
# ==============================================================================
def etude_conditionnelle_Y_sachant_X(i):
    # i correspond à l'index de la modalité de X
    modalite_x = centres_x[i]
    effectifs_cond = tab_nij.iloc[i, :]
    total_cond = effectifs_cond.sum()
    freq_cond = effectifs_cond / total_cond
    
    moyenne_cond = np.sum(np.array(centres_y, dtype=float) * freq_cond)
    print(f"Distribution de Y conditionnellement à X = {modalite_x} (i={i}) :")
    print(f"Moyenne conditionnelle E[Y | X={modalite_x}] : {moyenne_cond:.2f}\n")

etude_conditionnelle_Y_sachant_X(0)

# ==============================================================================
# Question 10 : Test d'indépendance (Khi-deux)
# Condition théorique : f_ij = f_i. * f_.j pour tout (i, j)
# ==============================================================================
chi2, p_val, dof, _ = chi2_contingency(tab_nij)
print("--- Test d'indépendance du Khi-deux ---")
print(f"Statistique Chi2 : {chi2:.2f}, p-value : {p_val:.4f}, ddl : {dof}")
if p_val > 0.05:
    print("Décision : p-value > 0.05, on ne rejette pas l'hypothèse d'indépendance (X et Y sont indépendantes).\n")
else:
    print("Décision : p-value <= 0.05, les variables ne sont pas indépendantes.\n")

# ==============================================================================
# Question 11 : Coefficient de corrélation de Pearson
# ==============================================================================
r_pearson = df['Prix'].corr(df['Unites'])
print("--- Corrélation de Pearson ---")
print(f"Coefficient r : {r_pearson:.4f}")
print("Interprétation : La valeur est très proche de 0 (tirage aléatoire indépendant uniforme),")
print("ce qui traduit une absence totale de liaison linéaire entre le prix et les ventes.\n")

# ==============================================================================
# Question 12 : Nuage de points (Scatter plot)
# ==============================================================================
plt.figure(figsize=(8, 5))
plt.scatter(df['Prix'], df['Unites'], alpha=0.5, color='royalblue', edgecolors='none')
plt.title("Nuage de points : Nombre d'unités vendues en fonction du Prix")
plt.xlabel("Prix du produit X (€)")
plt.ylabel("Unités vendues Y")
plt.grid(True, linestyle='--', alpha=0.5)
plt.tight_layout()
plt.show()