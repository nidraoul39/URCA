#include <stdio.h>
#include <stdlib.h>

int main2(void){
    int *p = malloc(sizeof(int));
    if(p==NULL){
        printf("erreur dalloc ");
        return EXIT_FAILURE;}
    *p = 123;
    printf("hey %d ",*p);

    return 0;
}
int main(void){
    int **p = calloc(3,sizeof(int*));
    if(p == NULL){
        printf("erreru");
        return EXIT_FAILURE;
    }
    for(int i = 0;i<3;i++){
        p[i] = calloc(3,sizeof(int));
        if (p[i]==NULL)
        {
            printf("erreur d'allocation");
            return EXIT_FAILURE;
        }
        
    }

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            p[i][j] = 10*i+j;
        }
        
    }

    for(int i=0; i<3;i++){
        for(int j=0;j<3;j++){
            printf("p[%d][%d] = %d \n",i,j,p[i][j]);
        }
    }

    for(int i=0;i<3;i++)
        free(p[i]);
    free(p);
    return 0;
    
}