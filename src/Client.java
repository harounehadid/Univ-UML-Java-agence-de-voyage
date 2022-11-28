import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private String nom;
    private String id;
    private ArrayList<Reservation> reservations;

    public Client(String nom, String id) {
        this.nom = nom;
        this.id = id;
        reservations = new ArrayList<Reservation>();
    }

    public void reserver(Voyage v, int nbPassager) {
        if (v.isOuvert()) {
            LocalDate dateReservation = LocalDate.now();
            
            for (int i = 0; i < nbPassager; i++) {
                Reservation newReservation = new Reservation(dateReservation, true);
                this.ajouterReservation(newReservation);
            }
        }
    }

    public boolean ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
        return true;
    }

    String getId() {
        return this.id;
    }

    String getNom() {
        return this.nom;
    }

    void setNom(String value) {
        this.nom = value;
    }

    ArrayList getReservations() {
        return this.reservations;
    }
}
