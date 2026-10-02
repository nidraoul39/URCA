import numpy as np
import matplotlib.pyplot as plt
import math
x = np.linspace(-1,1,100)

# def g(x):
#     return np.sqrt(1+x)

# y = g(x)

# fig, ax = plt.subplots(figsize=(8, 5))
# ax.plot(x, y, color="red", label="x et g(x)",linewidth=2)
# ax.set_title("Fonction racine carree decaler")
# ax.grid(True)
# ax.legend()

# plt.show()

def verif_pair(f,x_test):
    for i in x_test:
        if f(i) != f(-i):
            return False
    return True

def verif_impair(f,x_test):
    for i in x_test:
        if f(-i) != -f(i):
            return False
    return True
def verif_symetrie(f,x_test):
    if(verif_pair(f,x_test)):
        return "pair"
    elif(verif_impair(f,x_test)):
        return "impair"
    else:
        return "ni l'un ni l'autre"

def f(x):
    return x**2

def g(x):
    return math.sin(x)

def e(x):
    return math.exp(x)

print(verif_symetrie(f,x))