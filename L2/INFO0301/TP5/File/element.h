#ifndef ELEMENT
#define ELEMENT
#include <stdbool.h>

typedef struct element element ;
void saisie(element *e);
void afficher(element *e);
bool equal(element *e1, element *e2);


#endif