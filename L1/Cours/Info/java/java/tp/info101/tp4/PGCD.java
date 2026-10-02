import java.util.Scanner;
class pgcd {
    public static void main(String[] args){
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("enter a poistif sup a b : ");
            a = input.nextInt();
            System.out.print("enter b positif inf a a : ");
            b = input.nextInt();
        }while(estvalide(a,b));
        System.out.println("pgcd de a et b = "+pgcd(a,b));


    }
    public static int pgcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a; 
    }
    public static boolean estvalide(int a,int b){
        return a<b && a>0 && b>0;
    }
    
}
