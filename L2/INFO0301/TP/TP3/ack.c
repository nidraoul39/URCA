#include <stdio.h>
int ack(int n,int p){
    if(n==0){
        return p+1;
    }
    else if(n>0 && p==0){
        return ack(n-1,1);
    }
    else {
        return ack(n-1, ack(n,p-1));
    }
}
int ack2(int n,int p,int t[]){
    if(n==0){
        return t[n];
    }
    else if(n>p && p == 0){
        
    }
    
}

int main(void){
    int a =ack(2,1);
    printf("%d\n",a);
    return 0;
}
