package personnage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        for (Maladie maladie : maladies) {
            orque.tomberMalade(maladie);

            // Vérifier que l'orque a bien contracté la maladie
            assertTrue(orque.getMaladies().contains(maladie), 
                "L'orque devrait être malade avec " + maladie.getNomComplet());
        }
    }

    @Test
    void testAugmentationEtDiminutionNiveauViaCreature() {
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
