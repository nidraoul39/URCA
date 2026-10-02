/**
 * Classe des nombres complexe
 * @autor Nidal
 * @version 1.4.23
 */
public class Complexe implements IComplexe{
    
    /**
     * @param a est la partie réel
     * @param b est la partie imaginaire
     */
    private double a;
    private double b;

        /**
 * constructeur par initialisation
 * @param a partie reel a
 * @param b partie imaginaire b
 */
    
    public Complexe(double a, double b){
        this.a = a;
        this.b = b;
    }
    /**
 * constructeur par defaut 
 */
    public Complexe(){
        this(0,0);
    }
    /**
 * constructeur par copie
 * @param p un point existant
 */
    public Complexe(Complexe c){
        this.a = c.getPartieReelle();
        this.b = c.getPartieImaginaire();
    }


    /**
     * - getter de la partie reel
     * @return La partie Réel
     */
    
    public double getPartieReelle(){
        return this.a;
    }

    /**
     * - getter de la partie imaginaire
     * @return La partie imaginaire
     */

    public double getPartieImaginaire(){
        return this.b;
    }
    /**
     * - setter de la partie reel
     * @param a est la nouvelle partie reel
     */
    public void setPartieReelle(double a){
        this.a = a;
    }
    /**
     * - setter de la partie Imaginaire
     * @param a est la nouvelle partie Imaginaire
     */
    public void setPartieImaginaire(double b){
        this.b = b;
    }

    /**
     * - change les valeurs des deux partie réel puis imaginair
     * @param a nouvelle valeur reel
     * @param b nouvelle valeur imaginaire
     */
    public void changerValeur(double a, double b){
        this.a = a;
        this.b = b;
    }

    /**
     * - Verifie l'égalité entre deux complexe
     * @param C un autre nombre complexe
     * @return retourne vrai ou faux
     */
    public boolean egalA(IComplexe c){
        return (c.getPartieReelle() == this.a)&&(c.getPartieImaginaire() == this.b);
    }

	/**
	* Additionne la partie reelle au nombre complexe courant
	* @param reel la partie reelle
	*/
	public void additionner(double reel){
        this.a += reel;
    }

	/**
	* Additionne ajoute la partie reelle et la partie imaginaire au complexe courant (resp. à sa partie réelle et à sa partie imaginaire).
	* @param reel la partie reelle
	* @param imaginaire la partie imaginaire
	*/
	public void additionner(double reel, double imaginaire){
        this.a+= reel;
        this.b +=imaginaire;
    }

	/**
	* Additionne un nombre complexe passé au parametre au nombre complexe courant
	* @param r le nombre complexe
	*/
	public void additionner(IComplexe r){
        this.a += r.getPartieReelle();
        this.b += r.getPartieImaginaire();
    }
    
    public String toString(){

    }
}
