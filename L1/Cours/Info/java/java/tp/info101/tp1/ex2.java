import java.util.Scanner;

class ex2{
    static public void main(String[] args){
        Scanner input = new Scanner(System.in);
        String prenom,nom;
        int anne;

        System.out.print("quelle est votre prenom : ");
        prenom = input.nextLine();
        System.out.print("quelle est votre nom : ");
        nom = input.nextLine();
        System.out.print("quelle est votre année de naissance : ");
        anne = input.nextInt();

        System.out.println("Bonjour "+prenom+" "+nom+" vous avez "+(2025-anne)+" ans bonne journée");
    }
}