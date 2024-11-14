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
// TODO, relire le sujet et adapté cette fonction  
    // Méthode pour modéliser l'aspect temporel et passer la main aux médecins
    public void gestionTemps(int intervalle) {
        Random rand = new Random();
        for (int i = 0; i < intervalle; i++) {
            // Modifier aléatoirement l'état des créatures et des services médicaux
            for (ServiceMedical service : servicesMedicals) {
                service.modifierEtatCreatures(service.getCreatures());
                service.modifierEtatService();
            }

            // Passer la main aux médecins pour qu'ils effectuent des actions
            for (Medecin medecin : medecins) {
                medecin.effectuerActions(rand, servicesMedicals);
            }

            // Afficher les statistiques après chaque intervalle
            afficherStatistiques();
        }
    }

   
}