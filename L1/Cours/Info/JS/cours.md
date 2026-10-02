# Cours JavaScript

## Bases de JavaScript

### Variables et types

JavaScript supporte plusieurs types de données : `string`, `number`, `boolean`, `null`, `undefined`, `object`, etc.

```javascript
const name = "John";
const age = 30;
const active = true;
```

### Fonctions

Les fonctions sont des blocs de code réutilisables.

```javascript
function add(a, b) {
  return a + b;
}
```

### Méthodes sur les chaînes de caractères

Les chaînes de caractères disposent de nombreuses méthodes utiles.

```javascript
const str = "Hello World";

str.length; // 11
str.toUpperCase(); // "HELLO WORLD"
str.toLowerCase(); // "hello world"
str.charAt(0); // "H"
str.indexOf("World"); // 6
str.substring(0, 5); // "Hello"
str.includes("World"); // true
str.split(" "); // ["Hello", "World"]
str.trim(); // supprime les espaces
```

## Constructeur d'objet

### Définition d'objet par constructeur

```javascript
function Person(firstname, lastname) {
  this.firstname = firstname;
  this.lastname = lastname;
  this.display = function () {
    console.log(this.firstname + " " + this.lastname);
  };
}
```

### Utilisation

```javascript
const person1 = new Person("John", "Doe");
person1.display(); // John Doe
```

### Ajout de méthode au prototype

```javascript
Person.prototype.greet = function () {
  console.log("Bonjour " + this.firstname);
};

person1.greet(); // Bonjour John
```

### Accès et modification des propriétés

```javascript
console.log(person1.firstname); // "John"
person1.firstname = "Jane";
person1.age = 25;
delete person1.age;
console.log("firstname" in person1); // true
```

### Parcourir les propriétés

```javascript
for (let key in person1) {
  console.log(key + ": " + person1[key]);
}

const keys = Object.keys(person1);
```

## Objets littéraux

Créez des objets sans constructeur avec la syntaxe littérale :

```javascript
const person = {
  firstname: "John",
  lastname: "Doe",
  age: 30,
  display: function () {
    console.log(this.firstname + " " + this.lastname);
  },
};

person.display(); // John Doe
```

### Caractéristiques

- **Syntaxe simple** : directe et lisible
- **Propriétés dynamiques** : ajout/suppression à tout moment
- **Méthodes** : fonctions comme valeurs
- **Accès** : notation pointée `objet.propriete` ou crochets `objet['propriete']`

## Tableaux

### Définition

Un tableau est une collection ordonnée d'éléments accessibles par index (commençant à 0).

```javascript
let t = [1, 2, 3, 4];
t[0]; // 1
```

### Méthodes courantes

```javascript
const arr = [1, 2, 3, 4, 5];

arr.length; // 5
arr.push(6); // ajoute à la fin
arr.pop(); // supprime le dernier
arr.shift(); // supprime le premier
arr.unshift(0); // ajoute au début
arr.indexOf(3); // 2
arr.includes(4); // true
arr.slice(1, 3); // [2, 3]
arr.join("-"); // "1-2-3-4-5"
arr.reverse(); // inverse
arr.sort(); // trie
arr.map((x) => x * 2); // transforme chaque élément
arr.filter((x) => x > 2); // filtre
arr.reduce((acc, x) => acc + x, 0); // réduit
arr.forEach((x) => console.log(x)); // itère
```

## Map

### Définition

Une `Map` est une collection de paires clé-valeur où les clés peuvent être de n'importe quel type.

```javascript
const map = new Map();
map.set("name", "John");
map.set(1, "un");
map.set(true, "vrai");

map.get("name"); // "John"
map.size; // 3
map.has("name"); // true
map.delete("name");
map.clear();
```

### Itération

```javascript
for (let [key, value] of map) {
  console.log(key + ": " + value);
}

map.forEach((value, key) => {
  console.log(key + ": " + value);
});
```

### Définition

Un `Set` est une collection de valeurs uniques (pas de doublons).

```javascript
const set = new Set();
set.add(1);
set.add(2);
set.add(1); // ignoré, déjà présent

set.size; // 2
set.has(1); // true
set.delete(1);
set.clear();
```

### Itération

```javascript
for (let value of set) {
  console.log(value);
}

set.forEach((value) => {
  console.log(value);
});

const arr = Array.from(set); // convertir en tableau
```

## objet set

### Utilisation courante

Les `Set` sont utiles pour supprimer les doublons d'un tableau ou vérifier l'unicité de valeurs.

```javascript
const numbers = [1, 2, 2, 3, 3, 3, 4];
const unique = new Set(numbers); // Set { 1, 2, 3, 4 }

const arr = Array.from(unique); // [1, 2, 3, 4]
```

Comparaison avec les tableaux :

| Opération          | Array        | Set        |
| ------------------ | ------------ | ---------- |
| Ajouter            | `push()`     | `add()`    |
| Supprimer          | `splice()`   | `delete()` |
| Vérifier existence | `includes()` | `has()`    |
| Taille             | `length`     | `size`     |
| Doublons           | Autorisés    | Interdits  |

# DOM séléction :

## Sélection d'éléments

### Par ID

```javascript
const element = document.getElementById("myId");
```

### Par classe

```javascript
const elements = document.getElementsByClassName("myClass");
const elements = document.querySelectorAll(".myClass");
```

### Par tag

```javascript
const elements = document.getElementsByTagName("div");
```

### Sélecteurs CSS

```javascript
const element = document.querySelector("#myId"); // premier match
const elements = document.querySelectorAll("div.myClass"); // tous les matches
```

### Navigation dans le DOM

```javascript
element.parentElement; // parent
element.children; // enfants
element.firstChild; // premier enfant
element.lastChild; // dernier enfant
element.nextSibling; // élément suivant
element.previousSibling; // élément précédent
```

pour les collection retourner par les selecteru par exemple queryselector(.test)
donc on utilise `forEach()` :

```javascript
const elements = document.querySelectorAll(".test");
elements.forEach((el) => {
  console.log(el);
});
```

Convertir en tableau pour utiliser `map()`, `filter()`, etc. :

```javascript
const arr = Array.from(elements);
arr.map((el) => el.textContent);
```

## Manipulation du contenu

### Modifier le texte et le HTML

```javascript
element.textContent = "Nouveau texte"; // texte brut
element.innerHTML = "<p>Nouveau HTML</p>"; // HTML
element.innerText = "Texte visible"; // texte affiché
```

### Ajouter/supprimer des éléments

```javascript
const newElement = document.createElement("div");
element.appendChild(newElement); // ajouter en enfant
element.insertBefore(newElement, element.firstChild); // insérer avant
element.removeChild(newElement); // supprimer enfant
newElement.remove(); // supprimer l'élément
```

### Gérer les classes et attributs

```javascript
element.classList.add("active");
element.classList.remove("active");
element.classList.toggle("active");
element.classList.contains("active"); // true/false

element.setAttribute("data-id", "123");
element.getAttribute("data-id"); // "123"
element.removeAttribute("data-id");
```
