# 💻 SQL Pratique (TP Noté & Examen)

Lien : [[Index_Bases_de_Donnees]] | [[Modele_Relationnel_et_Algebre]]

---

## 1. Ordre d'Exécution et Syntaxe SELECT

```sql
SELECT [DISTINCT] colonnes_ou_agregats
FROM table1
INNER JOIN table2 ON condition_jointure
WHERE condition_filtre_lignes
GROUP BY colonnes_de_regroupement
HAVING condition_filtre_groupes
ORDER BY colonne [ASC | DESC];
```

> **Attention piège :** `WHERE` filtre les lignes **avant** le regroupement. `HAVING` filtre les groupes **après** calcul d'agrégat (`COUNT`, `AVG`, `SUM`, etc.).

---

## 2. Langage de Définition de Données (LDD)

### Création d'une table avec PK et FK
```sql
CREATE TABLE Employe (
    NoEmpl INT NOT NULL,
    Nom VARCHAR(50) NOT NULL,
    Salaire DECIMAL(8,2) NOT NULL,
    NoService INT,
    CONSTRAINT pk_employe PRIMARY KEY (NoEmpl),
    CONSTRAINT fk_employe_service FOREIGN KEY (NoService) 
        REFERENCES Service(NoService)
        ON DELETE SET NULL
);
```

### Altération de table (très demandé en TP)
```sql
-- Ajouter une colonne
ALTER TABLE Employe ADD Prenom VARCHAR(50);

-- Ajouter une clé étrangère a posteriori
ALTER TABLE Employe ADD INDEX (NoService);
ALTER TABLE Employe ADD CONSTRAINT fk_sec FOREIGN KEY (NoService) REFERENCES Service(NoService);

-- Supprimer une contrainte
ALTER TABLE Employe DROP FOREIGN KEY fk_sec;
```

---

## 3. Manipulation de Données (LMD)

```sql
-- Insertion
INSERT INTO Service (NoService, NomService) VALUES (10, 'Informatique');

-- Mise à jour
UPDATE Employe SET Salaire = Salaire * 1.05 WHERE NoService = 10;

-- Suppression ciblée
DELETE FROM Employe WHERE NoEmpl = 42;
```

---

## 4. Types de Jointures (À maîtriser absolument)

- **INNER JOIN** : Ne garde que les correspondances strictes entre les deux tables.
- **LEFT JOIN** : Garde toutes les lignes de la table de gauche, même si aucune correspondance n'existe à droite (valeurs `NULL`).
- **RIGHT JOIN** : Garde toutes les lignes de la table de droite.

```sql
-- Exemple : Tous les clients et leurs commandes éventuelles (même ceux qui n'ont rien commandé)
SELECT C.NoClient, C.NomClient, O.NoCommande
FROM Client C
LEFT JOIN Commande O ON C.NoClient = O.NoClient;
```

---

## 5. Sous-requêtes et Opérateurs Avancés

### Sous-requêtes avec `IN`, `EXISTS`, `NOT EXISTS`
```sql
-- Trouver les clients qui n'ont jamais passé de commande
SELECT NomClient 
FROM Client C 
WHERE NOT EXISTS (
    SELECT 1 FROM Commande O WHERE O.NoClient = C.NoClient
);
```

### Le Cas d'Examen : Implémentation de la Division ($R \div S$)
*Question type : "Donner les clients qui ont acheté TOUS les produits du catalogue."*
$\to$ Formulation logique équivalente : *"Trouver les clients pour lesquels il n'existe AUCUN produit qu'ils n'ont PAS acheté."*

```sql
SELECT C.NoClient, C.NomClient
FROM Client C
WHERE NOT EXISTS (
    -- Ensemble des produits non achetés par ce client
    SELECT P.RefProduit
    FROM Produit P
    WHERE NOT EXISTS (
        SELECT 1
        FROM Achat A
        WHERE A.NoClient = C.NoClient 
          AND A.RefProduit = P.RefProduit
    )
);
```

---

## 6. Fonctions d'Agrégation et Regroupement

```sql
-- Nombre de commandes et montant total par client ayant passé au moins 3 commandes
SELECT NoClient, COUNT(NoCommande) AS TotalCommandes, SUM(Montant) AS MontantCumule
FROM Commande
GROUP BY NoClient
HAVING COUNT(NoCommande) >= 3
ORDER BY MontantCumule DESC;
```