package personnage;

/**
 * Classe représentant un service médical standard.
 * Hérite des fonctionnalités de la classe abstraite {@link ServiceMedical}.
 */
public class ServiceMedicalStandard extends ServiceMedical {

    /**
     * Constructeur de la classe ServiceMedicalStandard.
     *
     * @param nom         Le nom du service médical standard.
     * @param superficie  La superficie du service en m².
     * @param capaciteMax La capacité maximale du service.
     * @param budget      Le budget initial du service.
     */
    public ServiceMedicalStandard(String nom, double superficie, int capaciteMax, double budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    /**
     * Méthode pour réviser le budget du service médical standard.
     * Implémentation spécifique pour ce type de service.
     */
    @Override
    public void reviserBudget() {
        System.out.println("Révision du budget pour le service médical standard.");
    }
}
