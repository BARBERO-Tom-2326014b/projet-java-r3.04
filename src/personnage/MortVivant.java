package personnage;


import java.util.List;

public abstract class MortVivant extends Creature {
    public MortVivant(String nomComplet, String sexe, double poids, double taille, int age) {
        super(nomComplet, sexe, poids, taille, age);
    }

    // Méthode de régénération, appelée lorsque la créature trépassera
    protected void regenerer() {
        // Logique de régénération (par exemple, restaurer le moral, retirer certaines maladies, etc.)
        setMoral(100); // On peut réinitialiser le moral à 100
        getMaladies().clear(); // Retire toutes les maladies
        System.out.println(getNomComplet() + " se régénère en trépassant et revient à la vie !");
    }

    @Override
    public boolean estMort() {
        if (super.estMort()) {
            regenerer(); // Appelle la méthode de régénération
            return true;
        }
        return false;
    }
}
