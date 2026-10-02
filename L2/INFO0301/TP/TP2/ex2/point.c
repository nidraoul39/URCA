#include <stdio.h>
#include "point.h"
#include <math.h>

double distanceorigin(point p){
    return sqrt(pow(p.x,2)+pow(p.y,2));
}
void saisir(point *p){
    printf("entrer les coordonner du point x:y : ");
    scanf("%lf:%lf",&p->x,&p->y);
}
void afficher(point p){
    printf("[%lf,%lf]",p.x,p.y);
}
double distance2point(point p1,point p2){
    return sqrt(pow((p1.x-p2.x),2)+pow((p1.y-p2.y),2));
}