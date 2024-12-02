package personnage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



class TestCreature {
    private Orque orque;
    private Elfe elfe;
    private Lycanthrope loupG;
    private List<Creature> proches;

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
        elfe.sEmporter(proches);
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

        /*// Cas 1 : Le loup n'est pas malade, il ne devrait pas contaminer
        loupG.sEmporter(proches); // Appelez la méthode que vous testez

        // Vérifier si la phrase de non-contamination a été affichée
        assertTrue(consoleOutput.toString().contains(loupG.getNomComplet() + " n'est pas malade donc ne contamine pas"));

        // Réinitialiser la sortie après le test
        System.setOut(System.out); 
		*/
        // Cas 2 : Le loupG tombe malade et il devrait contaminer
        loupG.tomberMalade(zpl);
        loupG.sEmporter(proches); // Appeler sEmporter
        // Vérifier si la phrase de contamination a été affichée
        assertTrue(consoleOutput.toString().contains(loupG.getNomComplet() + " contamine " + elfe.getNomComplet() + " avec " + zpl + " en s'emportant."));
        
        // Réinitialiser la sortie après le test
        System.setOut(System.out); 
        
    }

}

class TestMaladie {

    private List<Maladie> maladies;
    private Orque orque;
    private Elfe elfe;

    @BeforeEach
    void setUp() {
        // Initialisation des maladies spécifiques
        maladies = Arrays.asList(
            Maladie.creerMaladie("MDC"), // Maladie débilitante chronique
            Maladie.creerMaladie("FOMO"), // Syndrome fear of missing out
            Maladie.creerMaladie("DRS"), // Dépendance aux réseaux sociaux
            Maladie.creerMaladie("PEC"), // Porphyrie érythropoïétique congénitale
            Maladie.creerMaladie("ZPL"), // Zoopathie paraphrénique lycanthropique
            Maladie.creerMaladie("NDMAD") // Narcolepsie délirante maléfique auto-destructrice
        );

        // Création des créatures
        orque = new Orque("Tommy", "M", 120, 2.1, 30);
        elfe = new Elfe("Mathias", "F", 75, 1.9, 25);
    }

    @Test
    void testRendreUneCreatureMalade() {
        System.out.println("=== Test : rendre une créature malade ===");

        for (Maladie maladie : maladies) {
            orque.tomberMalade(maladie);

            // Vérifier que l'orque a bien contracté la maladie
            assertTrue(orque.getMaladies().contains(maladie), 
                "L'orque devrait être malade avec " + maladie.getNomComplet());
        }
    }

    @Test
    void testAugmentationEtDiminutionNiveauViaCreature() {
        System.out.println("=== Test : augmentation et diminution des niveaux de maladies via une créature ===");

        Maladie maladie = Maladie.creerMaladie("MDC");
        elfe.tomberMalade(maladie);

        // Augmenter le niveau via la maladie associée à la créature
        maladie.augmenterNiveau(5);
        assertEquals(5, maladie.getNiveauActuel(), 
            "Le niveau actuel de la maladie devrait être 5 après augmentation.");

        // Diminuer le niveau
        maladie.diminuerNiveau(3);
        assertEquals(2, maladie.getNiveauActuel(), 
            "Le niveau actuel de la maladie devrait être 2 après diminution.");
    }

    @Test
    void testChangementDeNiveauViaCreature() {
        System.out.println("=== Test : changement de niveau de maladie via une créature ===");

        Maladie maladie = Maladie.creerMaladie("FOMO");
        orque.tomberMalade(maladie);

        // Changer le niveau
        maladie.setNiveauActuel(4);
        assertEquals(4, maladie.getNiveauActuel(), 
            "Le niveau actuel de la maladie devrait être 4 après changement.");

        // Tenter de dépasser les limites
        maladie.setNiveauActuel(-1);
        assertEquals(0, maladie.getNiveauActuel(), 
            "Le niveau actuel de la maladie ne devrait pas être inférieur à zéro.");

        maladie.setNiveauActuel(maladie.getNiveauMax() + 1);
        assertEquals(maladie.getNiveauMax(), maladie.getNiveauActuel(), 
            "Le niveau actuel de la maladie ne devrait pas dépasser le niveau maximum.");
    }

    @Test
    void testNiveauLethalPourUneCreature() {
        System.out.println("=== Test : niveau létal pour une créature ===");

        Maladie maladie = Maladie.creerMaladie("ZPL");
        elfe.tomberMalade(maladie);

        // Amener la maladie au niveau létal
        maladie.setNiveauActuel(maladie.getNiveauMax());
        assertTrue(maladie.estLetale(), 
            "La maladie devrait être létale au niveau maximum.");

        // Vérifier si la créature est morte
        assertTrue(elfe.estMort(), "L'elfe devrait être mort à cause de la maladie létale.");
    }

    @Test
    void testPlusieursMaladiesPourUneCreature() {
        System.out.println("=== Test : gestion de plusieurs maladies pour une créature ===");

        orque.tomberMalade(Maladie.creerMaladie("DRS"));
        orque.tomberMalade(Maladie.creerMaladie("PEC"));

        // Vérifier que l'orque a bien les deux maladies
        List<Maladie> maladiesOrque = orque.getMaladies();
        assertEquals(2, maladiesOrque.size(), "L'orque devrait avoir exactement deux maladies.");
        assertTrue(maladiesOrque.stream().anyMatch(m -> m.getNomAbrege().equals("DRS")), 
            "L'orque devrait avoir la maladie 'DRS'.");
        assertTrue(maladiesOrque.stream().anyMatch(m -> m.getNomAbrege().equals("PEC")), 
            "L'orque devrait avoir la maladie 'PEC'.");
    }
}