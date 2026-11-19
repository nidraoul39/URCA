import numpy as np
import matplotlib.pyplot as plt

# 1. Fonction de Runge
def f(x):
    return 1.0 / (1.0 + 25.0 * x**2)

# Base de Lagrange L_k(x)
def lagrange_basis(x_points, k, x):
    result = 1.0
    xk = x_points[k]
    for j, xj in enumerate(x_points):
        if j != k:
            result *= (x - xj) / (xk - xj)
    return result

# Polynôme d'interpolation de Lagrange P(x)
def lagrange_interp(x_points, y_points, x):
    total = np.zeros_like(x, dtype=float)
    for k in range(len(x_points)):
        total += y_points[k] * lagrange_basis(x_points, k, x)
    return total

# Grille fine pour l'affichage continu
x_dense = np.linspace(-1, 1, 500)
y_exact = f(x_dense)

# 2. Calcul et tracé pour n = 5, 10, 15, 20
valeurs_n = [5, 10, 15, 20]

fig, axes = plt.subplots(2, 2, figsize=(12, 8))
axes = axes.flatten()

for idx, n in enumerate(valeurs_n):
    ax = axes[idx]
    
    # Points d'appui équidistants sur [-1, 1]
    xp = np.linspace(-1, 1, n)
    yp = f(xp)
    
    # Calcul de l'interpolation
    y_poly = lagrange_interp(xp, yp, x_dense)
    
    # Tracé
    ax.plot(x_dense, y_exact, "k--", label="$f(x)$ exacte")
    ax.plot(x_dense, y_poly, "b-", label=f"$P(x)$ (degré {n - 1})")
    ax.plot(xp, yp, "ro", markersize=4, label="Nœuds")
    
    ax.set_title(f"$n = {n}$ points")
    ax.set_ylim(-0.5, 1.5)  # Permet d'observer l'explosion sans écraser le graphe
    ax.grid(True)
    ax