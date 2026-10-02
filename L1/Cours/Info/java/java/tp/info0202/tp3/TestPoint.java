/**
 * Programme de test pour manipuler des points cartésiens et polaires
 * via l'interface IPoint.
 *
 * Le programme :
 * - Crée un point cartésien avec coordonnées (39, -3)
 * - Crée un point cartésien par défaut
 * - Affiche la distance à l'origine et la distance entre deux points
 * - Permet à l'utilisateur de saisir 5 points (cartésiens ou polaires)
 * - Affiche la distance de chaque point à l'origine
 *
 * @author Nidal
 * @version 1.0
 */
import java.util.Scanner;

public class TestPoint {

    /**
     * Méthode principale du programme.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        // Création de deux points cartésiens
        PointCartesien p = new PointCartesien(39, -3);
        PointCartesien p3 = new PointCartesien();

        Scanner input = new Scanner(System.in);

        // Affichage de la distance du point p à l'origine
        System.out.println(p.distance());

        // Affichage de la distance entre p et p3
        System.out.println(p.distance(p3));

        double a;
        double b;

        // Tableau de points (cartésiens ou polaires)
        IPoint[] tab = new IPoint[5];
        int choice;

        // Boucle pour saisir 5 points
        for (int i = 0; i < 5; i++) {
            System.out.print("Entrer 0 si coordonnées normales, 1 si polaires : ");
            choice = input.nextInt();

            if (choice == 0) {
                // Saisie d'un point cartésien
                System.out.print("Entrer a : ");
                a = input.nextDouble();

                System.out.print("Entrer b : ");
                b = input.nextDouble();

                tab[i] = new PointCartesien(a, b);
            } else {
                // Saisie d'un point polaire
                System.out.print("Entrer a : ");
                a = input.nextDouble();

                System.out.print("Entrer b : ");
                b = input.nextDouble();

                tab[i] = new PointPolaire(a, b);
            }

            // Affichage de la distance du point saisi à l'origine
            System.out.println(tab[i].distance());
        }

        input.close();
    }
}