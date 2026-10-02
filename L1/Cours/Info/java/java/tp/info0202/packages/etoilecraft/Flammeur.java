package etoilecraft;

public class Flammeur extends UniteTerran{
	
	private boolean volant = false;
	
	public Flammeur(double pv,double pa,double pf){
		super(pv, pa, pf, 0);
	}
	public boolean estVolante(){
		return volant;
	};
	
}
