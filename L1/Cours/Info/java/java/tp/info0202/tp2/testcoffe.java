import java.util.Scanner;
class testcoffe{
    
    
    public static void main(String[] args) throws IllegalArgumentException{
        Scanner input = new Scanner(System.in);
        String mark;
        System.out.println("entrer marque : ");
        mark = input.nextLine();

        Coffe machine1 = new Coffe(100,100,Marque.valueOf(mark),10000);
        int choice;
        double argent;
        double monaie;
        int nbdos;
        String markuser;
        while(true){
            System.out.println("(1) Afficher le distributeur\n" + 
                                "(2) Boire un café court (demander la monnaie à insérer)\n" + 
                                "(3) Boire un café long (demander la monnaie à insérer)\n" + 
                                "(4) Ajouter des dosettes (demander le nombre de dosettes à remettre puis demander la\n" + 
                                "marque en proposant tous les choix possibles)\n" + 
                                "(5) Remplir le réservoir (demander la quantité d’eau à ajouter)\n" + 
                                "(6) Permettre de récupérer, modifier ou augmenter les prix\n" +
                                "(7) quitter "+
                                "que veux tu faire ? : ");
            choice = input.nextInt();
            switch(choice){
                case 1:
                    machine1.Afficher();
                    break;
                case 2:
                    System.out.print("mettre argent : ");
                    argent = input.nextDouble();
                    monaie = machine1.boireCafeCourt(argent);
                    System.out.println("argent rendu : "+monaie);
                case 3: 
                    System.out.print("mettre argent : ");
                    argent = input.nextDouble();
                    monaie = machine1.boireCafeLong(argent);
                    System.out.println("argent rendu : "+monaie);
                case 4:
                    System.out.print("entrer la marque des dosettes : ");
                    markuser = input.nextLine();
                    System.out.print("entrer le nb de dosette : ");
                    nbdos = input.nextInt();
                    System.out.println(machine1.ajouterDosettes(nbdos,markuser));
                case 5:
                    System.out.print("Quantité d'eau à ajouter (ml) : ");
                    int eau = input.nextInt();
                    machine1.remplirReservoir(eau);
                    break;
                case 6:
                    System.out.println("(1) Voir les prix\n(2) Modifier un prix\n(3) Augmenter les prix");
                    int priceChoice = input.nextInt();
                    input.nextLine();
                    switch(priceChoice){
                        case 1:
                            System.out.println(Coffe.getPrixCafeLong()+"€");
                            System.out.println(Coffe.getPrixCafeCourt()+"€");
                            break;
                        case 2:
                            int c;
                            System.out.println("1 : changer prix cafe long \n2 : changer prix café court");
                            c = input.nextInt();
                            if(c==1){
                                System.out.println("entrer prix cafe long : ");
                                Coffe.setCafeLong(input.nextDouble());
                            }
                            else if(c==2){
                                System.out.println("entrer prix cafe court : ");
                                Coffe.setCafeCourt(input.nextDouble());
                            }
                            else
                                System.out.println("error");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Au revoir!");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }            

        }
        

    }

}