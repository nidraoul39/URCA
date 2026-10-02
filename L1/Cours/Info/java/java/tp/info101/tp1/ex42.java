import java.util.Scanner;

class ex42{
    public static void main(String[] args){
        int n1,n2;
        String operation;
        char op;
        Scanner input = new Scanner(System.in);

        System.out.print("entrez valeur 1 : ");
        n1 = input.nextInt();
        System.out.print("entrez valeur 2 : ");
        n2 = input.nextInt();
        System.out.println("quelle operation faire entre : + - * : ");
        input.nextLine();
        operation = input.nextLine();

        op = operation.charAt(0);

        if(op == '+')
            System.out.println("resultat est : "+(n1+n2));
        else{
            if(op == '-')
                System.out.println("resultat est : "+(n1-n2));
            else{
                if(op == '*')
                    System.out.println("resultat est : "+(n1*n2));
            }
                
        }

    }
}