package personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe {@code Lycanthrope} représente un lycanthrope, une créature bestiale possédant des caractéristiques
 * physiques et comportementales propres à une transformation en une créature mi-homme, mi-loup.
 * Cette classe hérite de {@code CreatureBestiale}.
 */
public class Lycanthrope extends CreatureBestiale {

    /**
     * Constructeur de la classe {@code Lycanthrope}.
     * 
     * @param nomComplet Le nom complet du lycanthrope.
     * @param sexe Le sexe du lycanthrope.
     * @param poids Le poids du lycanthrope en kilogrammes.
     * @param taille La taille du lycanthrope en mètres.
     * @param age L'âge du lycanthrope en années.
     */
    public Lycanthrope(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Retourne la liste des alliés proches de cette créature.
     * 
     * @return Une liste vide, car le lycanthrope n'a pas d'alliés définis par défaut.
     */
    @Override
    protected List<Creature> getAllies() {
        return new ArrayList<>();
    }
}
