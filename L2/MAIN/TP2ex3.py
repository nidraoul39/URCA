import math
import matplotlib.pyplot as plt
import pandas as pd

# =============================================================================
# 1. FONCTIONS STATISTIQUES (EXERCICE PRÉCÉDENT)
# =============================================================================


def cardinalite(x):
  return len(x)


def calculer_moyenne(echantillon):
  return sum(echantillon) / cardinalite(echantillon)


def calculer_mediane(echantillon):
  triee = sorted(echantillon)
  n = cardinalite(triee)
  if n == 0:
    return None
  milieu = n // 2
  if n % 2 == 1:
    return triee[milieu]
  return (triee[milieu - 1] + triee[milieu]) / 2


def calculer_mode(echantillon):
  return max(set(echantillon), key=echantillon.count)


def etendu(echantillon):
  return max(echantillon) - min(echantillon)


def ecart_absolu_moyen(echantillon):
  moyenne = calculer_moyenne(echantillon)
  return sum(abs(x - moyenne) for x in echantillon) / cardinalite(echantillon)


def variance(echantillon):
  moyenne = calculer_moyenne(echantillon)
  return sum((x - moyenne) ** 2 for x in echantillon) / cardinalite(echantillon)


def ecart_type(echantillon):
  return math.sqrt(variance(echantillon))


def Coef_variation(echantillon):
  moyenne = calculer_moyenne(echantillon)
  return ecart_type(echantillon) / moyenne if moyenne != 0 else float('nan')


def calculer_quartiles(echantillon):
  triee = sorted(echantillon)
  n = len(triee)
  idx_q1 = math.ceil(n / 4) - 1
  idx_q3 = math.ceil(3 * n / 4) - 1
  return triee[idx_q1], triee[idx_q3]


def ecart_interquartile(echantillon):
  q1, q3 = calculer_quartiles(echantillon)
  return q3 - q1


def etude_statistique(nom_var, serie):
  """Exécute l'analyse statistique complète sur une variable."""
  echantillon = serie.dropna().tolist()
  q1, q3 = calculer_quartiles(echantillon)

  print(f"\n--- Analyse : {nom_var} ---")
  print(f"Effectif total (N)     : {cardinalite(echantillon)}")
  print(f"Moyenne                : {calculer_moyenne(echantillon):.2f}")
  print(f"Médiane                : {calculer_mediane(echantillon):.2f}")
  print(f"Mode                   : {calculer_mode(echantillon)}")
  print(f"Étendue                : {etendu(echantillon):.2f}")
  print(f"Écart absolu moyen     : {ecart_absolu_moyen(echantillon):.2f}")
  print(f"Variance               : {variance(echantillon):.2f}")
  print(f"Écart-type             : {ecart_type(echantillon):.2f}")
  print(f"Coeff. de variation    : {Coef_variation(echantillon):.4f}")
  print(f"Q1                     : {q1}")
  print(f"Q3                     : {q3}")
  print(f"IQR (Écart interq.)    : {ecart_interquartile(echantillon)}")


# =============================================================================
# QUESTION 1 : Lecture et vérification de la structure
# =============================================================================
file = pd.read_csv('donnees_etudiants.csv', sep=',')

lignes, colonnes = file.shape
total_manquants = file.isnull().sum().sum()

print(f"Structure du fichier : {lignes} lignes et {colonnes} colonnes.")
if total_manquants == 0:
  print("Absence de valeurs manquantes : OK.")
else:
  print(f"Attention : {total_manquants} valeur(s) manquante(s).")
  print(file.isnull().sum()[file.isnull().sum() > 0])

# =============================================================================
# QUESTION 2 : Étude statistique des trois variables
# =============================================================================
# Adapter les noms de colonnes exacts si différents dans ton fichier CSV
col_age = [c for c in file.columns if 'age' in c.lower()][0]
col_sport = [c for c in file.columns if 'sport' in c.lower()][0]
col_malade = [
    c for c in file.columns if 'malad' in c.lower() or 'jour' in c.lower()
][0]

variables = [
    ('Âge', col_age),
    ('Heures de sport par semaine', col_sport),
    ('Nombre de jours malades', col_malade),
]

for label, col in variables:
  etude_statistique(label, file[col])

# =============================================================================
# QUESTION 3 : Construction des trois sous-échantillons par tranche d'âge
# =============================================================================
groupe_18_20 = file[(file[col_age] >= 18) & (file[col_age] <= 20)]
groupe_21_23 = file[(file[col_age] >= 21) & (file[col_age] <= 23)]
groupe_24_26 = file[(file[col_age] >= 24) & (file[col_age] <= 26)]

print(f"\nEffectif 18–20 ans : {len(groupe_18_20)}")
print(f"Effectif 21–23 ans : {len(groupe_21_23)}")
print(f"Effectif 24–26 ans : {len(groupe_24_26)}")

# =============================================================================
# QUESTION 4 : Boîtes à moustaches épurées (style noir et blanc)
# =============================================================================
labels_groupes = ['18–20 ans', '21–23 ans', '24–26 ans']

fig, axes = plt.subplots(1, 2, figsize=(11, 5))

# Données
data_sport = [
    groupe_18_20[col_sport].dropna(),
    groupe_21_23[col_sport].dropna(),
    groupe_24_26[col_sport].dropna(),
]

data_malade = [
    groupe_18_20[col_malade].dropna(),
    groupe_21_23[col_malade].dropna(),
    groupe_24_26[col_malade].dropna(),
]

# Graphique 1 : Heures de sport
axes[0].boxplot(
    data_sport,
    tick_labels=labels_groupes,
    showmeans=True,
    medianprops=dict(color='black'),
    meanprops=dict(marker='D', markeredgecolor='black', markerfacecolor='black', markersize=5),
    boxprops=dict(color='black'),
    whiskerprops=dict(color='black'),
    capprops=dict(color='black')
)
axes[0].set_title("HEURES DE SPORT PAR SEMAINE\n(par tranche d'âge)", fontsize=11)
axes[0].set_ylabel("Heures / semaine")

# Graphique 2 : Nombre de jours malades
axes[1].boxplot(
    data_malade,
    tick_labels=labels_groupes,
    showmeans=True,
    medianprops=dict(color='black'),
    meanprops=dict(marker='D', markeredgecolor='black', markerfacecolor='black', markersize=5),
    boxprops=dict(color='black'),
    whiskerprops=dict(color='black'),
    capprops=dict(color='black')
)
axes[1].set_title("NOMBRE DE JOURS MALADES\n(par tranche d'âge)", fontsize=11)
axes[1].set_ylabel("Nombre de jours")

plt.tight_layout()
plt.show()