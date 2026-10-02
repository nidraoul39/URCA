package animalerie;

public abstract class Insecte extends Animal{
	
	
	public Insecte(String nom, int nbAile){
		super(nom,6,nbAile);
	}
	
	public String toString(){
		return getNom()+", insecte a "+getNbAile()+" et "+getNbPatte()+ " patte(s)";
	}


}
