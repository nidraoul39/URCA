/**
 * Classe TestPendu
 * @author Jessica Jonquet
 * @version 25/03/2025
 */
import java.io.IOException;
import java.util.Scanner;
public class TestPendu{
	public static void main(String[] args) {    
		try{
		Scanner clavier = new Scanner(System.in);
		char lettre;
		ListeMot file = new ListeMot("dicoPendu.txt");
		boolean fini = true;
		System.out.println("bonjour choisissez le mode 1 : vous écrivez un mot 2 : un mot est tiré aléatoirement ");
		int choix;
		choix = clavier.nextInt();
		clavier.nextLine();
		Pendu p;
		if(choix==1){
			System.out.println("Saisir le mot d'au moins 4 lettres a deviner : ");
			String mot = clavier.nextLine();
			p = new Pendu(mot);
			file.ajouterMot(p.getMot());
		}
		else{
			p = new Pendu(file.getHasard());
		}

		do{
			p.afficherEssais();
			System.out.print("\nEntrez une lettre : ");
			lettre = clavier.nextLine().charAt(0);
		}
		while(p.jouer(lettre) && !p.estFini());
		p.afficherEssais();
		if(p.estFini())
			System.out.println("Gagne !!!!!");
		else{
			System.out.println("Perdu :-(");
			System.out.print("\nLa solution est : "+p.getMot());
		}
		}
		catch(IOException e){
			System.out.println("erreur fatal "+e);
		}
	}
	
}