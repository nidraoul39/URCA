# EX 115

### 1. Calcul explicite de $L_0(x)$, $L_1(x)$ et $L_2(x)$

- $L_0(x) = \frac{(x - 1)(x - 2)}{(0 - 1)(0 - 2)} = \frac{1}{2}x^2 - \frac{3}{2}x + 1$
- $L_1(x) = \frac{x(x - 2)}{(1 - 0)(1 - 2)} = -x^2 + 2x$
- $L_2(x) = \frac{x(x - 1)}{(2 - 0)(2 - 1)} = \frac{1}{2}x^2 - \frac{1}{2}x$

### 2. Degré de chaque polynôme

- $\deg(L_0) = 2$
- $\deg(L_1) = 2$
- $\deg(L_2) = 2$

### 3. Propriété « bouton »

- **Pour $L_0$ :**
  - $L_0(0) = 1$ (bouton activé)
  - $L_0(1) = 0$ (bouton désactivé)
  - $L_0(2) = 0$ (bouton désactivé)

- **Pour $L_1$ :**
  - $L_1(0) = 0$ (bouton désactivé)
  - $L_1(1) = 1$ (bouton activé)
  - $L_1(2) = 0$ (bouton désactivé)

- **Pour $L_2$ :**
  - $L_2(0) = 0$ (bouton désactivé)
  - $L_2(1) = 0$ (bouton désactivé)
  - $L_2(2) = 1$ (bouton activé)

### 4. Polynôme interpolateur $P(x)$

$$P(x) = 1 \cdot L_0(x) + 3 \cdot L_1(x) + 7 \cdot L_2(x)$$
$$P(x) = x^2 + x + 1$$

# EX 116

```python
import numpy as np
import matplotlib.pyplot as plt

a = -5
b = 5
x = np.linspace(int(a), int(b), 1000)

A = np.polynomial.Polynomial([0, 1])

def f_L0(x):
    poly = ((A - 1) / -1) * ((A - 2) / -2)
    return poly(x)

def f_L1(x):
    poly = ((A - 0) / 1) * ((A - 2) / -1)
    return poly(x)

def f_L2(x):
    poly = ((A - 0) / 2) * ((A - 1) / 1)
    return poly(x)

def f_somme(x):
    return f_L0(x) + f_L1(x) + f_L2(x)

def tracer():
    fig, ax = plt.subplots(figsize=(10, 6))

    # 1. Tracé des trois polynômes et de la somme
    ax.plot(x, f_L0(x), color="blue", label="L0(x)")
    ax.plot(x, f_L1(x), color="orange", label="L1(x)")
    ax.plot(x, f_L2(x), color="green", label="L2(x)")
    ax.plot(x, f_somme(x), color="black", linestyle="--", label="Somme = 1")

    # 2 & 3. Points bouton activés (ronds) et désactivés (croix)
    # L0
    ax.plot(0, 1, marker="o", color="blue", markersize=8, label="L0 actif (x=0)")
    ax.plot([1, 2], [0, 0], marker="x", color="blue", linestyle="None", markersize=8)

    # L1
    ax.plot(1, 1, marker="o", color="orange", markersize=8, label="L1 actif (x=1)")
    ax.plot([0, 2], [0, 0], marker="x", color="orange", linestyle="None", markersize=8)

    # L2
    ax.plot(2, 1, marker="o", color="green", markersize=8, label="L2 actif (x=2)")
    ax.plot([0, 1], [0, 0], marker="x", color="green", linestyle="None", markersize=8)

    # Lignes repères
    ax.axhline(0, color="gray", linestyle=":", linewidth=0.8)
    ax.axhline(1, color="gray", linestyle=":", linewidth=0.8)

    ax.set_title("Polynômes de base de Lagrange et propriété 'bouton'")
    ax.set_xlabel("x")
    ax.set_ylabel("y")
    ax.grid(True)
    ax.legend()
    plt.show()

tracer()

```

# EX 117 :

### 1. Pour 4 points d’interpolation

Le degré des polynômes $L_k(x)$ est **$3$**.

### 2. Pour $n + 1$ points d’interpolation

Le degré des polynômes $L_k(x)$ est **$n$**.

### 3. Pourquoi ce degré est-il nécessaire ?

- **$n$ racines distinctes obligatoires :** pour vérifier la propriété bouton ($L_k(x_j) = 0$ pour tout $j \neq k$), chaque polynôme $L_k(x)$ doit obligatoirement s'annuler sur les $n$ autres nœuds distincts, ce qui impose $\deg(L_k) \ge n$.

- **Unicité :** choisir le degré minimal $n$ garantit l'existence et l'unicité de la solution dans l'espace $\mathbb{R}_n[X]$.

# EX
