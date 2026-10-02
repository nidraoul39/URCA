import java.util.Scanner;
import java.lang.Math;

class image{
    public static void main(String[] args){
        boolean[][] image = {
            { false, false, false, false, false, false, false, false, false, false, false, false },
            { false, false, false, false, true, true, true, true, false, false, false, false },
            { false, false, false, true, false, false, false, false, true, false, false, false },
            { false, false, true, false, true, false, false, true, false, true, false, false },
            { false, false, true, false, false, false, false, false, false, true, false, false },
            { false, false, true, false, true, false, false, true, false, true, false, false },
            { false, false, true, false, false, true, true, false, false, true, false, false },
            { false, false, false, true, false, false, false, false, true, false, false, false },
            { false, false, false, false, true, true, true, true, false, false, false, false },
            { false, false, false, false, false, false, false, false, false, false, false, false }
        };

        Afficherimage(image);
        inverser(image,taillecadre(image));
        Afficherimage(image);

    }
    public static void effacerImage(boolean[][] image){
        for(int i=0;i<image.length;i++){
            for(int k=0; k<image[i].length;k++){
                image[i][k]=false;
            }
        }
    }

    public static boolean[][] creeImage(int largeur,int hauteur){
        boolean[][] image = new boolean[largeur][hauteur];
        effacerImage(image);
        return image;
    }

    public static void Afficherimage(boolean[][] image){
        for(int i = 0; i<image.length;i++){
            for(int k = 0; k<image[i].length;k++){
                if(image[i][k])
                    System.out.print("X");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void setpixel(boolean[][] image, int x, int y){
        if(image.length>=y){
            if(image[y].length>=x){
                image[y][x] = true;
            }
        }
    }
    public static void setLigne(boolean[][] image, int y){
        if(image.length>=y){
            for(int i = 0;i<image[y].length;i++){
                setpixel(image,i,y);
            }
        }
    }

    public static int firstligne(boolean[][] image){
        int i = 0;
        int k = 0;
        boolean found = false;
        while(i<image.length && !found){
            while(k<image[i].length && !found){
                if(image[i][k])
                    found=true;
                else
                    k++;
            }
            if(!found){
                i++;
                k=0;
            }
        }
        if(!found){
            i=0;
        }
        return i;
    }

    public static int firstcolonne(boolean[][] image){
        int i = 0;
        int k = 0;
        boolean found = false;
        while(i<image[0].length && !found){
            while(k<image.length && !found){
                if(image[k][i])
                    found=true;
                else
                    k++;
            }
            if(!found){
                i++;
                k=0;
            }

        }
        if(!found){
            i=0;
        }
        return i;
    }

    public static int lastligne(boolean[][] image){
        int i = image.length - 1;
        int k = 0;
        boolean found = false;
        while(i>=0 && !found){
            while(k<image[i].length && !found){
                if(image[i][k])
                    found=true;
                else
                    k++;
            }
            if(!found){
                i--;
                k=0;
            }

        }
        if(!found){
            i=image.length;
        }
        return i;
    }

    public static int lastcolonne(boolean[][] image){
        int i = image[0].length - 1;
        int k = 0;
        boolean found = false;
        while(i>=0 && !found){
            while(k<image.length && !found){
                if(image[k][i])
                    found=true;
                else
                    k++;
            }
            if(!found){
                i--;
                k=0;
            }

        }
        if(!found){
            i=image[0].length;
        }
        return i;
    }
    public static int[][] taillecadre(boolean[][] image){
        int[][] cadre = new int[2][2];
        cadre[0][0] = firstligne(image);
        cadre[0][1] = firstcolonne(image);
        cadre[1][0] = lastligne(image);
        cadre[1][1] = lastcolonne(image);
        return cadre;
    }
    public static void inverser(boolean[][] image, int[][] cadre){
        for(int i = cadre[0][0];i<=cadre[1][0];i++){
            for(int k = cadre[0][1];k<=cadre[1][1];k++){
                image[i][k] = !image[i][k];
            }
        }
        
    }

}