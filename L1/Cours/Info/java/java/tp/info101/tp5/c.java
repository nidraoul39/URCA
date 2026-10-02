import java.util.Scanner;

class TP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n;

        System.out.print("combien de ligne : ");
        n = input.nextLong();
        affichpasc(n);
    }

    public static long factoriel(long n) {
        long fact = 1;
        for (long i = 1; i <= n; i++) { 
            fact = fact * i;
        }
        return fact;
    }

    public static long coefBin(long n, long p) {
        return factoriel(n) / (factoriel(p) * factoriel(n - p)); 
    }

    public static void affval(long n, long dig) {
        for (long i = 0; i < dig - nbdig(n); i++) {
            System.out.print(" ");
        }
        System.out.print(n + " ");
    }

    public static long nbdig(long n) {
        long nb = 0;
        do {
            n /= 10;
            nb++;
        } while (n != 0);
        return nb;
    }
    
    public static long coefmax(long n) {
        long max = 0;
        for (long p = 0; p <= n; p++) {
            long coef = coefBin(n, p);
            if (coef > max)
                max = coef;
        }
        return max;
    }

    public static void afficherligne(long n, long largeur, long maxLargeur) {
        for (long i = 0; i < (maxLargeur - (n + 1) * (largeur + 1)) / 2; i++)
            System.out.print(" ");

        for (long p = 0; p <= n; p++) {
            affval(coefBin(n, p), largeur);
        }
        System.out.println();
    }

    public static void affichpasc(long n) {
        long largeur = nbdig(coefmax(n - 1));
        long maxLargeur = n * (largeur + 1);    

        for (long i = 0; i < n; i++) {
            afficherligne(i, largeur, maxLargeur);
        }
    }
    public static void lignemax(){
        
    }
}
    

