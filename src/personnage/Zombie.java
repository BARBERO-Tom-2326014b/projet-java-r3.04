package personnage;

/**
 * Classe représentant un Zombie, une sous-classe de MortVivant.
 * Les zombies ont des caractéristiques et comportements spécifiques,
 * qui peuvent être personnalisés dans cette classe.
 */
public class Zombie extends MortVivant {

    /**
     * Constructeur pour créer une instance de Zombie.
     *
     * @param nomComplet le nom complet du zombie
     * @param sexe       le sexe du zombie
     * @param poids      le poids du zombie en kilogrammes
     * @param taille     la taille du zombie en mètres
     * @param age        l'âge du zombie en années
     */
    public Zombie(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Exemple d'un comportement spécifique à un zombie.
     * Ce comportement peut être personnalisé pour refléter les traits uniques des zombies.
     */
    public void grogner() {
        System.out.println(getNomComplet() + " émet un grognement sinistre !");
    }

    /**
     * Méthode pour attaquer une autre créature.
     * Un comportement typique des zombies pourrait être d'infecter ou de réduire le moral.
     *
     * @param cible la créature cible de l'attaque
     */
    public void attaquer(Creature cible) {
        System.out.println(getNomComplet() + " attaque " + cible.getNomComplet() + " !");
        cible.setMoral(cible.getMoral() - 20); // Réduction du moral en guise d'attaque
    }
}
