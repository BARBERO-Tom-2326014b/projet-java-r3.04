package personnage;

import java.util.ArrayList;
import java.util.List;

public class Orque extends CreatureBestiale {
    public Orque(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    @Override
    protected List<Creature> getAllies() {
        // Retourne la liste des alliés proches de cette créature
        // (implémentation dépendante du contexte du jeu)
        return new ArrayList<>();
    }
}