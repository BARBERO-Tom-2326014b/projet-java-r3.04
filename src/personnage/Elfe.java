package personnage;

import java.util.List;
import java.util.Random;

public class Elfe extends Creature {
    public Elfe(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    @Override
    public boolean estMort() {
        if (super.estMort()) {
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
