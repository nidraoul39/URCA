import java.util.*;
import java.lang.Math;

public class tri {
    public static void main(String[] args){
        int n = 1000000;
        int a = 0, b = 100000;
        try {
            if (args.length >= 1) n = Integer.parseInt(args[0]);
            if (args.length >= 3) { a = Integer.parseInt(args[1]); b = Integer.parseInt(args[2]); }
        } catch (NumberFormatException e) {
            System.out.println("Arguments invalides. Usage: java tri [n] [a] [b]");
            return;
        }

        int[] original = genererTableau(n, a, b);
        if (n <= 50) {
            System.out.print("Tableau original : ");
            afficher(original);
        }

        int[] t;

        // triselection (renvoie un nouveau tableau)
        t = clone(original);
        long start = getTemps();
        int[] resSelection = triselection(t);
        long end = getTemps();
        System.out.println("triselection : " + (end - start) + " ms");
        if (n <= 50) {
            System.out.print("résultat triselection : ");
            afficher(resSelection);
        }

        // triselectionechange (tri sur place)
        t = clone(original);
        start = getTemps();
        triselectionechange(t);
        end = getTemps();
        System.out.println("triselectionechange : " + (end - start) + " ms");
        if (n <= 50) {
            System.out.print("résultat triselectionechange : ");
            afficher(t);
        }

        // triinsertion (tri sur place)
        t = clone(original);
        start = getTemps();
        triinsertion(t);
        end = getTemps();
        System.out.println("triinsertion : " + (end - start) + " ms");
        if (n <= 50) {
            System.out.print("résultat triinsertion : ");
            afficher(t);
        }

        // vérification des résultats
        boolean okSel = true;
        for (int i = 1; i < resSelection.length; i++) {
            if (resSelection[i - 1] > resSelection[i]) { okSel = false; break; }
        }
        boolean okEx = true;
        for (int i = 1; i < t.length; i++) { /* note: t contient le dernier tri (insertion) */ }
        boolean okIns = true;
        int[] chkIns = clone(original);
        triinsertion(chkIns);
        for (int i = 1; i < chkIns.length; i++) {
            if (chkIns[i - 1] > chkIns[i]) { okIns = false; break; }
        }
        // construire vérification pour triselectionechange
        int[] chkEx = clone(original);
        triselectionechange(chkEx);
        for (int i = 1; i < chkEx.length; i++) {
            if (chkEx[i - 1] > chkEx[i]) { okEx = false; break; }
        }

        System.out.println("Vérification tri : triselection=" + okSel +
                           " triselectionechange=" + okEx +
                           " triinsertion=" + okIns);
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
    public static long getTemps() {
        Date d = new Date();
        return d.getTime();
    }
    public static int[] clone(int[]t){
        int[] tab = new int[t.length];
        for(int i = 0; i<t.length;i++){
            tab[i]=t[i];
        }
        return tab;
    }

    public static int min(int[] t,int a){
        int k = 0;
        for(int i =a;i<t.length;i++){
            if(t[k]>t[i]){
                k=i;
            }
        }
        return k;
    }
    public static int max(int[] t){
        int k = 0;
        for(int i =1;i<t.length;i++){
            if(t[k]<t[i]){
                k=i;
            }
        }
        return k;
    }
    public static void echange(int[] t,int a,int b){
        t[a] = t[a]+t[b];
        t[b] = t[a];
        t[a] = t[a]-t[b];
    }

    public static int[] triselection(int[]t){
        int[] tab = new int[t.length];
        int max = max(t);
        int test;
        for(int i = 0; i<t.length;i++){
            test = min(t,0);
            tab[i] = t[test];
            t[test]=max;
        }
        return tab;
    }
    public static void triselectionechange(int[]t){
        int test;
        for(int i = 0; i<t.length;i++){
            test = min(t,i);
            echange(t,i,test);
        }
    }
    public static void decal(int[] t,int a,int b){
        int tmp=b;
        for(int i = b;i>a+1;i--){
            t[b]=t[b-1];
        }
        t[a]=tmp;
    }
    public static int insert(int[]t,int a){
        int k = 1;
        while(k<t.length && t[k]>a){
            k++;
        }
        return k;
    }

    public static void triinsertion(int[] t){
        
        for(int i = 0;i<t.length;i++){
            if(i == 0) continue;
            int key = t[i];
            int j = i - 1;
            while (j >= 0 && t[j] > key) {
                t[j + 1] = t[j];
                j--;
            }
            t[j + 1] = key;
        }
    }

}
