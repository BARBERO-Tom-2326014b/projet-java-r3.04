package personnage;

public class Medecin extends Creature {

    // Constructeur
    public Medecin(String nom, String sexe, int age) {
        super(nom, sexe, 0, 0, age);
        }
    // Méthode pour examiner un service médical
    public void examinerService(ServiceMedical service) {
        System.out.println("Examen du service " + service.getNom() + ":");
        System.out.println(service);
        System.out.println("Liste des créatures:");
        for (Creature creature : service.getCreatures()) {
            System.out.println(" - " + creature);
        }
    }

    // Méthode pour soigner toutes les créatures du service médical
    public void soignerCreatures(ServiceMedical service) {
        System.out.println("Soins en cours pour les créatures du service " + service.getNom() + "...");
        for (Creature creature : service.getCreatures()) {
            creature.etreSoignee(); // méthode pour guérir une créature
        }
        System.out.println("Toutes les créatures du service " + service.getNom() + " ont été soignées.");
    }

    // Méthode pour réviser le budget du service médical
    public void reviserBudget(ServiceMedical service, double nouveauBudget) {
        service.setBudget(nouveauBudget);
        System.out.println("Le budget du service " + service.getNom() + " a été révisé à " + nouveauBudget + " crédits.");
    }

    // Méthode pour transférer une créature vers un autre service médical
    public void transfererCreature(ServiceMedical serviceDepart, ServiceMedical serviceArrivee, Creature creature) {
        if (serviceDepart.getCreatures().contains(creature)) {
            serviceDepart.retirerCreature(creature);
            serviceArrivee.ajouterCreature(creature);
            System.out.println(creature.getNomComplet() + " a été transféré de " + serviceDepart.getNom() + " vers " + serviceArrivee.getNom());
        } else {
            System.out.println(creature.getNomComplet() + " n'est pas présent dans le service " + serviceDepart.getNom());
        }
    }
}
