import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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

    
    public void changerEtatDeReservation(boolean etat) {
        if (this.reservations.size() == 0) return;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("\n");

        for (int i = 0; i < this.reservations.size(); i++) {
            System.out.println("Reservation number " + i+1);
            this.reservations.get(i).afficherReservationInfo();
        }

        System.out.println("Please choose which reservation to update:  ");
        int indice = keyboard.nextInt();
        keyboard.nextLine();

        if (indice >= 0 && indice < this.reservations.size()) {
            this.reservations.get(indice).setEtat(etat);
        }
    }

    public void afficherLesReservation() {
        if (this.reservations.size() == 0) {
            System.out.println("\nThere is no reservation to show");
            return;
        }

        for (Reservation reservation : reservations) reservation.afficherReservationInfo();
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
