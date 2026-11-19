"""
TP5 - Exercice 2 : Appréciations d'un jury (variable qualitative ordinale)
Statistiques pour l'Informatique (MAINO0301) - Mme I. Yahiaoui
"""

import numpy as np

# Données brutes
avis = (
    "Bien ; Très bien ; Passable ; Bien ; Assez bien ; Insuffisant ; Bien ; Très bien ; "
    "Passable ; Assez bien ; Bien ; Bien ; Très bien ; Bien ; Passable ; Assez bien ; "
    "Bien ; Bien ; Très bien ; Bien"
)

# 1. Échantillon et tableau statistique (comme à l'exercice 1)
echantillon = np.array([a.strip() for a in avis.split(";")])

# Modalités et effectifs
modalites, effectifs = np.unique(echantillon, return_counts=True)
total = np.sum(effectifs)
frequences = effectifs / total
pourcentages = frequences * 100

tableau_statistique = np.column_stack((
    modalites,
    effectifs.astype(str),
    np.round(frequences, 4).astype(str),
    np.round(pourcentages, 2).astype(str)
))

print("1. Tableau statistique des appréciations :")
print(f"{'Appréciation':<15} {'Effectif':<10} {'Fréquence':<12} {'Pourcentage (%)':<15}")
print("-" * 55)
for ligne in tableau_statistique:
    print(f"{ligne[0]:<15} {ligne[1]:<10} {ligne[2]:<12} {ligne[3]:<15}")
print("-" * 55)
print(f"{'Total':<15} {total:<10} {np.sum(frequences):<12.2f} {np.sum(pourcentages):<15.2f}")

# 2. Identifier le mode
idx_mode = np.argmax(effectifs)
print(f"\n2. Mode : {modalites[idx_mode]} (effectif = {effectifs[idx_mode]})")

# 3. Fonction pour le calcul des quartiles à l'aide de np.sort()
def calcul_quartile(echantillon, num_quartile):
    """
    Calcule le quartile spécifié (1, 2 ou 3) à l'aide de np.sort().
    Prend en compte l'ordre naturel des appréciations :
    Insuffisant < Passable < Assez bien < Bien < Très bien
    """
    if num_quartile not in [1, 2, 3]:
        raise ValueError("Le numéro de quartile doit être 1, 2 ou 3.")
    
    # Ordre croissant des modalités ordinales
    ordre = ["Insuffisant", "Passable", "Assez bien", "Bien", "Très bien"]
    val_to_rank = {val: i for i, val in enumerate(ordre)}
    rank_to_val = {i: val for i, val in enumerate(ordre)}
    
    # Conversion en rangs pour trier correctement
    echantillon_numerique = np.array([val_to_rank[val] for val in echantillon])
    echantillon_trie = np.sort(echantillon_numerique)
    
    # Rang k * n / 4 (avec plafond - 1 pour l'indice 0-indexé)
    n = len(echantillon)
    idx = int(np.ceil(num_quartile * n / 4)) - 1
    
    return rank_to_val[echantillon_trie[idx]]

print("\n3. Calcul des quartiles :")
print(f"1er quartile (Q1)       : {calcul_quartile(echantillon, 1)}")
print(f"2ème quartile (Médiane) : {calcul_quartile(echantillon, 2)}")
print(f"3ème quartile (Q3)       : {calcul_quartile(echantillon, 3)}")