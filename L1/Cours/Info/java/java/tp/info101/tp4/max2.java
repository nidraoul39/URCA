import java.util.Scanner;
class max2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n;
        double nr;
        double t;
        double max;
        max = Double.NEGATIVE_INFINITY;
        System.out.print("entrer n : ");
        n = input.nextInt();
        for(int i = 0; i<n;i++){
            System.out.print("entrez un nb : ");
            nr = input.nextDouble();
            max = maxi(nr,max);
        }

        System.out.println("le max est : "+max);
        
        
    }
    public static double maxi(double a, double b){
        double max;
        if (a>b)
            max = a;
        else
            max = b;
        return max;
    }
    
}
