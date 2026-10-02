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

int main(void) {
    element e1;
    element e2 = {3.14, 42};
    element e3 = {3.14, 42};

    printf("=== Test 1 : Saisie de e1 ===\n");
    saisie(&e1);

    printf("\n=== Test 2 : Affichage ===\n");
    printf("e1 : ");
    afficher(&e1);
    printf("\n");

    printf("e2 : ");
    afficher(&e2);
    printf("\n");

    printf("\n=== Test 3 : Accesseurs sur e2 ===\n");
    printf("Partie reelle de e2   : %f\n", valeurreel(&e2));
    printf("Partie entiere de e2  : %d\n", valeurentiere(&e2));

    printf("\n=== Test 4 : Comparaisons ===\n");
    if (equal(&e2, &e3)) {
        printf("e2 et e3 sont egaux (attendu : oui)\n");
    } else {
        printf("e2 et e3 sont differents\n");
    }

    if (equal(&e1, &e2)) {
        printf("e1 et e2 sont egaux\n");
    } else {
        printf("e1 et e2 sont differents\n");
    }

    return 0;
}