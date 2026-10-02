#include "pile.h"
#include <stdio.h>

void definirPile(PileTSEnt *pile) {
    if (pile != NULL) {
        pile->nb = 0;
    }
}

_Bool estVide(const PileTSEnt *pile) {
    return (pile == NULL || pile->nb == 0);
}

_Bool estPleine(const PileTSEnt *pile) {
    return (pile != NULL && pile->nb >= MAX);
}

void empile(int element, PileTSEnt *pile) {
    if (pile == NULL || estPleine(pile)) {
        return; // Pile pleine ou pointeur invalide
    }
    pile->tab[pile->nb] = element;
    pile->nb++;
}

void depile(PileTSEnt *pile) {
    if (pile == NULL || estVide(pile)) {
        return; // Rien à dépiler
    }
    pile->nb--;
}

int sommet(const PileTSEnt *pile) {
    if (pile == NULL || estVide(pile)) {
        return -1; // Valeur sentinelle en cas d'erreur
    }
    return pile->tab[pile->nb - 1];
}

int taille(const PileTSEnt *pile) {
    if (pile == NULL) {
        return 0;
    }
    return pile->nb;
}

void afficherPile(const PileTSEnt *pile) {
    if (pile == NULL || estVide(pile)) {
        printf("Pile vide\n");
        return;
    }

    printf("Sommet -> ");
    for (int i = pile->nb - 1; i >= 0; i--) {
        printf("[%d] ", pile->tab[i]);
    }
    printf("<- Base\n");
}