#include <stdio.h>
#include <stdbool.h>
#include "pile.h"

void initialiser(pile *p) {
    if (p != NULL) {
        p->sommet = -1; // -1 indique que la pile est vide
    }
}

bool estVide(const pile *p) {
    return (p == NULL || p->sommet == -1);
}

bool estPleine(const pile *p) {
    return (p != NULL && p->sommet >= CAPACITE_MAX - 1);
}

bool empile(pile *p, const element *e) {
    if (p == NULL || e == NULL || estPleine(p)) {
        return false; // Échec : pile pleine ou pointeur invalide
    }
    p->sommet++;
    p->tab[p->sommet] = *e; // Copie de la structure element
    return true;
}

bool depile(pile *p) {
    if (estVide(p)) {
        return false; // Échec : rien à dépiler
    }
    p->sommet--; // Décrémenter suffit à ignorer l'élément
    return true;
}

int taille(const pile *p) {
    if (estVide(p)) {
        return 0;
    }
    return p->sommet + 1;
}

element* sommet(pile *p) {
    if (estVide(p)) {
        return NULL;
    }
    return &(p->tab[p->sommet]);
}

void viderpile(pile *p) {
    if (p != NULL) {
        p->sommet = -1;
    }
}

void copypile(const pile *source, pile *destination) {
    if (source == NULL || destination == NULL) {
        return;
    }
    destination->sommet = source->sommet;
    for (int i = 0; i <= source->sommet; i++) {
        destination->tab[i] = source->tab[i];
    }
}