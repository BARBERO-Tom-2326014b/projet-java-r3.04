package personnage;

/**
 * Représente une maladie avec un niveau d'intensité variable.
 * Permet de gérer l'évolution du niveau de la maladie et de vérifier si elle est létale.
 */
public class Maladie {
    private String nomComplet;
    private String nomAbrege;
    private int niveauActuel;
    private int niveauMax;

    /**
     * Constructeur de la classe Maladie.
     *
     * @param nomComplet Le nom complet de la maladie.
     * @param nomAbrege  Le nom abrégé de la maladie.
     * @param niveauMax  Le niveau maximum de la maladie.
     */
    public Maladie(String nomComplet, String nomAbrege, int niveauMax) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
        this.niveauMax = niveauMax;
        this.niveauActuel = 0; // Niveau initial de la maladie
    }

    /**
     * Retourne le nom complet de la maladie.
     *
     * @return Le nom complet de la maladie.
     */
    public String getNomComplet() {
        return nomComplet;
    }

    /**
     * Retourne le nom abrégé de la maladie.
     *
     * @return Le nom abrégé de la maladie.
     */
    public String getNomAbrege() {
        return nomAbrege;
    }

    /**
     * Retourne le niveau actuel de la maladie.
     *
     * @return Le niveau actuel.
     */
    public int getNiveauActuel() {
        return niveauActuel;
    }

    /**
     * Définit le niveau actuel de la maladie en respectant les limites (0 à niveauMax).
     *
     * @param niveau Le nouveau niveau de la maladie.
     */
    public void setNiveauActuel(int niveau) {
        if (niveau < 0) {
            this.niveauActuel = 0; // Niveau minimal
        } else if (niveau > niveauMax) {
            this.niveauActuel = niveauMax; // Niveau maximal
        } else {
            this.niveauActuel = niveau;
        }
    }

    /**
     * Retourne le niveau maximum de la maladie.
     *
     * @return Le niveau maximum.
     */
    public int getNiveauMax() {
        return niveauMax;
    }

    /**
     * Augmente le niveau de la maladie.
     *
     * @param increment Valeur à ajouter au niveau actuel.
     */
    public void augmenterNiveau(int increment) {
        setNiveauActuel(niveauActuel + increment);
    }

    /**
     * Diminue le niveau de la maladie.
     *
     * @param decrement Valeur à soustraire du niveau actuel.
     */
    public void diminuerNiveau(int decrement) {
        setNiveauActuel(niveauActuel - decrement);
    }

    /**
     * Vérifie si la maladie est létale (le niveau actuel atteint ou dépasse le niveau maximum).
     *
     * @return True si la maladie est létale, sinon False.
     */
    public boolean estLetale() {
        return this.niveauActuel >= this.niveauMax;
    }

    /**
     * Retourne une représentation textuelle de la maladie.
     *
     * @return Une chaîne décrivant la maladie, son niveau actuel et son niveau maximum.
     */
    @Override
    public String toString() {
        return nomComplet + " (" + nomAbrege + ") - Niveau: " + niveauActuel + "/" + niveauMax;
    }

    /**
     * Crée une maladie prédéfinie basée sur un type donné.
     *
     * @param type Le type de maladie (par exemple, "MDC", "FOMO", etc.).
     * @return Une instance de Maladie correspondant au type.
     * @throws IllegalArgumentException Si le type est inconnu.
     */
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
