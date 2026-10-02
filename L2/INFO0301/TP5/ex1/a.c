#include <stdio.h>
#include <stdlib.h>

typedef struct maillon{
    int element;
    struct maillon *suivant;
} maillon;

int main(void){
    maillon *x=malloc(sizeof(maillon));
    x->element=0;
    x->suivant = malloc(sizeof(maillon));
    maillon *origin=x;
    for(int i = 1;i<400;i++){
        x = x->suivant;
        x->element = i;
        x->suivant = malloc(sizeof(maillon));
    }
    
    x->suivant=NULL;
    x = origin;
    while (x->suivant != NULL) {
        printf("valeur du maillon : %d\n addresse suiv du maillon %p \n",x->element,x->suivant);
        x=x->suivant;
    }
    maillon *tmp;
    while (x->suivant != NULL) {
        tmp = x;
        x = x->suivant;
        free(tmp);
    }
    free(x);
    printf("%p , %d",x->suivant,x->element);
    return 0;
}