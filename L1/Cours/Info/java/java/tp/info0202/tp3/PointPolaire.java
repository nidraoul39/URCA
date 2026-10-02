public class PointPolaire implements IPoint {
    private double P;
    private double O;

/**
 * constructeur par initialisation
 * @param P la distance
 * @param O l'angle
 */
    public PointPolaire(double P,double O){
        this.P = P;
        this.O = O;
    }
    /**
     * constructeur par défaut
     */
    public PointPolaire(){
        this(0,0);
    }
    /** 
     * @return l'angle 
     */
    public double getO(){
        return this.O;
    }
    /**
     * @return la distance a l'origin
     */
    public double getP(){
        return this.P;
    }
    public String toString(){
        return "le point est de coordonnés P="+this.P+" et O="+this.O;
    }
    public void afficher(){
        System.out.println(toString());
    }    
    public double distance(){
        return this.P;
    }
    public double distance(IPoint p){
        return Math.sqrt(Math.pow((this.getX()-p.getX()),2)+Math.pow((this.getY()-p.getY()),2));

    }
    public double getX(){
        return this.P*Math.cos(this.O);
    }
    public double getY(){
        return this.P*Math.sin(this.O);
    }

}
