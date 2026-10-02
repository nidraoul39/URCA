import animalerie.*;

public class TestZoo {

    public static void main(String[] args) {

        // Création du zoo
        Zoo zoo = new Zoo(10);
        System.out.println(zoo);

        // Création d'animaux
        Chien chien = new Chien("Rex");
        Pigeon pigeon = new Pigeon("Titi");

        // Ajout des animaux
        try {
            zoo.ajouterAnimal(chien, 0);
            zoo.ajouterAnimal(pigeon, 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Test getAnimal
        try {
            System.out.println("Animal en cage 0 : " + zoo.getAnimal(0).getNom());
            System.out.println("Animal en cage 1 : " + zoo.getAnimal(1).getNom());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Faire crier les animaux
        System.out.println("Les animaux crient :");
        zoo.faireCrier();

        // Nombre de pattes et d'ailes
        System.out.println("Nombre total de pattes : " + zoo.getNbPatte());
        System.out.println("Nombre total d'ailes : " + zoo.getNbAile());

        // Désastre aléatoire
        for(int i = 0;i<100000;i++){
                zoo.desastre();
        }


        // Supprimer un animal
        try {
            zoo.supprimerAnimal(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Vérification finale
        System.out.println("Nombre total de pattes : " + zoo.getNbPatte());
        System.out.println("Nombre total d'ailes : " + zoo.getNbAile());
    }
}
