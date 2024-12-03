package personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Orque représente une créature bestiale de type orque. 
 * Elle hérite des caractéristiques générales des créatures bestiales.
 */
public class Orque extends CreatureBestiale {

    /**
     * Constructeur de la classe Orque.
     *
     * @param nomComplet Le nom complet de l'orque.
     * @param sexe       Le sexe de l'orque.
     * @param poids      Le poids de l'orque.
     * @param taille     La taille de l'orque.
     * @param age        L'âge de l'orque.
     */
    public Orque(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Retourne la liste des alliés proches de l'orque. 
     * L'implémentation actuelle retourne une liste vide, mais peut être étendue selon le contexte du jeu.
     *
     * @return Une liste d'objets {@code Creature} représentant les alliés de l'orque.
     */
    @Override
    protected List<Creature> getAllies() {
        // Retourne la liste des alliés proches de cette créature
        // (implémentation dépendante du contexte du jeu)
        return new ArrayList<>();
    }
}
