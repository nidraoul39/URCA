package animalerie;

public class Chien extends Mammifere{
	
	public Chien(String nom){
		super(nom);
	}
	
	public void crier(){
		System.out.println("Ouaf Ouaf");
	}
	
	public String toString(){
		return "Chien"+getNom()+", mammifere a "+super.getNbPatte()+" pattes";
	}
	
	
	

}


