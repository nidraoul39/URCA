import java.util.Scanner;
class appfact {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int nbSe;
        int nbSb;
        double prix;
        char choix;
        String choixstr;
        boolean nc;
        do{
            nbSe = NbSiropErable();
            nbSb = Nbsiropbleuets();
            prix = fraistransport(nbSe,nbSb)+nbSe*28+nbSb*12;
            System.out.println("le prix total pour "+nbSe+" Sirop d'erable et "+nbSb+" sirop de bleuet est de "+prix);
            System.out.print("voulez vous une nouvelle commande  oui (o) ou non (n): ");
            choixstr = input.nextLine();
            choix = choixstr.charAt(0);
            nc = (choix == 'o');
        }while(nc);
    }
    public static int NbSiropErable(){
        int nb;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("entrez nb de sirop multiple de 3 : ");
            nb = input.nextInt();
        }while(nb<0 || nb%3 != 0);
        return nb;
    }
    public static int Nbsiropbleuets(){
        int nb;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("entrez nb de sirop bleuet : ");
            nb = input.nextInt();
        }while(nb<0);
        return nb;
    }
    public static double fraistransport(int siroperable, int siropbleuret){
        double frais=0;
        if (siroperable<11)
            frais +=siroperable*1.5;
        else if(siroperable<24)
            frais += siroperable*1;
        frais += siropbleuret*0.5;
        return frais;        

    }
    
}
