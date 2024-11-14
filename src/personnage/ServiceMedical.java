package personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Classe de base pour les services médicaux
abstract class ServiceMedical {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private List<Creature> creatures;
    private double budget;

    public ServiceMedical(String nom, double superficie, int capaciteMax, double budget) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.creatures = new ArrayList<>();
        this.budget = budget;
    }

    public String getNom() {
        return nom;
    }

    public double getSuperficie() {
        return superficie;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }
    
    public int getNombreCreatures() {
    	return creatures.size();
    }
    
 // Méthode pour modifier l'état des créatures
    public static void modifierEtatCreatures(List<Creature> creatures) {
        Random random = new Random();

        for (Creature creature : creatures) {
            // Modification aléatoire du moral
            int changementMoral = random.nextInt(21) - 10; // Valeur entre -10 et +10
            int nouveauMoral = creature.getMoral() + changementMoral;
            creature.setMoral(Math.max(0, Math.min(nouveauMoral, 100))); // Bornage du moral entre 0 et 100
            System.out.println(creature.getNomComplet() + " voit son moral changer de " + changementMoral + ". Nouveau moral : " + creature.getMoral());

            // Chance d'ajouter une maladie
            if (random.nextInt(100) < 30) { // 30% de chance d'ajouter une maladie
                ajouterMaladie(creature);
            }

            // Chance de faire évoluer une maladie
            if (random.nextInt(100) < 20 && !creature.getMaladies().isEmpty()) { // 20% de chance d'évoluer une maladie
                evoluerMaladie(creature);
            }

            // Chance de rendre une créature malade
            if (random.nextInt(100) < 15) { // 15% de chance de rendre malade
                rendreMalade(creature);
            }
        }
    }
    
    public void modifierEtatService() {
        Random random = new Random();

        // Modification aléatoire du budget
        double changementBudget = random.nextInt(201) - 100; // Valeur entre -100 et +100
        budget += changementBudget;
        if (budget < 0) budget = 0; // Empêche un budget négatif
        System.out.println("Budget de " + nom + " modifié de " + changementBudget + ". Nouveau budget: " + budget);

        // Modification aléatoire de la superficie
        double changementSuperficie = random.nextInt(101) - 50; // Valeur entre -50 et +50 m²
        superficie += changementSuperficie;
        if (superficie < 0) superficie = 0; // Empêche une superficie négative
        System.out.println("Superficie de " + nom + " modifiée de " + changementSuperficie + " m². Nouvelle superficie: " + superficie);

        // Modification aléatoire de la capacité maximale
        int changementCapacite = random.nextInt(11) - 5; // Valeur entre -5 et +5
        capaciteMax += changementCapacite;
        if (capaciteMax < 0) capaciteMax = 0; // Empêche une capacité négative
        System.out.println("Capacité maximale de " + nom + " modifiée de " + changementCapacite + ". Nouvelle capacité: " + capaciteMax);

        // Exemple de changement aléatoire de l'isolation ou de la température si nécessaire
        // (par exemple, ici, je suppose qu'il existe des attributs isolation et temperature dans votre classe)
        // Si ces attributs sont ajoutés, vous pouvez les modifier de manière similaire.

        // Modification de l'isolation (si applicable)
        if (random.nextInt(100) < 30) { // 30% de chance de modifier l'isolation
            double changementIsolation = random.nextInt(21) - 10; // Valeur entre -10 et +10
            // isolation += changementIsolation; // Hypothétique - si vous avez un attribut isolation
            // System.out.println("Isolation modifiée de " + changementIsolation + ".");
        }

        // Modification de la température (si applicable)
        if (random.nextInt(100) < 40) { // 40% de chance de modifier la température
            double changementTemperature = random.nextInt(11) - 5; // Valeur entre -5 et +5
            // temperature += changementTemperature; // Hypothétique - si vous avez un attribut temperature
            // System.out.println("Température modifiée de " + changementTemperature + ".");
        }
    }

    // Ajouter une maladie aléatoire à une créature
    private static void ajouterMaladie(Creature creature) {
        String[] maladies = {"MDC", "FOMO", "DRS", "PEC", "ZPL", "NDMAD"};
        String maladie = maladies[new Random().nextInt(maladies.length)];
        creature.tomberMalade(maladie);
    }

    // Faire évoluer une maladie (augmenter son niveau)
    private static void evoluerMaladie(Creature creature) {
        List<String> maladies = creature.getMaladies();
        String maladie = maladies.get(new Random().nextInt(maladies.size()));
        System.out.println("La maladie " + maladie + " de " + creature.getNomComplet() + " évolue.");
        // Logique pour augmenter le niveau de la maladie (exemple simple)
        // La classe Maladie devrait avoir une méthode pour évoluer son niveau
        // Maladie maladieInstance = new Maladie(maladie);
        // maladieInstance.augmenterNiveau(1);
    }

    // Méthode pour rendre malade une créature (exemple de tomber malade)
    private static void rendreMalade(Creature creature) {
        String maladie = "Maladie Aléatoire " + new Random().nextInt(100);
        creature.tomberMalade(maladie);
    }

    public void afficherCaracteristiques() {
        System.out.println("Nom: " + nom);
        System.out.println("Superficie: " + superficie + " m²");
        System.out.println("Capacité max: " + capaciteMax);
        System.out.println("Budget: " + budget);
        System.out.println("Nombre de créatures présentes: " + creatures.size());
        for (Creature creature : getCreatures()) {
            System.out.println("Créature : " + creature.getNomComplet());
            System.out.println("Moral: " + creature.getMoral());
            System.out.println("Maladies: " + creature.getMaladies());
        }
    }

    public void retirerCreature(Creature creature) {
        creatures.remove(creature);
    }

    public boolean ajouterCreature(Creature creature) {
        if (getCreatures().size() < getCapaciteMax()) {
            getCreatures().add(creature);
            return true;
        }
        else {
            System.out.println("Le service est plein.");
            return false;
        }
    }

    public void soignerCreatures() {
        for (Creature creature : getCreatures()) {
            creature.etreSoignee();
        }
    }

    public abstract void reviserBudget();
}
