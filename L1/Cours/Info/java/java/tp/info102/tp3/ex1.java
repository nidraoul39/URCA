import java.util.*;
import java.lang.Math;

class ex1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a,b,n;
        int [] tab;

        do{
            System.out.print("entrez a inférieur a b : ");
            a = input.nextInt();
            System.out.print("entrez b supérieur à a : ");
            b = input.nextInt();
            System.out.print("entrez n positif : ");
            n = input.nextInt();

        }while(a>=b || n<=0);

        int k = (int) (Math.random()*(b-a)+a);

        tab = genererTableau(n,a,b);
        System.out.println(getTemps());
        System.out.println("on cherche "+k+" il est a position "+rechercheSequentielle(tab,k));
        System.out.println(getTemps());
        Arrays.sort(tab);
        System.out.println(getTemps());
        System.out.println("on cherche "+ k + " il est a position "+rechercheSequentielleTriee(tab,k));
        System.out.println(getTemps());

        System.out.println(getTemps());
        System.out.println("dichotomie: position " + dichotomie(tab,k));
        System.out.println(getTemps());
        
    }
    public static int aleatoire(int a,int b){
        return (int) (Math.random()*(b-a)+a);
    }
    public static int[] genererTableau(int n,int a, int b){
        int[] tab = new int[n];
        for(int i = 0;i<n;i++){
            tab[i] = aleatoire(a,b);
        }
        return tab;
    }
    public static void afficher(int[] tab){
        for(int i = 0; i<tab.length;i++){
            System.out.print(tab[i]+" ");
        }
        System.out.println();
    }
    public static int rechercheSequentielle(int [] tab, int n){
        int k = 0;
        while(k<tab.length && tab[k]!=n){
            k++;
        }
        if(k==tab.length)
            return -1;
        return k;
    }

    public static int rechercheSequentielleTriee(int[] tab,int n){
        int k = 0;
        while(k<tab.length && tab[k]<n){
            k++;
        }
        if(k==tab.length) return -1;
        if(tab[k]==n) return k;
        return -1;
    }
    public static long getTemps() {
        Date d = new Date();
        return d.getTime();
    }
    public static int dichotomie(int [] tab, int chr){
        int low = 0;
        int high = tab.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(tab[mid] == chr) return mid;
            else if(tab[mid] < chr) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}