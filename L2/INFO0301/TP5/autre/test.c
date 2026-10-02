#include <stdio.h>
#include <assert.h>
#include <stdbool.h>
#include "pile.h"

void test_initialisation_et_vide(void) {
    pile p;
    initialiser(&p);

    assert(estVide(&p) == true);
    assert(estPleine(&p) == false);
    assert(taille(&p) == 0);
    assert(sommet(&p) == NULL);
    assert(depile(&p) == false); // Dépiler sur pile vide doit échouer proprement

    printf("[OK] Initialisation et pile vide\n");
}

void test_empiler_sommet_taille(void) {
    pile p;
    initialiser(&p);

    element e1 = {1.5, 10};
    element e2 = {2.5, 20};

    assert(empile(&p, &e1) == true);
    assert(estVide(&p) == false);
    assert(taille(&p) == 1);
    
    element *s = sommet(&p);
    assert(s != NULL);
    assert(s->x == 1.5 && s->y == 10);

    assert(empile(&p, &e2) == true);
    assert(taille(&p) == 2);
    
    s = sommet(&p);
    assert(s != NULL);
    assert(s->x == 2.5 && s->y == 20);

    printf("[OK] Empilement, consultation du sommet et taille\n");
}

void test_depiler_et_lifo(void) {
    pile p;
    initialiser(&p);

    element e1 = {1.0, 100};
    element e2 = {2.0, 200};

    empile(&p, &e1);
    empile(&p, &e2);

    // Ordre LIFO : e2 doit sortir avant e1
    assert(sommet(&p)->y == 200);
    assert(depile(&p) == true);
    assert(taille(&p) == 1);

    assert(sommet(&p)->y == 100);
    assert(depile(&p) == true);
    assert(taille(&p) == 0);
    assert(estVide(&p) == true);

    printf("[OK] Principe LIFO (Last In, First Out) et dépilement\n");
}

void test_saturation_pile(void) {
    pile p;
    initialiser(&p);

    element dummy = {0.0, 0};

    // Remplissage jusqu'à saturation
    for (int i = 0; i < CAPACITE_MAX; i++) {
        dummy.y = i;
        assert(empile(&p, &dummy) == true);
    }

    assert(estPleine(&p) == true);
    assert(taille(&p) == CAPACITE_MAX);

    // Tentative d'empilement sur pile pleine (doit être refusée)
    assert(empile(&p, &dummy) == false);
    assert(taille(&p) == CAPACITE_MAX);

    printf("[OK] Gestion de la capacité maximale\n");
}

void test_copie_et_vidage(void) {
    pile src, dest;
    initialiser(&src);
    initialiser(&dest);

    element e1 = {3.14, 42};
    element e2 = {2.71, 7};

    empile(&src, &e1);
    empile(&src, &e2);

    copypile(&src, &dest);

    assert(taille(&dest) == 2);
    assert(sommet(&dest)->y == 7);
    assert(sommet(&dest)->x == 2.71);

    // Vérifier l'indépendance des deux piles après modification de src
    viderpile(&src);
    assert(estVide(&src) == true);
    assert(estVide(&dest) == false);
    assert(taille(&dest) == 2);

    printf("[OK] Copie indépendante et vidage de pile\n");
}

int main(void) {
    printf("=== Lancement de la suite de tests pour 'pile' ===\n");

    test_initialisation_et_vide();
    test_empiler_sommet_taille();
    test_depiler_et_lifo();
    test_saturation_pile();
    test_copie_et_vidage();

    printf("\n--> Tous les tests ont reussi avec succes.\n");
    return 0;
}