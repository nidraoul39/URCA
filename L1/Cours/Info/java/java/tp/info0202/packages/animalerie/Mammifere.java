package animalerie;

public abstract class Mammifere extends Animal{
	
	public Mammifere(String nom){
		super(nom,4,0);
	}
	
	
	public String toString(){
		return getNom()+", mammifere";
	}
	
	
	

}
