import java.util.Scanner;
import java.lang.Math;

class exo1b {
    public static void main(String[] args){
        int r;
        double cercle;
        Scanner input = new Scanner(System.in);

        do{
            System.out.print("entrez le rayon positif : ");
            r = input.nextInt();
        }while(r<0);
        
        cercle = 2*Math.PI*r;
        
        System.out.println("le périmetre du cercle est : "+cercle);
    }
}
