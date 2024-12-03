package personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe abstraite représentant un service médical dans le jeu.
 * Permet de gérer les créatures, leurs états, et de soigner leurs maladies.
 */
// Classe de base pour les services médicaux
abstract class ServiceMedical {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private List<Creature> creatures;
    private double budget;
    private boolean Aperdu = false;
    
    /**
     * Constructeur de la classe ServiceMedical.
     *
     * @param nom         Le nom du service médical.
     * @param superficie  La superficie du service en m².
     * @param capaciteMax La capacité maximale du service.
     * @param budget      Le budget initial du service.
     */

    public ServiceMedical(String nom, double superficie, int capaciteMax, double budget) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.creatures = new ArrayList<>();
        this.budget = budget;
    }



    /**
     * @return Le nom du service médical.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit l'état du service comme ayant échoué à une tâche.
     */
    public void setAperdu() {
    	Aperdu = true;
    }
    
    /**
     * @return {@code true} si le service a échoué à une tâche, {@code false} sinon.
     */
    public boolean getAperdu() {
    	return Aperdu;
    }

    /**
     * @return La superficie du service en m².
     */
    public double getSuperficie() {
        return superficie;
    }

    /**
     * @return La capacité maximale du service.
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }

    /**
     * @return Le budget actuel du service.
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Définit le budget du service.
     *
     * @param budget Le nouveau budget.
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * @return La liste des créatures prises en charge par le service.
     */
    public List<Creature> getCreatures() {
        return creatures;
    }
    
    /**
     * @return Le nombre de créatures actuellement prises en charge.
     */
    public int getNombreCreatures() {
    	return creatures.size();
    }
    
    
    
    
    /**
     * Retire les créatures mortes de la liste et marque le service comme ayant échoué si des morts sont détectées.
     *
     * @param creatures La liste des créatures à vérifier.
     */
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
    
    /**
     * Modifie de manière aléatoire l'état des créatures (moral, maladies).
     *
     * @param creatures La liste des créatures à modifier.
     */
    public static void modifierEtatCreatures(List<Creature> creatures) {
        for (Creature creature : creatures) {
        	Random random = new Random();
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
    
    /**
     * Modifie de manière aléatoire les caractéristiques du service (budget, superficie, capacité).
     */
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
    /**
     * 
     * @param ajoute une maladie de maniere aleatoire a une creature
     * 
     */
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
                maladie.setNiveauActuel(1);
                break;
            case "FOMO":
            	maladie = Maladie.creerMaladie("FOMO");
                maladie.setNiveauActuel(1);

                break;
            case "DRS":
            	maladie = Maladie.creerMaladie("DRS");
                maladie.setNiveauActuel(1);

                break;
            case "PEC":
            	maladie = Maladie.creerMaladie("PEC");
                maladie.setNiveauActuel(1);

                break;
            case "ZPL":
            	maladie = Maladie.creerMaladie("ZPL");
                maladie.setNiveauActuel(1);

                break;
            case "NDMAD":
            	maladie = Maladie.creerMaladie("NDMAD");
                maladie.setNiveauActuel(1);

                break;
        }

        // Ajouter la maladie à la créature
        if (maladie != null) {
            creature.tomberMalade(maladie);
        }
    }


    /** Faire évoluer une maladie (augmenter son niveau)

     * 
     * @param creature
     */
    private static void evoluerMaladie(Creature creature) {
        List<Maladie> maladies = creature.getMaladies();
        Maladie maladie = maladies.get(new Random().nextInt(maladies.size()));
        maladie.augmenterNiveau(1);
        System.out.println("La maladie " + maladie + " de " + creature.getNomComplet() + " évolue.");
        // Logique pour augmenter le niveau de la maladie (exemple simple)
        // La classe Maladie devrait avoir une méthode pour évoluer son niveau
 
        if(maladie.estLetale()) {
        	creature.estMort();
        };
    }

    // Méthode pour rendre malade une créature (exemple de tomber malade)
    /*private static void rendreMalade(Creature creature) {
        Maladie maladie = "Maladie Aléatoire " + new Random().nextInt(100);
        creature.tomberMalade(maladie);
    } */

    /**
     * methode d'affichage du service
     */
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

    /**Retire une creature d'un service ( le retire de la list<creature> du service )
     * 
     * 
     * @param creature
     */
    public void retirerCreature(Creature creature) {
        creatures.remove(creature);
    }
    
    public abstract void reviserBudget();
}
