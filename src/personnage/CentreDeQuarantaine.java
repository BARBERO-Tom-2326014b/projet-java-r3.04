package personnage;

public class CentreDeQuarantaine extends ServiceMedical {
    private boolean isolation;

    /**
     * Constructeur pour initialiser un centre de quarantaine avec les informations de base.
     * @param nom Le nom du centre de quarantaine.
     * @param superficie La superficie du centre de quarantaine en mètres carrés.
     * @param capaciteMax La capacité maximale d'accueil du centre de quarantaine.
     * @param budget Le budget alloué pour le centre de quarantaine.
     * @param isolation Indique si le centre est équipé pour l'isolation (true si oui, false sinon).
     */
    public CentreDeQuarantaine(String nom, double superficie, int capaciteMax, double budget, boolean isolation) {
        super(nom, superficie, capaciteMax, budget);
        this.isolation = isolation;
    }

    /**
     * Retourne l'état de l'isolation du centre de quarantaine.
     * @return true si le centre est en mesure d'assurer l'isolation, false sinon.
     */
    public boolean isIsolation() {
        return isolation;
    }

    /**
     * Définit l'état de l'isolation pour le centre de quarantaine.
     * @param isolation true si le centre doit être isolé, false sinon.
     */
    public void setIsolation(boolean isolation) {
        this.isolation = isolation;
    }

    /**
     * Méthode qui permet de réviser le budget du centre de quarantaine.
     * Cette révision prend en compte les coûts supplémentaires liés à l'isolation.
     */
    public void reviserBudget(double newBudget) {
        setBudget(newBudget);
    }
}
