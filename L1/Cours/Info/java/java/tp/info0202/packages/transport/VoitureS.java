package transport;
import personne.Personne;

/**
* Class voiture copie de surface 
*/
public class VoitureS implements IVoiture{
/**
* @param Couleur couleur de la voiture
* @param Reservoir de la voiture 
*/
	private Couleur Couleur;
	private Reservoir reservoir;
	private Moteur Moteur;
	private Personne Conducteur;
	
	/**
	* constructeur par initialisation
	* @param Couleur Couleur de la voiture
	* @param Reservoir reservoir de la voiture
	* @param Moteur moteur de la voiture
	* @param personne conducteur de la voiture
	*/
	public VoitureS(Couleur Couleur, Reservoir reservoir, Moteur Moteur, Personne Conducteur){
		this.Couleur = Couleur.NOIRE;
		this.reservoir = reservoir;
		this.Moteur = Moteur;
		this.Conducteur = Conducteur;
		
	}
	/**
	* constructeur par défaut
	*/
	public VoitureS(){
		this(null,null, null,null);
		}
		
	public VoitureS(VoitureS v){
		this.Couleur = v.getCouleur();
		this.reservoir = v.getreservoir();
		this.Moteur = v.getMoteur();
		
		
	}
	
	public Reservoir getreservoir(){
		return this.reservoir;
	}
	
	public Moteur getMoteur(){
		return this.Moteur;
	}
	
	public Personne getConducteur(){
		return this.Conducteur;
	}
	
	public Couleur getCouleur(){
		return this.Couleur;
	}
	
	public void setConducteur(Personne c){
		if(c.getAge()>=18)
			this.Conducteur = c;
			
	}
	
	public void Afficher(){
		System.out.println(this);
	}
	
	public String toString(){
		return "la voiture est jolie elle est " + this.Couleur + " le reservoir "+this.reservoir;
	}
	
	public double  avancer(double distance){
		double distanceafaireencr;
		double distancefaites;
		distancefaites = this.Moteur.getConsommation()*this.getContenuReservoir();
		this.reservoir.vider(Moteur.getConsommation()*(distance/100));
		distanceafaireencr = distance - distancefaites;
		return distanceafaireencr;

	}
	
	public double faireLePlein(){
		this.reservoir.remplir(this.reservoir.getCapacite()-this.getContenuReservoir());
		return 	0;
	}
	
	public double getContenuReservoir(){
		return this.reservoir.getContenu();
	}
	
	
	
}
