#include <stdio.h>

int main(void){
    double a,b,x;

    printf("entrer un nb : ");
    scanf("%lf",&a);
    printf("entrer un nb : ");
    scanf("%lf",&b);

    if(a>b){
        double temp = a;
        a = b;
        b = temp;
    }
    do
    {
        printf("entrer x entre a et b : ");
        scanf("%lf",&x);
    } while (x>b || x<a);
    char res = (b-x)<(x-a) ? 'b' : 'a';
    printf("x est plus proche de %c \n",res);

    
    return 0;
}