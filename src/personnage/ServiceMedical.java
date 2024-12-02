package personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Classe de base pour les services médicaux
abstract class ServiceMedical {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private List<Creature> creatures;
    private double budget;
    private boolean Aperdu = false;

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
    
    public void setAperdu() {
    	Aperdu = true;
    }
    
    public boolean getAperdu() {
    	return Aperdu;
    }

    public double getSuperficie() {
        return superficie;
    }

    public int getCapaciteMax(creatures) {
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
    
    
    
    
    
    public void maladieTropEvoluer(List<Creature> creatures) {
        List<Creature> ListeDesMorts = new ArrayList<>();
        for (Creature creature : creatures) {
            if (creature.estMort()) {
            	ListeDesMorts.add(creature);
            }
        }
        creatures.removeAll(ListeDesMorts);
        if (ListeDesMorts.isEmpty() == false){
        	setAperdu();
        }
    }
    
    
 // Méthode pour modifier l'état des créatures
    public static void modifierEtatCreatures(List<Creature> creatures) {
        Random random = new Random();

        for (Creature creature : creatures) {
            // Modification aléatoire du moral
            int changementMoral = random.nextInt(21) - 10; // Valeur entre -10 et +10
            int nouveauMoral = creature.getMoral() + changementMoral;
            creature.setMoral(Math.max(0, Math.min(nouveauMoral, 100))); // Bornage du moral entre 0 et 100
            //System.out.println(creature.getNomComplet() + " voit son moral changer de " + changementMoral + ". Nouveau moral : " + creature.getMoral());

            // Chance d'ajouter une maladie
            if (random.nextInt(100) < 10) { // 30% de chance d'ajouter une maladie
                ajouterMaladie(creature);
            }

            // Chance de faire évoluer une maladie
            if (random.nextInt(100) < 100 && !creature.getMaladies().isEmpty()) { // 20% de chance d'évoluer une maladie
                evoluerMaladie(creature);
            }

            
        }
    }
    
    public void modifierEtatService() {
        Random random = new Random();

        if (random.nextInt(100) < 30) { // 30% de changer le budget
        	// Modification aléatoire du budget
            double changementBudget = random.nextInt(201) - 100; // Valeur entre -100 et +100
            budget += changementBudget;
            if (budget < 0) budget = 0; // Empêche un budget négatif
            System.out.println("Budget de " + nom + " modifié de " + changementBudget + ". Nouveau budget: " + budget);

        }
        
        if (random.nextInt(100) < 5) { // 5% de changer la superficie
	        // Modification aléatoire de la superficie
	        double changementSuperficie = random.nextInt(101) - 50; // Valeur entre -50 et +50 m²
	        superficie += changementSuperficie;
	        if (superficie < 0) superficie = 0; // Empêche une superficie négative
	        System.out.println("Superficie de " + nom + " modifiée de " + changementSuperficie + " m². Nouvelle superficie: " + superficie);
	        }
        
        if (random.nextInt(100) < 10) { // 10% de changer la superficie
	        // Modification aléatoire de la capacité maximale
	        
	        int changementCapacite = random.nextInt(9) - 3; // Valeur entre -3 et +3
	        capaciteMax += changementCapacite;
	        if (capaciteMax < 0) capaciteMax = 0; // Empêche une capacité négative
	        System.out.println("Capacité maximale de " + nom + " modifiée de " + changementCapacite + ". Nouvelle capacité: " + capaciteMax);
        }
        
        
        
        // Exemple de changement aléatoire de l'isolation ou de la température si nécessaire
        // (par exemple, ici, je suppose qu'il existe des attributs isolation et temperature dans votre classe)
        // Si ces attributs sont ajoutés, vous pouvez les modifier de manière similaire.

        // Modification de l'isolation (si applicable)
        if (random.nextInt(100) < 5) { // 30% de chance de modifier l'isolation
            double changementIsolation = random.nextInt(21) - 10; // Valeur entre -10 et +10
            // isolation += changementIsolation; // Hypothétique - si vous avez un attribut isolation
            // System.out.println("Isolation modifiée de " + changementIsolation + ".");
        }

        // Modification de la température (si applicable)
        if (random.nextInt(100) < 20) { // 40% de chance de modifier la température
            double changementTemperature = random.nextInt(11) - 5; // Valeur entre -5 et +5
            // temperature += changementTemperature; // Hypothétique - si vous avez un attribut temperature
            // System.out.println("Température modifiée de " + changementTemperature + ".");
        }
    }

    // Ajouter une maladie aléatoire à une créature
    private static void ajouterMaladie(Creature creature) {
        // Liste des maladies avec leur nom et type
        String[] maladies = {"MDC", "FOMO", "DRS", "PEC", "ZPL", "NDMAD"};
        
        // Choisir une maladie au hasard parmi les chaînes
        String maladieNom = maladies[new Random().nextInt(maladies.length)];
        
        // Créer l'objet maladie correspondant
        Maladie maladie = null;
        switch (maladieNom) {
            case "MDC":
                maladie = Maladie.creerMaladie("MDC");
                break;
            case "FOMO":
            	maladie = Maladie.creerMaladie("FOMO");
                break;
            case "DRS":
            	maladie = Maladie.creerMaladie("DRS");
                break;
            case "PEC":
            	maladie = Maladie.creerMaladie("PEC");
                break;
            case "ZPL":
            	maladie = Maladie.creerMaladie("ZPL");
                break;
            case "NDMAD":
            	maladie = Maladie.creerMaladie("NDMAD");
                break;
        }

        // Ajouter la maladie à la créature
        if (maladie != null) {
            creature.tomberMalade(maladie);
        }
    }


    // Faire évoluer une maladie (augmenter son niveau)
    private static void evoluerMaladie(Creature creature) {
        List<Maladie> maladies = creature.getMaladies();
        Maladie maladie = maladies.get(new Random().nextInt(maladies.size()));
        System.out.println("La maladie " + maladie + " de " + creature.getNomComplet() + " évolue.");
        // Logique pour augmenter le niveau de la maladie (exemple simple)
        // La classe Maladie devrait avoir une méthode pour évoluer son niveau
        maladie.augmenterNiveau(1);
        if(maladie.estLetale()) {
        	creature.estMort();
        };
    }

    // Méthode pour rendre malade une créature (exemple de tomber malade)
    /*private static void rendreMalade(Creature creature) {
        Maladie maladie = "Maladie Aléatoire " + new Random().nextInt(100);
        creature.tomberMalade(maladie);
    } */

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
        if (getCreatures().isEmpty()) {
            System.out.println("Aucune créature à soigner.");
            return;
        }

        // Afficher les créatures présentes dans le service
        System.out.println("Liste des créatures présentes :");
        for (int i = 0; i < getCreatures().size(); i++) {
            Creature creature = getCreatures().get(i);
            System.out.println(i + 1 + ". " + creature.getNomComplet() + " (Moral: " + creature.getMoral() + ", Maladies: " + creature.getMaladies() + ")");
        }

        // Demander à l'utilisateur de choisir une créature à soigner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro de la créature à soigner : ");
        int choix = scanner.nextInt();
        if (choix < 1 || choix > getCreatures().size()) {
            System.out.println("Choix invalide.");
            soignerCreatures();
        }

        Creature creatureASoigner = getCreatures().get(choix - 1);

        // Vérifier si la créature a des maladies à soigner
        if (creatureASoigner.getMaladies().isEmpty()) {
            System.out.println(creatureASoigner.getNomComplet() + " n'a aucune maladie à soigner.");
            soignerCreatures();
        }

        // Afficher les maladies de la créature
        System.out.println("Liste des maladies de " + creatureASoigner.getNomComplet() + " :");
        for (int i = 0; i < creatureASoigner.getMaladies().size(); i++) {
            Maladie maladie = creatureASoigner.getMaladies().get(i);
            System.out.println(i + 1 + ". " + maladie);
        }

        // Demander à l'utilisateur de choisir une maladie à soigner
        System.out.print("Entrez le numéro de la maladie à soigner : ");
        int maladieChoisie = scanner.nextInt();
        if (maladieChoisie < 1 || maladieChoisie > creatureASoigner.getMaladies().size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Maladie maladieASoigner = creatureASoigner.getMaladies().get(maladieChoisie - 1);

        // Ajouter une chance de réussir le soin
        if (new Random().nextInt(100) < 70) { // 70% de chance de réussir
            System.out.println("Le soin de " + creatureASoigner.getNomComplet() + " pour la maladie " + maladieASoigner.getNomComplet() + " est un succès !");
            maladieASoigner.diminuerNiveau(1); // Diminuer le niveau de la maladie
        } else {
            // Si le soin échoue, la maladie évolue
            System.out.println("Le soin de " + creatureASoigner.getNomComplet() + " pour la maladie " + maladieASoigner.getNomComplet() + " a échoué. La maladie évolue.");
            maladieASoigner.augmenterNiveau(1); // Augmenter le niveau de la maladie
        }
    }

    public abstract void reviserBudget();
}
