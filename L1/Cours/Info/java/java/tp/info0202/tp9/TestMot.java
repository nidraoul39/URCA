
public class TestMot {
    public static void main(String[] args){
        ListeMot m = new ListeMot("dicoPendu.txt");
        try{
            m.ajouterMot("bonjour");
            m.afficherFile();
            System.out.println(m.getHasard());


        }
        catch(Exception e){
            System.out.println("erreur");
        }
    }
}
