package personnage;

import java.util.List;

public abstract class CreatureTriage extends Creature {
    public CreatureTriage(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    @Override
    protected boolean peutAttendrePatiemment(List<Creature> proches) {
        return proches.stream().anyMatch(creature -> creature.getClass() == this.getClass());
    }

    @Override
    protected boolean estVIP() {
        return false; // Les créatures du triage ne sont pas VIP
    }
}