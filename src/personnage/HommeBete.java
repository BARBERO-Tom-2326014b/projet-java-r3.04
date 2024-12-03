package personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un Homme-Bête, une sous-classe de CreatureBestiale.
 * L'Homme-Bête possède un comportement unique et peut interagir avec ses alliés.
 */
public class HommeBete extends CreatureBestiale {

    /**
     * Constructeur pour initialiser un Homme-Bête avec ses caractéristiques de base.
     * 
     * @param nomComplet Le nom complet de l'Homme-Bête.
     * @param sexe Le sexe de l'Homme-Bête.
     * @param poids Le poids de l'Homme-Bête.
     * @param taille La taille de l'Homme-Bête.
     * @param age L'âge de l'Homme-Bête.
     */
    public HommeBete(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Fournit la liste des alliés de l'Homme-Bête.
     * 
     * Cette méthode est actuellement implémentée pour retourner une liste vide,
     * mais peut être étendue pour inclure des alliés spécifiques.
     * 
     * @return Une liste des créatures alliées proches. Actuellement vide.
     */
    @Override
    protected List<Creature> getAllies() {
        return new ArrayList<>();
    }
}
