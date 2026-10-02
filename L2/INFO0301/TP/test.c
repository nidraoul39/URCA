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

int main(void){
    int a =ack(2,1);
    printf("%d\n",a);
    return 0;
}
