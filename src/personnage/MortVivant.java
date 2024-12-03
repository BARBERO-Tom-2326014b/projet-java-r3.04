package personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe abstraite MortVivant représente une créature de type mort-vivant. 
 * Ces créatures possèdent des caractéristiques uniques, telles que la régénération après la mort.
 */
public abstract class MortVivant extends Creature {

    /**
     * Constructeur de la classe MortVivant.
     *
     * @param nomComplet Le nom complet du mort-vivant.
     * @param sexe       Le sexe du mort-vivant.
     * @param poids      Le poids du mort-vivant.
     * @param taille     La taille du mort-vivant.
     * @param age        L'âge du mort-vivant.
     */
    public MortVivant(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Méthode de régénération pour les morts-vivants. 
     * Cette méthode réinitialise le moral à 100 et supprime toutes les maladies.
     */
    protected void regenerer() {
        setMoral(100);
        getMaladies().clear();
        System.out.println(getNomComplet() + " se régénère et revient à la vie !");
    }

    /**
     * Vérifie si le mort-vivant est mort. 
     * En cas de décès, la méthode déclenche la régénération.
     *
     * @return {@code true} si la créature est morte, {@code false} sinon.
     */
    @Override
    public boolean estMort() {
        if (super.estMort()) {
            regenerer();
            return true;
        }
        return false;
    }
}
