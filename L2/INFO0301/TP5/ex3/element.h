#ifndef ELEMENT
#define ELEMENT
#include <stdbool.h>
typedef struct element{
    double x;
    int y;
} element ;

void saisie(element *e);
void afficher(element *e);
bool equal(element *e1, element *e2);


#endif