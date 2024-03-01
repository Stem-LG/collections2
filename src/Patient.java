import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient {

    private String nom;
    private Set<String> ordonnance;

    public Patient(String n) {
        nom = n;
        ordonnance = new HashSet<String>();
    }

    public String getNom() {
        return nom;
    }

    public boolean ordonnanceVide() {
        return ordonnance.size() == 0;
    }

    public void ajoutMedicament(String m) {
        ordonnance.add(m);
    }

    public void affiche() {
        System.out.println("nom: " + nom);
        System.out.println("ordoannance: ");
        for (String med : ordonnance) {
            System.out.println("- " + med);
        }
    }

    public boolean contientMedicament(String m) {
        return ordonnance.contains(m);
    }

    public void trieOrdonnace() {
        TreeSet<String> trie = new TreeSet<>(ordonnance);
        ordonnance = new HashSet<>(trie);
    }

}
