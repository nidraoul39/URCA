import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-2, 4, 400)

def f(x):
    return np.sin(x)

y = f(x)

fig, ax = plt.subplots(figsize=(8, 5))
ax.plot(x, y, color="blue", label="Parabolic")
ax.plot(1, -1, color="red", marker="o", label="Minimum")
ax.set_title("Graphique de la fonction f(x)")
ax.grid(True)
ax.legend()

plt.show()