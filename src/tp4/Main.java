package tp4;

public class Main {
    public static void main(String[] args) {
        // Création de la colonie de lycanthropes
        Colonie colonie = new Colonie("Colonie des Loups-Garous");

        // Création des lycanthropes avec des caractéristiques spécifiques
        Lycanthrope lycanthrope1 = new Lycanthrope(true, "adulte", 90, 8.0f, "α", 15, 4.5f, "Meute des Loups", "Léo");
        //Lycanthrope lycanthrope2 = new Lycanthrope(false, "adulte", 75, 6.5f, "α", 12, 4.0f, "Meute des Loups", "Luna");
        Lycanthrope lycanthrope3 = new Lycanthrope(true, "jeune", 70, 5.0f, "β", 6, 5.0f, "Meute des Loups", "Max");
        Lycanthrope lycanthrope4 = new Lycanthrope(false, "jeune", 65, 4.8f, "β", 5, 5.2f, "Meute des Loups", "Mia");
        Lycanthrope lycanthrope5 = new Lycanthrope(true, "vieux", 60, 7.0f, "γ", 9, 3.8f, "Meute des Loups", "Rex");
        Lycanthrope lycanthrope6 = new Lycanthrope(false, "vieux", 55, 7.5f, "γ", 8, 4.0f, "Meute des Loups", "Eira");
        Lycanthrope lycanthrope10 = new Lycanthrope(false, "vieux", 55, 7.5f, "γ", 8, 4.0f, "Meute des Loups", "Tommy");

        // Création de la meute
        Meute meuteDesLoups = new Meute("Meute des Loups");

        // Ajout des lycanthropes à la meute
        meuteDesLoups.ajouterMembre(lycanthrope1);
        //meuteDesLoups.ajouterMembre(lycanthrope2);
        meuteDesLoups.ajouterMembre(lycanthrope3);
        meuteDesLoups.ajouterMembre(lycanthrope4);
        meuteDesLoups.ajouterMembre(lycanthrope5);
        meuteDesLoups.ajouterMembre(lycanthrope6);

        // Affichage de la meute avant la définition du couple alpha
        System.out.println("Avant définition du couple alpha :");
        meuteDesLoups.afficherLycanthropesDeLaMeute();

        // Définir le couple alpha
        meuteDesLoups.definirCoupleAlpha();

        // Affichage des membres de la meute après avoir défini le couple alpha
        System.out.println("\nAprès définition du couple alpha :");
        meuteDesLoups.afficherLycanthropesDeLaMeute();

        // Vérification de la présence de conflit de domination
        if (meuteDesLoups.estConflitPresent()) {
            System.out.println("\nUn conflit de domination est présent dans la meute.");
        } else {
            System.out.println("\nAucun conflit de domination dans la meute.");
        }

       System.out.println();

    
        System.out.println("\nTransformation de Léo en humain...");
        lycanthrope1.transformerHumain();
        meuteDesLoups.afficherLycanthropesDeLaMeute(); // Affiche la colonie après transformation

        // Essayer de redéfinir le couple alpha après la transformation
        System.out.println("\nTentative de redéfinition du couple alpha après transformation de Léo...");
        meuteDesLoups.definirCoupleAlpha();
        meuteDesLoups.ajouterMembre(lycanthrope10);
        meuteDesLoups.afficherLycanthropesDeLaMeute();
    }
}


