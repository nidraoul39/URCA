/**
 * @file lecteur_PCC.h
 *
 * @brief Description des méthodes utiles pour le lecteur PCC */

/* STL */
#define  _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>

/**
 *@fn void chargement(const char* nomFichier)
 *@brief Procédure qui charge le fichier demandé
 *@param nomFichier le fichier PCC à charger*/
void chargement(const char* nomFichier, int *longueur);

/**
 * @fn int main(int argc, char **argv)
 * @brief the main */
int main(int argc, char **argv);
