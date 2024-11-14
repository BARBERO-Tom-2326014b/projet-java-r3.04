package personnage;

public class Vampire extends MortVivant {
    public Vampire(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    @Override
    public boolean estMort() {
        if (super.estMort()) {
            // Le vampire peut démoraliser ses alliés en trépassant
            demoraliserAllies();
            return true;
        }
        return false;
    }
    
    private void demoraliserAllies() {
        System.out.println(getNomComplet() + " démoralise ses alliés en trépassant.");
        // Logique pour réduire le moral des créatures alliées
    }
}
