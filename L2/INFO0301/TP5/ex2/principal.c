#include <stdio.h>
#include "maillon.h"

int main(void){
    maillon *chaine = creechaine(500);
    ajouterapres(chaine, chercherval(chaine, 400), 100000);
    maillon *x = chercherval(chaine, 100000);
    supprimer(chaine, chercherval(chaine, 100));
    printf("element 100000 a laddresse  %p\n",x);
    printf("element 100 : %p ",chercherval(chaine, 100));
    return  0;
}
