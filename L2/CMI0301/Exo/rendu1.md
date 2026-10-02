### Excercice

## 1

- le domaine de def est [-1 ; +infinie[

## 2

- g(0) =1
- g(3)= 2
- g(-1) = 0

## 3

[./image.png]

## 4

-1 0
-0,5 0,707106781186548
0 1
0,5 1,22474487139159
1 1,4142135623731
1,5 1,58113883008419

### EX 1

## 1 et 2

```python
import math

def g(x):
    return math.sqrt(1+x)
i = -1
while i<=1.5:
    print(f"g({i}) = {g(i):.3g}")
    i+=0.5
```

## 3

```python
import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-1,3,100)

def g(x):
    return np.sqrt(1+x)

y = g(x)

fig, ax = plt.subplots(figsize=(8, 5))
ax.plot(x, y, color="red", label="x et g(x)")
ax.set_title("Fonction racine carree decaler")
ax.grid(True)
ax.legend()

plt.show()
```

### EX2

## 1

pair : g(x) = g(-x) : x\*\*2

impair : g(-x) = -g(x) : x\*\*3

## 2

```python
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
print(verif_symetrie(g,x))
print(verif_symetrie(e,x))

```

### EX deriver :

## 1

La formule centrée \(\frac{f(a+h)-f(a-h)}{2h}\) est plus précise car elle équilibre le calcul en observant la fonction à la fois juste avant (\(a-h\)) et juste après (\(a+h\)) le point visé. Grâce aux développements de Taylor, on sait que son erreur est proportionnelle à \(h^{2}\) (ordre 2), alors que la formule classique fait une erreur bien plus grande, proportionnelle à \(h\) (ordre 1).

## 2

```py

def derivee(f, a, h=1e-5):
    return (f(a + h) - f(a - h)) / (2 * h)


def f_carre(x):
    return x**2

def fcube(x):
    return x**3

print(derivee(f_carre,4))

print(derivee(fcube,2))
```

### EX Methode 62

## 1,2

0 0
0,5 2,47308190605019
1 8,15484548537714
1,5 20,1676008165213
2 44,3343365935839
2,5 91,368704705276
3 180,769832308689
3,5 347,712245566269
4 655,177800397731
4,5 1215,23127255704
5 2226,19738653865

## 3, 4

```py
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
```

### ex 64

```py
import numpy as np

# Définition
f = lambda x: np.exp(x)
T0 = lambda x: 1 + x

# Recherche du seuil sur [0, 0.5]
x_vals = np.linspace(0, 0.5, 10000)
for x in x_vals:
    if abs(f(x) - T0(x)) > 0.05:
        print(f"L'erreur dépasse 0.05 pour x > {x:.4f}")
        break
```

### EX 80

- La formule du développement de Taylor d’une fonction \(f\) autour d’un point \(a\) à l’ordre \(n\) s'écrit : \(f(x)=f(a)+f^{\prime }(a)(x-a)+\frac{f^{\prime \prime }(a)}{2!}(x-a)^{2}+\dots +\frac{f^{(n)}(a)}{n!}(x-a)^{n}+R\*{n}(x)\)

- Ou, avec le symbole de somme (\(\sum \)) :\(f(x)=\sum \*{k=0}^{n}\frac{f^{(k)}(a)}{k!}(x-a)^{k}+R\_{n}(x)\)\(f^{(k)}(a)\)

on l'utilise car c'est plus simple et facile à analyser
