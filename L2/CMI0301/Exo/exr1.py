import math

def g(x):
    return math.sqrt(1+x)
i = -1
while i<=1.5:
    print(f"g({i}) = {g(i):.3g}")
    i+=0.5