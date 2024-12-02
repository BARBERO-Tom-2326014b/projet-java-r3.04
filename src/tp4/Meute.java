package tp4;

import java.util.ArrayList;
import java.util.List;

public class Meute {
    private String nom;
    private ArrayList<Lycanthrope> lycanthropes = new ArrayList<Lycanthrope>();
    private Couple couple = new Couple(null,null);

    public Meute(String nom) {
        this.nom = nom;
        this.lycanthropes = new ArrayList<>();
        
    }

    // Ajouter un lycanthrope à la meute
    public void ajouterMembre(Lycanthrope lycanthrope) {
        this.lycanthropes.add(lycanthrope);
        lycanthrope.setMeute(this);
        
    }

    // Définir le couple Alpha (mâle et femelle les plus forts)
    public void definirCoupleAlpha() {
        Lycanthrope meilleurMâle = null;
        Lycanthrope meilleureFemelle = null;

        // Trouver le meilleur mâle
        for (Lycanthrope l : lycanthropes) {
            if (l.isSexe() && l.getCategorieAge().equals("Adulte")) { // Mâle adulte
                if (meilleurMâle == null || l.getForce() > meilleurMâle.getForce()) {
                    meilleurMâle = l;
                }
            }
        }

        // Trouver la meilleure femelle
        for (Lycanthrope l : lycanthropes) {
            if (!l.isSexe() && l.getCategorieAge().equals("Adulte")) { // Femelle adulte
                if (meilleureFemelle == null || l.getForce() > meilleureFemelle.getForce()) {
                    meilleureFemelle = l;
                }
            }
        }

        // Si un mâle et une femelle ont été trouvés, les désigner comme couple Alpha
        if (meilleurMâle != null && meilleureFemelle != null) {
        	couple.setFemelle(meilleureFemelle);
        	couple.setMale(meilleurMâle);
            System.out.println("Couple Alpha défini: " + meilleurMâle.getNom() + " et " + meilleureFemelle.getNom());
        } else {
            System.out.println("Impossible de définir un couple Alpha: Mâle et/ou Femelle non trouvés.");
        }
    }

    // Méthode pour afficher les membres de la meute
    public void afficherLycanthropesDeLaMeute() {
        System.out.println("Membres de la meute :" + nom + ":");
        for (Lycanthrope l : lycanthropes) {
            l.afficherCaracteristiques();
        }
    }

    // Getter pour obtenir le couple Alpha

    // Getters et setters pour le nom et les lycanthropes
    public String getNom() {
        return this.nom;
    }

    public List<Lycanthrope> getLycanthropes() {
        return this.lycanthropes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


	public void enleverLycanthropes(Lycanthrope l) {
    			lycanthropes.remove(l);
    		
    	}
	public void hierarchie() {
	    // Séparer les lycanthropes par sexe
	    ArrayList<Lycanthrope> males = new ArrayList<>();
	    ArrayList<Lycanthrope> femelles = new ArrayList<>();

	    for (Lycanthrope l : lycanthropes) {
	        if (l.isSexe()) { // Sexe vrai = mâle
	            males.add(l);
	        } else { // Sexe faux = femelle
	            femelles.add(l);
	        }
	    }

	    // Trier les mâles et les femelles par force décroissante
	    males.sort((a, b) -> Integer.compare(b.getForce(), a.getForce()));
	    femelles.sort((a, b) -> Integer.compare(b.getForce(), a.getForce()));

	    // Attribuer les rangs aux mâles
	    System.out.println("Hiérarchie des mâles :");
	    attribuerRangs(males);

	    // Attribuer les rangs aux femelles
	    System.out.println("Hiérarchie des femelles :");
	    attribuerRangs(femelles);
	}

	// Méthode utilitaire pour attribuer les rangs à une liste de lycanthropes
	private void attribuerRangs(ArrayList<Lycanthrope> lycanthropes) {
	    int total = lycanthropes.size();

	    for (int i = 0; i < total; i++) {
	        Lycanthrope lycanthrope = lycanthropes.get(i);

	        // Attribuer les rangs en fonction de la position
	        if (i == 0) {
	            lycanthrope.setRang("Alpha");
	        } else if (i < total / 3) {
	            lycanthrope.setRang("Beta");
	        } else if (i < (2 * total) / 3) {
	            lycanthrope.setRang("Omega");
	        } else {
	            lycanthrope.setRang("Zeta");
	        }

	        // Afficher le rang
	        System.out.println(lycanthrope.getNom() + " - Rang : " + lycanthrope.getRang());
	    }
	}
		
	}



