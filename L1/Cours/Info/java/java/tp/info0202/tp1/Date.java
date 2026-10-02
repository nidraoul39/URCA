package tp1;
class Date {
    
    private int jour;
    private int mois;
    private int année;
    
    public Date(){
        this.jour = 1;
        this.mois = 1;
        this.année = 2000;
    }

    public Date(int jour, int mois , int année){
        this.jour = jour;
        this.mois = mois;
        this.année = année;
        if(!estValide())
            corrige();
    }

    public String toString(){
        return ("La date est : le "+this.jour+"/"+this.mois+"/"+this.année);
    }

    public int getJour(){
        return this.jour;
    }

    public int getMois(){
        return this.mois;
    } 

    public int getAnnée(){
        return this.année;
    }

    public String Afficher(){
        return ((this.jour<10) ? "0" + this.jour : this.jour) +"/"+ ((this.mois<10)? "0" + this.mois : this.mois) +"/"+ this.année;
    }

    public void setJour(int jour){
        this.jour = jour;
        if(!estValide())
            corrige();
        
    }
    public void setMois(int mois){
        this.mois = mois;
        if(!estValide())
            corrige();
    }
    public void setAnnée(int année){
        this.année = année;
        if(!estValide())
            corrige();
    }


    public boolean estBissextile(){
        return (this.année%4==0&&this.année%100!=0)||(this.année%400==0);
    }
    public int nbJours(){
        int nbj;
        if(this.mois == 2){
            if(estBissextile())
                nbj=29;
            else
                nbj=28;
        }
        else if(this.mois==4|| this.mois == 6 || this.mois==9 || this.mois == 11)
            nbj = 30;
        else
            nbj = 31;
        return nbj;
    }
    public boolean estValide(){
        boolean valid = true;
        if(this.mois>12 || this.mois<1)
            valid = false;
        if(this.jour > nbJours() || this.jour<1)
            valid = false;
        return valid;
    }
    private void corrige(){
        if (this.mois < 1 || this.mois > 12)
            this.mois = 1;

        if (this.jour < 1 || this.jour > nbJours())
            this.jour = 1;
      
    }


}
