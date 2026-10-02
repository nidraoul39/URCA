import java.util.Scanner;
import java.lang.Math;

class jeudevin{
    public static void main(String[] args){
        int nb = (int)(Math.random()*1024+1);
        int j1;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("entrer un nombre : ");
            j1 = input.nextInt();
            if(j1<nb)
                System.out.println("trop petit");
            else if(j1>nb)
                System.out.println("trop grand");

        }
        while(j1!=nb);
        System.out.println("Bravo !! ");

    }
}