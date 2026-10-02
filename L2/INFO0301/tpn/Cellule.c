#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "element.h"
#include "Cellule.h"

Cellule *creerC(void) {
    Cellule *c = malloc(sizeof(Cellule));
    assert(c != NULL && "erreur pointeur non alloué");
    c->e = saisi();
    c->svt = NULL;
    return c;
}