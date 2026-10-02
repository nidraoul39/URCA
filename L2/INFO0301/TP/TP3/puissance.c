#include <stdio.h>

#include <stdio.h>
#include <time.h>
typedef  __int128 uint128 ;

uint128 puiss(uint128 x,uint128 n){
    if (n==0) {
        return 1;
    }
    else if(n%2==1){
        return x*puiss(x,n-1);
    }
    else {
        return puiss(x*x,n/2);
    }
}

uint128 puiss2(uint128 x,uint128 n,uint128 acc){
    if(n==0){
        return acc;
    }
    else if(n%2==1){
        return puiss2(x,n-1,acc*x);
    }
    else {
        return puiss2(x*x,n/2,acc);
    }
}

uint128 puissance_indienne(uint128 x, uint128 n) {
    uint128 resultat = 1;

    while (n > 0) {
        // Si n est impair
        if (n % 2 == 1) {
            resultat = resultat * x;
        }
        // Dans tous les cas, on divise n par 2 et on élève x au carré
        x = x * x;
        n = n / 2;
    }

    return resultat;
}

double diff_ms(struct timespec start, struct timespec end) {
    return (end.tv_sec - start.tv_sec) * 1000.0 + 
           (end.tv_nsec - start.tv_nsec) / 1000000.0;
}


int main(void) {
    
    struct timespec begin, end;
    uint128 n = 1000000000000000000; // Réduit pour éviter le segfault sur Somme() sans crash
    uint128 x = 5;
    clock_gettime(CLOCK_MONOTONIC, &begin);
    uint128 res2 = puiss2(x, n,1);
    clock_gettime(CLOCK_MONOTONIC, &end);
    printf(" | temps = %lf ms\n",  diff_ms(begin, end));

    clock_gettime(CLOCK_MONOTONIC, &begin);
    uint128 res1 = puiss(x,n);
    clock_gettime(CLOCK_MONOTONIC, &end);
    printf("puiss:  | temps = %lf ms\n",  diff_ms(begin, end));


    clock_gettime(CLOCK_MONOTONIC, &begin);
    uint128 res3 = puissance_indienne(x,n);
    clock_gettime(CLOCK_MONOTONIC, &end);
    printf(" | temps = %lf ms\n",  diff_ms(begin, end));



    return 0;
}