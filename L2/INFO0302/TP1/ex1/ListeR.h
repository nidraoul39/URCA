#ifndef LISTER
#define LISTER
#include "Key.h"

typedef int Element;

typedef struct El2P
{
    struct El2P *prec;
    struct El2P *svt;
    Key key;
    Element value;
    
}Element2p;


typedef Element2p *ListeR;

void LR_insert(ListeR *,Key,Element);
Element2p * LR_recherche(ListeR *,Key);
void LR_supprimer(ListeR *,Element2p*);


#endif