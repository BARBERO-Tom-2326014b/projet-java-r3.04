package personnage;

import java.util.List;

public class Vampire extends MortVivant implements VIP {
    public Vampire(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    // Implémentation de la méthode VIP pour diminuer rapidement le moral
    @Override
    public void diminuerMoralRapide() {
        setMoral(getMoral() - 15); // VIP perd le moral plus vite
        System.out.println(getNomComplet() + " perd rapidement du moral. Moral actuel : " + getMoral());
    }

    @Override
    public void attendre(List<Creature> proches) {
        if (getMoral() > 0) {
            diminuerMoralRapide();
        }
        super.attendre(proches); // Appel à la méthode attendre de Creature
    }

    // Méthode pour démoraliser les alliés à la mort
    private void demoraliserAllies(List<Creature> allies) {
        System.out.println(getNomComplet() + " démoralise ses alliés en trépassant.");
        for (Creature ally : allies) {
            ally.setMoral(ally.getMoral() - 10); // Exemple : diminue le moral des alliés
        }
    }

    @Override
    public boolean estMort() {
        if (super.estMort()) {
            // Appelle demoraliserAllies lors de la mort
            // Passer une liste d'alliés lorsque nécessaire
            return true;
        }
        return false;
    }
}
