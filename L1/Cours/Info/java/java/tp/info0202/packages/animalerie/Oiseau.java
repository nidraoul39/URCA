package animalerie;

public abstract class Oiseau extends Animal{
	
	
	public Oiseau(String nom){
		super(nom,2,2);
	}
	
	public String toString(){
		return getNom()+", oiseau et a "+getNbAile()+" Aile(s) et "+ getNbPatte() +" patte(s)";
	}


}
