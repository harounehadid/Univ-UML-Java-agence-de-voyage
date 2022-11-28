import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Voyage {
    private LocalDate d_depart;
    private LocalDate d_arrivee;
    private float h_depart;
    private float h_arrivee;
    private boolean etat;
    private Ville ville_d;
    private Ville ville_a;
    private ArrayList<Arret> arrets;
    // When all the seats are full we can turn this into false
    private boolean ouvert;

    public Voyage(String ville_d, 
                  String ville_a, 
                  LocalDate d_depart, 
                  LocalDate d_arrivee, 
                  float h_depart, 
                  float h_arrivee, 
                  boolean etat) {

        this.setVille_d(new Ville(ville_d));
        this.setVille_a(new Ville(ville_a));
        this.d_depart = d_depart;
        this.d_arrivee = d_arrivee;
        this.h_depart = h_depart;
        this.h_arrivee = h_arrivee;
        this.etat = etat;
        this.arrets = new ArrayList<Arret>();
        this.setOuvert(true);

        this.managerArrets();
    }

    private void managerArrets() {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("\nHow many stops you want to add:  ");
        int arretsNombre = keyboard.nextInt();
        keyboard.nextLine();

        String arretNom;
        float d_temp;
        float a_temp;

        for (int i = 0; i < arretsNombre; i++) {
            System.out.print("\nStop number " + i + " >>");
            System.out.print("\nEnter the name:  ");
            arretNom = keyboard.nextLine();
            System.out.println("Enter the time (please stick to this format h.m)");
            System.out.print("Arrival:  ");
            a_temp = keyboard.nextFloat();
            keyboard.nextLine();
            System.out.print("Departure:  ");
            d_temp = keyboard.nextFloat();
            keyboard.nextLine();

            this.ajouterArret(new Arret(arretNom, a_temp, d_temp));
        }
    }

    public void ajouterArret(Arret nouvArret) {
        boolean exists = false;

        for (int i = 0; i < arrets.size(); i++) {
            if (arrets.get(i).getNom() == nouvArret.getNom()) {
                exists = true;
                break;
            }
        }

        if (!exists) arrets.add(nouvArret);
        else System.out.println("\nA stop with the same name already exists!");
    }

    public void afficherVoyageInfo() {
        System.out.print("\n");
        System.out.print("From " + this.ville_d.getNom() + " ");
        System.out.print("to " + this.ville_a.getNom() + " ");
        System.out.print("\n");
        System.out.println("Departure in " + this.d_depart + " at " + this.h_depart);
        System.out.println("Arrival in " + this.d_arrivee + " at " + this.h_arrivee);
        System.out.print("State ");
        if (this.etat) System.out.print("active");
        else System.out.print("suspended");
        System.out.print("\nStops:  ");
        if (arrets.size() > 0) {
            for (Arret arret : arrets) System.out.print(arret.getNom() + "  ");
            System.out.print("\n");
        }
        else System.out.println("there is no stops");
        System.out.println("");
    }

    Ville getVille_d() {
        return this.ville_d;
    }

    void setVille_d(Ville value) {
        this.ville_d = value;
    }

    Ville getVille_a() {
        return this.ville_a;
    }

    void setVille_a(Ville value) {
        this.ville_a = value;
    }

    ArrayList<Arret> getArrets() {
        return this.arrets;
    }

    boolean isOuvert() {
        return this.ouvert;
    }

    void setOuvert(boolean value) {
        this.ouvert = value;
    }

    boolean isEtat() {
        return this.etat;
    }

    void setEtat(boolean etat) {
        this.etat = etat;
    }
}
