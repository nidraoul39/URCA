import matplotlib.pyplot as plt
import numpy as np

A = np.polynomial.Polynomial([0, 1])
poly = A**2


def f(x):
    return poly(x)


a = float(input("de : "))
b = float(input("à : "))
pas = 0.0001

x = np.linspace(a, b, 1000)
y = f(x)


def tracer(y, x):
    fig, ax = plt.subplots(figsize=(8, 5))  
    ax.plot(x, y, color="blue", label="Parabolic")
    ax.set_title("Graphique de la fonction f(x)")
    ax.grid(True)
    ax.legend()
    plt.show()


tracer(y, x)

integral = 0
i = a
while i < b:
    integral += f(i) * pas  
    i += pas 

print(f"L'intégrale de {a} à {b} vaut environ : {integral:.4f}")