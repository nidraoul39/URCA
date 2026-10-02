import java.util.Scanner;
class fact {
    public static void main(String[] args){
        int a;
        Scanner input = new Scanner(System.in);
        System.out.print("enter n factoriel : ");
        a = input.nextInt();
        System.out.println("factoriel "+ a +" = "+ facto(a));

    }
    public static int facto(int a){
        int factoriel = 1;
        for(int i=1; i<a; i++){
            factoriel *=i;
        }
        return factoriel;
    }
}
