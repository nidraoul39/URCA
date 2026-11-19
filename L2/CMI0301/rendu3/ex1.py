import numpy as np
import matplotlib.pyplot as plt

a = input("de : ")
b = input("à : ")
x = np.linspace(int(a), int(b), 1000)

def f(x):
    A = np.polynomial.Polynomial([0,1])
    poly = ((A-1)/-1)*((A-2)/-2)
    return poly(x)

y = f(x)
def tracer(y):
    fig, ax = plt.subplots(figsize=(8, 5))
    ax.plot(x, y, color="blue", label="Parabolic")
    ax.plot(1, -1, color="red", marker="o", label="Minimum")
    ax.set_title("Graphique de la fonction f(x)")
    ax.grid(True)
    ax.legend()

    plt.show()
    
tracer(y)