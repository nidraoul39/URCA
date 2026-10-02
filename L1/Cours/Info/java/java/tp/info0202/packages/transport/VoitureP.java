package transport;
import personne.Personne;

/**
* Class voiture copie de surface 
*/
public class VoitureP implements IVoiture{
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
	public VoitureP(Couleur Couleur, Reservoir reservoir, Moteur moteur, Personne Conducteur){
		this.Couleur = Couleur.NOIRE;
		this.reservoir = new Reservoir(reservoir);
		this.Moteur = new Moteur(moteur);
		this.Conducteur = Conducteur;
		
	}
	/**
	* constructeur par défaut
	*/
	public VoitureP(){
		this(null,null, null,null);
		}
		
	public VoitureP(VoitureP v){
		this.Couleur = v.getCouleur();
		this.reservoir = new Reservoir(v.getreservoir());
		this.Moteur = new Moteur(v.getMoteur());
		
		
	}
	/**
	* @return le reservoir
	*/
	public Reservoir getreservoir(){
		return this.reservoir;
	}
	/**
	* @return le moteur
	*/	
	public Moteur getMoteur(){
		return this.Moteur;
	}
	
	/**
	* @return le conducteur
	*/
	public Personne getConducteur(){
		return this.Conducteur;
	}
	/**
	* @return la couleur
	*/
	public Couleur getCouleur(){
		return this.Couleur;
	}
	/**
	* @param conducteur un conducteur objet personne
	* Verifie que le conducteur a plus de 18ans et change de conducteur
	*/
	
	public void setConducteur(Personne conducteur){
		if(conducteur.getAge()>=18)
			this.Conducteur = conducteur;
			
	}
	
	/**
	* affiche le toString
	*/
	public void Afficher(){
		System.out.println(this);
	}
	
	public String toString(){
		return "la voiture est jolie elle est " + this.Couleur + " le reservoir "+this.reservoir;
	}
	
	/**
	* @param distance est la distance à parcourir
	* @return retourne la distance restante à parcourir
	* cette fonction verifie si on a assez de carburant et fais le trajet mais si pas assez elle fais ce qui est possible et vide le reservoir et indique combien il reste a parcourir
	*/
	public double avancer(double distance){
	    double distanceMax = 100 * this.getContenuReservoir() / this.Moteur.getConsommation();

	    if(distance <= distanceMax){
		this.reservoir.vider(this.Moteur.getConsommation() * distance / 100);
		return 0;
	    } else {
		this.reservoir.vider(this.getContenuReservoir());
		return distance - distanceMax;
	    }
	}
	/**
	* cette fonction fais le plein
	*/
	public double faireLePlein(){
		this.reservoir.remplir(this.reservoir.getCapacite()-this.getContenuReservoir());
		return 	0;
	}
	/**
	* @return recupere le contenu du reservoir
	*/
	public double getContenuReservoir(){
		return this.reservoir.getContenu();
	}
	
	
	
}
