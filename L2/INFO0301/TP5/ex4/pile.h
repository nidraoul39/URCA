#ifndef PILE
#define PILE
#include "element.h"

typedef struct pile pile;
struct pile{
    element *e;
    pile *suivant;
};

void initialiser();
void estVide(pile *p);
void empile(pile *p, element *e);
void depile(pile *p);
int taille(pile *p);
element* sommet(pile *p);
void viderpile(pile *p);
void copypile(pile *p);



#endif