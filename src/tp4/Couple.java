package tp4;

import java.util.ArrayList;
import java.util.List;

public class Couple {
    private Lycanthrope male;
    private Lycanthrope femelle;

    // Constructeur
    public Couple(Lycanthrope male, Lycanthrope femelle) {
        this.male = male;
        this.femelle = femelle;
    }

    // Afficher les caractéristiques du couple
    public String afficherCaracteristiqueCouple() {
        return "Couple: " + male.getNom() + " et " + femelle.getNom();
    }

    // Réaliser la reproduction (créer des lycanthropes)
    public List<Lycanthrope> realiserReproduction() {
        List<Lycanthrope> portee = new ArrayList<>();
        int nombreDeJeunes = (int) (Math.random() * 7) + 1; // Nombre aléatoire entre 1 et 7
        for (int i = 0; i < nombreDeJeunes; i++) {
            // Créer un nouveau lycanthrope, avec un rang γ par exemple
            Lycanthrope jeune = new Lycanthrope(Math.random() > 0.5, "jeune", 50, 0.0f, "γ", 1, 1.0f, "Meute", "Jeune_" + i);
            portee.add(jeune);
        }
        return portee;
    }

    public Lycanthrope getMale() {
        return male;
    }

    public void setMale(Lycanthrope male) {
        this.male = male;
    }

    public Lycanthrope getFemelle() {
        return femelle;
    }

    public void setFemelle(Lycanthrope femelle) {
        this.femelle = femelle;
    }

}


