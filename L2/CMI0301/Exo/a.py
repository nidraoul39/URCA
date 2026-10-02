import numpy as np
import math
import matplotlib.pyplot as plt

def taylor_approximation(f, a, n):
    h = 0.001
    derivatives = []
    
    for k in range(n + 1):
        if k == 0:
            derivatives.append(f(a))
        elif k == 1:
            deriv1 = (f(a + h) - f(a - h)) / (2 * h)
            derivatives.append(deriv1)
        elif k == 2:
            deriv2 = (f(a + h) - 2 * f(a) + f(a - h)) / (h ** 2)
            derivatives.append(deriv2)
        elif k == 3:
            deriv3 = (f(a + 2*h) - 2*f(a + h) + 2*f(a - h) - f(a - 2*h)) / (2 * h ** 3)
            derivatives.append(deriv3)

    factorials = []
    for k in range(n + 1):
        factorials.append(math.factorial(k))
    
    coeffs = []
    for k in range(n + 1):
        coeffs.append(derivatives[k] / factorials[k])
    
    def polynomial(x):
        total = 0
        for k in range(n + 1):
            total = total + coeffs[k] * (x - a)**k
        return total
        
    return polynomial

def f(x):
    return np.sin(x)

point_a = 0
ordre_n = 3

T3 = taylor_approximation(f, point_a, ordre_n)

x_vals = np.linspace(-4, 4, 400)
y_f = f(x_vals)
y_taylor = T3(x_vals)

fig, ax = plt.subplots(figsize=(8, 5))
ax.plot(x_vals, y_f, color="blue", label="Fonction originale sin(x)")
ax.plot(x_vals, y_taylor, color="red", linestyle="--", label=f"Taylor Ordre {ordre_n}")
ax.plot(point_a, f(point_a), color="black", marker="o", label="Point de contact (a)")

ax.set_title("Approximation de Taylor de sin(x)")
ax.grid(True)
ax.legend()

plt.show()

print("f(a) =", f(point_a))
print("T3(a) =", T3(point_a))
