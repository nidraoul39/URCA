#include <stdio.h>
#include <stdlib.h>


int main(void){

    double *p= malloc(3*sizeof(double));

    p[1]=5;
    free(p);
    printf("%lf",p[1]);
    p[1]=100;
    return  0;
}