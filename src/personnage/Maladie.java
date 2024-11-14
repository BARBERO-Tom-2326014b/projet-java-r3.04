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
        this.niveauActuel = Math.max(1, Math.min(niveau, niveauMax)); // Bornage du niveau entre 1 et niveauMax
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
    
    public class MaladieDebilitanteChronique extends Maladie {
        public MaladieDebilitanteChronique() {
            super("Maladie Débilitante Chronique", "MDC", 10);
        }

        
    }

    public class SyndromeFOMO extends Maladie {
        public SyndromeFOMO() {
            super("Syndrome Fear of Missing Out", "FOMO", 5);
        }
    }

    public class DependenceAuxReseauxSociaux extends Maladie {
        public DependenceAuxReseauxSociaux() {
            super("Dépendance aux Réseaux Sociaux", "DRS", 7);
        }
    }

    public class PorphyrieErythropoïétiqueCongénitale extends Maladie {
        public PorphyrieErythropoïétiqueCongénitale() {
            super("Porphyrie érythropoïétique congénitale", "PEC", 3);
        }
    }
    
    public class ZoopathieParaphréniqueLycanthropique extends Maladie {
        public ZoopathieParaphréniqueLycanthropique() {
            super("Zoopathie paraphrénique lycanthropique", "ZPL", 8);
        }
    }
    
    public class NarcolepsieDéliranteMaléfiqueAutoDestructrice extends Maladie {
        public NarcolepsieDéliranteMaléfiqueAutoDestructrice() {
            super("Narcolepsie délirante maléfique auto-destructrice", "NDMAD", 6);
        }
    }

}

