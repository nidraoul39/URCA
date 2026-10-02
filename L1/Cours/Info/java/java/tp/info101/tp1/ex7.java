import java.util.Scanner;
class ex7{
    public static void main(String[] args){
        int n;
        int factoriel=1;
        Scanner input = new Scanner(System.in);
        System.out.println("entrez un nombre : ");
        n = input.nextInt();

        for(int i=1 ; i<n; i++){
            factoriel *= i;
        }
        System.out.println("la factoriel de "+n+" est : "+factoriel);

        
    }
}