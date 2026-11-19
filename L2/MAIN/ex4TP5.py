import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

# 1. Génération de l'échantillon (50 musiciens entre 35s et 60s)
np.random.seed(42)  # Fixe la graine pour des résultats reproductibles
echantillon = np.random.uniform(35, 60, size=50)

# 2 & 3. Regroupement en classes (par défaut 10 classes)
# np.histogram renvoie les effectifs et les bornes des classes
effectifs, bornes = np.histogram(echantillon, bins=10)

# Calcul des centres de classes
centres = (bornes[:-1] + bornes[1:]) / 2

# 4. Construction et affichage du tableau statistique
classes_str = [
    f"[{bornes[i]:.2f} ; {bornes[i+1]:.2f}[" for i in range(len(effectifs))
]
frequences = effectifs / len(echantillon)

tableau_stat = pd.DataFrame(
    {
        "Classe": classes_str,
        "Centre": np.round(centres, 2),
        "Effectif": effectifs,
        "Fréquence (%)": np.round(frequences * 100, 2),
        "Effectif cumulé": np.cumsum(effectifs),
    }
)

print("--- Tableau statistique (Exercice 4) ---")
print(tableau_stat.to_string(index=False))

# 5. Mesures statistiques descriptives
moyenne = np.mean(echantillon)
variance = np.var(echantillon, ddof=1)  # variance échantillonnale
ecart_type = np.std(echantillon, ddof=1)
mediane = np.median(echantillon)
q1 = np.percentile(echantillon, 25)
q3 = np.percentile(echantillon, 75)

print("\n--- Indicateurs statistiques ---")
print(f"Moyenne      : {moyenne:.2f} s")
print(f"Médiane      : {mediane:.2f} s")
print(f"Écart-type   : {ecart_type:.2f} s")
print(f"Variance     : {variance:.2f}")
print(f"Q1 (25%)     : {q1:.2f} s")
print(f"Q3 (75%)     : {q3:.2f} s")
print(f"Min / Max    : {np.min(echantillon):.2f} s / {np.max(echantillon):.2f} s")

# 6. Représentations graphiques
plt.figure(figsize=(12, 5))

# Histogramme
plt.subplot(1, 2, 1)
plt.hist(
    echantillon, bins=10, edgecolor="black", color="skyblue", density=False
)
plt.title("Histogramme des durées d'exécution")
plt.xlabel("Durée (secondes)")
plt.ylabel("Effectif")
plt.grid(axis="y", linestyle="--", alpha=0.7)

# Boîte à moustaches
plt.subplot(1, 2, 2)
plt.boxplot(echantillon, vert=True, patch_artist=True, boxprops=dict(facecolor="lightgreen"))
plt.title("Boîte à moustaches")
plt.ylabel("Durée (secondes)")
plt.grid(axis="y", linestyle="--", alpha=0.7)

plt.tight_layout()
plt.show()