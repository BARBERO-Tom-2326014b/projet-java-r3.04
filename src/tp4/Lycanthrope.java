package tp4;


import java.util.Random;

public class Lycanthrope {
    private boolean sexe; // true = mâle, false = femelle
    private String categorieAge; // "jeune", "adulte", "vieux"
    private int force; // Force physique
    private int rang;
    private int niveau; // Critère de qualite
    private String nom; // Nom du lycanthrope
    private Random random = new Random();
  
    

    // Constructeur
    public Lycanthrope(boolean sexe, int force, float facteurDomination, int rang, int niveau, String nom) {
    	int choix=random.nextInt(3);
    	switch (choix) {
    	case 1:
    		this.categorieAge = "Jeune";
    	case 2:
    		this.categorieAge = "Adulte";
    	case 3:
    		this.categorieAge = "Vieux";
    		
    	}
    	
        this.sexe = sexe;
        this.force = force;
        this.rang = rang;
        this.niveau = niveau;
        this.nom = nom;
    }
   

    // Getter pour le rang
    public int getRang() {
        return this.rang;
    }



    // Méthode pour effectuer un hurlement
    public String hurler() {
        return "Hurlement de " + nom + " (Rang: " + rang + ")";
    }

    // Méthode pour transformer le lycanthrope en humain
    public void transformerHumain(Meute meute) {
        if (niveau > 5) {
            System.out.println(nom + " se transforme en humain. Il ne fait donc plus partie de la meute ");
			meute.enleverLycanthropes(this);
            
        } else {
            System.out.println(nom + " ne peut pas se transformer en humain.");
        }
    }

    // Getters et setters pour chaque attribut
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }


    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }



	public void afficherCaracteristiques() {
		if(sexe==true) {
			System.out.println( "Lycanthrope [sexe= Male" + ", categorieAge=" + categorieAge + ", force=" + force + ", rang=" + rang
					+ ", niveau=" + niveau + ", nom=" + nom + "]");
		}
		else {
			System.out.println( "Lycanthrope [sexe= Femelle" + ", categorieAge=" + categorieAge + ", force=" + force + ", rang=" + rang
					+ ", niveau=" + niveau + ", nom=" + nom + "]");
		}
		
	}
    
    

}



