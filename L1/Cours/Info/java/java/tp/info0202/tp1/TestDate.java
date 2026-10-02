package tp1;
import java.util.Scanner;
public class TestDate {
 
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Date date = new Date();
        System.out.println(date.Afficher());
        System.out.println(date);
        int j = input.nextInt();
        int m = input.nextInt();
        int a = input.nextInt();
        date.setJour(j);
        date.setMois(m);
        date.setAnnée(a);
        System.out.println(date.Afficher());

        System.out.println(date);


    }
}
