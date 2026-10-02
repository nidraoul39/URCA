import random
import matplotlib.pyplot as plt

def afficher(stat):
    return "effectif : " + str(stat[0]) + " frequence : " + str(stat[1]) + " frequence en pourcentage : " + str(stat[2]) + "%"

# 1. Échantillon aléatoire (N = 200)
modalite = ("Tres insatisfait", "Insatisfait", "Indifferent", "Satisfait", "Tres satisfait")
echantillon = random.choices(modalite, k=200, weights=[random.randint(1, 100) for _ in range(len(modalite))])

# 2. Tableau statistique
statistique = dict()
for i in modalite:
    n = echantillon.count(i)
    statistique[i] = [n, n / len(echantillon), (n / len(echantillon)) * 100]

print("--- Tableau statistique ---")
for i in modalite:
    print(i + " -> " + afficher(statistique[i]))

# 3. Mesures statistiques (variable qualitative ordinale)
# Mode : modalité avec l'effectif maximal
mode = max(modalite, key=lambda k: statistique[k][0])

# Médiane : modalité où les fréquences cumulées atteignent ou dépassent 50 %
freq_cumul = 0.0
mediane = None
for m in modalite:
    freq_cumul += statistique[m][1]
    if freq_cumul >= 0.5 and mediane is None:
        mediane = m

print("\n--- Mesures statistiques ---")
print("Mode :", mode)
print("Mediane :", mediane)

# 4. Graphiques
data = [statistique[k][0] for k in modalite]

# Diagramme à bandes
plt.figure(figsize=(10, 4))
plt.bar(modalite, data, color='skyblue', edgecolor='black')
plt.title("Satisfaction des employés (Effectifs)")
plt.ylabel("Effectifs (ni)")
plt.xticks(range(len(data)), modalite, rotation=15)
plt.tight_layout()
plt.show()

# Diagramme circulaire
plt.figure(figsize=(7, 7))
plt.pie(data, labels=modalite, autopct='%1.1f%%', startangle=140)
plt.title("Répartition de la satisfaction des employés")
plt.tight_layout()
plt.show()