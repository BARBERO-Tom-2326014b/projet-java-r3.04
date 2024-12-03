package personnage;

import java.util.List;

/**
 * Classe représentant un Vampire, un type spécifique de {@link MortVivant}.
 * Les vampires possèdent des comportements particuliers, tels qu'une diminution rapide du moral
 * et un effet de démoralisation sur leurs alliés à leur mort.
 */
public class Vampire extends MortVivant implements VIP {

    /**
     * Constructeur de la classe Vampire.
     *
     * @param nomComplet Le nom complet du vampire.
     * @param sexe       Le sexe du vampire.
     * @param poids      Le poids du vampire en kilogrammes.
     * @param taille     La taille du vampire en mètres.
     * @param age        L'âge du vampire en années.
     */
    public Vampire(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Implémentation spécifique de la méthode VIP permettant de diminuer rapidement le moral.
     * Les vampires subissent une perte accélérée de moral.
     */
    @Override
    public boolean estVip() {

    
        System.out.println(getNomComplet() + " perd rapidement du moral. Moral actuel : " + getMoral());
        return true;
    }

    /**
     * Méthode appelée pour démoraliser les alliés du vampire lorsqu'il meurt.
     *
     * @param allies La liste des créatures alliées proches du vampire.
     *               Leur moral est diminué en conséquence.
     */
    private void demoraliserAllies(List<Creature> allies) {
        System.out.println(getNomComplet() + " démoralise ses alliés en trépassant.");
        for (Creature ally : allies) {
            ally.setMoral(ally.getMoral() - 10); // Exemple : diminue le moral des alliés
        }
    }
}
