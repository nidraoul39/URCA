import java.util.Scanner;

class ex1{
    public static void main(String[] args){
        int n1,n2;
        Scanner input = new Scanner(System.in);
        System.out.print("Valeur 1 : ");
        n1 = input.nextInt();
        System.out.print("Valeur 2 : ");
        n2 = input.nextInt();
        System.out.println("La somme des deux valeur est : "+(n1+n2));
        
    }
}