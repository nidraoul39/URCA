import java.util.Scanner;

class ex6{
    public static void main(String[] args){
        int h1,m1,s1,h2,m2,s2,r1,r2, r3, ope,hf,mf,sf;
        Scanner input = new Scanner(System.in);

        System.out.print("entrez h1 : ");
        h1 = input.nextInt();
        System.out.print("entrez m1 : ");
        m1 = input.nextInt();
        System.out.print("entrez s1 : ");
        s1 = input.nextInt();
        System.out.print("entrez h2 : ");
        h2 = input.nextInt();
        System.out.print("entrez m2 : ");
        m2 = input.nextInt();
        System.out.print("entrez s2 : ");
        s2 = input.nextInt();

        r1 = h1*3600 + m1*60 + s1;
        r2 = h2*3600 + m2*60 + s1;
        
        input.nextLine();
        System.out.print("quelle operation faire + ou - : ");
        ope = input.nextLine().charAt(0);

        if(ope == '+'){
            r3 = r1+r2;
            hf = r3/3600;
            r3= r3%3600;
            mf = r3/60;
            r3 = r3%60;
            sf = r3;
            System.out.println("l'heure calculer est : h "+hf+" m "+mf+" s "+sf);        

        }
        else if(ope == '-'){
            r3 = r1-r2;
            hf = r3/3600;
            r3= r3%3600;
            mf = r3/60;
            r3 = r3%60;
            sf = r3;
            System.out.println("l'heure calculer est : h "+hf+" m "+mf+" s "+sf);        

        }
        else
            System.out.println("erreur mauvais signe au revoir.");

    }
}
