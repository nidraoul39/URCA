#include <lecteur_PCC.h>

void chargement(const char* nomFichier) {
  
  char *ligne, *chaine, *temp;
  char delimiteur;
  size_t taille;
  unsigned int index;
  ssize_t nb_caracteres_lus;
  FILE* descripteur = fopen(nomFichier,"r");

  ligne = "";
  delimiteur = ' ';
  
  if (descripteur==NULL) {
    fprintf(stderr, "Erreur: Impossible d'ouvrir le fichier %s\n", nomFichier);
    perror("fopen");
    exit(10);
  }

  nb_caracteres_lus=0;
  taille=0;

  do {
    ligne=NULL;
    nb_caracteres_lus=getline(&ligne,&taille,descripteur);
    if(nb_caracteres_lus!=-1){
      /*printf("Taille = %lu,ligne lue [%s]",strlen(ligne),ligne);*/
      do {
	chaine=strchr(ligne,delimiteur);
	if(chaine!=NULL) {
	  index = chaine - ligne;
	  /*printf("\tIndex %d \n",index);*/
	  temp=(char*) malloc((index + 1) * sizeof(char));
	  memcpy(temp,ligne, index);
	  temp[index] = '\0';
	  printf("%s ",temp);
	  /*printf("\t\tSous-chaine [%s]\n",temp);*/
	  free(temp);
	  temp=(char*) malloc((strlen(ligne) - index + 1 + 1) * sizeof(char));
	  memcpy(temp,ligne+index+1, strlen(ligne)-index+1);
	  free(ligne);
	  ligne=temp;
	  /*printf("\tRestant Taille = %lu,ligne lue [%s]",strlen(ligne),ligne);*/
    
	}
      }
      while(chaine!=NULL);
      printf("%s",ligne);
      free(ligne);
      ligne=NULL;
    }
  }
  while(nb_caracteres_lus!=-1);
  printf("\n");
}

int main(int argc, char **argv) {

  if(argc != 2) {
    fprintf(stderr, "Un unique nom de fichier PCC est attendu\n");
    return 20;
  }
  int taille;
  chargement(argv[1]);
  

  return 0;
}
