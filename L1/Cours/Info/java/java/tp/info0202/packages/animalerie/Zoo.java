package animalerie;


public class Zoo implements IZoo{
	private int nbCage;
	private Animal[] cage;
	private static final int a = 10;
	private static final int b = 20;
	
	
	public Zoo(int nbCage){
		this.nbCage = nbCage;
		if(this.nbCage<a || this.nbCage>b)
			this.nbCage =  (int) Math.random()*a+(b-a);
		this.cage = new Animal[nbCage];
	}
	public Zoo(){
		this.nbCage =  (int) Math.random()*a+(b-a);
		this.cage = new Animal[this.nbCage];
	}
	
	
	public void ajouterAnimal(Animal a, int i) throws IndexOutOfBoundsException{
	    if(i >= this.nbCage || i < 0)
		throw new IndexOutOfBoundsException("erreur impossible de mettre à cette index");

	    if(this.cage[i] == null){
		this.cage[i] = a;
	    }
	    else{
		System.out.println("il y a deja un animal");
	    }
	}
	
	public Animal getAnimal(int i)throws IndexOutOfBoundsException{
		if(i>=this.nbCage || i<0)
			throw new IndexOutOfBoundsException("erreur impossible de mettre à cette index");
		return this.cage[i];    
	}
	
	public void supprimerAnimal(int i)throws IndexOutOfBoundsException{
		if(i>=this.nbCage || i<0)
			throw new IndexOutOfBoundsException("erreur impossible de mettre à cette index");
		if(this.cage[i] != null){
			System.out.println(this.cage[i].getNom()+" est libre !!!" );
			this.cage[i] = null;
		}else
			System.out.println("c'est deja vide...");
	}
	public void faireCrier(){
	    for(int i = 0; i < nbCage; i++){
		if(cage[i] != null){
		    cage[i].crier();
		}
	    }
	}
	public String toString(){
		return "c'est un zoo il y a " + this.nbCage+" cage";
	}
	
	public void desastre(){
		int a;
		a = (int) Math.random()*this.a+(this.b-(this.a+1));
		if( this.cage[a] != null){
			if(Math.random()<0.5)
				this.cage[a].arracherAile();
			else
				this.cage[a].arracherPatte();
		}
	}
	
	public int getNbPatte(){
		int sum=0;
		for(int i = 0; i<this.cage.length;i++){
			if(this.cage[i] != null)
				sum+=this.cage[i].getNbPatte();
		}
		return sum;
	}

	public int getNbAile(){
		int sum=0;
		for(int i = 0; i<this.cage.length;i++){
			if(this.cage[i] != null)
				sum+=this.cage[i].getNbAile();
		}
		return sum;
	}
	
	
	
	
}
