import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from scipy import stats

# Données
entrainement = np.array([4, 5, 3, 5, 2, 1, 3, 2, 4, 5, 1, 3, 4, 2, 5, 1, 3, 4, 2, 5])
notes = np.array([12, 19, 7, 4, 8, 15, 16, 5, 14, 20, 1, 11, 17, 10, 18, 9, 13, 6, 3, 12])

# 1. Tableaux de contingence 2D (effectifs et fréquences)
# pd.crosstab construit directement la table croisée
table_effectifs = pd.crosstab(
    entrainement, notes, rownames=["Entraînement (h)"], colnames=["Notes"]
)
table_frequences = pd.crosstab(
    entrainement,
    notes,
    rownames=["Entraînement (h)"],
    colnames=["Notes"],
    normalize=True,
)

print("--- Tableau de contingence : Effectifs ---")
print(table_effectifs)

print("\n--- Tableau de contingence : Fréquences ---")
print(np.round(table_frequences, 3))

# 2. Lois marginales
# Loi marginale de X (entraînement)
marg_x_eff = table_effectifs.sum(axis=1)
marg_x_freq = marg_x_eff / len(entrainement)

# Loi marginale de Y (notes)
marg_y_eff = table_effectifs.sum(axis=0)
marg_y_freq = marg_y_eff / len(notes)

print("\n--- Loi marginale de X (Entraînement) ---")
loi_x = pd.DataFrame({"Effectif": marg_x_eff, "Fréquence": marg_x_freq})
print(loi_x)

print("\n--- Loi marginale de Y (Notes) ---")
loi_y = pd.DataFrame({"Effectif": marg_y_eff, "Fréquence": marg_y_freq})
print(loi_y.T)  # Transposé pour un affichage compact

# 3. Nuage de points
plt.figure(figsize=(7, 5))
plt.scatter(entrainement, notes, color="darkblue", s=60, edgecolors="black")
plt.title("Relation entre heures d'entraînement et notes")
plt.xlabel("Entraînement quotidien (heures)")
plt.ylabel("Note attribuée")
plt.grid(True, linestyle="--", alpha=0.6)
plt.xticks(np.arange(1, 6))
plt.tight_layout()
plt.show()

# 4. Coefficients de corrélation
r_pearson, p_pearson = stats.pearsonr(entrainement, notes)
rho_spearman, p_spearman = stats.spearmanr(entrainement, notes)
tau_kendall, p_kendall = stats.kendalltau(entrainement, notes)

print("\n--- Coefficients de corrélation ---")
print(f"Pearson (r)      : {r_pearson:.4f} (p-valeur : {p_pearson:.4e})")
print(f"Spearman (rho)   : {rho_spearman:.4f} (p-valeur : {p_spearman:.4e})")
print(f"Kendall (tau)    : {tau_kendall:.4f} (p-valeur : {p_kendall:.4e})")