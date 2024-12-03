package personnage;

import java.util.List;

public abstract class CreatureTriage extends Creature {

    /**
     * Constructeur de base pour initialiser une créature de type triage avec ses caractéristiques.
     * 
     * @param nomComplet Le nom complet de la créature.
     * @param sexe Le sexe de la créature.
     * @param poids Le poids de la créature.
     * @param taille La taille de la créature.
     * @param age L'âge de la créature.
     */
    public CreatureTriage(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    /**
     * Vérifie si la créature peut attendre patiemment en fonction de la présence d'autres créatures de la même classe.
     * 
     * @param proches La liste des créatures proches.
     * @return {@code true} si au moins une créature proche est de la même classe que cette créature, sinon {@code false}.
     */
    protected boolean peutAttendrePatiemment(List<Creature> proches) {
        return proches.stream().anyMatch(creature -> creature.getClass() == this.getClass());
    }

    /**
     * Vérifie si la créature est considérée comme VIP.
     * 
     * @return {@code true} si la créature est VIP, sinon {@code false}.
     * Par défaut, les créatures de triage ne sont pas VIP.
     */
    protected boolean estVIP() {
        return false;
    }
}
