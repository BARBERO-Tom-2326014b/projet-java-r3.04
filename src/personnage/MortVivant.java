package personnage;

import java.util.ArrayList;
import java.util.List;

public abstract class MortVivant extends Creature {
    public MortVivant(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    // Méthode de régénération pour les morts-vivants
    protected void regenerer() {
        setMoral(100);
        getMaladies().clear();
        System.out.println(getNomComplet() + " se régénère et revient à la vie !");
    }

    @Override
    public boolean estMort() {
        if (super.estMort()) {
            regenerer();
            return true;
        }
        return false;
    }
}