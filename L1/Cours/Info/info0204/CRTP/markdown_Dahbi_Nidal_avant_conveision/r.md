<div style="page-break-after: always;">

<table style="height: 100vh; width: 100%; border: none;">
<tr>
<td style="vertical-align: middle; text-align: center; border: none;">
<div align="center">

# CRTP — INFO 0204

## Réseaux

### TP de synthèse et évaluation

<br>

    Université de Reims Champagne–Ardenne
    UFR Sciences Exactes et Naturelles
    Département Mathématiques–Informatique
    L1 Informatique — Année 2025–2026

</div>

<br><br><br>

### **Nom : Nidal**

### **Groupe de TP : Info-S2-1A**

</td>
</tr>
</table>

</div>

# Exercice 1 — Plan d’adressage

## 1) Caractéristiques de l’adresse 172.30.0.0

### a) Classe de l’adresse IPv4

L’adresse **172.30.0.0** appartient à la classe B.

En effet, le premier octet vaut 172 :

172 = 10101100₂

Les adresses de classe B commencent par le préfixe binaire `10`.

---

### b) Masque réseau par défaut

Le masque par défaut d’une adresse de classe B est :

255.255.0.0 (/16)

Cela correspond à :

- 16 bits pour le réseau
- 16 bits pour les hôtes

---

### c) Adresses interdites

Adresse réseau : 172.30.0.0  
Adresse de diffusion : 172.30.255.255

Ces deux adresses ne peuvent pas être attribuées à des machines.

---

### d) Nombre d’hôtes disponibles

2^16 − 2 = 65 534 hôtes

## 2) Codage des deux derniers chiffres du numéro étudiant

### a) Nombre minimal de bits

Il faut 5 bits pour coder la valeur xy Dans mon cas.

---

### b) Code binaire obtenu

11101

---

## 3) Adresse obtenue dans le 3ᵉ octet

En plaçant cette suite binaire à gauche dans le 3ᵉ octet :

11101000₂ = 232

Adresse obtenue :

172.30.232.0

## 4) Sous-domaine obtenu

### a) Masque du sous-réseau

255.255.248.0 (/21)

---

### b) Capacité du sous-domaine

2^11 − 2 = 2046 hôtes

---

## 5) Vérification du découpage

Le sous-domaine doit être divisé en 10 sous-réseaux.

Nombre total de machines nécessaires : 413

Ce nombre est inférieur à 2046.

Le découpage est donc réalisable.

<div style="page-break-after: always; visibility: hidden">
\pagebreak
</div>

## 6) Plan d’adressage proposé

| Sous-réseau | Préfixe | Masque                | Adresse réseau | Plage d’hôtes                   | Diffusion      | Nb hôtes |
| ----------- | ------- | --------------------- | -------------- | ------------------------------- | -------------- | -------- |
| A           | 100     | 255.255.255.0 (/24)   | 172.30.236.0   | 172.30.236.1 – 172.30.236.254   | 172.30.236.255 | 254      |
| B           | 1010    | 255.255.255.128 (/25) | 172.30.237.0   | 172.30.237.1 – 172.30.237.126   | 172.30.237.127 | 126      |
| C           | 101110  | 255.255.255.224 (/27) | 172.30.237.192 | 172.30.237.193 – 172.30.237.222 | 172.30.237.223 | 30       |
| D           | 101111  | 255.255.255.224 (/27) | 172.30.237.224 | 172.30.237.225 – 172.30.237.254 | 172.30.237.255 | 30       |
| E           | 10110   | 255.255.255.192 (/26) | 172.30.237.128 | 172.30.237.129 – 172.30.237.190 | 172.30.237.191 | 62       |
| F           | 00      | 255.255.254.0 (/23)   | 172.30.232.0   | 172.30.232.1 – 172.30.233.254   | 172.30.233.255 | 510      |
| G           | 01      | 255.255.254.0 (/23)   | 172.30.234.0   | 172.30.234.1 – 172.30.235.254   | 172.30.235.255 | 510      |
| H           | 1100    | 255.255.255.128 (/25) | 172.30.238.0   | 172.30.238.1 – 172.30.238.126   | 172.30.238.127 | 126      |
| I           | 1101    | 255.255.255.128 (/25) | 172.30.238.128 | 172.30.238.129 – 172.30.238.254 | 172.30.238.255 | 126      |
| J           | 111     | 255.255.255.192 (/26) | 172.30.239.0   | 172.30.239.1 – 172.30.239.62    | 172.30.239.63  | 62       |

Remarque :  
Le sous-réseau I possède plus d’adresses que J, mais chaque sous-réseau dispose d’une capacité suffisante (j'avais fais erreur sur l'attribution et je n'avais pas envie de changer le shema mais ce n'est pas un probleme en soit).

<div style="page-break-after: always; visibility: hidden">
\pagebreak
</div>

## Configuration du DHCP

le serveur DHCP est a chaque fois sur la premiere adresse disponible du réseau.

## Configuration type d’un routeur

les routeurs (pasrelle par défaut ) prenne la derniere addresse disponible et si d'autre routeur existe il prenne celle de la passrel -1 et ainsi de suite
Exemple pour le routeur RBF :

```bash
ip address add 172.30.233.254/23 dev FastEthernet0/0
ip address add 172.30.237.125/25 dev FastEthernet1/0

ip route add 172.30.237.224/27 via 172.30.233.253
ip route add 172.30.237.128/26 via 172.30.233.252
ip route add default via 172.30.237.126
```

La plupart des routeurs utiliseront principalement une route par défaut.

RDF :
![RDF](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-1.png?raw=true)

REF :
![REF](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-2.png?raw=true)

RBF :
![RBF](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-3.png?raw=true)

RBC :
![RBC](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-4.png?raw=true)

RAC :
![RAC](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-5.png?raw=true)

RAB :
![RAB](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-6.png?raw=true)

RAG :
![RAG](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-7.png?raw=true)

RGH :
![RGH](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-8.png?raw=true)

RHI :
![RHI](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-9.png?raw=true)

RIJ :
![RIJ](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-10.png?raw=true)

RAJ :
![RAJ](https://github.com/nidraoul39/info0204/blob/master/CRTP/image-11.png?raw=true)

---

## Placement du serveur DNS

Le serveur DNS est placé dans le sous-réseau A. a la deuxieme addresse disponible meme si on aurait pu reprendre le meme serveur que le dhcp.

Ce choix est pertinent car ce réseau est central dans l’infrastructure, ce qui facilite l’accès depuis tous les autres sous-réseaux.

![alt text](https://github.com/nidraoul39/info0204/blob/master/CRTP/image.png?raw=true)

# Conclusion

Ce plan d’adressage permet :

- une subdivision cohérente du domaine attribué
- le respect des contraintes en nombre de machines
- une organisation claire pour le routage et les services réseau
