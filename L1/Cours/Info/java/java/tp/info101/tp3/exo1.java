import java.lang.Math;
import java.util.Scanner;
class exo1 {
    public static void main(String[] args){
        int n;
        double min;
        min = 10;
        double max = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("entrez un nombre : ");
        n = input.nextInt();
        for(int i = 0; i<n;i++){
            double random = Math.random()*10-5;
            random = Math.round(random);
            System.out.println(random);
            if (min>random)
                min = random;
            if (max<random)
                max = random;
        }

        System.out.println("minimum : "+ min);
        System.out.println("max : "+ max);

    }
}