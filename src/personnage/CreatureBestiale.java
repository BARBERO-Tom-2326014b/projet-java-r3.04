package personnage;

import java.util.List;
import java.util.Random;

public abstract class CreatureBestiale extends Creature {

    /**
     * Constructeur de base pour initialiser une créature bestiale avec ses caractéristiques.
     * 
     * @param nomComplet Le nom complet de la créature.
     * @param sexe Le sexe de la créature.
     * @param poids Le poids de la créature.
     * @param taille La taille de la créature.
     * @param age L'âge de la créature.
     */
    public CreatureBestiale(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Contamine un allié lors du trépas de la créature, en transmettant une maladie aléatoire.
     * 
     * @param allies Liste des alliés proches pouvant être contaminés.
     */
    protected void contaminerAllie(List<Creature> allies) {
        if (!getMaladies().isEmpty() && !allies.isEmpty()) {
            // Choisit une maladie aléatoire parmi celles de la créature.
            Maladie maladie = getMaladies().get(new Random().nextInt(getMaladies().size()));
            // Sélectionne un allié aléatoire pour transmettre la maladie.
            Creature allie = allies.get(new Random().nextInt(allies.size()));
            allie.tomberMalade(maladie);
            System.out.println(getNomComplet() + " transmet la maladie " + maladie + " à " + allie.getNomComplet() + " en trépassant.");
        }
    }

    /**
     * Vérifie si la créature est morte. Si c'est le cas, elle contamine un allié.
     * 
     * @return {@code true} si la créature est morte, sinon {@code false}.
     */
    @Override
    public boolean estMort() {
        if (super.estMort()) {
            // Contamine un allié en cas de trépas.
            contaminerAllie(getAllies());
            return true;
        }
        return false;
    }

    /**
     * Obtient la liste des alliés de la créature.
     * 
     * Cette méthode doit être implémentée par les sous-classes pour définir comment
     * récupérer les alliés spécifiques à chaque type de créature.
     * 
     * @return La liste des alliés de la créature.
     */
    protected abstract List<Creature> getAllies();
}
