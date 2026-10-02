#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "point.h"

void remplissage(point p[],int n){
    srand(time(NULL));
    double a = -3.1;
    double b = 5;
    for(int i = 0; i<n;i++){
        p[i].x = a+(b-a)*rand() / RAND_MAX;
        p[i].y = a+(b-a)*rand() / RAND_MAX;
    }

}
int indMinD(point p[],int n,int start){
    int indmin = start;
    double min = distanceorigin(p[start]);
    for (int i =start; i<n; i++) {
        if(distanceorigin(p[i])<min){
            min = distanceorigin(p[i]);
            indmin = i;
        }
    }
    return indmin;
}
void affichage(point p[],int n){
    for(int i = 0;i<n;i++)
        printf("point %d : [%lf,%lf]",i,p[i].x,p[i].y);
}

void pluseloigner(point p[],int n,int *ind1,int *ind2){
    int i1,i2;
    i1 = 0;
    i2 = 0;
    for (int i = 0; i<n; i++) {
        for(int j =0;j<n; j++){
            if(distance2point(p[i], p[j])>distance2point(p[i1],p[i2])){
                i1 = i;
                i2 = j;
            }
        }
    }
    *ind1 = i1;
    *ind2 = i2;
}
void tripoint(point p[],int n){
    int indmin;
    point temp;
    for (int i=0; i<n; i++) {
        indmin = indMinD(p, n,i);
        temp = p[i];
        p[i] = p[indmin];
        p[indmin] = temp;
    }
} 