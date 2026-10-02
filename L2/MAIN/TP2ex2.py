import math

echantillon = [15] * 1 + [20] * 2 + [18] * 3 + [12] * 4 + [8] * 5 + [5] * 6
echantillon.sort()
print(echantillon)

def cardinalite(x):
    return len(x)
def afficher(stat):
    return "effectif : "+str(stat[0])+" frequance : "+str(stat[1])+" frequance en pourcentage : "+str(stat[2])+"%"

print("CARD(E) = "+str(cardinalite(echantillon)))

modalite = tuple(dict.fromkeys(echantillon))  # converti en tuple trié 
print(modalite)

stat = {}
for i in modalite:
    n = echantillon.count(i)
    stat[i] = [n,n/len(echantillon),n/len(echantillon)*100]

for i in modalite:
    print(str(i)+" "+afficher(stat[i]))

def calculer_mode(echantillon):
    return max(set(echantillon), key=echantillon.count)

def calculer_moyenne(echantillon):
    return sum(echantillon)/cardinalite(echantillon)


def calculer_mediane(echantillon):
    n=cardinalite(echantillon)
    if n == 0:
        return None
    
    milieu = n // 2
    if n % 2 == 1:
        return echantillon[milieu]
    return (echantillon[milieu - 1] + echantillon[milieu]) / 2

def etandu(echantillon):
    return echantillon[-1]-echantillon[0]

def ecart_absolu_moyen(echantillon):
    moyenne = calculer_moyenne(echantillon)
    n = cardinalite(echantillon)  
    return sum(abs(x - moyenne) for x in echantillon) / n

def variance(echantillon):
    moyenne = calculer_moyenne(echantillon)
    n = cardinalite(echantillon)
    return sum((x-moyenne)**2  for x in echantillon) /n

def ecart_type(echantillon):
    return math.sqrt(variance(echantillon))

def Coef_variation(echantillon):
    return ecart_type(echantillon)/calculer_moyenne(echantillon)


def calculer_quartiles(echantillon):
    """Renvoie Q1, Q3 et l'écart interquartile (IQR)."""
    triee = sorted(echantillon)
    n = len(triee)

    idx_q1 = math.ceil(n / 4) - 1
    idx_q3 = math.ceil(3 * n / 4) - 1

    q1 = triee[idx_q1]
    q3 = triee[idx_q3]

    return q1, q3

def ecart_interquartile(echantillon):
    q1, q2 = calculer_quartiles(echantillon)
    return q2-q1

q1, q3 = calculer_quartiles(echantillon)

print("median = " + str(calculer_mediane(echantillon)))
print("moyenne = " + str(calculer_moyenne(echantillon)))
print("mode = " + str(calculer_mode(echantillon)))
print("etandu = " + str(etandu(echantillon)))
print("l'ecart moyen est nul par définition")
print("EAM = " + str(ecart_absolu_moyen(echantillon)))
print("variance = " + str(variance(echantillon)))
print("ecart-type = " + str(ecart_type(echantillon)))
print("coefficient de variation = " + str(Coef_variation(echantillon)))
print("Q1 = " + str(q1))
print("Q3 = " + str(q3))
print("IQR = " + str(ecart_interquartile(echantillon)))


import matplotlib.pyplot as plt

# -------------------------------------------------------------
# 1. Diagramme en bâtons (effectifs par modalité)
# -------------------------------------------------------------
data = [stat[k][0] for k in modalite]

plt.figure(figsize=(9, 4.5))

# Largeur adaptée à l'échelle des données numériques
plt.bar(modalite, data, color='royalblue', width=0.1, edgecolor='black')

plt.title("Distribution des effectifs par modalité", fontsize=12, fontweight='bold')
plt.xlabel("Modalités", fontsize=10)
plt.ylabel("Effectifs ($n_i$)", fontsize=10)

# Aligne les graduations exactement sur tes valeurs réelles
plt.xticks(modalite)
plt.yticks(range(0, max(data) + 2))
plt.grid(axis='y', linestyle='--', alpha=0.6)

plt.tight_layout()
plt.show()

# -------------------------------------------------------------
# 2. Boîte à moustaches (Boxplot)
# -------------------------------------------------------------
plt.figure(figsize=(9, 3.5))

# Personnalisation pour bien visualiser médiane, moyenne et dispersion
plt.boxplot(
    echantillon,
    vert=False,
    patch_artist=True,
    showmeans=True,
    boxprops=dict(facecolor='lightblue', color='navy'),
    medianprops=dict(color='crimson', linewidth=2),
    meanprops=dict(marker='D', markeredgecolor='black', markerfacecolor='gold'),
    whiskerprops=dict(color='navy', linewidth=1.5),
    capprops=dict(color='navy', linewidth=1.5)
)

plt.title("Boîte à moustaches de la distribution", fontsize=12, fontweight='bold')
plt.xlabel("Valeurs de l'échantillon", fontsize=10)
plt.yticks([1], ["Échantillon"])
plt.xticks(range(min(echantillon), max(echantillon) + 2))
plt.grid(axis='x', linestyle='--', alpha=0.7)

plt.tight_layout()
plt.show()