package animalerie;

public class Abeille extends Insecte{
	
	
	public Abeille(String nom){
		super("Maya",4);
	}
	
	public void crier(){
		System.out.println("bzz bzzz");
	}
	
	public String toString(){
		return getNom()+", oiseau";
	}


}
