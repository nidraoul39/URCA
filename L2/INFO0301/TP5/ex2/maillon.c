#include "maillon.h"
#include <stdio.h>
#include <stdlib.h>

maillon* creechaine(int nb){
    maillon *origin = malloc(sizeof(maillon));
    origin->element = 0;
    maillon *base;
    base = origin;
    
    for (int i = 1; i<nb; i++) {
        origin->suivant = malloc(sizeof(maillon));
        origin->element = i;
        origin = origin->suivant;
    }
    origin->suivant = NULL;
    
    return base;
}


maillon* chercherval(maillon *origin,int element){
    maillon *chaine = origin;

    while (chaine != NULL) {
            if (chaine->element == element)
                return chaine;
            chaine = chaine->suivant;
        }
    return NULL;
}

void modifval(maillon *chaine,maillon *position,int element){
    position->element = element;
}

void ajouterapres(maillon *chaine,maillon *position,int n){
    maillon *new=malloc(sizeof(maillon)) ;
    new->element = n;
    new->suivant =position->suivant;
    position->suivant = new;
}

void supprimer(maillon *chaine, maillon *position){
    while (chaine->suivant != NULL && chaine->suivant != position) {
        chaine = chaine->suivant;
    }
    if (chaine->suivant == NULL) {
        return;
    }
    
    chaine->suivant = position->suivant;
    free(position);
}


