package personnage;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    
    public void effectuerActions(Random rand, List<ServiceMedical> services) {
    	
        Scanner scanner = new Scanner(System.in);
        for(ServiceMedical serviceX : services) {
        	serviceX.maladieTropEvoluer(serviceX.getCreatures());
        }
        System.out.println("\nChoisissez une action à effectuer :");
        System.out.println("1. Examiner un service médical");
        System.out.println("2. Soigner les créatures d'un service médical");
        System.out.println("3. Réviser le budget d'un service médical");
        System.out.println("4. Transférer une créature entre deux services médicaux");
        System.out.println("Votre choix : ");
        int choix = scanner.nextInt();

        switch (choix) {
            case 1: // Examiner un service
                System.out.println("Choisissez un service médical à examiner :");
                ServiceMedical serviceExam = choisirService(scanner, services);
                examinerService(serviceExam);
                break;

            case 2: // Soigner les créatures
                System.out.println("Choisissez un service médical pour soigner les créatures :");
                ServiceMedical serviceSoins = choisirService(scanner, services);
                soignerCreatures(serviceSoins);
                break;

            case 3: // Réviser le budget
                System.out.println("Choisissez un service médical pour réviser le budget :");
                ServiceMedical serviceBudget = choisirService(scanner, services);
                System.out.println("Entrez le nouveau budget :");
                double nouveauBudget = scanner.nextDouble();
                reviserBudget(serviceBudget, nouveauBudget);
                break;

            case 4: // Transférer une créature
                System.out.println("Choisissez le service médical de départ :");
                ServiceMedical serviceDepart = choisirService(scanner, services);
                System.out.println("Choisissez la créature à transférer :");
                Creature creature = choisirCreature(scanner, serviceDepart);
                System.out.println("Choisissez le service médical de destination :");
                ServiceMedical serviceArrivee = choisirService(scanner, services);
                transfererCreature(serviceDepart, serviceArrivee, creature);
                break;

            default:
                System.out.println("Action invalide. Veuillez réessayer.");
        }
    }

    // Méthode pour choisir un service médical parmi une liste
    private ServiceMedical choisirService(Scanner scanner, List<ServiceMedical> services) {
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom());
        }
        int choix = scanner.nextInt();
        return services.get(Math.max(0, Math.min(choix - 1, services.size() - 1)));
    }

    // Méthode pour choisir une créature parmi une liste
    private Creature choisirCreature(Scanner scanner, ServiceMedical service) {
        List<Creature> creatures = service.getCreatures();
        for (int i = 0; i < creatures.size(); i++) {
            System.out.println((i + 1) + ". " + creatures.get(i).getNomComplet());
        }
        int choix = scanner.nextInt();
        return creatures.get(Math.max(0, Math.min(choix - 1, creatures.size() - 1)));
    }
}

