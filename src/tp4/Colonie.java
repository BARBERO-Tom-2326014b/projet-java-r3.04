package tp4;

import java.util.*;

public class Colonie {
    private List<Meute> meutes;
    private String nom;

    public Colonie(String nom) {
		this.nom=nom;
		 meutes = new ArrayList<>();
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Meute> getMeutes() {
		return meutes;
	}

	public void setMeutes(List<Meute> meutes) {
		this.meutes = meutes;
	}

	
    
    

}

