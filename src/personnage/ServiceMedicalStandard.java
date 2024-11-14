package personnage;

public class ServiceMedicalStandard extends ServiceMedical{
	public ServiceMedicalStandard(String nom, double superficie, int capaciteMax, double budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    @Override
    public void reviserBudget() {
        System.out.println("Révision du budget pour le service médical standard.");
    }
}
