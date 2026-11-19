#include "ListeR.h"
#include "Key.h"
#include <stdio.h>

int main(){
    ListeR x;
    x = NULL;

    LR_insert(&x,10,3);
    LR_insert(&x,4,6);
    LR_insert(&x,23,45);
    Element2p *p=LR_recherche(&x,4);
    if(p!=NULL){
        LR_supprimer(&x,p);
        printf("element supprimer !!");
    }
    else{
        printf("letes to vicecyty");
    }
    return 0;
}