package etoilecraft;

public class Marine extends UniteTerran{
	
	private boolean volant = false;
	
	public Marine(double pv,double pa,double pf){
		super(pv, pa, pf, pf);
	}
	public boolean estVolante(){
		return volant;
	};
	
	
}
