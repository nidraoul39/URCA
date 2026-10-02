#include <stdio.h>
#include "tabpoint.h"
#include "point.h"

int main(void){
    point p[100];
    int n = 89;
    remplissage(p, n);
    affichage(p, n);
    tripoint(p, n);
    return 0;
}