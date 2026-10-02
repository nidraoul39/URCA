import java.util.Scanner;

class TP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("combien de ligne : ");
        n=input.nextInt();
        affichpasc(n);

    }

    public static int factoriel(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) { 
            fact = fact * i;
        }
        return fact;
    }

    public static int coefBin(int n, int p) {
        return factoriel(n) / (factoriel(p) * factoriel(n - p)); 
    }

    public static void afficherligne(int n,int dig){
        for (int p = 0; p <= n; p++) {
            affval(coefBin(n, p) , dig);
        }
        System.out.print("\n");
    }

    public static void affichpasc(int n){
        int space;
        for(int i=0; i<n;i++){
            space = n-i*nbdig(coefmax(n));
            afficherligne(i,space);
        }
    }
    public static int nbdig(int n){
        int x = n;
        int nb=0;
        do{
            x/=10;
            nb+=1;
            
        }while(x!=0);
        return nb;
    }
    public static int coefmax(int n){
        int max = 0;
        int coef = 0;
        for (int p = 0; p <= n; p++) {
            coef = coefBin(n, p);
            if(max<coef)
                max = coef;
        }
        return max;
    }
    public static void affval(int n,int dig){
        for(int i=0;i<=(dig-nbdig(n));i++){
            System.out.print(" ");
        }
        System.out.print(n);
        
    }
}
