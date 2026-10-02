#include <stdio.h>
#include "plateauPlH.h"

void hanoi(int nb, int depart, int inter, int arriver, plateauHanoi *p) {
    if (nb > 0) {
        // 1. Déplacer nb - 1 disques de depart vers inter
        hanoi(nb - 1, depart, arriver, inter, p);

        // 2. Déplacer le disque restant de depart vers arriver
        deplacerPlh(p, depart, arriver); // ou la fonction de déplacement de ton module (ex: deplacerPLH)
        printf("\nDéplacement d'un disque de la tour %d vers la tour %d :\n", depart, arriver);
        afficherPlH(p);

        // 3. Déplacer les nb - 1 disques de inter vers arriver
        hanoi(nb - 1, inter, depart, arriver, p);
    }
}

int main(void) {
    int nbDisques = 5;
    plateauHanoi p;
    
    creerPLH(&p, nbDisques);

    printf("État initial :\n");
    afficherPlH(&p);

    // Tours indexées généralement de 0 à 2 (ou 1 à 3 selon ton plateauPlH.h)
    // Ici avec les indices 0, 1, 2 :
    hanoi(nbDisques, 1, 2, 3, &p);
    return 0;
sudo pacman -S python python-pipsudo pacman -S python python-pip