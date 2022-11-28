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

        if (exists) System.out.println("\nWelcome back " + nom + "!");
        else this.ajouterClient(nom, id);
    }

    public void ajouterClient(String nom, String id) {
        boolean newClient = true;

        for (Client client : clients) {
            if (client.getId().compareTo(id) == 0) {
                newClient = false;
                break;
            }
        }

        if (newClient) {
            clients.add(new Client(nom, id));
            System.out.println("\nClient added successfully");
        }
    }

    public void afficherLesVoyages() {
        if (this.voyages.size() == 0) {
            System.out.println("\nNo trips available at the moment");
            return;
        }
        
        for (Voyage voyage : voyages) voyage.afficherVoyageInfo();
    }

    public void afficherLesVoyagesAvecIndice() {
        if (this.voyages.size() == 0) {
            System.out.println("\nNo trips available at the moment");
            return;
        }

        for (int i = 0; i < this.voyages.size(); i++) {
            System.out.println("\nVoyage number " + i);
            this.voyages.get(i).afficherVoyageInfo();
        }
    }

    public Voyage getVoyageObjet(int indice) {
        if (this.voyages.size() == 0) return null;

        return this.voyages.get(indice);
    }

    public void afficherToutLesReservation() {
        if (this.clients.size() == 0) {
            System.out.println("\nThere is no reservations to display");
            return;
        }

        for (Client client : clients) {
            client.afficherLesReservation();
        }
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

    Client getClient(String id) {
        Client selectedClient = null;

        for (Client client : clients) {
            if (client.getId().compareTo(id) == 0) {
                selectedClient = client;
                break;
            }
        }

        return selectedClient;
    }

    ArrayList getVoyages() {
        return this.voyages;
    }
}
