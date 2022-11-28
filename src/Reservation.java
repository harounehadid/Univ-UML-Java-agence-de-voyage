import java.time.LocalDate;
import java.util.Scanner;

public class Reservation {
    private LocalDate d_reservation;
    private boolean etat;
    private Passager passager;

    public Reservation(LocalDate d_reservation, boolean etat) {
        this.d_reservation = d_reservation;
        this.etat = etat;

        System.out.print("\nEnter the name of the passenger:  ");
        Scanner keyboard = new Scanner(System.in);

        String nom = keyboard.nextLine();
        Passager nauvPassager = new Passager(nom);

        this.setPassager(nauvPassager);
    }

    LocalDate getD_reservation() {
        return this.d_reservation;
    }

    boolean isEtat() {
        return this.etat;
    }

    void setEtat(boolean value) {
        this.etat = value;
    }

    Passager getPassager() {
        return this.passager;
    }

    void setPassager(Passager value) {
        this.passager = value;
    }
}
