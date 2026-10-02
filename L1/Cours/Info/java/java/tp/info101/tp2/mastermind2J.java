import java.util.Scanner;

class mastermind2j{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
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

        int n5= (int)(10 * Math.random());
        int n6;
        int n7;
        int n8;
        
        do
            n6 = (int)(10 * Math.random());
        while(n6==n5);
        do
            n7 = (int)(10 * Math.random());
        while(n7 == n5 || n7==n6);        
        do
            n8 = (int)(10 * Math.random());
        while(n8 == n7 || n8==n6 || n8 == n5);


        int nu1,nu2,nu3,nu4;
        int nu21,nu22,nu23,nu24;

        do{
            System.out.print("donnez n1 joueur 1 : ");
            nu1 = input.nextInt();
            System.out.print("donnez n2 joueur 1 : ");
            nu2 = input.nextInt();
            System.out.print("donnez n3 joueur 1 : ");
            nu3 = input.nextInt();
            System.out.print("donnez n4 joueur 1 : ");
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

            System.out.print("donnez n1 joueur 2 : ");
            nu21 = input.nextInt();
            System.out.print("donnez n2 joueur 2 : ");
            nu22 = input.nextInt();
            System.out.print("donnez n3 joueur 2 : ");
            nu23 = input.nextInt();
            System.out.print("donnez n4 joueur 2 : ");
            nu24 = input.nextInt(); 
            
            if(nu21==n5)
                System.out.println("le nombre 1 est bon !");
            else if(nu21 == n6 || nu21 == n7 || nu21 == n8)
                System.out.println("le nombre 1 est mal placé !");
            else
                System.out.println("le nombre 1 est faux !");
            if(nu22==n6)
                System.out.println("le nombre 2 est bon !");
            else if (nu22  == n5 || nu22 == n7 || nu22 == n8)
                System.out.println("le nombre 2 est mal placé !");
            else
                System.out.println("le nombre 2 est faux !");
            if(nu23==n7)
                System.out.println("le nombre 3 est bon !");
            else if (nu23  == n5 || nu23 == n6 || nu23 == n8)
                System.out.println("le nombre 3 est mal placé !");
            else
                System.out.println("le nombre 3 est faux !");
            if(nu24==n8)
                System.out.println("le nombre 4 est bon !");
            else if (nu24  == n5 || nu24 == n6 || nu24 == n7)
                System.out.println("le nombre 4 est mal placé !");
            else
                System.out.println("le nombre 4 est faux !");            

        }while(((nu1 != n1) || (nu2 != n2) || (nu3 != n3) || (nu4 != n4)) && (((nu21 != n5) || (nu22 != n6) || (nu23 != n7) || (nu24 != n8))));
        
        
        if(((nu1 == n1) && (nu2 == n2) && (nu3 == n3) && (nu4 == n4))&& (((nu21 == n5) && (nu22 == n6) && (nu23 == n7) && (nu24 == n8))))
            System.out.println("égalité !!! ");
        else if(((nu1 == n1) && (nu2 == n2) && (nu3 == n3) && (nu4 == n4)))
            System.out.println("joueur 1 à gagné !!! ");
        else if(((nu21 == n5) && (nu22 == n6) && (nu23 == n7) && (nu24 == n8)))
            System.out.println("joueur 2 à gagné !!! ");
        else
            System.out.println("aucun n'a gagné...");


    }
}