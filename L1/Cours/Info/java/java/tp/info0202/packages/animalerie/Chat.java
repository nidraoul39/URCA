package animalerie;
public class Chat extends Mammifere{
	
	public Chat(String nom){
		super(nom);
	}
	
	public String toString(){
		return "Chat"+getNom()+", mammifere a "+super.getNbPatte()+" pattes";
	}
	
	public void crier(){
	
		System.out.println("Miaou miaou");
	}
	
	

}
