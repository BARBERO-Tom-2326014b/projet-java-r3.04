package tp4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLycanthrope {
    
    private Lycanthrope lycanthrope1;
    private Lycanthrope lycanthrope2;
    private Meute meute;

    @BeforeEach
    void setUp() {
        // Créer un objet Meute fictif pour tester
        meute = new Meute("Meute des Lunes");
        
        // Créer des Lycanthropes avec différents sexes, forces et niveaux
        lycanthrope1 = new Lycanthrope(true, 50, 1.0f, 6, "Lupo",2);
        lycanthrope2 = new Lycanthrope(false, 40, 1.2f, 3, "Luna",2);
    }

    @Test
    void testLycanthropeCreation() {
        assertNotNull(lycanthrope1);
        assertEquals("Lupo", lycanthrope1.getNom());
        assertTrue(lycanthrope1.isSexe()); // Mâle
        assertEquals(50, lycanthrope1.getForce());
        assertTrue(lycanthrope1.getNiveau() > 5); // Niveau doit être 6 ou plus
        
        assertNotNull(lycanthrope2);
        assertEquals("Luna", lycanthrope2.getNom());
        assertFalse(lycanthrope2.isSexe()); // Femelle
        assertEquals(40, lycanthrope2.getForce());
        assertTrue(lycanthrope2.getNiveau() <= 5); // Niveau doit être 3 ou moins
    }

    @Test
    void testVieillir() {
        String initialAge = lycanthrope1.getCategorieAge();
        lycanthrope1.vieillir();
        assertNotEquals(initialAge, "Le lycanthrope " + lycanthrope1.getNom() + " a vieilli"); // Le lycanthrope devrait vieillir
    }

    @Test
    void testChangerForce() {
        int initialForce = lycanthrope2.getForce();
        lycanthrope2.changerForce();
        assertNotEquals(initialForce, lycanthrope2.getForce()); // La force doit avoir changé
    }

    @Test
    void testHurler() {
        String hurlement = lycanthrope1.hurler();
        assertTrue(hurlement.contains("Hurlement de " + lycanthrope1.getNom())); 
    }

    @Test
    void testTransformationHumain() {
    	lycanthrope1.setMeute(meute);
    	lycanthrope2.setMeute(meute);
        // Test de la transformation en humain pour un niveau supérieur à 5
        lycanthrope1.transformerHumain(meute);
        assertFalse(meute.getLycanthropes().contains(lycanthrope1), "Le lycanthrope 1 devrait être retiré de la meute.");
        // Test pour un niveau inférieur à 5
        lycanthrope2.transformerHumain(meute);
        assertNotNull(lycanthrope2.getMeute()); // Il fait toujours partie de la meute
    }

    @Test
    void testAfficherCaracteristiques() {
        // Cette méthode affiche dans la console, mais nous allons juste vérifier qu'elle ne génère pas d'exception
        try {
            lycanthrope1.afficherCaracteristiques();
            lycanthrope2.afficherCaracteristiques();
        } catch (Exception e) {
            fail("La méthode afficherCaracteristiques a échoué : " + e.getMessage());
        }
    }

    @Test
    void testMeute() {
        // Ajouter les lycanthropes à la meute
        lycanthrope1.setMeute(meute);
        lycanthrope2.setMeute(meute);
        assertEquals(meute, lycanthrope1.getMeute()); // Vérifier qu'ils font partie de la même meute
        assertEquals(meute, lycanthrope2.getMeute());

        // Tester la séparation d'une meute
        lycanthrope1.transformerHumain(meute); // Il doit quitter la meute après transformation
        assertFalse(meute.getLycanthropes().contains(lycanthrope1), "Le lycanthrope 1 devrait être retiré de la meute.");// Lycanthrope1 ne fait plus partie de la meute
    }
}

