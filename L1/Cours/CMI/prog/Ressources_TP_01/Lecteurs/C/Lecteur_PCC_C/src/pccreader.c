#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


#define BUFFER 255
void couleursol(int* couleur, int frontiere[][BUFFER], int taille);
void chomp(char *s);
int nbcouleur(int* couleur, int taille);
int nbvoisin(int frontiere[][BUFFER], int region, int taille);
int contrainteviole(int* couleur,int taille, int frontiere[][BUFFER]);
int* changealeatoire(int* couleur, int taille, int frontiere[][BUFFER]);
int* compare(int* couleur1, int* couleur2, int taille, int frontiere[][BUFFER]);
void optisolution(int *couleur, int *essaie, int taille, int frontiere[][BUFFER]);


int main(int argc, char **argv){
    srand(time(NULL));
    
    char ligne[BUFFER];
    int taille;
    int k;
    int e;
    char *token;
    int essaie=1000000000;
    char region[BUFFER][BUFFER]; 
    int frontiere[BUFFER][BUFFER];
    memset(frontiere, 0, sizeof(frontiere));


    if(argc != 2){
        printf("il manque un argument le fichier stp ! \n");
        return 1;
    }
    FILE *fichier = fopen(argv[1],"r");
    if(fichier == NULL){
        printf("erreur fichier innexistant ou impossible a ouvrir");
        return 1;
    }
    for (int i = 0; i < 3; i++)
    {
        fgets(ligne,BUFFER,fichier);

    }
    chomp(ligne);
    taille = atoi(ligne);


    for(int i=0; i<taille; i++){
        fscanf(fichier,"%d = %s", &k, region[i]);
        chomp(region[i]);
        printf("Region %d : %s\n", k, region[i]);
    }
    fgets(ligne,BUFFER,fichier);
    fgets(ligne,BUFFER,fichier);

    for(int i=0; i<taille; i++){
        fgets(ligne,BUFFER,fichier);
        chomp(ligne);
        token = strtok(ligne, " ");
        e=0;
        while (token != NULL)
        {
            frontiere[i][e]=atoi(token);
            e+=1;
            token = strtok(NULL, " ");
        }
    }


    
    for (int i = 0; i < taille; ++i) {
        printf("Frontieres de la region %d:", i+1); 
        for (int j = 0; j < taille; ++j) {
            if(frontiere[i][j] == 0){
                break;
            }
            printf(" %d", frontiere[i][j]);
        }
        printf("\n");
    }
    int couleur[taille];
    memset(couleur, 0, sizeof(int) * taille); // memset sert a initialiser un tableau a 0
    couleursol(couleur, frontiere, taille);

    /* printf("\nCouleurs attribuées :\n");
    for (int i = 0; i < taille; i++) {
        printf("Couleur de la region %d : %d\n", i+1, couleur[i]);
    }
    int total_couleurs = nbcouleur(couleur, taille);
    printf("\nNombre total de couleurs utilisées : %d\n", total_couleurs); */
    int *couleurdep = malloc(taille*sizeof(int));
    couleurdep[0]=0;
    couleurdep[1]=1;
    couleurdep[2]=2;
    couleurdep[3]=3;
    couleurdep[4]=4;
    couleurdep[5]=5;
    couleurdep[6]=0;
    couleurdep[7]=1;
    couleurdep[8]=2;
    couleurdep[9]=3;
    couleurdep[10]=4;
    couleurdep[11]=5;

    int contrainte = contrainteviole(couleurdep, taille, frontiere);
    printf("Nombre de contraintes violées pour truc en dur : %d\n", contrainte);
    optisolution(couleurdep, &essaie, taille, frontiere);
    for (int i = 0; i < taille; i++) {
        printf("Couleur de la region %d : %d\n", i+1, couleurdep[i]);
    }
    contrainte = contrainteviole(couleurdep, taille, frontiere);
    printf("Nombre de contraintes violées après optimisation : %d\n", contrainte);
    printf("Nombre de couleurs utilisées après optimisation : %d\n", nbcouleur(couleurdep, taille));



    fclose(fichier);
    return 0;

}


void chomp(char *s) 
{
    while (*s != '\n' && *s != '\0')
        ++s;

    *s = '\0';
}

void couleursol(int* couleur, int frontiere[][BUFFER], int taille) {
    for (int i = 0; i < taille; i++) {
        if (couleur[i] != 0) continue;
        
        int interdit[BUFFER] = {0};
        int n = 0;
        
        while (frontiere[i][n] != 0) {
            int voisin = frontiere[i][n] - 1;
            if (voisin >= 0 && voisin < taille && couleur[voisin] != 0) {
                interdit[couleur[voisin]] = 1;
            }
            n++;
        }
        
        int c = 1;
        while (interdit[c] && c < BUFFER) {
            c++;
        }
        
        couleur[i] = c;
    }
}
int nbcouleur(int* couleur, int taille) {
    int max_couleur = 0;
    for (int i = 0; i < taille; i++) {
        if (couleur[i] > max_couleur) {
            max_couleur = couleur[i];
        }
    }
    return max_couleur;
}
int nbvoisin(int frontiere[][BUFFER], int region, int taille){
    int nb=0;
    for (int i = 0; i < taille; i++)
    {
        if (frontiere[region][i]!=0)
        {
            nb+=1;
        }
        
    }
    return nb;
    
}

int contrainteviole(int* couleur,int taille, int frontiere[][BUFFER]){
    int nbviole=0;
    for (int i = 0; i < taille; i++)
    {
        int n=0;
        while (frontiere[i][n]!=0)
        {
            int voisin=frontiere[i][n]-1;
            if (couleur[i]==couleur[voisin])
            {
                nbviole+=1;
            }
            n+=1;
        }
        
    }
    return nbviole/2;

}

/*int* changealeatoire(int* couleur, int taille, int frontiere[][BUFFER]){
    int i = rand() % taille;
    int nouv_couleur = (couleur[i] + 1 + rand() % 5) % 6; // assure un changement
    int *nouvtab = malloc(taille*sizeof(int));
    memcpy(nouvtab, couleur, sizeof(int) * taille);
    nouvtab[i] = nouv_couleur;
    return nouvtab;
}*/

int* nouveautabaleatoire(int* couleur, int taille, int frontiere[][BUFFER]){



int* compare(int* couleur1, int* couleur2, int taille, int frontiere[][BUFFER]) {
    if (contrainteviole(couleur1, taille, frontiere) < contrainteviole(couleur2, taille, frontiere)) {
        return couleur1;
    } else {
        return couleur2;
    }
}


void optisolution(int *couleur, int *essaie, int taille, int frontiere[][BUFFER]){
    int n=0;
    int* c2;
    c2 = malloc(taille*sizeof(int));


    while(contrainteviole(couleur, taille, frontiere) != 0){
        int* c2 = changealeatoire(couleur, taille, frontiere);
        int v1 = contrainteviole(couleur, taille, frontiere);
        int v2 = contrainteviole(c2, taille, frontiere);
        if(v2 < v1){
            memcpy(couleur, c2, sizeof(int) * taille);
        }
        free(c2);
        n++;
        if (n%1000==0){
            printf("Essai numero %d\n", n);
            printf("Contraintes violées : %d\n", contrainteviole(couleur, taille, frontiere));
        }
    }
}
