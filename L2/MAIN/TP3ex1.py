import random
import math
from collections import Counter
import matplotlib.pyplot as plt

# 1. Génération de l'échantillon
N = random.randint(10, 244)
echantillon = sorted([random.uniform(3.5, 32) for _ in range(N)])

# 2. Calcul de l'étendue
etendue = echantillon[-1] - echantillon[0]

# 3. Calcul du nombre de classes k (Racine, Yule, Sturges)
k_list = [
    math.ceil(math.sqrt(N)), 
    math.ceil(2.5 * math.sqrt(math.sqrt(N))), 
    math.ceil(1 + 3.3 * math.log10(N))
]

k_uniques = list(set(k_list))

# 4. Étude pour chaque valeur de k
for k in k_uniques:
    print(f"\n{'='*50}\nÉtude pour k = {k} classes (N = {N})\n{'='*50}")
    
    # a. Amplitude
    a = etendue / k
    
    # b. Définition des classes
    classes = {}
    L_inf = echantillon[0]
    for i in range(1, k + 1):
        L_sup = L_inf + a
        classes[i] = {
            "borne_inf": L_inf,
            "borne_sup": L_sup,
            "centre": (L_inf + L_sup) / 2
        }
        L_inf = L_sup
        
    # c. Tableau statistique
    Tableau_stat = {}
    N_cumul = 0
    F_cumul = 0
    
    for i in range(1, k + 1):
        b_inf = classes[i]["borne_inf"]
        b_sup = classes[i]["borne_sup"]
        
        if i == k:
            n = sum(1 for x in echantillon if b_inf <= x <= b_sup)
        else:
            n = sum(1 for x in echantillon if b_inf <= x < b_sup)
            
        N_cumul += n
        f = n / N
        F_cumul += f
        fp = f * 100
        FP = F_cumul * 100
        h = n / a
        
        Tableau_stat[i] = [n, N_cumul, f, F_cumul, fp, FP, h]
        
    # d. Affichage formaté
    print(f"{'Cl':<3} | {'Intervalles':<15} | {'ci':<5} | {'ni':<3} | {'Ni':<3} | {'fi':<4} | {'Fi':<4} | {'hi':<5}")
    print("-" * 65)
    for i in range(1, k + 1):
        b_inf = classes[i]["borne_inf"]
        b_sup = classes[i]["borne_sup"]
        ci = classes[i]["centre"]
        n, Ni, f, Fi, fp, FP, h = Tableau_stat[i]
        print(f"{i:<3} | [{b_inf:>5.2f}, {b_sup:>5.2f}) | {ci:>5.2f} | {n:<3} | {Ni:<3} | {f:>4.2f} | {Fi:>4.2f} | {h:>5.2f}")
        
    # e. Mesures de tendance centrale
    moyenne = sum(classes[i]["centre"] * Tableau_stat[i][2] for i in range(1, k + 1))
    classe_modale_idx = max(Tableau_stat, key=lambda x: Tableau_stat[x][0])
    classe_modale = f"[{classes[classe_modale_idx]['borne_inf']:.2f}, {classes[classe_modale_idx]['borne_sup']:.2f})"
    
    def quantile_groupe(p):
        for i in range(1, k + 1):
            if Tableau_stat[i][3] >= p:
                F_prec = Tableau_stat[i-1][3] if i > 1 else 0
                return classes[i]["borne_inf"] + a * ((p - F_prec) / Tableau_stat[i][2])
        return classes[k]["borne_sup"]
        
    mediane = quantile_groupe(0.50)
    
    # f. Mesures de dispersion
    q1 = quantile_groupe(0.25)
    q3 = quantile_groupe(0.75)
    eiq = q3 - q1
    
    variance = sum(Tableau_stat[i][2] * (classes[i]["centre"] - moyenne)**2 for i in range(1, k + 1))
    ecart_type = math.sqrt(variance)
    ecart_moyen = sum(Tableau_stat[i][2] * abs(classes[i]["centre"] - moyenne) for i in range(1, k + 1))
    cv = (ecart_type / moyenne) * 100
    
    print(f"\n[Tendance Centrale]")
    print(f"Moyenne : {moyenne:.2f} kg | Classe Modale : {classe_modale} | Médiane : {mediane:.2f} kg")
    print(f"[Dispersion]")
    print(f"Q1 : {q1:.2f} | Q3 : {q3:.2f} | EIQ : {eiq:.2f}")
    print(f"Var : {variance:.2f} | Écart-type : {ecart_type:.2f} | Écart moy. abs : {ecart_moyen:.2f} | CV : {cv:.2f}%\n")
    
    # g, h, i. Tracés graphiques
    fig, axs = plt.subplots(1, 3, figsize=(16, 4))
    fig.suptitle(f"Représentations pour k = {k} classes", fontweight='bold')
    
    # g. Histogramme
    bins = [classes[i]["borne_inf"] for i in range(1, k + 1)] + [classes[k]["borne_sup"]]
    axs[0].hist(echantillon, bins=bins, edgecolor='black', color='skyblue')
    axs[0].set_title("Histogramme")
    axs[0].set_xlabel("Poids (kg)")
    axs[0].set_ylabel("Effectif")
    
    # h. Boîte à moustaches
    axs[1].boxplot(echantillon, vert=False, patch_artist=True, boxprops=dict(facecolor="lightgreen"))
    axs[1].set_title("Boîte à moustaches")
    axs[1].set_xlabel("Poids (kg)")
    
    # i. Fonction de répartition (Polygone pour variable continue)
    x_repartition = [classes[1]["borne_inf"]] + [classes[i]["borne_sup"] for i in range(1, k + 1)]
    y_repartition = [0] + [Tableau_stat[i][3] for i in range(1, k + 1)]
    
    axs[2].plot(x_repartition, y_repartition, color='darkorange', marker='.')
    axs[2].set_title("Fonction de répartition")
    axs[2].set_xlabel("Poids (kg)")
    axs[2].set_ylabel("Fréquence cumulée F(x)")
    axs[2].grid(True, linestyle='--', alpha=0.7)
    
    plt.tight_layout()
    plt.show()