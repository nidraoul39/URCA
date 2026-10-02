#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE 256

int main(int argc, char **argv) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <fichier.pcc>\n", argv[0]);
        return 1;
    }

    FILE *f = fopen(argv[1], "r");
    if (!f) {
        perror("Erreur ouverture fichier");
        return 1;
    }

    char line[MAX_LINE];

    // 1ère ligne : description
    fgets(line, MAX_LINE, f);
    
    // 2ème ligne : vide
    fgets(line, MAX_LINE, f);

    // 3ème ligne : nombre d'éléments N
    int N;
    fgets(line, MAX_LINE, f);
    sscanf(line, "%d", &N);

    // 4ème ligne : vide
    fgets(line, MAX_LINE, f);

    // 5ème à N+4 lignes : descriptions
    char **descriptions = malloc(N * sizeof(char*));
    for (int i = 0; i < N; i++) {
        fgets(line, MAX_LINE, f);
        char *eq = strchr(line, '=');
        if (!eq) {
            fprintf(stderr, "Erreur format description ligne %d\n", i+5);
            return 1;
        }
        *eq = '\0';
        // On copie la description
        descriptions[i] = strdup(eq + 1);
        // Supprimer le \n final
        descriptions[i][strcspn(descriptions[i], "\n")] = '\0';
    }

    // ligne vide après les descriptions
    fgets(line, MAX_LINE, f);

    // lignes des voisins : créer un tableau de N pointeurs vers les voisins
    int **voisins = malloc(N * sizeof(int*));
    int *nb_voisins = calloc(N, sizeof(int)); // nombre de voisins par région

    for (int i = 0; i < N; i++) {
        fgets(line, MAX_LINE, f);
        int numero;
        char *p = line;

        // lire le numéro de la région
        sscanf(p, "%d", &numero);
        numero--; // passer de 1-based à 0-based
        // avancer p après le numéro
        while (*p && *p != ' ') p++;
        while (*p == ' ') p++;

        // compter le nombre de voisins
        int count = 0;
        char *tmp = p;
        while (*tmp) {
            if (*tmp == ' ') count++;
            tmp++;
        }
        count++; // dernier voisin
        voisins[numero] = malloc(count * sizeof(int));

        // lire les voisins
        int idx = 0;
        char *tok = strtok(p, " \n");
        while (tok) {
            voisins[numero][idx++] = atoi(tok);
            tok = strtok(NULL, " \n");
        }
        nb_voisins[numero] = idx;
    }

    // Affichage
    for (int i = 0; i < N; i++) {
        printf("Région %d (%s) : voisins -> ", i+1, descriptions[i]);
        for (int j = 0; j < nb_voisins[i]; j++) {
            printf("%d ", voisins[i][j]);
        }
        printf("\n");
    }

    // Libération mémoire
    for (int i = 0; i < N; i++) {
        free(descriptions[i]);
        free(voisins[i]);
    }
    free(descriptions);
    free(voisins);
    free(nb_voisins);
    fclose(f);

    return 0;
}