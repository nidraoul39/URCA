public class Senseo{
    private boolean dosette = false;
    private int capaciteReservoir = 1000;
    private Couleur color;
    private int reservoir;

    public Senseo(int reservoir, Couleur color){
        this.color = color;
        this.reservoir = reservoir;
    }
    public Senseo(Senseo m){
        this.color = m.color;
        this.reservoir = m.reservoir;
    }
    public Senseo(){
        this(0,Couleur.ROUGE);
    }
    public int getReservoir(){
        return reservoir;
    }
    public int getCapaciteReservoir(){
        return capaciteReservoir;
    }
    public String toString(){
        return "l'objet est une caftiere senseo avec une capacité de 1000ml et il y a "+reservoir+"ml d'eau dedans et de couleurs "+ color;
    }
    public String afficher(){
        return "une caftiere senseo avec une capacité de 1000ml et il y a "+reservoir+"ml d'eau dedans et de couleurs "+ color;

    }
    public String ajouterDosette(){
        String res;
        if(dosette)
            res = "il y a déja une dosette";
        else{
            dosette = true;
            res = "ajout de la dosette effectué";
        }
        return res;
    }
    public String boireCafe(){
        String res;
        if(capaciteReservoir>= 15){
            if(dosette){
                dosette = false;
                reservoir -= 15;
                res ="prenez votre café";
            }
            else
                res = "pas de café il y a pas de dosette";
        }
        else
            res = "pas de café il y a pas d'eau";
        return res;
    }
    public String remplirReservoir(int nb){
        String result;
        if(nb>this.capaciteReservoir-this.reservoir){
            this.reservoir = this.capaciteReservoir;
            result = "trop d'eau donc on jette le reste ";
        }
        else{
            this.reservoir+=nb;
            result = "c'est ok il y a "+this.reservoir+"ml";
        }
        return result;
    }


}