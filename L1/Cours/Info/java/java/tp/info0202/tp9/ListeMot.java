import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class ListeMot {

    private String path;

    public ListeMot(String path){
        this.path = path;
    }

    public void ajouterMot(String mot) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(this.path, true))) {
            w.write(mot.toUpperCase());
            w.newLine();
            w.close();
        }
    }
    public int compterLignes() throws IOException {
        int count = 0;
        BufferedReader r = new BufferedReader(new FileReader(this.path));
        while (r.readLine() != null) {
            count++;
        }
        return count;
    }
    public void afficherFile() throws IOException{
        BufferedReader r = new BufferedReader(new FileReader(this.path));
        String ligne= r.readLine();
        while(ligne != null){
        System.out.println(ligne);
        ligne = r.readLine();
        }
        r.close();
    }

    public String getHasard() throws IOException{
        BufferedReader r = new BufferedReader(new FileReader(this.path));
        String ligne = r.readLine();
        int n = compterLignes();
        int random = (int)(Math.random()*n);
        for(int i =0;i<random;i++){
            ligne = r.readLine();
        }
        r.close();
        return ligne;



    }
}
