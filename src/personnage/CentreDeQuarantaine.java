package personnage;

public class CentreDeQuarantaine extends ServiceMedical {
	private boolean isolation;

    public CentreDeQuarantaine(String nom, double superficie, int capaciteMax, double budget, boolean isolation) {
        super(nom, superficie, capaciteMax, budget);
        this.isolation = isolation;
    }

    public boolean isIsolation() {
        return isolation;
    }

    public void setIsolation(boolean isolation) {
        this.isolation = isolation;
    }

    @Override
    public void reviserBudget() {
        System.out.println("Révision du budget pour le centre de quarantaine, en prenant en compte l'isolation.");
    }
}
