#include "Element.h"
#include <stdbool.h>
#include <stdlib.h>
#include "File_.h"
#include "Cellule.h"
void enfiler(File_ *f,Element e){
    cellule *c = malloc(sizeof(cellule));
    c->e = e;
    f->fin->svt = c;
    f->fin = c;
}
void defiler(File_ *f)