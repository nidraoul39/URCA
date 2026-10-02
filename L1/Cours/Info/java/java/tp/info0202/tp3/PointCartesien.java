import java.lang.Math;

public class PointCartesien implements IPoint {
    private double x;
    private double y;
    /**
 * constructeur par initialisation
 * @param x coordonné x
 * @param y coordonné y
 */
    
    public PointCartesien(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
 * constructeur par defaut 
 */
    public PointCartesien(){
        this(0,0);
    }
    /**
 * constructeur par copie
 * @param p un point existant
 */
    public PointCartesien(PointCartesien p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public String toString(){
        return "le point est de coordonnés x="+this.x+" et y="+this.y;
    }
    public void afficher(){
        System.out.println(toString());
    }    
    public double distance(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
    public double distance(IPoint p){
        return Math.sqrt(Math.pow((this.x-p.getX()),2)+Math.pow((this.y-p.getY()),2));
    }
}
