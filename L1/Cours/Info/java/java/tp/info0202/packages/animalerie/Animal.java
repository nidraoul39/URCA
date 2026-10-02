package animalerie;

public abstract class Animal implements IAnimal{
	private String nom;
	private int nbPatte;
	private int nbAile;
	
	public Animal(String nom, int nbPatte, int nbAile){
		this.nom = nom;
		this.nbPatte = nbPatte;
		this.nbAile = nbAile;
	}
	
	public Animal(Animal a){
		this.nom = a.getNom();
		this.nbPatte = a.getNbPatte();
		this.nbAile = a.getNbAile();
	}
		
	public int getNbAile(){
		return this.nbAile;
	}
	
	public String getNom(){
		return this.nom;
	}
	public int getNbPatte(){
		return this.nbPatte;
	}
	
	public String toString(){
		return "l'animal s'appel "+this.nom+" et il a "+this.nbPatte+" pattes et "+this.nbAile+" aile";	
	}
	public void afficher(){
		System.out.println(this);
	}
	
	public void arracherPatte(){
		if(this.nbPatte>1){
			this.nbPatte--;
			crier();
		}
	}
	
	public void arracherAile(){
		if(this.nbAile>1){
			this.nbAile--;
			crier();
		}
	}
	
}
