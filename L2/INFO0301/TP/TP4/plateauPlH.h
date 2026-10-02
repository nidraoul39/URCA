#ifndef PLATEAUPLH
#define PLATEAUPLH

#include "pile.h"

typedef struct{
        PileTSEnt t[3];  
} plateauHanoi;

void creerPLH(plateauHanoi *plateau,int nb);
_Bool finiPlh(plateauHanoi *plateau);
_Bool deplacerPlh(plateauHanoi *plateau,int i,int j);
void afficherPlH(plateauHanoi *plateau);

#endif