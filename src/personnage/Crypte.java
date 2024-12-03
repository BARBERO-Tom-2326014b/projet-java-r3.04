package personnage;

/**
 * Classe représentant une crypte, un type de service médical avec des caractéristiques spécifiques
 * telles que la ventilation et la température.
 */
class Crypte extends ServiceMedical {

    /** Niveau de ventilation de la crypte (exprimé en unités arbitraires). */
    private int niveauVentilation;

    /** Température de la crypte (exprimée en degrés Celsius). */
    private double temperature;

    /**
     * Constructeur pour initialiser une crypte avec ses attributs spécifiques.
     * 
     * @param nom Le nom de la crypte.
     * @param superficie La superficie totale de la crypte en mètres carrés.
     * @param capaciteMax La capacité maximale d'accueil de la crypte.
     * @param budget Le budget alloué à la crypte.
     * @param niveauVentilation Le niveau de ventilation de la crypte.
     * @param temperature La température de la crypte en degrés Celsius.
     */
    public Crypte(String nom, double superficie, int capaciteMax, double budget, int niveauVentilation, double temperature) {
        super(nom, superficie, capaciteMax, budget);
        this.niveauVentilation = niveauVentilation;
        this.temperature = temperature;
    }

    /**
     * Obtient le niveau de ventilation de la crypte.
     * 
     * @return Le niveau de ventilation actuel.
     */
    public int getNiveauVentilation() {
        return niveauVentilation;
    }

    /**
     * Modifie le niveau de ventilation de la crypte.
     * 
     * @param niveauVentilation Le nouveau niveau de ventilation à définir.
     */
    public void setNiveauVentilation(int niveauVentilation) {
        this.niveauVentilation = niveauVentilation;
    }

    /**
     * Obtient la température actuelle de la crypte.
     * 
     * @return La température actuelle en degrés Celsius.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Modifie la température de la crypte.
     * 
     * @param temperature La nouvelle température à définir en degrés Celsius.
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Révise le budget de la crypte en prenant en compte des facteurs spécifiques 
     * comme la ventilation et la température.
     */
    @Override
    public void reviserBudget() {
        System.out.println("Révision du budget pour la crypte, en vérifiant la ventilation et la température.");
    }
}
