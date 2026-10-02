#ifndef PILE
#define PILE
#include <stdbool.h>
#include "element.h"
#include "Cellule.h"
typedef struct Pile
{
    Cellule *som;
} Pile;

Element sommet(Pile *p);
void depile(Pile *p);
void empile(Pile *p, Cellule *c);
bool estVide(Pile *p);
void liberer(Pile *p);

#endif