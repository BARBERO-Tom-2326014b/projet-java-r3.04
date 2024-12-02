package tp4;

import java.util.ArrayList;
import java.util.List;

public class Meute {
    private String nom;
    private ArrayList<Lycanthrope> lycanthropes = new ArrayList<Lycanthrope>();
    private ArrayList<Lycanthrope> coupleAlpha = new ArrayList<Lycanthrope>();

    public Meute(String nom) {
        this.nom = nom;
        this.lycanthropes = new ArrayList<>();
        this.coupleAlpha = null;
    }

    // Ajouter un lycanthrope à la meute
    public void ajouterMembre(Lycanthrope lycanthrope) {
        this.lycanthropes.add(lycanthrope);
        
    }

    // Définir le couple Alpha (mâle et femelle les plus forts)
    public void definirCoupleAlpha() {
        Lycanthrope meilleurMâle = null;
        Lycanthrope meilleureFemelle = null;

        // Trouver le meilleur mâle
        for (Lycanthrope l : lycanthropes) {
            if (l.isSexe() && l.getCategorieAge().equals("adulte")) { // Mâle adulte
                if (meilleurMâle == null || l.getForce() > meilleurMâle.getForce()) {
                    meilleurMâle = l;
                }
            }
        }

        // Trouver la meilleure femelle
        for (Lycanthrope l : lycanthropes) {
            if (!l.isSexe() && l.getCategorieAge().equals("adulte")) { // Femelle adulte
                if (meilleureFemelle == null || l.getForce() > meilleureFemelle.getForce()) {
                    meilleureFemelle = l;
                }
            }
        }

        // Si un mâle et une femelle ont été trouvés, les désigner comme couple Alpha
        if (meilleurMâle != null && meilleureFemelle != null) {
        	coupleAlpha.clear();
            coupleAlpha.add(meilleureFemelle);
            coupleAlpha.add(meilleurMâle);
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
    public ArrayList<Lycanthrope> getCoupleAlpha() {
        return this.coupleAlpha;
    }

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
		
	}
		
	}



