import java.util.Scanner;

class ex3{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n;
        System.out.print("entrez votre valeur : ");
        n = keyboard.nextInt();
        if(n==0)
            System.out.println("vous avez saisi 0");
        
        else if(n>0)
            System.out.println("+");
        
        else
            System.out.println("-");
        
        
    }
}