import java.util.Scanner;
import java.lang.Math;

class ggmaps{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        String villes[] = { "Reims", "Paris", "Strasbourg"};
        int distances[][] = { {0, 144, 348}, {144, 0, 488}, {348, 488, 0}};
        AfficherVille(villes);
        AfficherVille(distances);
        int[] parcours = saisirParcours(distances, villes);
        afficherparcours(parcours, villes);
        System.out.println("\nDistance totale: " + distanceParcours(parcours, distances) + " km");
    }
    public static String[] SaisirVille(){
        int n;
        System.out.print("Combien de ville allez vous entrer : ");
        n = input.nextInt();
        input.nextLine();
        String[] ville = new String[n];
        for(int i = 0; i<n; i++){
            System.out.print("Entrez Ville numéro "+i+" : ");
            ville[i] = input.nextLine();
            input.nextLine();
        }

        return ville;
    }
    public static void AfficherVille(String[] ville){
        for(int i = 0; i<ville.length; i++){
            System.out.print(ville[i]+" / ");
        }
        System.out.println();
    }
    public static int[][] SaisirDistance(String[] ville){
        int[][] distance = new int[ville.length][ville.length];
        int a;
        for(int i = 0;i<ville.length;i++){
            for(int k = 0; k<ville.length;k++){
                do{
                    System.out.print("entrez la distance entre "+ville[i]+" et "+ville[k]+" 0 si aucun chemin entre eux : ");
                    a = input.nextInt();
                }while(a<0);
                distance[i][k]=a;
            }
        }
        return distance;
    }
    public static void AfficherVille(int[][] distance){
        for(int i = 0;i<distance.length;i++){
            System.out.print("{ ");
            for(int k = 0; k<distance[i].length;k++){
                System.out.print(distance[i][k]+", ");
            }
            System.out.print("}");
            System.out.println();
        }
    }
    public static int[] saisirParcours(int[][] distance, String[] ville){
        int n;
            
        AfficherVille(ville);
        for(int i = 0; i<ville.length;i++){
            System.out.print(i);
        }
        System.out.println();
        
        do{
            System.out.print("combien de ville vas tu parcourir : ");
            n = input.nextInt();
        }while(n<0);
        int[] parcours = new int[n];

        do{
            System.out.print("entrer numéro de la ville de départ : ");
            parcours[0] = input.nextInt();
        }while(parcours[0]>=ville.length || parcours[0]<0);

        int prodest;

        for(int i = 1; i<ville.length; i++){
            do{
                System.out.print("entrer numéro de la prochaine destination (impossible si les 2 villes sont pas lié) : ");
                prodest = input.nextInt();
            }while(distance[prodest-1][prodest]==0);
            parcours[i] = prodest;
        }

        return parcours;

    }
    public static void afficherparcours(int[] parcours,String[] ville){
        for(int i = 0; i<parcours.length;i++){
            System.out.print(ville[parcours[i]]+" ");
        }
    }
    public static int distanceParcours(int[] parcours, int[][] distance){
        int totalDistance = 0;
        for(int i = 0; i < parcours.length - 1; i++){
            totalDistance += distance[parcours[i]][parcours[i+1]];
        }
        return totalDistance;
    }
}