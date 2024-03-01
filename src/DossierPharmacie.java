import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DossierPharmacie {
    private String nom;
    private HashMap<String, Patient> patients;

    public DossierPharmacie(String n) {
        nom = n;
        patients = new HashMap<String, Patient>();
    }

    void nouveauPatient(String nom, String[] ord) {

        Patient p = new Patient(nom);

        for (String o : ord) {

            p.ajoutMedicament(o);
        }

        patients.put(nom, p);
    }

    public boolean ajoutMedicament(String nom, String m) {
        Patient p = patients.get(nom);
        if (p == null) {
            return false;
        }
        p.ajoutMedicament(m);
        return true;
    }

    void affichePatient(String nom) {
        Patient p = patients.get(nom);
        if (nom == null) {
            System.out.println("patient n'existe pas");
            return;
        }

        p.affiche();
    }

    void affiche() {
        System.out.println("pharmacie: " + nom);
        for (String key : patients.keySet()) {
            System.out.println(patients.get(key));
        }
    }

    public Collection<String> affichePatientAvecMedicament(String m) {
        Collection<String> ps = new ArrayList<String>();

        for (String p : patients.keySet()) {
            if (patients.get(p).contientMedicament(m)) {
                ps.add(p);
            }
        }

        return ps;
    }

}