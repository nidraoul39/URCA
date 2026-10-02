#ifndef TAB_POINT
#define TAB_POINT
#include "point.h"

void remplissage(point p[],int n);
int indMinD(point p[],int n,int start);
void affichage(point p[],int n);
void pluseloigner(point p[],int n,int *ind1,int *ind2);
void tripoint(point p[],int n);

#endif