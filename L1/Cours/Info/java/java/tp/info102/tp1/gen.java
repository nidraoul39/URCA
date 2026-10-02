import java.util.Scanner;
import java.lang.Math;

class gen{
    public static void main(String args[]){
        int taille;
        Scanner input = new Scanner(System.in);
        
        System.out.println("entrer taille tableau ");
        taille = input.nextInt();
        int [] tab = new int[taille];

        for(int i=0;i<=tab.length-1;i++){
            tab[i] = (int)(Math.random()*(2000)-1000);
        }
    

        for(int i=0;i<=tab.length-1;i++){
            System.out.println(tab[i]);
        }
        System.out.println(tab);
        System.out.println("le maximum est : "+max(tab)+" voila !!");
    

    }
    public static int max(int [] tab){
        int max = tab[0];
        for(int i=1;i<tab.length;i++){
            if (max<tab[i]){
                max = tab[i];
            }
        }
        return max;

    }

    
}