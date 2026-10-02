#include <stdio.h>

void echange(int *a,int *b){
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

void ordonnedeux(int *a,int *b){
    if(*a>*b)
        echange(a,b);
}
void ordonnetrois(int *a,int *b,int *c){
    ordonnedeux(a,b);
    ordonnedeux(a,c);
    ordonnedeux(b,c);
}

void minmax(int a,int b, int c, int *min, int *max){
    ordonnetrois(&a,&b,&c);
    *min = a;
    *max = c;
}


int main(void){
    int a = 5;
    int b = 4;
    int c = 3;
    int min = 0;
    int max = 0;
    minmax(a,b,c,&min,&max);
    ordonnetrois(&a,&b,&c);
    printf("ordre est : %d %d %d \n",a,b,c);
    printf("le minimum est %d et le max est %d \n",min,max);
    int x[] = {1,2,3};
    printf("%d \n",x[0]);
    return 0;
}


