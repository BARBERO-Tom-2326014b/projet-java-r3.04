package personnage;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestHopitalFantastique {
	private HopitalFantastique hopitalFantastique;
	private Medecin docteur;
	private Medecin toubib;
	private ServiceMedicalStandard hopital;
	private HommeBete hommeB;
	private CentreDeQuarantaine quarantaine;
	private Elfe elfe;
	private static List<ServiceMedical> servicesMedicals;
	
	@BeforeEach
    void setUp() {
        // Initialisation
		hopitalFantastique = new HopitalFantastique("hopital fantastique", 3);
		hopital = new ServiceMedicalStandard("hopital",200,50,5000);
		quarantaine = new CentreDeQuarantaine("centre de quarantaine", 300, 5, 10000, false);
		toubib = new Medecin("doc jazy", "M", 30);
		docteur = new Medecin("dr maboul", "M", 69);
		hommeB = new HommeBete("tommy", "F", 45, 1.35, 19);
		elfe = new Elfe("Mathias", "F", 75, 1.9, 25);
		servicesMedicals = new ArrayList<>();
		
		//ajouter service medical dans la liste 
		servicesMedicals.add(hopital);
		servicesMedicals.add(quarantaine);
    }
	
	@Test
	public void afficheNbCreature() {
		hopital.getCreatures().add(hommeB);
		quarantaine.getCreatures().add(elfe);
		hopitalFantastique.ajouterServiceMedical(hopital);
		hopitalFantastique.ajouterServiceMedical(quarantaine);
		
		assertEquals(2,hopitalFantastique.getNombreTotalCreatures());
	}
	
	@Test
	public void afficheCreatureHopital() {
		hopital.getCreatures().add(hommeB);
		quarantaine.getCreatures().add(elfe);
		hopitalFantastique.ajouterServiceMedical(hopital);
		hopitalFantastique.ajouterServiceMedical(quarantaine);
		
		ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(consoleOutput)); // Rediriger System.out
	    
	    for (ServiceMedical service : hopitalFantastique.listerServices()) {
            service.afficherCaracteristiques();
        }
	   
	    
		assertTrue(consoleOutput.toString().contains("Créature : " + elfe.getNomComplet()));
		assertTrue(consoleOutput.toString().contains("Créature : " + hommeB.getNomComplet()));
		
		// Réinitialiser la sortie après le test
		System.setOut(System.out); 
	}







}
