import math
import matplotlib.pyplot as plt

# 1. Données (déjà regroupées en classes)
bornes = [50, 100, 150, 200, 250, 300, 350]
effectifs = [10, 18, 32, 30, 20, 10]
N = sum(effectifs)
a = 50 # Amplitude constante

# 2. Tableau statistique
Tableau_stat = []
Ni, Fi = 0, 0

print(f"{'Cl':<3} | {'Intervalle':<12} | {'ci':<5} | {'ni':<3} | {'Ni':<3} | {'fi':<4} | {'Fi':<4}")
print("-" * 55)

for i, ni in enumerate(effectifs):
    b_inf, b_sup = bornes[i], bornes[i+1]
    ci = (b_inf + b_sup) / 2
    Ni += ni
    fi = ni / N
    Fi += fi
    
    Tableau_stat.append({"b_inf": b_inf, "b_sup": b_sup, "ci": ci, "ni": ni, "Ni": Ni, "fi": fi, "Fi": Fi})
    print(f"{i+1:<3} | [{b_inf:>3}, {b_sup:>3}) | {ci:>5.1f} | {ni:<3} | {Ni:<3} | {fi:.2f} | {Fi:.2f}")

# 3. Mesures statistiques
moyenne = sum(c["ci"] * c["fi"] for c in Tableau_stat)
variance = sum(c["fi"] * (c["ci"] - moyenne)**2 for c in Tableau_stat)
ecart_type = math.sqrt(variance)
ecart_moyen = sum(c["fi"] * abs(c["ci"] - moyenne) for c in Tableau_stat)

def quantile(p):
    for c in Tableau_stat:
        if c["Fi"] >= p:
            F_prec = c["Fi"] - c["fi"]
            return c["b_inf"] + a * ((p - F_prec) / c["fi"])

q1, mediane, q3 = quantile(0.25), quantile(0.50), quantile(0.75)
idx_modale = effectifs.index(max(effectifs))
classe_modale = f"[{bornes[idx_modale]}, {bornes[idx_modale+1]})"

print("\n[Tendance Centrale]")
print(f"Moyenne : {moyenne:.2f} L | Modale : {classe_modale} | Médiane : {mediane:.2f} L")
print("\n[Dispersion]")
print(f"Q1 : {q1:.2f} | Q3 : {q3:.2f} | EIQ : {q3-q1:.2f}")
print(f"Var : {variance:.2f} | Écart-type : {ecart_type:.2f} | Écart moy : {ecart_moyen:.2f} | CV : {(ecart_type/moyenne)*100:.2f}%\n")

# 4. Graphiques
# Astuce : Simulation d'un échantillon uniformément réparti pour réutiliser plt.boxplot et plt.hist sans effort
echantillon = []
for c in Tableau_stat:
    pas = a / c["ni"]
    echantillon.extend([c["b_inf"] + j * pas for j in range(c["ni"])])

fig, axs = plt.subplots(1, 3, figsize=(15, 4))

# Histogramme
axs[0].hist(echantillon, bins=bornes, edgecolor='black', color='skyblue')
axs[0].set_title("Histogramme")
axs[0].set_xlabel("Consommation d'eau (L)")

# Boîte à moustaches
axs[1].boxplot(echantillon, vert=False, patch_artist=True, boxprops=dict(facecolor="lightgreen"))
axs[1].set_title("Boîte à moustaches")
axs[1].set_xlabel("Consommation d'eau (L)")

# Fonction de répartition (Polygone)
x_rep = [bornes[0]] + [c["b_sup"] for c in Tableau_stat]
y_rep = [0] + [c["Fi"] for c in Tableau_stat]
axs[2].plot(x_rep, y_rep, color='darkorange', marker='.')
axs[2].set_title("Fonction de répartition")
axs[2].grid(True, linestyle='--', alpha=0.7)

plt.tight_layout()
plt.show()