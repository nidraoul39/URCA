import java.util.Scanner;
class note {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int note;
        
        System.out.print("entrer le nb de note : ");
        note = input.nextInt();

        double [] tab = new double[note];
        enternote(tab);
        affichertab(tab);
        System.out.println("la moyenne est de : "+moyenne(tab));


    }  
    public static void enternote(double [] tab){
        double note;
        Scanner input = new Scanner(System.in);
        for(int i=0; i<=tab.length-1;i++){
            int barem;
            System.out.print("entrer le barem pour la note numero "+(i+1)+" : ");
            barem = input.nextInt();
            do{
                System.out.print("entrer la note numero "+(i+1)+" entre 0 et "+barem+" STP : ");
                note = input.nextDouble();
            }while(note>barem || note<0);
            note=(note*20)/barem;
            tab[i] = note;
        }
    }  
    public static void affichertab(double [] tab){
        for(int i = 0; i<=tab.length-1;i++){
            System.out.println("note "+i+" : "+tab[i]);
        }
    }
    public static double moyenne(double [] tab){
        double moyenne=0;
        for(int i = 0; i<=tab.length-1;i++){
            moyenne+=tab[i];
        }
        return moyenne / tab.length;
    }
}
