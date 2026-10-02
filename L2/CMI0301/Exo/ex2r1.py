

def derivee(f, a, h=1e-5):
    return (f(a + h) - f(a - h)) / (2 * h)


def f_carre(x):
    return x**2

def fcube(x):
    return x**3

print(derivee(f_carre,4))

print(derivee(fcube,2))