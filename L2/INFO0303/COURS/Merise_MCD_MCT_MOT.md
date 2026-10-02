# 📐 Conception Merise : MCD, MCT, MOT

Lien : [[Index_Bases_de_Donnees]] | [[Modele_Relationnel_et_Algebre]]

---

## 1. Modèle Conceptuel des Données (MCD)

Le MCD répond à la question : **QUOI ?** (indépendamment du matériel et de l'organisation).

### Composants fondamentaux
- **Entité** : Objet ou individu ayant une existence propre (ex: `CLIENT`, `ARTICLE`).
- **Attribut / Propriété** : Donnée élémentaire qualifiant l'entité.
  - *Règle d'atomicité* : Les valeurs doivent être indivisibles (ex: `Nom` et `Prenom`, pas `NomPrenom`).
  - *Règle d'unicité* : Chaque attribut n'apparaît qu'une seule fois dans le MCD.
- **Identifiant (Clé primaire conceptuelle)** : Attribut unique permettant d'identifier sans ambiguïté chaque occurrence de l'entité (souligné dans le schéma).
- **Association / Relation** : Lien sémantique entre entités.
  - *Dimension* : Binaire (2 entités), Ternaire (3 entités), Réflexive (l'entité sur elle-même).
  - *Association porteuse* : Contient des propriétés dépendant de toutes les entités reliées (ex: `DateAchat`, `QteAchetee` sur `ACHETER`).

### Cardinalités
Couple `(min, max)` positionné côté entité :
- `min` : Nombre minimal de fois où une entité participe à l'association ($0$ ouou $1$).
- `max` : Nombre maximal de fois où une entité participe à l'association ($1$ ou $n$).

```mermaid
erDiagram
    CLIENT ||--o{ ACHETER : "0,n"
    ARTICLE ||--o{ ACHETER : "0,n"
    ARTICLE }o--|| FAMILLE : "1,1 / 0,n"

    CLIENT {
        int NoClient PK
        string NomClient
        string VilleClient
    }
    ACHETER {
        date DateAchat
        int QteAchetee
    }
    ARTICLE {
        int RefArticle PK
        string LibelleArticle
        float PUHT
    }
    FAMILLE {
        int RefFamille PK
        string LibelleFamille
    }
```

> **Note d'examen (C.I.F.)** : La relation a   vec cardinalité `(1,1)` (ex: `ARTICLE -> APPARTENIR -> FAMILLE`) représente une **Contrainte d'Intégrité Fonctionnelle**.

---

## 2. Modèle Conceptuel des Traitements (MCT)

Le MCT formalise le fonctionnement dynamique du Système d'Information (toujours au niveau **QUOI ?**).

```mermaid
flowchart TD
    %% Événements initiaux
    E1([Demande Client])

    %% Synchronisation OP1
    Sync1{{a}}

    %% Opération 1
    subgraph OP1["Opération : Prise en charge de la demande"]
        direction TB
        A1["- action 1<br/>- action 2"]
    end

    %% Règle d'émission OP1
    R1["Toujours"]

    %% Résultats OP1
    Res1_1([Dde renseig. Bq de France])
    Res1_2([Création Dossier client])

    %% Événements entrants OP2
    E2([Réponse Bq De France])

    %% Synchronisation OP2
    Sync2{{"b ET c"}}

    %% Opération 2
    subgraph OP2["Opération : Traitement de la réponse"]
        direction TB
        A2["- action 1<br/>- action 2"]
    end

    %% Règles d'émission OP2
    R2_1["Refus"]
    R2_2["Accord"]

    %% Résultats OP2
    Res2_1([Lettre de refus])
    Res2_2([Demande signature])

    %% Connexions OP1
    E1 -->|a| Sync1
    Sync1 --> OP1
    OP1 --> R1
    R1 --> Res1_1
    R1 --> Res1_2

    %% Connexions OP2
    E2 -->|b| Sync2
    Res1_2 -->|c| Sync2
    Sync2 --> OP2
    OP2 --> R2_1
    OP2 --> R2_2
    R2_1 --> Res2_1
    R2_2 --> Res2_2
```

### Concepts indispensables
1. **Événement** : Fait déclencheur (externe ou résultat interne).
2. **Synchronisation** : Condition booléenne (`ET`, `OU`) requise pour débuter l'opération.
3. **Opération** : Suite ininterruptible d'actions sur les données.
4. **Règles d'émission** : Conditions logiques définissant quel résultat est émis en sortie.

---

## 3. Modèle Organisationnel des Traitements (MOT)

Le MOT répond à : **QUI ? OÙ ? QUAND ?**

- **Poste de travail** (**OÙ**) : Accueil, Service comptabilité, Guichet.
- **Ressource & Nature** (**QUI**) : Automatique (Batch), Conversationnel (Écran/Saisie), Manuel.
- **Périodicité / Chronologie** (**QUAND**) : Immédiat, Fin de mois, Quotidien à minuit.
- **Règle des 3 unités d'une Phase (Procédure fonctionnelle)** : Même poste, Même période, Même nature d'action.