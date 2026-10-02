import java.util.Scanner;
class puissance {
    public static void main(String[] args){
        int a;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("enter a : ");
        a = input.nextInt();
        System.out.print("enter n puissance : ");
        n = input.nextInt();
        System.out.println( a +" puissance "+n+" = " + puis(a,n));

    }
    public static int puis(int a,int n){
        int puissance = 1;
        for(int i=0; i<n; i++){
            puissance *=a;
        }
        return puissance;
    }
}
