import java.util.Scanner;

class max{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a;
        int b;
        System.out.print("entrer a :");
        a = input.nextInt();
        System.out.print("entrer b :");
        b = input.nextInt();
        int max = maxi(a,b);
        System.out.println("max est : "+max);
    }
    public static int maxi(int a, int b){
        int max;
        if (a>b)
            max = a;
        else
            max = b;
        return max;
    }
}