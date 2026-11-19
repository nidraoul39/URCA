import numpy as np
import matplotlib.pyplot as plt

def f(x):
    A = np.polynomial.Polynomial([0, 1])
    poly = 3 * A + 2
    return poly(x)

def dico(a, b, precision):
    
    while (b-a) > precision:
        m = (a + b) / 2

        if f(m) > 0:
            a = m
        else:
            b = m
            

    return (a, b)

intervalle_racine = dico(-1000, 1000, 0.000001)
print(f"L'encadrement de la racine est : {intervalle_racine}")
print(f"La valeur approchée de la racine est : {(intervalle_racine[0] + intervalle_racine[1]) / 2}")
