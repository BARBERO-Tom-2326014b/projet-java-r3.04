package tp4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class TestMeute {

    private Meute meute;
    private Lycanthrope lycanthrope1;
    private Lycanthrope lycanthrope2;
    private Lycanthrope lycanthrope3;

    @BeforeEach
    void setUp() {
        // Initialisation des objets pour les tests
        meute = new Meute("MeuteAlpha");
        lycanthrope1 = new Lycanthrope(true, 80, 5.5f, 3, "Loup1",1);
        lycanthrope2 = new Lycanthrope(false, 70, 6.0f, 2, "Louve1",1);
        lycanthrope3 = new Lycanthrope(true, 90, 6.5f, 4, "Loup2",1);
    }

    @Test
    void testAjouterMembre() {
        // Ajouter des lycanthropes à la meute
        meute.ajouterMembre(lycanthrope1);
        meute.ajouterMembre(lycanthrope2);
        
        // Vérifier que les lycanthropes sont bien ajoutés
        assertTrue(meute.getLycanthropes().contains(lycanthrope1));
        assertTrue(meute.getLycanthropes().contains(lycanthrope2));
    }

    @Test
    void testDefinirCoupleAlpha() {
        // Ajouter des lycanthropes et définir un couple Alpha
        meute.ajouterMembre(lycanthrope1);
        meute.ajouterMembre(lycanthrope2);
        meute.ajouterMembre(lycanthrope3);
        
        Couple couple = meute.definirCoupleAlpha();
        // Vérifier que le couple Alpha a bien été défini
        assertNotNull(couple);
        assertTrue(couple.afficherCaracteristiqueCouple().contains(lycanthrope3.getNom()));
        assertTrue(couple.afficherCaracteristiqueCouple().contains(lycanthrope2.getNom()));
 
    }

    @Test
    void testAfficherLycanthropesDeLaMeute() {
        // Ajouter des lycanthropes et vérifier l'affichage
        meute.ajouterMembre(lycanthrope1);
        meute.ajouterMembre(lycanthrope2);
        
        // Vérifier que l'affichage des lycanthropes fonctionne (pas de retour direct à tester ici)
        meute.afficherLycanthropesDeLaMeute();
        // Ce test est plus visuel, tu peux vérifier la sortie dans la console
    }

    @Test
    void testHierarchie() {
        // Ajouter des lycanthropes avec différentes forces
        meute.ajouterMembre(lycanthrope1);
        meute.ajouterMembre(lycanthrope2);
        meute.ajouterMembre(lycanthrope3);
        
        // Vérifier la hiérarchie
        meute.hierarchie();
        // Ce test est plus visuel aussi, tu peux vérifier la sortie dans la console
    }

    @Test
    void testEnleverLycanthropes() {
        // Ajouter des lycanthropes à la meute
        meute.ajouterMembre(lycanthrope1);
        meute.ajouterMembre(lycanthrope2);
        
        // Enlever un lycanthrope de la meute
        meute.enleverLycanthropes(lycanthrope1);
        
        // Vérifier que le lycanthrope a bien été retiré
        assertFalse(meute.getLycanthropes().contains(lycanthrope1));
        assertTrue(meute.getLycanthropes().contains(lycanthrope2));
    }
    
    @Test
    void testRealiserReproduction() {
    	// Ajouter des lycanthropes à la meute
        meute.ajouterMembre(lycanthrope1);
        meute.ajouterMembre(lycanthrope2);
        
        Couple couple = meute.definirCoupleAlpha();
     // Vérifier que le couple Alpha a bien été défini
        assertNotNull(couple);
     // Vérifier que reproduction fonctionne
        List<Lycanthrope> portee=couple.realiserReproduction();
        assertNotNull(portee);
    }
}

