import java.time.LocalDate;
import java.util.ArrayList;

public class Agence {
    private String nom;
    private String telephone;
    private ArrayList<Client> clients;
    private ArrayList<Voyage> voyages;

    public Agence(String nom, String telephone) {
        this.nom = nom;
        this.telephone = telephone;

        clients = new ArrayList<Client>();
        voyages = new ArrayList<Voyage>();
    }

    public void ajouterVoyage(String vile_d, 
                              String vile_a, 
                              LocalDate d_depart, 
                              LocalDate d_arrivee, 
                              float h_depart, 
                              float h_arrivee, 
                              boolean etat) {
        
        Voyage nauVoyage = new Voyage(vile_d, vile_a, d_depart, d_arrivee, h_depart, h_arrivee, etat);
        voyages.add(nauVoyage);
    }

    public void identifier(String nom, String id) {
        boolean exists = false;

        for (int i = 0; i < clients.size(); i++) {
            Client curClient = clients.get(i);

            if (curClient.getNom() == nom && curClient.getId() == id) {
                exists = true;
                break;
            }
        }
    }

    public void ajouterClient(String nom, String id) {
        boolean newClient = true;

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                newClient = false;
                break;
            }
        }

        if (newClient) clients.add(new Client(nom, id));
    }

    String getNom() {
        return this.nom;
    }

    String getTelephone() {
        return this.telephone;
    }

    ArrayList getClients() {
        return this.clients;
    }
}
