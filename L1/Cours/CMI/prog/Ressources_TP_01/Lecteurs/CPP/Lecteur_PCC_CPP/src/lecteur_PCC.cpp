#include <lecteur_PCC.h>

void
chargement(const char* nomFichier) {
  
  std::string ligne, delimiteur;
  size_t index;
  std::ifstream fichier(nomFichier);
  
  ligne = "";
  delimiteur = " ";
  
  if (!fichier.is_open()) {
    std::cerr << "Erreur: Impossible d'ouvrir le fichier " << nomFichier << std::endl;
    exit(10);
  }
  
  while(getline(fichier,ligne)) {
    do {
      index = ligne.find(delimiteur);
      if(index != std::string::npos) {
	std::cout << ligne.substr(0,index) << " ";
	ligne=ligne.substr(index+1,ligne.length());
      }
    }
    while(index != std::string::npos);
    std::cout << ligne <<  std::endl;
  }
}

int
main(int argc, char **argv) {

  if(argc != 2) {
    std::cerr << "Un unique nom de fichier PCC est attendu" << std::endl;
    return 20;
  }

  chargement(argv[1]);

  return 0;
}
