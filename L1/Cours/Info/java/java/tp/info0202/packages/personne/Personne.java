package personne;

/**
 * Classe représentant une personne.
 * @author Cyril Rabat
 * @version 18/04/2016
 */
public class Personne implements Cloneable {
    
    private String nom;
    private String prenom;
    
    /**
     * Constructeur par initialisation.
     * @param nom le nom de la personne
     * @param prenom le prénom de la personne
     */
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Personne(Personne p){
        this.nom = p.getNom();
        this.prenom = p.getPrenom();
    }
    
    /**
     * Retourne le nom de la personne.
     * @return le nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom de la personne.
     * @return le prénom de la personne
     */    
    public String getPrenom() {
        return prenom;
    }
    public String toString(){
        return this.getPrenom()+" "+this.getNom();
    }
    public Personne clone() throws CloneNotSupportedException{
        return (Personne) clone();
    };
    public boolean equals(Personne p){
        boolean b=false;
        if(this.nom.equals(p.getNom())&& this.prenom.equals(p.getPrenom()))
            b=true;
        return b;
    }
    
    
}