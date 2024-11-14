package personnage;

class Crypte extends ServiceMedical {
    private int niveauVentilation;
    private double temperature;

    public Crypte(String nom, double superficie, int capaciteMax, String budget, int niveauVentilation, double temperature) {
        super(nom, superficie, capaciteMax, budget);
        this.niveauVentilation = niveauVentilation;
        this.temperature = temperature;
    }

    public int getNiveauVentilation() {
        return niveauVentilation;
    }

    public void setNiveauVentilation(int niveauVentilation) {
        this.niveauVentilation = niveauVentilation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void reviserBudget() {
        System.out.println("Révision du budget pour la crypte, en vérifiant la ventilation et la température.");
    }
}