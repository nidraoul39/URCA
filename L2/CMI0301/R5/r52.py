import matplotlib.pyplot as plt
import numpy as np
import random

R = 1
n = 1000000

x_in, y_in = [], []
x_out, y_out = [], []

for _ in range(n):
    x = random.uniform(0, R)
    y = random.uniform(0, R)
    
    if x**2 + y**2 <= R**2:
        x_in.append(x)
        y_in.append(y)
    else:
        x_out.append(x)
        y_out.append(y)

fig, ax = plt.subplots(figsize=(6, 6))

ax.scatter(x_in, y_in, color="green", s=5, alpha=0.6, label="Dans le quart")
ax.scatter(x_out, y_out, color="red", s=5, alpha=0.6, label="Hors du quart")

x_cercle = np.linspace(0, R, 500)
y_cercle = np.sqrt(R**2 - x_cercle**2)
ax.plot(x_cercle, y_cercle, color="black", linewidth=2, label="Bord du cercle")

ax.set_aspect("equal")
ax.set_xlim(0, R)
ax.set_ylim(0, R)
ax.set_title(f"Pi = {4 * len(x_in) / n:.4f}")
ax.legend(loc="lower left")
plt.show()