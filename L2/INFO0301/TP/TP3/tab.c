#include <stdio.h>

int croissant(int n,int t[],_Bool v){
    if (!v) {
        return v;
    }
    else if(n==0){
        return v;
    }
    else if(t[n-1]<t[n]){
        return croissant(n-1,t,1);
    }
    else {
        return croissant(n-1, t, 0);
    }
}

int decroissant(int n,int t[],_Bool v){
    if (!v) {
        return v;
    }
    else if(n==0){
        return v;
    }
    else if(t[n-1]>t[n]){
        return decroissant(n-1,t,1);
    }
    else {
        return decroissant(n-1, t, 0);
    }
}

int main(void){
    int t[100] = {2,4,6,7,9,19,20,24};
    printf("%d \n",croissant(7, t, 1));
    int t1[100] = {100,40,25,23,12,10,6,4,3,2,1};
    printf("%d",decroissant(10,t1,1));
    return 0;
}