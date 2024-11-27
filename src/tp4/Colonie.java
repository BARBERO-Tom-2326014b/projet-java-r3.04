package tp4;

import java.util.*;

public class Colonie {
    private List<Meute> meutes;
    private String nom;

    // Constructeur
    public Colonie() {
        meutes = new ArrayList<>();
    }

    public Colonie(String nom) {
		this.nom=nom;
	}

	// Ajouter une meute à la colonie
    public void ajouterMeute(Meute meute) {
        meutes.add(meute);
    }

    // Afficher les meutes de la colonie
    public void afficherMeutes() {
        for (Meute meute : meutes) {
            meute.afficherLycanthropesDeLaMeute();
        }
    }

}

