package personne;

/**
 * Classe représentant un étudiant.
 * @author Cyril Rabat
 * @version 18/04/2016
 */
public class Etudiant extends Personne implements Cloneable{
    
    private int numeroEtudiant;
    
    /**
     * Constructeur par initialisation.
     * @param nom le nom de l'étudiant
     * @param prenom le prénom de l'étudiant
     * @param numero le numéro d'étudiant
     */
    public Etudiant(String nom, String prenom, int numero) {
        super(nom, prenom);
        this.numeroEtudiant = numero;
    }
    public Etudiant(Etudiant e) {
        super(e.getNom(), e.getPrenom());
        this.numeroEtudiant = e.getNumeroEtudiant();
    }
     /**
     * Retourne le numéro d'étudiant de l'étudiant.
     * @return le numéro d'étudiant
     */
    public int getNumeroEtudiant() {
        return numeroEtudiant;
    } 
    public String toString(){
        Class m = this.getClass();
        return m.getName()+" "+super.getNom()+" "+super.getPrenom()+" numéro : "+this.getNumeroEtudiant();
    }
    public Etudiant clone() throws CloneNotSupportedException{
        Etudiant e = (Etudiant)super.clone();
        e.numeroEtudiant= this.numeroEtudiant;
        
        return e;
    };

 
}