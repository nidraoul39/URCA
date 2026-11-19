import numpy as np
import matplotlib.pyplot as plt

def f(x):
    A = np.polynomial.Polynomial([0, 1])
    poly = 3 * A + 2
    return poly(x)

def balayage(precision, a, b):
    if abs(b - a) < precision:
        return a
    
    pas = (b - a) / 100
    
    for i in np.arange(a, b, pas):
        if f(i) * f(i + pas) <= 0:
            return balayage(precision, i, i + pas)
            
racine = balayage(0.001, -100, 100)
print(f"La racine trouvée est : {racine}")

