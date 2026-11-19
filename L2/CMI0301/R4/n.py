import numpy as np
import matplotlib.pyplot as plt

def f(x):
    A = np.polynomial.Polynomial([0, 1])
    poly = 3 * A**3 + 2
    return poly(x)

def deriverf(x):
    A = np.polynomial.Polynomial([0, 1])
    poly = 3 * A**3 + 2
    return poly.deriv()(x)

def newton(a,b,precision):
    x0 = a-f(a)/deriverf(a)
    while (b-a)>precision:
        x0 = x0-f(x0)/deriverf(x0)
        if(f(x0)>0):
            a=x0
        else:
            b=x0

    return(a,b)
        


intervalle_racine = newton(-1000, 1000, 0.000001)
print(f"L'encadrement de la racine est : {intervalle_racine}")
print(f"La valeur approchée de la racine est : {(intervalle_racine[0] + intervalle_racine[1]) / 2}")


print(f(-0.87))