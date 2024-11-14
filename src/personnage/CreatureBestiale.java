package personnage;

import java.util.List;
import java.util.Random;

public abstract class CreatureBestiale extends Creature {
    public CreatureBestiale(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    // Méthode de contamination, appelée lors du trépas
    protected void contaminerAllie(List<Creature> allies) {
        if (!getMaladies().isEmpty() && !allies.isEmpty()) {
            // Choisit une maladie aléatoire de la liste de maladies de la créature
            String maladie = getMaladies().get(new Random().nextInt(getMaladies().size()));
            // Sélectionne un allié aléatoire pour transmettre la maladie
            Creature allie = allies.get(new Random().nextInt(allies.size()));
            allie.tomberMalade(maladie);
            System.out.println(getNomComplet() + " transmet la maladie " + maladie + " à " + allie.getNomComplet() + " en trépassant.");
        }
    }

    @Override
    public boolean estMort() {
        if (super.estMort()) {
            // Appelle la méthode contaminerAllie avec la liste des alliés, par exemple
            contaminerAllie(getAllies());
            return true;
        }
        return false;
    }

    // La méthode getAllies() pourrait être définie pour obtenir les alliés de la créature.
    protected abstract List<Creature> getAllies();
}