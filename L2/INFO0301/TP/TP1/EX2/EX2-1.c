#include "temps.h"
#include <stdio.h>
#include <stdlib.h>

int main(void){
    temps t;
    t=creer(1,5,4);
    if(correct(t))
        printf("le temps est bon \n");
    else
        printf("erreur le temps est moche \n");

    saisir(&t);
    
    afficher(t);
    
    temps t2;

    t2 = creer2();
    t2 = normaliser(t2);
    afficher(t2);


    return EXIT_SUCCESS;
}