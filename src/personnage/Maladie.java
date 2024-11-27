package personnage;

public class Maladie {
    private String nomComplet;
    private String nomAbrege;
    private int niveauActuel;
    private int niveauMax;

    
    public Maladie(String nomComplet, String nomAbrege, int niveauMax) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
        this.niveauMax = niveauMax;
        this.niveauActuel = 1; // Niveau initial de la maladie
    }

    // Getters et Setters
    public String getNomComplet() {
        return nomComplet;
    }

    public String getNomAbrege() {
        return nomAbrege;
    }

    public int getNiveauActuel() {
        return niveauActuel;
    }

    public void setNiveauActuel(int niveau) {
        this.niveauActuel = niveau;
    }

    public int getNiveauMax() {
        return niveauMax;
    }

    // Méthode pour augmenter le niveau
    public void augmenterNiveau(int increment) {
        setNiveauActuel(niveauActuel + increment);
    }

    // Méthode pour diminuer le niveau
    public void diminuerNiveau(int decrement) {
        setNiveauActuel(niveauActuel - decrement);
    }

    // Vérifie si la maladie est létale
    public boolean estLetale() {
    	return this.niveauActuel >= this.niveauMax;
    }

    @Override
    public String toString() {
        return nomComplet + " (" + nomAbrege + ") - Niveau: " + niveauActuel + "/" + niveauMax;
    }
    // Fabrique de maladies prédéfinies
    public static Maladie creerMaladie(String type) {
        switch (type) {
            case "MDC":
                return new Maladie("Maladie Débilitante Chronique", "MDC", 10);
            case "FOMO":
                return new Maladie("Syndrome Fear of Missing Out", "FOMO", 5);
            case "DRS":
                return new Maladie("Dépendance aux Réseaux Sociaux", "DRS", 7);
            case "PEC":
                return new Maladie("Porphyrie érythropoïétique congénitale", "PEC", 3);
            case "ZPL":
                return new Maladie("Zoopathie paraphrénique lycanthropique", "ZPL", 8);
            case "NDMAD":
                return new Maladie("Narcolepsie délirante maléfique auto-destructrice", "NDMAD", 6);
            default:
                throw new IllegalArgumentException("Type de maladie inconnu : " + type);
        }
    }
}
