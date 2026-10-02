#ifndef PILE
#define PILE

#include <stdbool.h>
#include "element.h"

#define CAPACITE_MAX 100

typedef struct pile {
    element tab[CAPACITE_MAX];
    int sommet; // Indice du dernier élément empilé (-1 si vide)
} pile;

void initialiser(pile *p);
bool estVide(const pile *p);
bool estPleine(const pile *p);
bool empile(pile *p, const element *e);
bool depile(pile *p);
int taille(const pile *p);
element* sommet(pile *p);
void viderpile(pile *p);
void copypile(const pile *source, pile *destination);

#endif