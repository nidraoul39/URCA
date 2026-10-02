import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.text.Normalizer;
import java.lang.Math;

class pendu{
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        char[] solution;
        char[] mask;
        char c;
        String C;
        int i=0;
        solution = initsol();
        mask = newmask(solution.length);
        do{
            showtab(mask);
            showtry(i);
            do {
                C = input.nextLine().trim();
            } while (C.length() == 0);

            c = C.charAt(0);

            if (!jouer(mask, solution, c))
                i++;

        }while(!isend(mask) && i<6);
        if(isend(mask))
            System.out.println("c'est gagné BRAVO !! ");
        else
            System.out.println("perdu");
        showtab(solution);


        
    }

    public static int nbLignes(String nomFichier) {
            int resultat = 0;
            String tmp;
            
            try {
                // Ouverture du fichier
                FileInputStream fs = null;
                fs = new FileInputStream(nomFichier);

                // Lecture de chaque ligne du fichier => compte les mots
                Scanner scanner = new Scanner(fs,"UTF-8");
                while(scanner.hasNext()) {
                    tmp = scanner.nextLine();
                    resultat++;
                }
                scanner.close();
            
                // Fermeture du fichier
                fs.close();
            } catch(IOException e) {
                System.err.println("Erreur lors de la lecture du fichier.");
                System.err.println(e);
                System.exit(-1);
            }
            
            return resultat;
        }

        public static String motn(int n,String nomFichier){
                String tmp;
                tmp = "ERREUR";
                try {
                    // Ouverture du fichier
                    FileInputStream fs = null;
                    fs = new FileInputStream(nomFichier);

                    // Lecture de chaque ligne du fichier => compte les mots
                    Scanner scanner = new Scanner(fs,"UTF-8");
                    for(int i=0;i<n;i++) {
                        tmp = scanner.nextLine();
                    }
                    scanner.close();
                
                    // Fermeture du fichier
                    fs.close();
                } catch(IOException e) {
                    System.err.println("Erreur lors de la lecture du fichier.");
                    System.err.println(e);
                    System.exit(-1);
                }
                return tmp;
            }

    

    public static boolean isvalid(String mot){
        boolean valid = true;
        char c;
        if (mot.length()>=4){
            for(int i = 0; i<mot.length();i++){
                c = mot.charAt(i);
                if(c<'A' || c>'Z'){
                    valid = false;
                }
            }
        }
        else
            valid=false;
        return valid;
    }
    public static char[] conv(String mot){
        char[] tmot = new char[mot.length()];
        char c;
        for(int i = 0; i < mot.length();i++){
            c = mot.charAt(i);
            tmot[i] = c;
        }
        return tmot;
    }
    public static char[] initsol(){
        String mot = motn((int)(Math.random() * nbLignes("liste_francais.txt")), "liste_francais.txt");

        // Décomposition des accents
        mot = Normalizer.normalize(mot, Normalizer.Form.NFD);

        // Suppression des signes diacritiques (accents)
        mot = mot.replaceAll("\\p{M}", "");
        mot = mot.toUpperCase();

        return conv(mot);
}
    public static char[] newmask(int n){
        char [] mask = new char[n];
        for(int i = 0; i<n ; i++){
            mask[i] = '_';
        }
        return mask;
    }
    public static void showtab(char[] tab){
        for(int i = 0; i < tab.length; i++){
            System.out.print(tab[i]);
        }
        System.out.println();
    }
    public static boolean jouer(char[] mask, char[] solution, char coup){
        boolean res= false;
        for(int i = 0; i<solution.length;i++){
            if(solution[i] == coup){
                res = true;
                mask[i] = solution[i];
            } // accolade manquante dog
        }
        return res;
    }
    public static void showtry(int n){
        switch(n) {
            case 5: // La potence en entier et le pendu
                System.out.println(" /---\\\n |   |\n |   O\n |  /|\\\n |  / \\\n-^-");
                break;
            case 4: // La potence en entier
                System.out.println(" /---\\\n |   |\n |\n |\n |\n-^-");
                break;
            case 3: // La potence sans la corde
                System.out.println(" /---\\\n |\n |\n |\n |\n-^-");
                break;
            case 2: // Le corps de la potence
                System.out.println("\n |\n |\n |\n |\n-^-");
                break;
            case 1: // Le pied de la potence
                System.out.println("\n\n\n\n\n-^-");
                break;
            case 0:
                System.out.println("");
                break;
            }
    }
    public static boolean isend(char[] mask){
        boolean res = true;
        for(int i =0;i<mask.length;i++){
            if(mask[i] == '_')
                res = false;
        }
        return res;
    }


}