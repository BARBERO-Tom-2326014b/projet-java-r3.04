package personnage;

import java.util.*;

public class HopitalFantastique {
    private String nom;
    private int nombreMaxServices;
    private List<ServiceMedical> servicesMedicals;
    private List<Medecin> medecins;
    private volatile boolean perdu = false;

    public HopitalFantastique(String nom, int nombreMaxServices) {
        this.nom = nom;
        this.nombreMaxServices = nombreMaxServices;
        this.servicesMedicals = new ArrayList<>();
        this.medecins = new ArrayList<>();
    }

    public void ajouterServiceMedical(ServiceMedical service) {
        if (servicesMedicals.size() < nombreMaxServices) {
            servicesMedicals.add(service);
        } else {
            System.out.println("Le nombre maximum de services médicaux est atteint.");
        }
    }
    
    public boolean servicesPleins() {
        for (ServiceMedical service : servicesMedicals) {
            if (service.getNombreCreatures() < service.getCapaciteMax()) {
                return false; // Si un service n'est pas plein, retourne false
            }
        }
        return true; // Si tous les services sont pleins, retourne true
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
    
    public boolean admettreCreature(Creature creature, ServiceMedical serviceVoulu) {
        if (servicesPleins() == false) {
        	if(serviceVoulu.getNombreCreatures()<serviceVoulu.getCapaciteMax()) {
        		serviceVoulu.ajouterCreature(creature);
	        	listerCreatures().add(creature);
	            return true;}
        	return false;
        } else {
            System.out.println("Tout les services sont pleins ");
            return false; // Si le service est plein, retourne false
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
    
    public List<ServiceMedicalStandard> listerServices() {
        List<ServiceMedicalStandard> servicesStandard = new ArrayList<>();
        for (ServiceMedical service : servicesMedicals) {
            if (service instanceof ServiceMedicalStandard) {
                servicesStandard.add((ServiceMedicalStandard) service);
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
                            t.interrupt();
                        }
                        break; // Arrête la boucle principale
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (perdu) {
                break; // Arrête la boucle principale dès qu'une perte est détectée
            }

            // Afficher les statistiques après chaque intervalle
            afficherStatistiques();

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