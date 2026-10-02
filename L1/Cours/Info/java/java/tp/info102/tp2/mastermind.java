import java.util.Scanner;
import java.lang.Math;


class mastermind {
    public static void main(String args[]){
        boolean win = false;
        int [] solution;
        solution = remplirSolution(4);
        afficherTableauEntiers(solution);
        char [] reponse;
        int [] saisi;
            
        while(!win){
            saisi = saisirProposition(4);
            win = afficherResultat(saisi, solution);
        }
        System.out.println("ggwp");

    }
    public static void afficherTableauEntiers(int[] t){
        for(int i = 0; i<t.length;i++){
            System.out.print(t[i]+" ");
        }
        System.out.println();

    }
    public static void afficherTableauCaracteres(char[] t){
        for(int i = 0; i<t.length;i++){
            System.out.print(t[i]+" ");
        }
        System.out.println();

    }
    public static int[] remplirSolution(int taille){
        int[] t=new int[taille];
        for(int i = 0;i<taille;i++){
            t[i]=(int)(Math.random()*9);
        }
        return t;
    }
    public static int[] saisirProposition(int taille){
        int[] t = new int[taille];
        int p;
        Scanner input = new Scanner(System.in);
        for(int i = 0;i<taille;i++){
            do{
                System.out.print("entrez proposition "+(i+1)+" entre 0 et 9: ");
                p = input.nextInt();
            }while(p<0 || p>9);
            t[i] = p;
        }
        return t;
    }
    public static boolean bienPlacee(int[] solution, int valeur, int position){
        return valeur == solution[position];
    }
    public static boolean malPlacee(int[] solution, int valeur, int position){
        boolean p = false;
        if (!bienPlacee(solution,valeur,position)){
            for(int i=0; i<solution.length;i++){
                if (solution[i] == valeur){
                    p = true;
                }
            }
        }
        return p;
    }
    public static char[] compare(int[] proposition, int[] solution){
        char[] reponse = new char[proposition.length];
        for(int i = 0; i<reponse.length;i++){
            if (bienPlacee(solution, proposition[i],i))
                reponse[i]='B';
            else if(malPlacee(solution, proposition[i],i))
                reponse[i] = 'M';
            else
                reponse[i] = '-';
        }
        return reponse;
    }
    public static boolean gagne(char[] resultat){
        boolean win = true;
        int i = 0;
        while(i<resultat.length && win){
            if(resultat[i]!='B')
                win = false;
            i+=1;
        }
        return win;
    }
    public static boolean afficherResultat(int[] proposition, int[] solution){
        char [] res;
        afficherTableauEntiers(proposition);
        res = compare(proposition,solution);
        afficherTableauCaracteres(res);
        System.out.println("");
        return gagne(res);
    }
}
