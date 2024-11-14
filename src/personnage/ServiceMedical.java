package personnage;

import java.util.ArrayList;
import java.util.List;

// Classe de base pour les services médicaux
abstract class ServiceMedical {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private List<Creature> creatures;
    private String budget;

    public ServiceMedical(String nom, double superficie, int capaciteMax, String budget) {
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

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void afficherCaracteristiques() {
        System.out.println("Nom: " + nom);
        System.out.println("Superficie: " + superficie + " m²");
        System.out.println("Capacité max: " + capaciteMax);
        System.out.println("Budget: " + budget);
        System.out.println("Nombre de créatures présentes: " + creatures.size());
        for (Creature creature : creatures) {
            creature.afficherCaracteristiques();
        }
    }

    public boolean ajouterCreature(Creature creature) {
        if (creatures.size() < capaciteMax) {
            creatures.add(creature);
            return true;
        } else {
            System.out.println("Le service est plein.");
            return false;
        }
    }

    public void retirerCreature(Creature creature) {
        creatures.remove(creature);
    }

    public void soignerCreatures() {
        for (Creature creature : creatures) {
            creature.seSoigner();
        }
    }

    public abstract void reviserBudget();
}
