package etoilecraft;

public abstract class UniteTerran implements IUnite{

	private double pv;
	private double pa;
	private double pts;
	private double pta;

	public UniteTerran(double pv,double pa,double pts,double pta){
		this.pv = pv;
		this.pa = pa;
		this.pts = pts;
		this.pta = pta;
	}
	
	 public double getPointsDeVie(){
	 	return this.pv;
	 };


	public double getPointsArmure(){
		return this.pa;
	};


	public double getPuissanceTirSol(){
		return this.pts;
	};
	


	public double getPuissanceTirAir(){
		return this.pta;
	};


	public boolean subirAttaque(double degats){
		boolean res = true;
		this.pv = this.pv - (degats/this.pa);
		if(this.pv<=0){
			res = false;
		}
		return res;
	};


	public boolean attaquer(IUnite u){
		boolean res;
		if(u.estVolante()){
			
			res = !u.subirAttaque(Math.random()*this.pta);
		}
		else{
			res = !u.subirAttaque(Math.random()*this.pts);
		}
		return res;
		
	};

}
