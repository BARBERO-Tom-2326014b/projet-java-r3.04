package personnage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMedecin {
	private Medecin docteur;
	private Medecin toubib;
	private ServiceMedicalStandard hopital;
	private HommeBete hommeB;
	private CentreDeQuarantaine quarantaine;
	
	@BeforeEach
    void setUp() {
        // Initialisation
		hopital = new ServiceMedicalStandard("hopital",200,50,5000);
		quarantaine = new CentreDeQuarantaine("centre de quarantaine", 300, 5, 10000, false);
		toubib = new Medecin("doc jazy", "M", 30);
		docteur = new Medecin("dr maboul", "M", 69);
		hommeB = new HommeBete("tommy", "F", 45, 1.35, 19);
    }
	
	@Test
	public void examServiceMed() {
		docteur.examinerService(hopital);
		hopital.getCreatures().add(hommeB);
		//Test
		assertEquals(1, hopital.getCreatures().size());
	    assertEquals("tommy", hopital.getCreatures().get(0).getNomComplet());
	}
	
	@Test
	public void soignerCreatures() {
		hommeB.tomberMalade(Maladie.creerMaladie("FOMO"));
		hopital.getCreatures().add(hommeB);
	    
		hommeB.etreSoignee(); // soigne la creature ( on devrait appeler soignerCreature() mais il y a des input)
		
		// Test
	    assertEquals(0, hommeB.getMaladies().size());
	    assertEquals(90, hommeB.getMoral()); // Moral augmenté de 20 après soins
		
	}
	
	@Test
	public void reviseBudget() {
		toubib.reviserBudget(hopital);
		
		// Test
	    assertEquals(15000, hopital.getBudget());
	}
	
	@Test
	public void transfereCreature() {
		hopital.getCreatures().add(hommeB);
		docteur.transfererCreature(hopital, quarantaine, hommeB);
		
		// Test
	    assertFalse(hopital.getCreatures().contains(hommeB));
	    assertTrue(quarantaine.getCreatures().contains(hommeB));
	}
}
