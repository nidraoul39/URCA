import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(0,5,100)

def f(x):
    return x**3*np.exp(-x)

y = f(x)

fig, ax = plt.subplots(figsize=(8, 5))
ax.plot(x, y, color="blue", label="Parabolic")
i = 0
while i<=5:
    ax.plot(i,f(i), color="red", marker="o")
    i+=0.5
ax.set_title("Graphique de la fonction f(x)")
ax.grid(True)
ax.legend()

plt.show()