package personnage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestServiceMedical {
	
    private ServiceMedicalStandard hopital;
    private Crypte crypte;
    private CentreDeQuarantaine quarante;
    private Elfe elfe;
    private Medecin toubib;
        
    @BeforeEach
    void setUp() {
        hopital = new ServiceMedicalStandard("hopital",200,50,500000);
        crypte = new Crypte("crypte", 300, 20, 300000, 5, 21);
        quarante = new CentreDeQuarantaine("quarantaine", 150, 10, 250000, true);
        elfe = new Elfe("elwin", "M", 52, 1.6, 20);     
        toubib = new Medecin("doc jazy", "M", 30);
        };    
        
        @Test
        void testAfficheCara() {
        	assertEquals("elwin", elfe.getNomComplet());
            assertEquals("M", elfe.getSexe());
            assertEquals(52, elfe.getPoids());
            assertEquals(1.6, elfe.getTaille());
            assertEquals(20, elfe.getAge());
            assertEquals(0, elfe.getMaladies().size());
        }
        
        @Test
        public void testAjoutEtRetraitCreature() {
            hopital.getCreatures().add(elfe);
            assertEquals(1, hopital.getNombreCreatures());
            assertEquals("elwin", hopital.getCreatures().get(0).getNomComplet());

            hopital.retirerCreature(elfe);
            assertEquals(0, hopital.getNombreCreatures());
        }
        
        @Test
        public void testSoins() {
        	Maladie fomo = Maladie.creerMaladie("FOMO"); // Syndrome fear of missing out
        	elfe.tomberMalade(fomo);
        	crypte.getCreatures().add(elfe);

            System.out.println((elfe.getMaladies()));
            assertEquals(1, elfe.getMaladies().size());
            elfe.etreSoignee(); 
            assertEquals(0, elfe.getMaladies().size());
        }
        
        @Test
        public void testReviserBudget() {
        	quarante.reviserBudget(600);
            assertEquals(600, quarante.getBudget());
        }
      
}
