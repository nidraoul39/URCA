# 🔗 Modèle Relationnel & Algèbre Relationnelle

Lien : [[Index_Bases_de_Donnees]] | [[Merise_MCD_MCT_MOT]] | [[SQL_Pratique_TP_et_Exams]]

---

## 1. Règles de Dérivation MCD $\to$ MLD (Modèle Relationnel)

Ces règles tombent **systématiquement** en examen et TP :

### Règle 1 : Entité simple
Toute entité devient une relation (table).
- L'identifiant devient **clé primaire (PK)**.
- Les propriétés deviennent des attributs.

### Règle 2 : Association binaire $(0,1)$ ou $(1,1)$ avec $(0,n)$ ou $(1,n)$
- L'entité côté `(1,1)` ou `(0,1)` reçoit la clé primaire de l'autre entité sous forme de **clé étrangère (FK)** (notée avec un `#` ou préfixée par convention).
- Les propriétés éventuelles portées par l'association migrent également dans cette table.
- *Exemple :*
  - `ARTICLE (1,1) ---- APPARTENIR ---- (0,n) FAMILLE`
  - $\to$ `FAMILLE (RefFamille, LibelleFamille)`
  - $\to$ `ARTICLE (RefArticle, LibelleArticle, PUHT, #RefFamille)`

### Règle 3 : Association plusieurs-à-plusieurs $(0,n)$ ou $(1,n)$ à $(0,n)$ ou $(1,n)$
- L'association devient une **table de liaison distincte**.
- Sa clé primaire est la **concaténation des clés primaires** des entités reliées.
- Elle embarque les propriétés de l'association.
- *Exemple :*
  - `CLIENT (0,n) ---- ACHETER ---- (0,n) ARTICLE`
  - $\to$ `ACHETER (#NoClient, #RefArticle, DateAchat, QteAchetee)` avec `PRIMARY KEY (NoClient, RefArticle)`.

---

## 2. Contraintes d'Intégrité Fondamentales

1. **Contrainte d'entité** : Toute relation doit avoir une clé primaire non nulle (`NOT NULL`) et unique.
2. **Contrainte référentielle** : Une clé étrangère doit obligatoirement correspondre à une valeur existante de la clé primaire référencée (ou être `NULL` si autorisé).
3. **Contrainte de domaine** : Un attribut doit appartenir à son ensemble de valeurs autorisées (ex: `Note BETWEEN 0 AND 20`).

---

## 3. Algèbre Relationnelle (Opérateurs de Codd)

| Opération | Notation mathématique | Signification / SQL équivalent |
| :--- | :---: | :--- |
| **Restriction (Sélection)** | $\sigma_{condition}(R)$ | Filtre les lignes (`WHERE`) |
| **Projection** | $\pi_{A1, A2}(R)$ | Filtre les colonnes sans doublons (`SELECT DISTINCT`) |
| **Produit Cartésien** | $R \times S$ | Combinaison de toutes les lignes |
| **Jointure ($\theta$-jointure)** | $R \bowtie_{cond} S$ | Produit cartésien filtré par une condition |
| **Jointure naturelle** | $R \bowtie S$ | Équi-jointure sur les attributs de même nom, dédoublonnés |
| **Union** | $R \cup S$ | Schémas identiques requis (`UNION`) |
| **Intersection** | $R \cap S$ | Schémas identiques requis (`INTERSECT`) |
| **Différence** | $R \setminus S$ | Tuples dans $R$ mais pas dans $S$ (`EXCEPT`) |
| **Division** | $R \div S$ | "Tous les..." (voir ci-dessous) |

### Cas Critique : La Division Relationnelle ($R \div S$)
Utilisée pour répondre aux requêtes universelles : *"Trouver les docteurs qui soignent tous les patients"* ou *"Les clients ayant acheté tous les produits de la gamme"*.
- Soit $R(A, B)$ et $S(B)$, le résultat $T = R \div S$ a pour schéma $T(A)$.
- $T$ contient les valeurs de $A$ qui sont associées à **toutes** les valeurs possibles de $B$ présentes dans $S$.