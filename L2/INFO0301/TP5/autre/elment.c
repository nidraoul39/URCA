#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "element.h"

void saisie(element *e){
    printf("enter l'a partie reel : ");
    scanf("%lf",&(e->x));
    printf("entrer la partie entiere : ");
    scanf("%d",&(e->y));
}

void afficher(element *e){
    printf("partie entiere : %d \npartie reel : %2lf",e->y,e->x);
}
bool equal(element *e1,element *e2){
    return ((e1->x == e2->x) && (e1->y == e2->y));
}

int valeurentiere(element *e){
    return e->y;
}
double valeurreel(element *e){
    return e->x;
}

