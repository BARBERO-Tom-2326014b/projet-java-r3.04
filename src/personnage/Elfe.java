package personnage;

import java.util.List;
import java.util.Random;

/**
 * Classe représentant un Elfe, une sous-classe de Creature avec des comportements spécifiques.
 * Lorsqu'un Elfe meurt, il démoralise ses alliés.
 */
public class Elfe extends Creature {

    /**
     * Constructeur pour initialiser un Elfe avec ses caractéristiques de base.
     * 
     * @param nomComplet Le nom complet de l'Elfe.
     * @param sexe Le sexe de l'Elfe.
     * @param poids Le poids de l'Elfe.
     * @param taille La taille de l'Elfe.
     * @param age L'âge de l'Elfe.
     */
    public Elfe(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Vérifie si l'Elfe est mort. Si c'est le cas, ses alliés subissent une démoralisation.
     * 
     * @return {@code true} si l'Elfe est mort, sinon {@code false}.
     */
    @Override
    public boolean estMort() {
        if (super.estMort()) {
            demoraliserAllies();
            return true;
        }
        return false;
    }

    /**
     * Démoralise les alliés de l'Elfe en cas de trépas.
     * 
     * Affiche un message et réduit potentiellement le moral des créatures proches.
     * Cette méthode pourrait être enrichie pour inclure une logique précise de démoralisation.
     */
    private void demoraliserAllies() {
        System.out.println(getNomComplet() + " démoralise ses alliés en trépassant.");
        // Logique future : Réduction du moral des alliés à implémenter
    }
}
