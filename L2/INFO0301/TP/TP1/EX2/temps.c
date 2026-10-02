#include "temps.h"
#include <stdio.h>

temps creer(int h, int m, double s){
    temps t={.h=h,.m=m,.s=s};
    return t;
}

_Bool correct(temps t){
    return (t.h>=0 && t.m>=0 &&t.s>=0) ? 1:0;
}

void afficher(temps t){
    printf("%d:%02d:%04.1lf\n",t.h,t.m,t.s);
}

temps normaliser(temps t){
    int temp;
    temp = t.s;

    t.s = temp%60;
    t.m+=temp/60;
    temp=t.m;
    t.m = temp%60;
    t.h+=temp/60;

    return t;
}
temps creer2(void){
    temps t;
    printf("ecrire le temps sous forme hh:mm:ssss : ");
    scanf("%d:%d:%lf",&(t.h),&(t.m),&(t.s));
    return t;
}

void saisir(temps *pt){
    int h,m;
    double s;
    printf("ecrire le temps sous forme hh:mm:ssss : ");
    scanf("%d:%d:%lf",&h,&m,&s);
    pt->h = h;
    pt->m = m;
    pt->s = s;
}

