import personne.*;
import java.util.*;

/**
 * Classe permettant de tester les classes du package personne.
 * @author Cyril Rabat
 * @author Jessica Jonquet
 * @version 20/03/2021
 */
public class TestPersonne1 {
    
    public static Scanner clavier = new Scanner(System.in);
    
    /**
     * Création d'une personne depuis des informations saisies au clavier.
     * @return la personne créée
     */
    public static Personne creerPersonne() {
        String nom, prenom;
        
        System.out.println("Création d'une personne :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();

        return new Personne(nom, prenom);
    }
    /**
     * Création d'un étudiant depuis des informations saisies au clavier.
     * @return l'étudiant créé
     */
    public static Etudiant creerEtudiant() {
        String nom, prenom;
        int numero;
        
        System.out.println("Création d'un étudiant :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();
        System.out.print("Numéro d'étudiant : ");
        numero = clavier.nextInt();
        clavier.nextLine(); /* Vidage du tampon */

        return new Etudiant(nom, prenom, numero);
    }

    /**
     * Création d'un enseignant depuis des informations saisies au clavier.
     * @return l'enseignant créé
     */
    public static Enseignant creerEnseignant() {
        String nom, prenom;
        double salaire;
        
        System.out.println("Création d'un enseignant :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();
        System.out.print("Salaire           : ");
        salaire = clavier.nextDouble();
        clavier.nextLine();        
        
        return new Enseignant(nom, prenom, salaire);
    }

        public static Vacataire creerVacataire() {
        String nom, prenom,entreprise;
        double salaire;
        
        System.out.println("Création d'un vacataire :");
        System.out.print("Nom               : ");
        nom = clavier.nextLine();
        System.out.print("Prénom            : ");
        prenom = clavier.nextLine();
        System.out.print("Salaire           : ");
        salaire = clavier.nextDouble();
        clavier.nextLine();  
        System.out.print("entreprise        : ");
        entreprise = clavier.nextLine();
      

        
        return new Vacataire(nom, prenom, salaire,entreprise);
    }

    
    /** 
     * Méthode principale.
     * @param args les arguments
     */
    public static void main(String args[]) {
        Personne tableau[] = new Personne[4];

        /* Initialisation du tableau */
        tableau[0] = creerPersonne();
        tableau[1] = creerEtudiant();
        tableau[2] = creerEnseignant();
        tableau[3] = creerVacataire();

        Personne tableaucp[] =  new Personne[4];
        try{
            tableaucp[0] = tableau[0].clone();
            tableaucp[1] = tableau[1].clone();
            tableaucp[2] = tableau[2].clone();
            tableaucp[3] = tableau[3].clone();
        }
        catch(Exception e){
            System.out.println("erreur "+e);
        }


        
        /* Affichage du contenu du tableau */
        System.out.println("Résumé : ");
        for(int i = 0; i < tableau.length; i++)
            System.out.println(tableau[i]);
    
    System.out.println("Résumé 2 : ");
        for(int i = 0; i < tableaucp.length; i++)
            System.out.println(tableaucp[i]);
    }
    
}
    
