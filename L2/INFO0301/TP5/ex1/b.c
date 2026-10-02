#include <stdio.h>
#include <stdlib.h>

typedef struct maillon{
    int element;
    struct maillon *suivant;
} maillon;

int main(void){
    maillon *x=malloc(sizeof(maillon));
    maillon *origin=x;
    x->element=1;
    x->suivant = malloc(sizeof(maillon));
    x=x->suivant;
    x->element = 3;
    x->suivant = malloc(sizeof(maillon));
    x=x->suivant;
    x->element = 2;
    x = origin;
    while (x!=NULL) {
        printf("%d \n",x->element);
        x=x->suivant;
    }
    x=origin;
    while (x!=NULL) {
        origin = x;
        x=x->suivant;
        free(origin);
    }


    return 0;
}