import java.util.Scanner;
import java.lang.Math;
class tri{
    public static void main(String args[]){
        int n;
        Scanner input = new Scanner(System.in);
        int a,b,p;
        double [] tab;
        double [] tritab;
        do{
            System.out.print("entrez la taille du tableau de départ (positif) : ");
            n = input.nextInt();
            System.out.print("entrez la born min ( positif et inférieur a la borne max ): ");
            a = input.nextInt();
            System.out.print("entrez la born max ( positif et superieur a la borne min ): ");
            b = input.nextInt();
            System.out.print("entrez la precision cb de 0 apres la virgule positif ou nul: ");
            p = input.nextInt();            
        }while(n<=0 || a>b || p<0);
        tab = allocate(n);
        alea(tab,a,b,p);
        affichertab(tab);
        tritab = triselec(tab);
        affichertab(tritab);        

    }

    public static double[] allocate(int n){
        double[] tab = new double[n];
        return tab;
    }
    public static void alea(double[] t, double a, double b,int precision){
        final double cst = Math.pow(10,precision);
        for(int i = 0; i < t.length; i++)
            t[i] = (double)((int)((Math.random() * (b-a)+b) * cst)) / cst;
    }
    public static void affichertab(double[] t){
        for(int i = 0; i<t.length; i++){
            System.out.print(t[i]+" ");
        }
        System.out.println();
    }
    public static int indiceMinimum(double[] t){
        int indicemin=0;
        for(int i = 1; i<t.length; i++){
            if (t[i]<t[indicemin])
                indicemin=i;
        }
        return indicemin;
    }
    public static double maximum(double[] t){
        double maxi=t[0];
        for(int i = 1; i<t.length; i++){
            if (t[i]>maxi)
                maxi=t[i];
        }
        return maxi;
    }
    public static double[] triselec(double[] t){
        double [] t2= new double[t.length];
        double max = maximum(t);
        int k=0;
        for(int i = 0; i<t.length;i++){
            k=indiceMinimum(t);
            t2[i]=t[k];
            t[k] = max;
        }
        return t2;
    }


}