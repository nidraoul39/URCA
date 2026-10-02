import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Object pour gérer l'extraction d'information d'un fichier PCC
 *
 *@author J.-C. BOISSON
 *
 *@version 1.0
 */
public class Lecteur_PCC {

    /** Chemin vers le fichier actuellement géré*/
    private String nomFichier;

    /**
     * Constructeur par initialisation d'un objet Lecteur_PCC
     *
     * @param nomFichier Le nom du fichier à charger
     */
    public Lecteur_PCC(String nomFichier) {
	this.nomFichier=nomFichier;
	this.chargement();
    }
    

    /**
     * Méthode qui ouvre et extrait les informations du fichier demandé
     */
    private void chargement() {
	
	FileReader fr=null;
	
	try {
	    fr = new FileReader(nomFichier);
	} catch(FileNotFoundException fnfe) {
	    System.err.println(nomFichier+" n'est pas un nom de fichier valide");
	    System.exit(10);
	}

	BufferedReader br = new BufferedReader(fr);

	String line=null;
	Scanner scanner=null;
	do {
	    try {
		line = br.readLine();
	    } catch(IOException ioe) {
		System.err.println("Problème d'entrée sortie, voir message ci-dessous");
		System.err.println(ioe.getMessage());
		System.exit(20);
	    }

	    if(line != null) {
		scanner = new Scanner(line);
		while(scanner.hasNext()) {
		    System.out.print(scanner.next()+" ");
		}
		System.out.println();
		scanner.close();
	    }
	}
	while(line!=null);
    }
  
}
