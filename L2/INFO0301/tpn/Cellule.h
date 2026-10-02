#ifndef CELLULE_H
#define CELLULE_H

#include "element.h" /* Obligatoire pour connaître le type Element */

typedef struct Cellule Cellule; /* Déclaration préalable */

struct Cellule {
    Element e;
    Cellule *svt; /* ou struct Cellule *svt; */
};

Cellule *creerC(void);

#endif