public class Arret {
    private float h_arrivee;
    private float h_depart;
    private String nom;

    public Arret(String nom, float h_arrivee, float h_depart) {
        this.nom = nom;
        this.h_arrivee = h_arrivee;
        this.h_depart = h_depart;
    }

    float getH_depart() {
        return this.h_depart;
    }

    float getH_arrivee() {
        return this.h_arrivee;
    }

    String getNom() {
        return this.nom;
    }
}
