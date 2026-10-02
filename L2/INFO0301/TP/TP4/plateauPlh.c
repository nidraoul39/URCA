#include "plateauPlH.h"
#include "pile.h"
#include <stdio.h>


void creerPLH(plateauHanoi *plateau,int nb){
    for (int i = nb; i>0; i--) {
        empile(i, &plateau->t[0]);
    }
}

_Bool finiPlh(plateauHanoi *plateau){
    _Bool res;
    if(estVide(&plateau->t[0]) && estVide(&plateau->t[1]))
        res = 1;
    else 
        res = 0;
    return  res;
    
}


_Bool deplacerPlh(plateauHanoi *plateau,int i,int j){
    if (i>3 || i<1 || j>3 || j<1 || i==j || estVide(&plateau->t[i-1]) || sommet(&plateau->t[j-1])>sommet(&plateau->t[i-1])) {
        return 0;        
    }
    empile(sommet(&plateau->t[i-1]), &plateau->t[j-1]);
    depile(&plateau->t[i-1]); 
}


void afficherPlH(plateauHanoi *plateau){
    for (int i = 0; i<3; i++) {
        afficherPile(&plateau->t[i]);
        printf("\n\n");
    }
}
