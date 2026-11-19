import numpy as np
import matplotlib.pyplot as plt

# 1. Fonction de Runge
def runge(x):
    return 1.0 / (1.0 + 25.0 * x**2)

# Base élémentaire de Lagrange L_k(x)
def lagrange_basis(x_points, k, x):
    result = 1.0
    xk = x_points[k]
    for j, xj in enumerate(x_points):
        if j != k:
            result *= (x - xj) / (xk - xj)
    return result

# Polynôme d'interpolation P(x) = sum( y_k * L_k(x) )
def lagrange_interp(x_points, y_points, x):
    total = np.zeros_like(x, dtype=float)
    for k in range(len(x_points)):
        total += y_points[k] * lagrange_basis(x_points, k, x)
    return total

# Grille d'évaluation fine pour le tracé
x_eval = np.linspace(-1, 1, 500)
y_exact = runge(x_eval)

# 2. Interpolation pour n = 5, 10, 15, 20
valeurs_n = [5, 10, 15, 20]

fig, ax = plt.subplots(figsize=(10, 6))

# Courbe de référence
ax.plot(x_eval, y_exact, "k--", linewidth=2, label="Fonction exacte $f(x)$")

for n in valeurs_n:
    # Nœuds équidistants sur [-1, 1]
    xp = np.linspace(-1, 1, n)
    yp = runge(xp)
    
    # Calcul des interpolations
    y_interp = lagrange_interp(xp, yp, x_eval)
    
    # Tracé
    ax.plot(x_eval, y_interp, label=f"$n = {n}$ points")

ax.set_title("Interpolation polynomiale de Lagrange (phénomène de Runge)")
ax.set_xlabel("x")
ax.set_ylabel("y")
ax.set_ylim(-0.5, 2.0)  # Tronque pour observer les oscillations sans écraser le graphe
ax.grid(True)
ax.legend()

plt.show()