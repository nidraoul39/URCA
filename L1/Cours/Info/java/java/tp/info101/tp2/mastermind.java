import java.util.Scanner;

class mastermind{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int score = 0;
        int n1= (int)(10 * Math.random());
        int n2;
        int n3;
        int n4;
        
        do
            n2 = (int)(10 * Math.random());
        while(n2==n1);
        do
            n3 = (int)(10 * Math.random());
        while(n3 == n2 || n3==n1);        
        do
            n4 = (int)(10 * Math.random());
        while(n4 == n2 || n4==n1 || n4 == n3);

        int nu1,nu2,nu3,nu4;

        do{
            System.out.print("donnez n1 : ");
            nu1 = input.nextInt();
            System.out.print("donnez n2 : ");
            nu2 = input.nextInt();
            System.out.print("donnez n3 : ");
            nu3 = input.nextInt();
            System.out.print("donnez n4 : ");
            nu4 = input.nextInt();

            if(n1==nu1)
                System.out.println("le nombre 1 est bon !");
            else if(n2 == nu1 || nu1 == n3 || nu1 == n4)
                System.out.println("le nombre 1 est mal placé !");
            else
                System.out.println("le nombre 1 est faux !");

            if(nu2==n2)
                System.out.println("le nombre 2 est bon !");
            else if (nu2  == n1 || nu2 == n3 || nu2 == n4)
                System.out.println("le nombre 2 est mal placé !");
            else
                System.out.println("le nombre 2 est faux !");
            if(nu3==n3)
                System.out.println("le nombre 3 est bon !");
            else if (nu3  == n1 || nu3 == n2 || nu3 == n4)
                System.out.println("le nombre 3 est mal placé !");
            else
                System.out.println("le nombre 3 est faux !");
            if(nu4==n4)
                System.out.println("le nombre 4 est bon !");
            else if (nu4  == n1 || nu4 == n3 || nu4 == n2)
                System.out.println("le nombre 4 est mal placé !");
            else
                System.out.println("le nombre 4 est faux !");
            score+=1;
            

        }while((nu1 != n1) || (nu2 != n2) || (nu3 != n3) || (nu4 != n4));
        System.out.println("Bravo vous avez gagnez !!! ");
        System.out.println("vous avez réussi en "+score+" coups");

    }
}