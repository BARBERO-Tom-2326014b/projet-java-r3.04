package personnage;

import java.util.List;
import java.util.Scanner;

public class main {
	/**
     * Méthode principale qui initialise l'hôpital et gère les choix de l'utilisateur.
     * Elle affiche un menu permettant de consulter les statistiques de l'hôpital,
     * simuler l'activité des médecins, ou quitter l'application.
     * 
     * @param args Arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        // Initialiser l'hôpital
        HopitalFantastique hopital = new HopitalFantastique("Hôpital Fantastique", 10);

        // Exemple d'initialisation : ajouter des services et des médecins
        initialiserHopital(hopital);

        // Scanner pour l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        System.out.println("Bienvenue dans Fantasy Hospital !");
        while (!quitter) {
            // Afficher le menu principal
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1. Afficher les statistiques de l'hôpital");
            //System.out.println("2. Admettre une créature dans un service");
            System.out.println("2. Passer la main aux médecins (simulation)");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                    hopital.afficherStatistiques();
                    break;
                    /*
                case 2:
                    admettreCreature(scanner, hopital);
                    break; */
                case 2:
                    System.out.print("Combien d'intervalles de temps simuler ? ");
                    int intervalle = scanner.nextInt();
                    hopital.gestionTemps(intervalle);
                    break;
                case 3:
                    System.out.println("Merci d'avoir joué ! À bientôt.");
                    quitter = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }

    /**
     * Méthode d'initialisation des services médicaux et des médecins dans l'hôpital.
     * Elle crée des services (Elf, Orque, Vampire) et y admet des créatures de type correspondant.
     * 
     * @param hopital L'hôpital dans lequel ajouter les services et créatures.
     */
    private static void initialiserHopital(HopitalFantastique hopital) {
        // Exemple de services et médecins ajoutés
        ServiceMedicalStandard serviceElfes = new ServiceMedicalStandard("Service des Elfes elfique", 10.5, 20, 1500); // Capacité de 10
        CentreDeQuarantaine serviceOrques = new CentreDeQuarantaine("Service des Orques", 20, 10, 900, true); // Capacité de 8	
        CentreDeQuarantaine serviceHommeBete = new CentreDeQuarantaine("Service des Hommes Betes", 20, 3, 900, true); // Capacité de 8	
        CentreDeQuarantaine serviceLycanthrope = new CentreDeQuarantaine("Service des Lycanthrope", 20, 3, 900, true); // Capacité de 8	
        Crypte serviceVampire = new Crypte("Service des Vampires", 20, 3, 900, 20,2 ); // Capacité de 8	
        Crypte LaCrypteDesMortsVivants = new Crypte("La Crypte Des Morts Vivants", 8, 6, 200, 10, 0);
        
        hopital.ajouterServiceMedical(serviceElfes);
        hopital.ajouterServiceMedical(serviceVampire);
        hopital.ajouterServiceMedical(serviceOrques);
        hopital.ajouterServiceMedical(serviceLycanthrope);
        hopital.ajouterServiceMedical(LaCrypteDesMortsVivants);

        // Ajout des médecins
        Medecin medecin1 = new Medecin("Dr. Galadriel", "F", 123); // Exemple de médecin
        Medecin medecin2 = new Medecin("Dr. Grommash", "M", 125);
        hopital.ajouterMedecin(medecin1);
        hopital.ajouterMedecin(medecin2);

        // Création et ajout des créatures dans les services
        // Service des Elfes : Créatures de type Elfe
        Elfe elfe1 = new Elfe("Elena", "F", 50, 1.70, 120);
        Elfe elfe2 = new Elfe("Eldar", "M", 65, 1.80, 110);
        hopital.admettreCreature(elfe1, serviceElfes);
        hopital.admettreCreature(elfe2, serviceElfes);

        // Service des Orques : Créatures de type Orque
        Orque orque1 = new Orque("Martin le gros orque", "M", 120, 2.10, 45);
        Orque orque2 = new Orque("Thrall", "M", 115, 2.05, 50);
        hopital.admettreCreature(orque1, serviceOrques);
        hopital.admettreCreature(orque2, serviceOrques);
        // Créatures supplémentaires dans d'autres services
        Vampire vampire1 = new Vampire("Vlad", "M", 80, 1.85, 300);
        Vampire vampire2 = new Vampire("MiaK", "F", 70, 1.70, 250);
        hopital.admettreCreature(vampire1, serviceVampire);
        hopital.admettreCreature(vampire2, serviceVampire);
        Zombie zombie1 = new Zombie("Zeke", "M", 90, 1.85, 40);
        Zombie zombie2 = new Zombie("Tanya", "F", 85, 1.75, 35);
        hopital.admettreCreature(zombie1, LaCrypteDesMortsVivants);
        hopital.admettreCreature(zombie2, LaCrypteDesMortsVivants);

        Lycanthrope lycan1 = new Lycanthrope("Fenrir", "M", 100, 2.00, 30);
        Lycanthrope lycan2 = new Lycanthrope("Luna", "F", 95, 1.90, 28);
        hopital.admettreCreature(lycan1, serviceLycanthrope);
        hopital.admettreCreature(lycan2, serviceLycanthrope);


        // Ajouter les créatures aux services appropriés
        // Ces créatures pourraient être ajoutées à d'autres services en fonction de leurs caractéristiques
    }
    
    /*
    
    //TODO se casser la tete pour faire ca 

    private static void admettreCreature(Scanner scanner, HopitalFantastique hopital) {
    // Demande des informations sur la créature
    System.out.print("Entrez le nom de la créature : ");
    String nomCreature = scanner.nextLine();
    System.out.print("Entrez le sexe de la créature (M/F) : ");
    String sexe = scanner.nextLine();
    System.out.print("Entrez le poids de la créature : ");
    double poids = scanner.nextDouble();
    System.out.print("Entrez la taille de la créature : ");
    double taille = scanner.nextDouble();
    System.out.print("Entrez l'âge de la créature : ");
    int age = scanner.nextInt();
    scanner.nextLine(); // Consommer le saut de ligne restant

    // Choisir le type de créature
    System.out.println("Choisissez le type de créature : ");
    System.out.println("1. Elfe");
    System.out.println("2. Orque");
    System.out.println("3. Vampire");
    System.out.println("4. Zombie");
    System.out.println("5. Lycanthrope");
    int choixCreature = scanner.nextInt();
    scanner.nextLine(); // Consommer le saut de ligne restant

    Creature nouvelleCreature = null;

    // Création de la créature en fonction du type choisi
    switch (choixCreature) {
        case 1:
            nouvelleCreature = new Elfe(nomCreature, sexe, poids, taille, age);
            break;
        case 2:
            nouvelleCreature = new Orque(nomCreature, sexe, poids, taille, age);
            break;
        case 3:
            nouvelleCreature = new Vampire(nomCreature, sexe, poids, taille, age);
            break;
        case 4:
            nouvelleCreature = new Zombie(nomCreature, sexe, poids, taille, age);
            break;
        case 5:
            nouvelleCreature = new Lycanthrope(nomCreature, sexe, poids, taille, age);
            break;
        default:
            System.out.println("Choix invalide.");
            return; // Retourner si le choix est invalide
    }

    // Choisir un service pour la créature
    List<ServiceMedical> services = hopital.listerServices();
    System.out.println("Choisissez un service : ");
    for (int i = 0; i < services.size(); i++) {
        System.out.println((i + 1) + ". " + services.get(i).getNom());
    }

    int choixService = scanner.nextInt() - 1;
    scanner.nextLine(); // Consommer le saut de ligne restant    
    

    if (choixService >= 0 && choixService < services.size()) {
        // Récupérer le service sélectionné
        ServiceMedical service = services.get(choixService);
        
        // Admettre la créature dans le service sélectionné
        hopital.admettreCreature(nouvelleCreature, service);
    } else {
        System.out.println("Choix de service invalide.");
    }
}
*/
}
