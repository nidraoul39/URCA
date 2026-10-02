a = 768
b = 744
r = b
while r>0:
    r = a%b
    a = b
    b = r

print(a)