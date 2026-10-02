package tp1;
import java.util.Scanner;
class TestPersonne {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Personne A = new Personne("Cackpo","Armand",184,70,"Mr.",18);
        System.out.println(A);
        int n;
        String nom;
        String prenom;
        int taille;
        int poids; 
        String civil;
        int age;
        System.out.print("combien d'humain crée : ");
        n = input.nextInt();
        Personne[] humain = new Personne[n];

        for(int i = 0;i<n;i++){
            System.out.print("entrer nom : ");
            nom = input.next();
            System.out.print("entrer prenom : ");
            prenom = input.next();
            System.out.print("entrer taille : ");
            taille = input.nextInt();
            System.out.print("entrer poids : ");
            poids = input.nextInt();
            System.out.print("entrer civilité : ");
            civil = input.next();
            System.out.print("entrer age : ");
            age = input.nextInt();
            humain[i] = new Personne(nom, prenom, taille, poids, civil, age);
            System.out.println(humain[i]);
            System.out.println(humain[i].IMCS());
        }
    } 
}
