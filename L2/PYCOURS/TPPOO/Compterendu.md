# Compte-rendu TP — UnivSim (POO en Python)

**Étudiant :** Nidal Dahbi

**UE :** PPRI0301 — Analyse de données en Python

**Date :** 16 octobre 2026

---

## Partie 1 – La classe de base : Salle

### Q1.1 – Prédiction et exécution

Code testé :

```python
s = Salle("D101", 30)
s.entrer(25)
s.entrer(10)
print(s.get_occupants())
s.sortir(40)
print(s.get_occupants())

```

- **Prédiction :**
- `s.entrer(25)` : 25 personnes entrent.
- `s.entrer(10)` : 35 > 30, la capacité est dépassée. Le message `"pas assez de place"` s'affiche et personne n'entre.
- `print(...)` : affiche `25`.
- `s.sortir(40)` : la méthode bloque à 0 pour éviter un effectif négatif.
- `print(...)` : affiche `0`.

- **Trace réelle :**

```text
pas assez de place
25
0

```

- **Écart :** aucun écart, le comportement respecte bien le refus d'entrée sans ajout partiel.

---

### Q1.2 – Portée

Le code `__occupants = __occupants + n` lève une exception `UnboundLocalError`.

Python détecte le signe `=` et interprète `__occupants` comme une **variable locale** à la méthode. Il essaie ensuite d'évaluer le membre droit (`__occupants + n`) avant que cette variable locale n'ait reçu une valeur.

Pour modifier l'**attribut d'instance**, il faut explicitement écrire `self.__occupants`.

---

### Q1.3 – _Name mangling_

Après `s._Salle__occupants = 999`, l'instruction `s.get_occupants()` renvoie **999**.

Cela démontre que l'encapsulation en Python n'est pas un verrouillage absolu : le double tiret bas applique seulement un renommage interne (_name mangling_ en `_Salle__occupants`) pour éviter les collisions de noms lors de l'héritage. L'attribut est dit « private » par **convention** et reste accessible.

---

## Partie 2 – Encapsulation : héritée et spécialisée

### Q2.1 – Choix de conception

`est_rentable` dépend uniquement d'une valeur brute (la capacité) sans avoir besoin d'accéder aux attributs d'une instance existante (`self`). En faire une méthode d'instance forcerait à créer une salle inutilement juste pour tester un seuil.

**Critère de choix :**

- **Instance (`self`) :** lit ou modifie l'état d'un objet précis (`entrer`, `sortir`).
- **Classe (`cls`) :** manipule la classe, souvent pour créer une instance alternative (_factory_ comme `from_texte`).
- **Statique (`@staticmethod`) :** simple fonction utilitaire qui ne dépend ni de l'objet ni de la classe.

---

### Q2.2 – Prédiction et test

- `Salle.est_rentable(15)` : renvoie `False`.
- `Salle.from_texte("D103;60")` : crée et renvoie une nouvelle instance de `Salle`.
- `s.est_rentable(15)` : renvoie `False` si décorée avec `@staticmethod`. Sans décorateur, Python transmet automatiquement `self` en premier argument, provoquant une erreur `TypeError` (2 arguments reçus pour 1 attendu).

---

### Q2.3 – Traces personnelles

Code exécuté :

```python
s1 = Salle.from_texte("B201;40")
s2 = Salle("Labo", 15)

s1.entrer(30)
print(s1.get_occupants())
s2.entrer(10)
print(s2.get_occupants())

s1.sortir(12)
print(s1.get_occupants())
s2.sortir(15)
print(s2.get_occupants())

```

**Trace console :**

```text
30
10
18
0

```

---

## Partie 3 – Héritage et polymorphisme

### Q3.1 – Polymorphisme

L'appel uniforme `salle.entrer(30)` exécute la version de `entrer` propre à chaque objet à l'exécution sans tester son type : c'est le **polymorphisme par sous-typage**.

Sans réécriture dans les classes filles, c'est l'implémentation de base de `Salle` qui s'appliquerait à tous, ignorant la limite de 90 % de l'amphi et le plafond des postes de la salle de TP.

---

### Q3.2 – _Duck typing_

`CourtDeSport` est accepté dans la boucle du campus sans hériter de `Salle` car il dispose de la méthode `entrer(n)`. Python vérifie la présence de l'interface appelée et non la classe d'origine (_duck typing_).

**Risque :** si un objet ne possède pas la méthode `entrer`, le code plante à l'exécution dès son passage dans la boucle :

```text
AttributeError: 'ObjetInvalide' object has no attribute 'entrer'

```

---

### Q3.3 – Utilisation de `super()`

Extrait du code :

```python
class Amphi(Salle):
    def __init__(self, nom: str, capacite: int, micro: bool) -> None:
        super().__init__(nom, capacite)
        self.__micro = micro

```

Appeler en dur `Salle.__init__(self, ...)` fonctionne en héritage direct, mais provoque des doubles exécutions de classes ancêtres en cas d'héritage multiple (problème du diamant). `super()` garantit que chaque classe parente n'est initialisée qu'une seule fois selon le MRO.

---

## Partie 4 – Méthodes spéciales et finitions

### Q4.1 – `==` contre `is`

Code exécuté :

```python
s1 = Salle("D1", 10)
s2 = Salle("D1", 10)

print(s1 == s2)
print(s1 is s2)

```

**Trace console :**

```text
False
False

```

- **`is`** teste l'identité mémoire (`id(s1) == id(s2)`), donc deux adresses distinctes renvoient `False`.
- **`==`** appelle `__eq__`. Comme chaque création de salle incrémente `_dernier_numero`, deux instances ont des numéros d'identification uniques différents, donc `s1 == s2` renvoie `False`.

---

### Q4.2 – MRO (Bonus)

Ordre retourné par `SalleAnnexe.mro()` :

```python
[<class '__main__.SalleAnnexe'>, <class '__main__.Salle'>, <class '__main__.Batiment'>, <class 'object'>]

```

Le MRO donne l'ordre exact de recherche des méthodes et attributs (d'abord `SalleAnnexe`, puis `Salle`, `Batiment`, et enfin `object`). Il résout le problème du diamant en linéarisant l'arbre d'héritage sans répétition de classe parente.

L'encapsulation oblige à regrouper les contrôles (seuils, effectifs négatifs) dans la classe via des méthodes dédiées, évitant de corrompre l'état des objets depuis l'extérieur.  
La limite concrète en Python est que le mot-clé `private` n'existe pas : le _name mangling_ n'empêche pas de modifier un attribut de force. De plus, avec le typage dynamique, une méthode absente ou mal orthographiée n'est détectée qu'au crash à l'exécution.
