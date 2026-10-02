package tp1;
class Personne {
    private String nom;
    private String prenom;
    private int taille;
    private int poids;
    private int age;
    private String civil;

    public Personne(){
        this.nom = "nom";
        this.prenom = "prenom";
        this.taille = 170;
        this.poids = 70;
        this.civil= "?";
    }

    public Personne(String nom, String prenom,int taille, int poids,String civil,int age){
        this.nom = nom;
        this.prenom = prenom;
        this.taille = taille;
        this.poids =poids;
        this.civil = civil;
        this.age =age;
        if(!estValide())
            corrige();
        
    }
    private boolean estValide(){
        boolean valid = true;
        if(this.taille<30 || this.taille>250)
            valid = false;
        if(this.poids<1|| this.poids > 200)
            valid = false;
        if(this.age<0 || this.age>150);
            valid = false;
        return valid;
    }
    private void corrige(){
        if(this.taille<30 || this.taille>250)
            this.taille = 170;
        if(this.poids<1|| this.poids > 200)
            this.poids = 70;
        if(this.age<0 || this.age>150);
            this.age=30;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public int getTaille(){
        return this.taille;
    }
    public int getPoids(){
        return this.poids;
    }
    public String getCivil(){
        return this.civil;
    }
    public void setTaille(int taille){
        this.taille = taille;
        if(!estValide())
            corrige();

    }
    public void setPoids(int poids){
        this.poids = poids;
        if(!estValide())
            corrige();
    }    
    public void setAge(int age){
        this.age = age;
        if(!estValide())
            corrige();
    }
    public String toString(){
        return ("la personne est "+this.civil+" "+this.prenom+" "+this.nom+" : "+this.age+" ans, "+this.taille+" cm, "+this.poids+"kg");
    }
    public String Afficher(){
        return (this.civil+" "+this.prenom+" "+this.nom+" : "+this.age+" ans, "+this.taille+" cm, "+this.poids+"kg"); 
    }
    public double IMC(){
        double tailleM = this.taille / 100.0;
        return this.poids / (tailleM * tailleM);
    }
    public String IMCS(){
        double IMC = IMC();
        String rep;
        if(IMC<16.5)
            rep = "dénutrition";
        else if(IMC<18.5)
            rep = "maigreur";
        else if(IMC<25)
            rep = "corpulence standard";
        else if(IMC<30)
            rep = "Surpoids";
        else if(IMC<35)
            rep = "obésité modérée";
        else if(IMC<40)
            rep = "obésité sévère";
        else
            rep = "obésité morbide";
        return rep;
    }



}
