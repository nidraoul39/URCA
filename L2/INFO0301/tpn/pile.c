#include "element.h"
#include "Cellule.h"
#include "pile.h"
#include <stdbool.h>
#include <stdlib.h>

Element sommet(Pile *p){
    if (estVide(p))
    {
        exit(-1);
    }
    Element e = p->som->e;
    return e;
}

void depile(Pile *p){
    if (estVide(p))
    {
        exit(-1);
    }
    
    Cellule *tmp = p->som;
    p->som = p->som->svt;
    free(tmp);
}

void empile(Pile *p,Cellule *c){
    if(!estVide(p)){
        c->svt = p->som;
    }
    p->som = c;

}

bool estVide(Pile *p){
    if(p->som == 0){
        return true;
    }
    return false;
}

void liberer(Pile *p){
    free(p);
}