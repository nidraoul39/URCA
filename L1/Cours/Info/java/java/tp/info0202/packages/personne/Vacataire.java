package personne;

public class Vacataire extends Enseignant implements Cloneable {
    
    private String entreprise;

    public Vacataire(String nom, String prenom, double salaire , String entreprise){
        super(nom,prenom,salaire);
        this.entreprise = entreprise;
    }
    public Vacataire(Vacataire v){
        super(v.getNom(),v.getPrenom(),v.getSalaire());
        this.entreprise = v.getEntreprise();
    }

    public String getEntreprise(){
        return this.entreprise;
    }

    public String toString(){
        Class m = this.getClass();
        return m.getName()+" "+super.getNom()+" "+super.getPrenom()+" salaire : "+this.getSalaire()+ " son entreprise : "+this.getEntreprise();
    }
    public Vacataire clone() throws CloneNotSupportedException{
        Vacataire v = (Vacataire)super.clone();
        v.entreprise = this.entreprise;
        return v;
    }; 

}
