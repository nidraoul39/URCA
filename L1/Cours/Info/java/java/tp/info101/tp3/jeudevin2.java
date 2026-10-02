import java.util.Scanner;
import java.lang.Math;

class Jeudevin {
    public static void main(String[] args) {
        int a,b,j1,y;
        boolean win = false;
        int maxdonner=0; 
        int mindonner=0; 
        Scanner input = new Scanner(System.in);
        boolean x = true;

        System.out.print("borne du debut : ");
        a = input.nextInt();

        System.out.print("borne de fin : ");
        b = input.nextInt();       
        int nb = (int)(Math.random() * (b-a+1) + a);
        y = b-a+1;
        double ln = Math.log(y);
        int t = 0;
        do{


            System.out.print("Entrez un nombre : ");
            j1 = input.nextInt();

            if (x){
                maxdonner = j1+1;
                mindonner = j1-1;
                x = false;
            }

            if (j1 < nb) {
                if (j1 <= mindonner) 
                    System.out.println("Je t'ai déjà dit trop petit !");
                 else 
                    System.out.println("Trop petit !");
                
            } else if (j1 > nb) {
                if (j1 >= maxdonner) 
                    System.out.println("Je t'ai déjà dit trop grand !");
                else 
                    System.out.println("Trop grand !");
                
            }

            
            if (j1 < maxdonner && nb <maxdonner) {
                maxdonner = j1;
            }
            if (j1 > mindonner) {
                mindonner = j1;
            }
            if(nb == j1)
                win = true;
            t+=1;

        }while (j1 != nb || t<ln );
        System.out.println("");

        if (win)
            System.out.println("Bravo !! Le nombre était bien " + nb);
        else
            System.out.println("vous avez perdu");
    }
}
