import java.util.Scanner;

class calculatrice{
    public static void main(String[] args){
        int n1,n2;
        String operation;
        char op;
        Scanner input = new Scanner(System.in);

        System.out.print("entrez valeur 1 : ");
        n1 = input.nextInt();
        System.out.print("entrez valeur 2 : ");
        n2 = input.nextInt();

        for(int i=0;i<5;i++){

            do{
                System.out.println("quelle operation faire entre : + - * / : ");
                input.nextLine();
                operation = input.nextLine();
                op = operation.charAt(0);}
            while(op!= '*' || op != '+' || op != '/' || op != '/');


            switch (op) {
                case '*':
                    System.out.println("resultat est : "+(n1*n2));
                    break;
                case '+':
                    System.out.println("resultat est : "+(n1+n2));
                    break;
                case '-':
                    System.out.println("resultat est : "+(n1-n2));
                    break;
                case '/':
                    if(n2 == 0)
                        System.out.println("erreur division par 0 impossible ");
                    else
                        System.out.println("resultat est : "+(n1/n2));  
                    break;        
                default:
                    System.out.println("vous avez pas selectionner d'opérateur au revoir.");
            }
        }
    }
}