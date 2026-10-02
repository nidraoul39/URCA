/**
 * Classe de test pour le lecteur PCC
 *
 * @author J.-C. BOISSON
 *
 * @version 1.0
 *
 */
public class Test_Lecteur_PCC {

    /**
     * Default constructor (for avoiding warning in documentation generation
     */
    public Test_Lecteur_PCC(){}

    
    /**
     * Classic main method
     *
     * @param args The command line arguments : one PCC file
     */
    public static void main(String[] args) {
	
	String nomFichier=null;
	
	if(args.length!=1) {
	    System.err.println("Un seul argument attendu");
	    System.exit(20);
	}
	
	nomFichier=args[0];
	
	System.out.println("Essai de lecteur du fichier "+nomFichier);
	
	new Lecteur_PCC(nomFichier);
    }
}
