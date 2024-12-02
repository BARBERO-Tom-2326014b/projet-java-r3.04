package personnage;

import java.util.*;

public class HopitalFantastique {
    private String nom;
    private int nombreMaxServices;
    private static List<ServiceMedical> servicesMedicals;
    private List<Medecin> medecins;
    public static boolean perdu = false;
    private static List<Creature> ListeDeCreatureEnAttente;

    public HopitalFantastique(String nom, int nombreMaxServices) {
        this.nom = nom;
        this.nombreMaxServices = nombreMaxServices;
        this.servicesMedicals = new ArrayList<>();
        this.medecins = new ArrayList<>();
        this.ListeDeCreatureEnAttente = new ArrayList<>();
    }
    
    public static List<Creature> getListeDeCreatureEnAttente() {
		return ListeDeCreatureEnAttente;
	}
    

    public void ajouterServiceMedical(ServiceMedical service) {
        if (servicesMedicals.size() < nombreMaxServices) {
            servicesMedicals.add(service);
        } else {
            System.out.println("Le nombre maximum de services médicaux est atteint.");
        }
    }
    

    public List<Creature> listerCreatures() {
        List<Creature> creaturesDansHopital = new ArrayList<>();
        
        // Parcourt tous les services médicaux pour récupérer les créatures
        for (ServiceMedical service : servicesMedicals) {
            creaturesDansHopital.addAll(service.getCreatures());
        }

        return creaturesDansHopital;
    }
    
    
    
    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }
    
    public static boolean verifieCompatibilite(Creature creature, ServiceMedical serviceVoulu) {
        // Obtenez le nom de la classe de la créature
        String nomClass = creature.getClass().getSimpleName(); // Utilisez getSimpleName() pour obtenir le nom simple de la classe

        // Vérifiez la compatibilité en fonction du type de service
        switch (serviceVoulu.getClass().getSimpleName()) { // Utilisez getSimpleName() ici aussi
            case "Crypte":
                if (nomClass.equals("Zombie") || nomClass.equals("Vampire")) {
                    // Vérifiez si le service est déjà occupé par une créature de même type
                    if (!serviceVoulu.getCreatures().isEmpty()) {
                        Creature creatureInitial = serviceVoulu.getCreatures().get(0);
                        if (creatureInitial.getClass().getSimpleName().equals(nomClass)) {
                            return true;
                        }
                        return false;
                    }
                    return true; // Si le service est vide, accepte la créature
                }
                return false;

            case "CentreDeQuarantaine":
                if (nomClass.equals("Lycanthrope") || nomClass.equals("HommeBete") || nomClass.equals("Orque") || nomClass.equals("Vampire")) {
                    if (!serviceVoulu.getCreatures().isEmpty()) {
                        Creature creatureInitial = serviceVoulu.getCreatures().get(0);
                        if (creatureInitial.getClass().getSimpleName().equals(nomClass)) {
                            return true;
                        }
                        return false;
                    }
                    return true; // Si le service est vide, accepte la créature
                }
                return false;

            case "ServiceMedicalStandard":
                if (!serviceVoulu.getCreatures().isEmpty()) {
                    Creature creatureInitial = serviceVoulu.getCreatures().get(0);
                    if (creatureInitial.getClass().getSimpleName().equals(nomClass)) {
                        return true;
                    }
                    return false;
                }
                return true; // Si le service est vide, accepte la créature

            default:
                return false; // Si le service n'est pas reconnu
        }
    }

    
    public static void admettreCreature(Creature creature, ServiceMedical serviceVoulu) {
    	if (serviceVoulu.getNombreCreatures() < serviceVoulu.getCapaciteMax()) {
        	if(verifieCompatibilite(creature, serviceVoulu)) {
        		serviceVoulu.getCreatures().add(creature);
        		System.out.println("La creature a bien été ajoutée");
        	}
        	else {
        		System.out.println("Desoler votre Creature n'est pas du bon type pour ce service");
        	}
        			
        } else {
            System.out.println("Tout les services sont pleins ");
        }
    }

    public void afficherStatistiques() {
        System.out.println("Hôpital fantastique : " + nom);
        System.out.println("Nombre total de créatures présentes : " + getNombreTotalCreatures());
        for (ServiceMedical service : servicesMedicals) {
            service.afficherCaracteristiques();
        }
    }

    public int getNombreTotalCreatures() {
        int total = 0;
        for (ServiceMedical service : servicesMedicals) {
            total += service.getNombreCreatures();
        }
        return total;
    }
    
    public void ChanceDarriverCreature (List<Creature> ListeDeCreatureEnAttente) {
    	Random random = new Random();
    	int chance = random.nextInt(100); // 0 à 99 inclus

        // Si le nombre est inférieur à 10 (10 % de chance)
        if (chance < 10) {
        	ajouterCreaturesAleatoires(ListeDeCreatureEnAttente);
        }
    	
    }
    /**
     * 
     * @param ListeDeCreatureEnAttente
     * @return
     */
    public static List<Creature> ajouterCreaturesAleatoires(List<Creature> ListeDeCreatureEnAttente) {
        Random random = new Random();
        

        
        int type = random.nextInt(5); // 0 = Elfe, 1 = Orque, 2 = Vampire, 3 = Zombie, 4 = Lycanthrope
        Creature creature;

        String nom = genererNom(random);
        String sexe = random.nextBoolean() ? "M" : "F";
        double poids = 50 + random.nextDouble() * 100; // 50 à 150 kg
        double taille = 1.5 + random.nextDouble() * 0.8; // 1.5 à 2.3 mètres
        int age = random.nextInt(300); // 0 à 300 ans

        switch (type) {
            case 0: // Elfe
                creature = new Elfe(nom, sexe, poids, taille, age);
                ListeDeCreatureEnAttente.add(creature);
                return ListeDeCreatureEnAttente;
            case 1: // Orque
                creature = new Orque(nom, sexe, poids, taille, age);
                ListeDeCreatureEnAttente.add(creature);
                return ListeDeCreatureEnAttente;
            case 2: // Vampire
                creature = new Vampire(nom, sexe, poids, taille, age);
                ListeDeCreatureEnAttente.add(creature);
                return ListeDeCreatureEnAttente;
            case 3: // Zombie
                creature = new Zombie(nom, sexe, poids, taille, age);
                ListeDeCreatureEnAttente.add(creature);
                return ListeDeCreatureEnAttente;
            case 4: // Lycanthrope
                creature = new Lycanthrope(nom, sexe, poids, taille, age);
                ListeDeCreatureEnAttente.add(creature);
                return ListeDeCreatureEnAttente;
            default:
                throw new IllegalArgumentException("Type de créature inconnu : " + type);
        }
    }

    // Génère un nom aléatoire (exemple simplifié)
    /**
     * 
     * @param random
     * @return
     */
    private static String genererNom(Random random) {
        String[] noms = {"Elena", "Eldar", "Grommash", "Thrall", "Vlad", "Luna", "Fenrir", "Tanya", "Zeke"};
        return noms[random.nextInt(noms.length)];
    }
    
    /**
     * 
     * @return
     */
    public List<ServiceMedical> listerServices() {
        List<ServiceMedical> servicesStandard = new ArrayList<>();
        for (ServiceMedical service : servicesMedicals) {
            if (service instanceof ServiceMedical) {
                servicesStandard.add((ServiceMedical) service);
            }
        }
        return servicesStandard;
    }
    
    // Méthode pour modéliser l'aspect temporel et passer la main aux médecins
    //
    public void gestionTemps(int intervalle) {
        Random rand = new Random();
        

        for (int i = 0; i < intervalle; i++) {
            // Liste pour stocker tous les threads
            List<Thread> threads = new ArrayList<>();

            // Création des threads pour les services médicaux
            for (ServiceMedical service : servicesMedicals) {
                Thread thread = new Thread(() -> {
                    synchronized (this) {
                        if (!perdu) { // Arrête les actions si perdu est déjà vrai
                            service.modifierEtatCreatures(service.getCreatures());
                            service.modifierEtatService();

                        }
                    }
                });
                threads.add(thread);
            }
            Thread threadEvenHopital = new Thread(() -> {
            	synchronized (this) {
            		ChanceDarriverCreature(ListeDeCreatureEnAttente);
                    if(!ListeDeCreatureEnAttente.isEmpty()) {
                        System.out.println("La liste des creatures en attente est :");
                        for(Creature creatureEnAttente :  ListeDeCreatureEnAttente) {
                        	System.out.println(creatureEnAttente.getNomComplet() + " - " +creatureEnAttente.getClass().getSimpleName()+ "/n"); 
                        }
                    }
				}
            });
            threads.add(threadEvenHopital);
            
            for (ServiceMedical serviceX : servicesMedicals) {
            	Thread thread = new Thread(() -> {
            		synchronized(this) {
            			for(Creature creatureDansHopital : serviceX.getCreatures()) {
            				creatureDansHopital.attendre(serviceX.getCreatures());
            			}
            		}
            	});
            	threads.add(thread);
            }
            
            for (ServiceMedical serviceX : servicesMedicals) {
                Thread thread = new Thread(() -> {
                    synchronized (this) {
                        if (!perdu) { // Vérifie si perdu est déjà vrai
                            serviceX.maladieTropEvoluer(serviceX.getCreatures());
                            if (serviceX.getAperdu()) {
                                perdu = true;
                                afficherMessagePerte(); // Affiche immédiatement le message
                            }
                        }
                    }
                });
                threads.add(thread);
            }

            // Création des threads pour les actions des médecins
            for (Medecin medecin : medecins) {
                Thread thread = new Thread(() -> {
                    synchronized (this) {
                        if (!perdu) { // Vérifie si perdu est déjà vrai
                            medecin.effectuerActions(rand, servicesMedicals);
                        }
                    }
                });
                threads.add(thread);
            }

            // Démarrage de tous les threads
            for (Thread thread : threads) {
                thread.start();
            }

            // Surveillance des threads et interruption immédiate en cas de perte
            for (Thread thread : threads) {
                try {
                    thread.join(); // Attend la fin des threads
                    if (perdu) {
                        // Interrompt tous les threads restants dès qu'une perte est détectée
                        for (Thread t : threads) {
                            System.exit(1);
                        	t.interrupt();
                        }
                        break; // Arrête la boucle principale
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Afficher les statistiques après chaque intervalle
            //afficherStatistiques();

            // Pause entre les intervalles si nécessaire
            try {
                Thread.sleep(200); // Pause de 200 ms pour simuler un délai
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    
    private void afficherMessagePerte() {
        String message = "vous avez perdu";
        int largeur = message.length() + 6; // Ajuste la largeur du cadre en fonction du message

        // Ligne supérieure du cadre
        String bordure = "#".repeat(largeur);
        System.out.println(bordure);

        // Ligne vide avec des marges
        System.out.println("#" + " ".repeat(largeur - 2) + "#");

        // Ligne contenant le message centré
        int espaces = (largeur - 2 - message.length()) / 2;
        System.out.println("#" + " ".repeat(espaces) + message + " ".repeat(espaces) + "#");

        // Ligne vide avec des marges
        System.out.println("#" + " ".repeat(largeur - 2) + "#");

        // Ligne inférieure du cadre
        System.out.println(bordure);
    }

   
}