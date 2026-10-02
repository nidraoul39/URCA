import java.util.Scanner;
import java.lang.Math;

class Binaire{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String choix;
        char c;
        do {
            System.out.println("Choisissez une opération :");
            System.out.println("1. Addition binaire");
            System.out.println("2. Complément à 2");
            System.out.println("3. Conversion binaire -> entier");
            System.out.println("4. Conversion entier -> binaire");
            System.out.println("q. Quitter");
            choix = input.nextLine();
            c = choix.charAt(0);
            switch(c){
            case '1': {
                System.out.println("Entrez le premier nombre binaire:");
                String s1 = input.nextLine().trim();
                System.out.println("Entrez le deuxième nombre binaire:");
                String s2 = input.nextLine().trim();
                int[] bin1 = new int[s1.length()];
                int[] bin2 = new int[s2.length()];
                for(int i = 0; i < s1.length(); i++) bin1[i] = s1.charAt(i) - '0';
                for(int i = 0; i < s2.length(); i++) bin2[i] = s2.charAt(i) - '0';
                int[] res = somme(bin1, bin2);
                System.out.print("Résultat: ");
                for(int b : res) System.out.print(b);
                System.out.println();
                break;
            }
            case '2': {
                System.out.println("Entrez un nombre binaire:");
                String s = input.nextLine().trim();
                int[] bin = new int[s.length()];
                for(int i = 0; i < s.length(); i++) bin[i] = s.charAt(i) - '0';
                int[] comp = complementa2(bin);
                System.out.print("Complément à 2: ");
                for(int b : comp) System.out.print(b);
                System.out.println();
                break;
            }
            case '3': {
                System.out.println("Entrez un nombre binaire:");
                String s = input.nextLine().trim();
                int[] bin = new int[s.length()];
                for(int i = 0; i < s.length(); i++) bin[i] = s.charAt(i) - '0';
                System.out.println("Entier: " + binaire2entier(bin));
                break;
            }
            case '4': {
                System.out.println("Entrez un entier:");
                int n = input.nextInt();
                input.nextLine();
                System.out.println("Nombre d'octets:");
                int nboct = input.nextInt();
                input.nextLine(); 
                int[] b = entier2bin(n, nboct);
                System.out.print("Binaire: ");
                for(int i=0;i<b.length;i++){
                    System.out.print(b[i]);
                }
                System.out.println();
                break;
            }
            case 'q':
            case 'Q':
                System.out.println("Au revoir.");
                break;
            default:
                System.out.println("Choix invalide.");
            }
        } while(c != 'q' && c != 'Q');


        }
    public static int [] entier2bin(int n, int nboctect){
        int [] tab = new int[(nboctect*8)];
        int entier = n;
        for(int i = tab.length-1;i>=0;i--){
            tab[i] = entier%2;
            entier /=2;
        }
        return tab;
    }
    public static int binaire2entier(int [] bin){
        int entier = 0;
        for(int i = 0; i<=bin.length-1;i++){
            entier += bin[bin.length-1-i]*Math.pow(2,i);
        }
        return entier;
    }
    public static int [] somme(int [] bin1 , int [] bin2){
        int nboctect = 0;
        if(bin1.length<bin2.length)
            nboctect = (bin2.length/8);
        else
            nboctect = (bin1.length/8);
        return entier2bin(binaire2entier(bin1)+binaire2entier(bin2),nboctect);
    }
    public static int[] complementa2(int [] bin){
        int [] complement = new int[bin.length];
        for(int i = bin.length-1; i>=0;i--){
            if(bin[i] == 0)
                complement[i] = 1;
            else
                complement[i] = 0;
        }

        return somme(complement,entier2bin(1,1));
    }
}