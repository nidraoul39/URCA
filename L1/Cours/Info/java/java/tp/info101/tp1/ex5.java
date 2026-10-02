import java.util.Scanner;

class ex5{
    public static void main(String[] args){
        int n1,n2,n3;
        Scanner input = new Scanner(System.in);

        System.out.print("entrez valeur 1 : ");
        n1 = input.nextInt();
        System.out.print("entrez valeur 2 : ");
        n2 = input.nextInt();
        System.out.print("entrez valeur 3 : ");
        n3 = input.nextInt();
        System.out.println("échange 1 dans 2, 2 dans 3, et 3 dans 1 .....");
        n3 = n3 + n1;
        n1 = n3 - n1;
        n3 = n3 - n1;
        n3 = n3 + n2;
        n2 = n3 - n2;
        n3 = n3 - n2;
        System.out.println("valeur 1 : "+n1+" valeur 2 : "+n2+" valeur 3 : "+n3);


    }
}