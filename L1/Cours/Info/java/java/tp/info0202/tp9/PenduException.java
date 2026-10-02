
public class PenduException extends Exception{
    private String motInvalide = "";

    public PenduException(String erreur,String motInvalide){
        super(erreur);
        this.motInvalide = motInvalide;
        System.out.println("Erreur le mot est invalide vous avez entré " + motInvalide);

    }
    public PenduException(String erreur){
        super(erreur);
        System.out.println("Erreur");
    }
    public String toString(){
        return "Impossible d'instancié la classe une erreur est présente";
    }

}