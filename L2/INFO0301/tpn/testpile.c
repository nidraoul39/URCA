#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>
#include <math.h>

#include "element.h"
#include "Cellule.h"
#include "pile.h"

/* Utilitaires pour tester l'égalité des éléments */
static bool elements_egaux(Element a, Element b) {
    return (a.x == b.x) && (fabs(a.y - b.y) < 1e-6);
}

/* Fabrique une cellule initialisée à partir de valeurs directes */
static Cellule *fabriquer_cellule(int x, double y) {
    Cellule *c = creerC();
    assert(c != NULL);
    c->e.x = x;
    c->e.y = y;
    c->svt = NULL;
    return c;
}

int main(void) {
    printf("=== Lancement des tests de la pile ===\n");

    /* 1. Initialisation */
    Pile p;
    
    assert(estVide(&p));
    printf("[OK] Initialisation et vérification pile vide\n");

    /* 2. Données de test */
    Element e1 = {1, 1.5};
    Element e2 = {2, 2.5};
    Element e3 = {3, 3.5};

    /* 3. Empilements successifs */
    empile(&p, fabriquer_cellule(e1.x, e1.y));
    assert(!estVide(&p));
    assert(elements_egaux(sommet(&p), e1));

    empile(&p, fabriquer_cellule(e2.x, e2.y));
    assert(elements_egaux(sommet(&p), e2));

    empile(&p, fabriquer_cellule(e3.x, e3.y));
    assert(elements_egaux(sommet(&p), e3));
    printf("[OK] Empilements (e1, e2, e3) et vérification du sommet\n");

    /* Affichage du sommet pour tester afficher() */
    Element s = sommet(&p);
    printf("     Sommet actuel : ");
    afficher(&s);
    printf("\n");

    /* 4. Dépilements respectant l'ordre LIFO */
    assert(elements_egaux(sommet(&p), e3));
    depile(&p);

    assert(elements_egaux(sommet(&p), e2));
    depile(&p);

    assert(elements_egaux(sommet(&p), e1));
    depile(&p);

    assert(estVide(&p));
    printf("[OK] Dépilements respectant l'ordre LIFO et retour à l'état vide\n");

    /* 5. Test de la libération mémoire */
    empile(&p, fabriquer_cellule(10, 10.5));
    empile(&p, fabriquer_cellule(20, 20.5));
    liberer(&p);
    assert(estVide(&p));
    printf("[OK] Libération de la pile\n");

    printf("\nTous les tests sont passés avec succès !\n");
    return EXIT_SUCCESS;
}