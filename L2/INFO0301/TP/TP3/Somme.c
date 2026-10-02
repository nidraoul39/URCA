#include <stdio.h>
#include <time.h>
typedef __int128 uint128 ;
uint128 Somme(uint128 n) {
    if (n == 0) return 0;
    return n + Somme(n - 1);
}

uint128 Somme2(uint128 n, uint128 acc) {
    if (n == 0) return acc;
    return Somme2(n - 1, acc + n);
}

double diff_ms(struct timespec start, struct timespec end) {
    return (end.tv_sec - start.tv_sec) * 1000.0 + 
           (end.tv_nsec - start.tv_nsec) / 1000000.0;
}

int main(void) {
    struct timespec begin, end;
    uint128 n = 100000000000000000; // Réduit pour éviter le segfault sur Somme() sans crash

    clock_gettime(CLOCK_MONOTONIC, &begin);
    uint128 res2 = Somme2(n, 0);
    clock_gettime(CLOCK_MONOTONIC, &end);
    printf("SOM2: resultat = %lld | temps = %lf ms\n", res2, diff_ms(begin, end));

    clock_gettime(CLOCK_MONOTONIC, &begin);
    uint128 res1 = Somme(n);
    clock_gettime(CLOCK_MONOTONIC, &end);
    printf("SOM1: resultat = %lld | temps = %lf ms\n", res1, diff_ms(begin, end));

    return 0;
}