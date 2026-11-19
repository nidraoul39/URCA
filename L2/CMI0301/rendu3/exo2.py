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