package personnage;

import java.util.*;

public class HopitalFantastique {
    private String nom;
    private int nombreMaxServices;
    private List<ServiceMedical> servicesMedicals;
    private List<Medecin> medecins;

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
            // Création des threads pour les services médicaux
            List<Thread> threadsServices = new ArrayList<>();
            for (ServiceMedical service : servicesMedicals) {
                Runnable serviceTask = () -> {
                    service.modifierEtatCreatures(service.getCreatures());
                    service.modifierEtatService();
                };
                threadsServices.add(new Thread(serviceTask));
            }

            // Création des threads pour les actions des médecins
            List<Thread> threadsMedecins = new ArrayList<>();
            for (Medecin medecin : medecins) {
                Runnable medecinTask = () -> {
                    synchronized (this) { // Synchronisation si nécessaire
                        medecin.effectuerActions(rand, servicesMedicals);
                    }
                };
                threadsMedecins.add(new Thread(medecinTask));
            }

            // Démarrage de tous les threads des services médicaux
            for (Thread thread : threadsServices) {
                thread.start();
            }

            // Démarrage de tous les threads des médecins
            for (Thread thread : threadsMedecins) {
                thread.start();
            }

            // Attendre que tous les threads des services médicaux se terminent
            for (Thread thread : threadsServices) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Attendre que tous les threads des médecins se terminent
            for (Thread thread : threadsMedecins) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

   
}