package etoilecraft;

public class Cuirasse extends UniteTerran{
	
	private boolean volant = true;
	
	public Cuirasse(double pv,double pa,double pts,double pta){
		super(pv,pa,Math.max(pta,pts),Math.min(pta,pts));
		
	}
	

	public boolean estVolante(){
		return volant;
	};
	
}
