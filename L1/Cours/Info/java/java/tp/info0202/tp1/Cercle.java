package tp1;
import java.lang.Math;

class Cercle {
    private double rayon;
    private double x;
    private double y;

    public Cercle(){
        this.rayon = 1;
        this.x = 0;
        this.y = 0;

    }

    public Cercle(double rayon, double x, double y){
        this.rayon = Math.abs(rayon);
        this.x = x;
        this.y = y;
    }

    public double getRayon(){
        return rayon;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public String toString(){
        return "le cercle est de rayon "+this.rayon+" et son centre est en x = "+this.x+" : y = "+this.y;
    }
    public double DEC(Cercle r2){
        return (r2.y-this.y)/(r2.x-this.x);
    }
    
}
