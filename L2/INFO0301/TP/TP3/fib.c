#include <stdio.h>
#include <string.h>
int n1=0;
int n2 = 0;

long long fibonacci(long long n){
    n1++;
    if (n == 0) {
        return 1;
    }
    else if (n==1) {
        return 1;
    }
    else{
        return fibonacci(n-1)+fibonacci(n-2);
    }
}


long long fibonacci2(long long n,long long t[]){
    n2++;
    if (t[n]!= -1) {
        return t[n];
    }
    else{
        t[n] =fibonacci2(n-1,t)+fibonacci2(n-2,t);
        return t[n];
    }
}



int main(void){
    long long tab[1000000];
    memset(tab,-1,sizeof(tab));
    tab[1] = 1;
    tab[0] = 1;
    long long fib = fibonacci2(30,tab);
    printf("%lld \n",fib);
    long long fib2 = fibonacci(30);

    printf("fib 1 : %d \n fib 2 : %d \n",n1,n2);


    return 0;
}