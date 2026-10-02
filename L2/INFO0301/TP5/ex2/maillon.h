#ifndef MAILLON
#define MAILLON

typedef struct maillon{
    int element;
    struct maillon *suivant;
} maillon;

maillon* creechaine(int nb);
maillon* chercherval(maillon *chaine,int element);
void modifval(maillon *chaine,maillon *position,int element);
void ajouterapres(maillon *chaine,maillon *position,int n);
void supprimer(maillon *chaine, maillon *position);

#endif