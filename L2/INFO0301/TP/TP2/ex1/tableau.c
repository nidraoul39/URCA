#include <stdio.h>
#define MAX = 100

void Remplissage(double t[],int n){
    double x;
    for(int i =0;i<n;i++){
        printf("entrer la %d eme valeur : ",(i+1));
        scanf("%lf",&t[i]);
    }
}


double Somme(double t[], int n){
    double Somme=0;
    for(int i =0;i<n;i++)
        Somme+=t[i];
    return Somme;
}

int IndiceMin(double t[],int n,int start){
    int indicemin = start;
    double min = t[start];
    for(int i = start;i<n;i++){
        if(min>t[i]){
            min = t[i];
            indicemin = i;
        }
    }
    return indicemin;
}

void TriSelection(double t[],int n){
    int min;
    double temp;
    for(int i = 0;i<n;i++){
        min = IndiceMin(t, n,i);
        temp = t[i];
        t[i] = t[min];
        t[min] = temp;        
    }
}

int rechercheS(double t[],int n,double val){
    int ind = -1;
    int i=0;
    _Bool find = 0;
    while(i<n && find){
        if(t[i]==val){
            ind = i;
            find = 1;
        }
        else {
        i++;
        }
    }
    return ind;
}

int RechercheDich(double t[],int n,double val){
    _Bool find = 0;
    int min,max;
    min = 0;
    max = n;
    while (find) {
        if(t[max/2]>val){
            max = max/2;
        }
        else {
            min = max/2;
        }
        if(t[max]==val){
            find = 1;
        }
    }
    return max;
}


int main(void){
    double t[100] = {1,2,1,45,5,7,6,23,10};
    TriSelection(t, 9);
    for(int i = 0;i<9;i++)
        printf("%lf :",t[i]);
    return 0;

}