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
        System.out.println("Liste des créatures:");
        for (Creature creature : service.getCreatures()) {
            System.out.println(" - " + creature.getNomComplet());
            System.out.print(" Moral: " + creature.getMoral());
            System.out.print(" Maladies: " + creature.getMaladies());
        }
    }

    public void soignerCreature(ServiceMedical service) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Qui souhaitez-vous soigner ? Choisissez un numéro :");
        int index = 1;
        for (Creature creature : service.getCreatures()) {
            System.out.println(index + ". " + creature.getNomComplet() + creature.getMaladies());
            index++;
        }
        
        // Demande un choix à l'utilisateur
        System.out.print("Entrez le numéro correspondant : ");
        int choix = scanner.nextInt();
        
        // Vérifie si le choix est valide
        if (choix > 0 && choix <= service.getCreatures().size()) {
            Creature creatureASoigner = service.getCreatures().get(choix - 1);
            creatureASoigner.etreSoignee(); // Soigne la créature sélectionnée
            System.out.println("La créature " + creatureASoigner.getNomComplet() + " a été soignée.");
            System.out.println("Il reste" + creatureASoigner.getMaladies()+ " a La créature " + creatureASoigner.getNomComplet());
        } else {
            System.out.println("Choix invalide. Aucune créature n'a été soignée.");
        }
    }

    // Méthode pour réviser le budget du service médical
    public void reviserBudget(ServiceMedical service) {
        service.setBudget(service.getBudget()+10000);
        System.out.println("Le budget du service " + service.getNom() + " a été révisé à " + service.getBudget() + " crédits.");
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
    
    public void acceuilirUnPatient(Creature creature, ServiceMedical serviceAcceuilir) {
    	System.out.println("\n");
    }
    
    public synchronized void effectuerActions(Random rand, List<ServiceMedical> services) {
    	
    	if (HopitalFantastique.perdu){
    		return;
    	}
        Scanner scanner = new Scanner(System.in);
        for(ServiceMedical serviceX : services) {
        	serviceX.maladieTropEvoluer(serviceX.getCreatures());
        }
        System.out.println("\nChoisissez une action à effectuer :");
        System.out.println("1. Examiner un service médical");
        System.out.println("2. Soigner les créatures d'un service médical");
        System.out.println("3. Réviser le budget d'un service médical");
        System.out.println("4. Transférer une créature entre deux services médicaux");
        System.out.println("5. Acceuillir un nouveau patient");
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
                if(serviceSoins.getBudget()>2000) {
                soignerCreature(serviceSoins);
                serviceSoins.setBudget(serviceSoins.getBudget()-2000);
                System.out.println("Le soin sur le patient vous a couté 2000 votre budget est actuellement" + serviceSoins.getBudget())
                ;}
                else {
                	System.out.println("vous n'avez pas assez de budget dans ce service pour effectuer un soins.");
                }
                break;

            case 3: // Réviser le budget
                System.out.println("Choisissez un service médical pour réviser le budget :");
                ServiceMedical serviceBudget = choisirService(scanner, services);
                reviserBudget(serviceBudget);
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
                
            case 5: // Réviser le budget
            	System.out.println("Choisissez le patient a Acceuilir");
            	Creature creatureAttente = choisirCreatureEnAttente(scanner);
                System.out.println("Choisissez un service médical Acceuillir un patient :");
                ServiceMedical serviceAcceuil = choisirService(scanner, services);
                if(serviceAcceuil.getNombreCreatures() >= serviceAcceuil.getCapaciteMax()) {
                	System.out.println("Le service est plein");
                	break;
                }
                serviceAcceuil.ajouterCreature(creatureAttente);
                System.out.println("La Creature " + creatureAttente.getNomComplet() + " a bien été acceuili dans le service "+ serviceAcceuil.getNom());
                HopitalFantastique.getListeDeCreatureEnAttente().remove(creatureAttente); 
                break;

            default:
                System.out.println("Action invalide. Veuillez réessayer.");
        }
    }

    // Méthode pour choisir un service médical parmi une liste
    private ServiceMedical choisirService(Scanner scanner, List<ServiceMedical> services) {
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i).getNom() +" [" + services.get(i).getNombreCreatures()+ "/" +services.get(i).getCapaciteMax() + "]");
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
    
    private Creature choisirCreatureEnAttente(Scanner scanner) {
        List<Creature> creatures = HopitalFantastique.getListeDeCreatureEnAttente();
        for (int i = 0; i < creatures.size(); i++) {
            System.out.println((i + 1) + ". " + creatures.get(i).getNomComplet());
        }
        int choix = scanner.nextInt();
        return creatures.get(Math.max(0, Math.min(choix - 1, creatures.size() - 1)));
    }
}

