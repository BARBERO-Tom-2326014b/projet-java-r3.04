package personnage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



class TestCreature {
    private Orque orque;
    private Elfe elfe;
    private Lycanthrope loupG;
    private List<Creature> proches;
    private double chanceDeContamination = Math.random(); // Génère un nombre entre 0 et 1

    @BeforeEach
    void setUp() {
        // Initialiser les créatures avant chaque test
        orque = new Orque("The Orqueee", "M", 120, 2.1, 30);
        elfe = new Elfe("Mathias l'elfe", "M", 80, 1.8, 20);
        loupG = new Lycanthrope("Loup-garou", "F", 100.0, 1.75, 40);

        // Liste des créatures proches
        proches = new ArrayList<>();
        proches.add(elfe);
        proches.add(loupG);

    }

    @Test
    void testCaracteristiquesDeBase() {
        assertEquals("The Orqueee", orque.getNomComplet());
        assertEquals("M", orque.getSexe());
        assertEquals(120, orque.getPoids());
        assertEquals(2.1, orque.getTaille());
        assertEquals(30, orque.getAge());
        assertEquals(0, orque.getMaladies().size());
        assertEquals(100, orque.getMoral()); 
    }

    @Test
    void testFaireAttendre() {
        elfe.attendre(proches);
        assertTrue(elfe.getMoral() == 90); // Vérifie que le moral diminue de -10
    }

    @Test
    void testHurlerSiMoralBas() {
        elfe.setMoral(15);
        elfe.hurler(proches); // Ne doit pas hurler car moral > 10
        assertTrue(elfe.getMoral() >= 10);

        elfe.setMoral(5);
        elfe.hurler(proches); // Doit hurler car moral < 10
        assertTrue(elfe.getMoral() < 10);
    }

    @Test
    void testSEmporterSiHurlementsConsecutifs() {
        elfe.setMoral(5);
        elfe.hurler(proches);
        elfe.hurler(proches);
        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));
        elfe.sEmporter(proches,chanceDeContamination);
        assertTrue(consoleOutput.toString().contains("s'emporte avec fureur"));
        
    }

    @Test
    void testTomberMalade() {
        Maladie mdc = Maladie.creerMaladie("MDC");
        orque.tomberMalade(mdc);

        assertTrue(orque.getMaladies().contains(mdc));
    }

    @Test
    void testEtreSoignee() {
        Maladie mdc = Maladie.creerMaladie("MDC");
        orque.tomberMalade(mdc);
        orque.etreSoignee();

        assertTrue(orque.getMaladies().isEmpty());
        assertTrue(orque.getMoral() == 90); //recuperer de la vie
    }

    @Test
    void testTrepasserSiTropMalade() {
        Maladie mdc = Maladie.creerMaladie("MDC");
        elfe.tomberMalade(mdc);
        mdc.augmenterNiveau(mdc.getNiveauMax());

        assertTrue(elfe.estMort());
    }

@Test
void testSEmporterContamineProches() throws Exception{
    loupG.setMoral(8);
    Maladie zpl = Maladie.creerMaladie("ZPL");
    

    loupG.hurler(proches);
    loupG.hurler(proches);
    ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    System.setOut(new PrintStream(consoleOutput)); // Rediriger System.out

    // Cas 1 : Le loup n'est pas malade, il ne devrait pas contaminer
    loupG.sEmporter(proches,chanceDeContamination); // Appelez la méthode que vous testez

    // Vérifier si la phrase de non-contamination a été affichée
    //assertTrue(consoleOutput.toString().contains(loupG.getNomComplet() + " n'est pas malade donc ne contamine pas"));

    // Réinitialiser la sortie après le test
    System.setOut(System.out); 
	
    // Cas 2 : Le loupG tombe malade et il devrait contaminer
    loupG.tomberMalade(zpl);
    loupG.sEmporter(proches,1); // Appeler sEmporter
    // Vérifier si la phrase de contamination a été affichée
    assertTrue(consoleOutput.toString().contains(loupG.getNomComplet() + " contamine " + elfe.getNomComplet() + " avec " + zpl + " en s'emportant."));
    
    // Réinitialiser la sortie après le test
    System.setOut(System.out); 
    
}
@Test
void testSEmporterContaminePasProches() throws Exception{
	Maladie zpl = Maladie.creerMaladie("ZPL");
	
	ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    System.setOut(new PrintStream(consoleOutput)); // Rediriger System.out
    
    loupG.hurler(proches);
    loupG.hurler(proches);
    
	elfe.tomberMalade(zpl);
	elfe.sEmporter(proches,0); // Appeler sEmporter
	assertTrue(consoleOutput.toString().contains("Pas de contamination cette fois. "));
	
	// Réinitialiser la sortie après le test
	System.setOut(System.out); 
	}

}



