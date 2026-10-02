import java.io.IOException;
class Coffe{

    private int nbDosette;
    private int capaciteDosette;
    private double reservoir = 0; 
    final private int capaciteReservoir;
    private Marque marque;
    private double cagnotte;
    private static double cafecourt = 1.5;
    private static double cafelong = 2;

    public Coffe(Coffe C){
        this.nbDosette = C.getNbDosette();
        this.capaciteDosette = C.getCapaciteDosette();
        this.reservoir = C.getReservoir();
        this.marque = C.getMarque();
        this.cagnotte = C.getCagnotte();
        this.capaciteReservoir = C.getCapaciteReservoir();
    }
    public Coffe(int nbDosette, int capaciteDosette, Marque marque, int capaciteReservoir){
        this.nbDosette = nbDosette;
        this.capaciteDosette = capaciteDosette;
        this.marque = marque;
        this.cagnotte = 0;
        this.capaciteReservoir = capaciteReservoir;
        estValide();
    
    }
    public Coffe(int nbDosette, int capaciteDosette, Marque marque){
        this(nbDosette,capaciteDosette,marque,200);
    }
    public Coffe(){
        this(10,10,Marque.NESCAFE,200);
    }
    
    private void estValide(){
        if(this.capaciteDosette<0){
            this.capaciteDosette = 10;
        }
        if(this.nbDosette>this.capaciteDosette){
            this.nbDosette = capaciteDosette;
        }
        if(this.cagnotte< 0){
            this.cagnotte = 0;
        }
    }
    public int getNbDosette(){
        return this.nbDosette;
    }
    public int getCapaciteDosette(){
        return this.capaciteDosette;
    }
    public double getReservoir(){
        return this.reservoir;
    }
    public Marque getMarque(){
        return this.marque;
    }
    public double getCagnotte(){
        return this.cagnotte;
    }
    public int getCapaciteReservoir(){
        return this.capaciteReservoir;
    }

    public void Afficher(){
        System.out.println("la machine a café est une "+ marque +" il y a "+this.nbDosette+" dosette et "+this.reservoir+"cl d'eau");
    }
    public String toString(){
        return "l'objet est une machine a café "+this.marque+" nb de dosette  : "+ this.nbDosette+ " capacité de dosette : "+ this.capaciteDosette+" et un reservoir de "+this.reservoir;
    }
    public double boireCafeCourt(double argent){
        double monaie=0;
        if(this.reservoir<15)
            throw new IllegalArgumentException("erreur pas assez d'eau");
        if(argent<this.cafecourt)
            throw new IllegalArgumentException("erreur pas assez d'argent");
        if(this.nbDosette<1)
            throw new IllegalArgumentException("erreur pas assez de dosette");

        this.reservoir-=15;
        this.cagnotte+=this.cafecourt;
        monaie = argent-this.cafecourt;
        this.nbDosette--;
        
        return monaie;
        
    }
    public double boireCafeLong(double argent){
        double monaie = 0;
        if(this.nbDosette > 0){
            if(argent>=this.cafelong){
                if(this.reservoir>=20){
                    this.reservoir-=20;
                    this.cagnotte+=this.cafelong;
                    monaie = argent-this.cafelong;
                    this.nbDosette--;
                }
                else{
                    monaie = argent;
                    System.out.println("il n'y a plus d'eau remboursement");
                }
            }
            else{
                System.out.println("escro !!!");
                monaie = argent;
            }

        }
        else{
            monaie = argent;
            System.out.println("plus de dosette donc remboursement");
        }
        return monaie;
        
    }

    public String ajouterDosettes(int nb, String Marque){
        String result;
        if(!marque.equals(this.marque.name())){
            throw new IllegalArgumentException("error pas la bonne marque");
        }
            if(nb>(this.capaciteDosette - this.nbDosette)){
                this.nbDosette = this.capaciteDosette;
                result = "il y a trop de dosette on a rempli au max : "+this.nbDosette;
            }
            else{
                this.nbDosette += nb;
                result = "il y a "+this.nbDosette+" dosette";
            }
        
        
        return result;
    }
    public String remplirReservoir(int nb){
        String result;
        if(nb>this.capaciteReservoir-this.reservoir){
            this.reservoir = this.capaciteReservoir;
            result = "trop d'eau donc on jette le reste ";
        }
        else{
            this.reservoir+=nb;
            result = "c'est ok il y a "+this.reservoir+" cl";
        }
        return result;
    }
    public static void setCafeCourt(double prix){
        if(prix>0){
            cafecourt = prix;
        }
    }
    public static void setCafeLong(double prix){
        if(prix>0){
            cafelong = prix;
        }
    }
    public static double getPrixCafeLong(){
        return cafelong;
    }
    public static double getPrixCafeCourt(){
        return cafecourt;
    }
    public static void augmentation(double aug){
        if(aug>1){
            cafecourt*=aug;
            cafelong*=aug;
        }
    }


}