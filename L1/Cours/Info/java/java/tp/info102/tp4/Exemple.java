import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Exemple {
    
    public static int nbLignes(String nomFichier) {
        int resultat = 0;
        String tmp;
        
        try {
            // Ouverture du fichier
            FileInputStream fs = null;
            fs = new FileInputStream(nomFichier);

            // Lecture de chaque ligne du fichier => compte les mots
            Scanner scanner = new Scanner(fs);
            while(scanner.hasNext()) {
                tmp = scanner.nextLine();
                resultat++;
            }
            scanner.close();
         
            // Fermeture du fichier
            fs.close();
        } catch(IOException e) {
            System.err.println("Erreur lors de la lecture du fichier.");
            System.err.println(e);
            System.exit(-1);
        }
        
        return resultat;
    }
    
    public static void main(String[] args) {
        int nb = nbLignes("liste_francais.txt");
        
        System.out.println("Nombre de lignes : " + nb);
    }
    
}