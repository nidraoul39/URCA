#include "ListeR.h"
#include <stdio.h>
#include <stdlib.h>

void LR_insert(ListeR *px,Key k,Element v){
    Element2p *elem = malloc(sizeof(Element2p));
    elem->key = k;
    elem->value = v;
    elem->svt = *px;
    elem->prec = NULL;
    *px = elem;
}
void LR_supprimer(ListeR *px,Element2p *p){
    if(p->prec == NULL){
        *px = p->svt;
        p->svt->prec = NULL;
    }
    else{
        p->prec->svt = p->svt;
        p->svt->prec = p->prec;
    }

    free(p);
}
Element2p *LR_recherche(ListeR *px,Key k){
    Element2p *actual = *px;
    while (actual != NULL && actual->key != k)
    {
        actual = actual->svt;
    }
    return actual;
}