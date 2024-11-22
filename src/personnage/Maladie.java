package personnage;

public class Maladie {
    private String nomComplet;
    private String nomAbrege;
    private int niveauActuel;
    private int niveauMax;

    // Constructeur
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
        this.niveauActuel = niveauActuel +1;
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
        return niveauActuel >= niveauMax;
    }

    @Override
    public String toString() {
        return nomComplet + " (" + nomAbrege + ") - Niveau: " + niveauActuel + "/" + niveauMax;
    }
/*
    // Classes internes rendues statiques
    public static class MaladieDebilitanteChronique extends Maladie {
        public MaladieDebilitanteChronique() {
            super("Maladie Débilitante Chronique", "MDC", 10);
        }
    }

    public static class SyndromeFOMO extends Maladie {
        public SyndromeFOMO() {
            super("Syndrome Fear of Missing Out", "FOMO", 5);
        }
    }

    public static class DependenceAuxReseauxSociaux extends Maladie {
        public DependenceAuxReseauxSociaux() {
            super("Dépendance aux Réseaux Sociaux", "DRS", 7);
        }
    }

    public static class PorphyrieErythropoïetiqueCongenitale extends Maladie {
        public PorphyrieErythropoïetiqueCongenitale() {
            super("Porphyrie érythropoïétique congénitale", "PEC", 3);
        }
    }

    public static class ZoopathieParaphreniqueLycanthropique extends Maladie {
        public ZoopathieParaphreniqueLycanthropique() {
            super("Zoopathie paraphrénique lycanthropique", "ZPL", 8);
        }
    }

    public static class NarcolepsieDeliranteMalefiqueAutoDestructrice extends Maladie {
        public NarcolepsieDeliranteMalefiqueAutoDestructrice() {
            super("Narcolepsie délirante maléfique auto-destructrice", "NDMAD", 6);
        }
    }
    */
}
