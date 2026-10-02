import java.util.Scanner;
public class TestSenseo {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String color;
        System.out.print("entrer la couleur : ");
        color = input.nextLine();
        Senseo machine = new Senseo(0,Couleur.valueOf(color));
        int choice;
        boolean running = true;

        while(running) {
            System.out.println("\n--- Menu ---");
            System.out.println("(1) Afficher la cafetière");
            System.out.println("(2) Boire un café");
            System.out.println("(3) Ajouter une dosette");
            System.out.println("(4) Remplir le réservoir");
            System.out.println("(0) Quitter");
            System.out.print("Choisir une option : ");
            choice = input.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.println(machine);
                    break;
                case 2:
                    System.out.println(machine.boireCafe());
                    break;
                case 3:
                    System.out.println(machine.ajouterDosette());
                    break;
                case 4:
                    System.out.print("Quantité d'eau à ajouter (ml) : ");
                    int quantite = input.nextInt();
                    machine.remplirReservoir(quantite);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide");
            }
        }

    }
}
