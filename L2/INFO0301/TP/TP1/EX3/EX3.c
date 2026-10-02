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

int main(void){
    struct {int x; double y} a,b,c;
    a.x = 7;
    a.y = 3.01;
    b.x = 6;
    b.y = 4.3;    struct {int x; double y} a,b,c;

    c.x = -2;
    c.y = 10;
    ordonnetrois(&(a.x),&(b.x),&(c.x));

    printf("apres rangemeent : a(%d,%lf) b(%d,%lf) c(%d,%lf)",a.x,a.y,b.x,b.y,c.x,c.y);


    return 0;

}

