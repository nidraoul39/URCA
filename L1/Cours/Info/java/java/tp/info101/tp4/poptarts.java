import java.util.Scanner;
import java.lang.Math;
class poptarts {
    public static void main(String[] args){
        int res;
        boolean restart = true;
        int p =0;
        int n = 0;
        String charstr;
        char c;
        Scanner input = new Scanner(System.in);

        System.out.println("bonjour lancement d'une partie");
        do{
        p+=1;
        res = jeu();
        if(res==1){
            System.out.println("bravo vous avez gagnez !! ");
            n++;}
        else if(res == 0)
            System.out.println("vous avez perdu :( ");
        else
            System.out.println("erreur");
        System.out.println("voulez vous rejouez(r) arretez(a) ou stat (s) ?");
        charstr = input.nextLine();
        c = charstr.charAt(0);
        switch(c){
            case 'r':
                restart = true;
                break;
            case 'a':
                restart = false;
                break;
            case 's':
                System.out.println("vous avez jouez "+p+" partie vous avez gagnez "+n+" partie et perdu "+(p-n)+" partie");
                restart = false;
                break;
        }
        }while(restart);
    }
    public static int nbaleatoir(){
        int nb = (int)(Math.random()*(3)+1);
        return nb;
    }
    public static int jeuordi(int rest){
        int nb;
        do{
            nb = nbaleatoir();
        }while(nb>rest);
        return rest-nb;
    }
    public static int jeujoueur(int rest){
        int nb;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("entez le nb de truc a ramassez entre 1 et 3 (il reste "+rest+" baton ):");
            nb = input.nextInt();
        }while(nb>rest || nb>3 || nb<1);
        return rest-nb;
    }
    public static int jeu(){
        int nbaton = (int)(Math.random()*(20-10+1))+10;
        int jg=-1;
        do{
            nbaton = jeujoueur(nbaton);
            if (nbaton == 0)
                jg = 0;
            else{
                nbaton = jeuordi(nbaton);
                if(nbaton == 0)
                    jg = 1;  
            }

        }while(nbaton>0);
        return jg;
    }

    
}
