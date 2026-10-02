import numpy as np
import matplotlib.pyplot as plt

def resoudre_et_tracer(a, b, c):
    if a == 0:
        raise ValueError("Le coefficient 'a' doit être non nul pour une équation du second degré.")

    # 1. Calcul du discriminant
    delta = b**2 - 4 * a * c
    sommet_x = -b / (2 * a)
    sommet_y = c - (b**2) / (4 * a)

    print(f"\n--- Équation : {a}x² + ({b})x + ({c}) = 0 ---")
    print(f"Discriminant Δ = {delta}")

    # 2. Gestion des 3 cas et interprétation textuelle
    racines = []
    if delta > 0:
        x1 = (-b - np.sqrt(delta)) / (2 * a)
        x2 = (-b + np.sqrt(delta)) / (2 * a)
        racines = [x1, x2]
        print("Interprétation : Δ > 0. L'équation admet deux solutions réelles distinctes.")
        print(f"Racines : x₁ = {x1:.3f}, x₂ = {x2:.3f}")
        print("Graphique : La parabole coupe l'axe des abscisses en deux points.")
    elif delta == 0:
        x0 = -b / (2 * a)
        racines = [x0]
        print("Interprétation : Δ = 0. L'équation admet une racine double.")
        print(f"Racine double : x₀ = {x0:.3f}")
        print("Graphique : Le sommet de la parabole est tangent à l'axe des abscisses.")
    else:
        print("Interprétation : Δ < 0. Aucune solution réelle (deux racines complexes conjuguées).")
        print("Graphique : La parabole ne coupe jamais l'axe des abscisses.")

    # 3. Tracé graphique
    # Définition d'une fenêtre de tracé centrée sur le sommet
    ecart = max(abs(r - sommet_x) for r in racines) + 2 if racines else 3
    x = np.linspace(sommet_x - ecart, sommet_x + ecart, 500)
    y = a * x**2 + b * x + c

    plt.figure(figsize=(8, 5))
    plt.plot(x, y, label=f"f(x) = {a}x² + {b}x + {c}", color="navy", lw=2)
    plt.axhline(0, color="black", linestyle="--", linewidth=1, alpha=0.7)
    plt.axvline(0, color="black", linestyle="--", linewidth=1, alpha=0.7)

    # Affichage des racines réelles si elles existent
    for i, r in enumerate(racines, 1):
        plt.scatter([r], [0], color="crimson", zorder=5, s=60, label=f"Racine {i} ({r:.2f}, 0)")

    plt.scatter([sommet_x], [sommet_y], color="darkorange", zorder=4, s=40, label=f"Sommet ({sommet_x:.2f}, {sommet_y:.2f})")

    plt.title(f"Résolution graphique : Δ = {delta}")
    plt.xlabel("x")
    plt.ylabel("f(x)")
    plt.grid(True, linestyle=":", alpha=0.6)
    plt.legend()
    plt.show()



# Cas 1 : Δ > 0 (Deux racines réelles distinctes : x = -3 et x = 1)
resoudre_et_tracer(a=1, b=2, c=-3)

# Cas 2 : Δ = 0 (Une racine double : x = 2)
resoudre_et_tracer(a=1, b=-4, c=4)

# Cas 3 : Δ < 0 (Aucune racine réelle)
resoudre_et_tracer(a=1, b=2, c=5)