#ifndef PILE
#define PILE

#define MAX 100

typedef struct {
    int tab[MAX];
    int nb;
} PileTSEnt;

void definirPile(PileTSEnt *pile);
_Bool estVide(const PileTSEnt *pile);
_Bool estPleine(const PileTSEnt *pile);
void empile(int element, PileTSEnt *pile);
void depile(PileTSEnt *pile);
int sommet(const PileTSEnt *pile);
int taille(const PileTSEnt *pile);
void afficherPile(const PileTSEnt *pile);
#endif