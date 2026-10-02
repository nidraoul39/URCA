#include <stdio.h>
#include <stdbool.h>
#include "pile.h"
#include <stdlib.h>

void initialiser(){
    pile *p = malloc(sizeof(pile));
    p->e = NULL;
    p->suivant = NULL;
    return p;
}

void estVide(pile *p){
    if(p->e == NULL)
        return true;
    return false;
}

void empile(pile *p,element *e){
    pile *tmp = malloc(sizeof(pile));
    tmp->e->x = e->x;
    tmp->e->y = e->y;
    tmp->suivant = p;
    p = tmp;
}
void depile(pile *p){
    pile *tmp = p;
    p = p->suivant;
    free(tmp);
}
