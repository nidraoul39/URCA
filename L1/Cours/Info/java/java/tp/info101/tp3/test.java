import java.util.Scanner;
import java.lang.Math;

class test {
    public static void main(String[] args) {
        int a, b, j1,mem;

        boolean win = false;
        Scanner input = new Scanner(System.in);

        System.out.print("Borne du début : ");
        a = input.nextInt();

        System.out.print("Borne de fin : ");
        b = input.nextInt();       
        if(a>b){
            mem =a;
            a=b;
            b=mem;
        }
        int maxdonner = b+1; 
        int mindonner = a-1; 

        int nb = (int)(Math.random() * (b - a + 1) + a);

        // calcul du nombre max d'essais
        int y = b - a + 1;
        int essaisMax = (int) Math.ceil(Math.log(y) / Math.log(2));
        int t = 0;

        System.out.println("Tu dois trouver un nombre entre " + a + " et " + b);
        System.out.println("Tu as " + essaisMax + " essais maximum.");

        do {
            System.out.println("\nEssai " + (t+1) + " / " + essaisMax);
            System.out.print("Entrez un nombre : ");
            j1 = input.nextInt();

            if (j1 < nb) {
                if (j1 <= mindonner)
                    System.out.println("Trop petit, je te l'ai déjà dit !");
                else {
                    System.out.println("Trop petit !");
                    mindonner = j1;
                }
            } else if (j1 > nb) {
                if (j1 >= maxdonner)
                    System.out.println("Trop grand, je te l'ai déjà dit !");
                else {
                    System.out.println("Trop grand !");
                    maxdonner = j1;
                }
            } else {
                win = true;
            }

            t+=1;
        } while (!win && t < essaisMax);

        System.out.println();
        if (win) {
            System.out.println("Bravo !! Le nombre était bien " + nb);
            System.out.println("Tu l'as trouvé en " + t + " essais.");
        } else {
            System.out.println("Dommage ! Tu as perdu.");
            System.out.println("Le nombre était : " + nb);
        }
    }
}
