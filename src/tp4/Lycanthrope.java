package tp4;


import java.util.Random;

public class Lycanthrope {
    private boolean sexe; // true = mâle, false = femelle
    private String categorieAge; // "jeune", "adulte", "vieux"
    private int force; // Force physique
    private String rang;
    private int niveau; // Critère de qualite
    private String nom; // Nom du lycanthrope
    private Random random = new Random();
    private Meute Meute;
  
    

    // Constructeur
    public Lycanthrope(boolean sexe, int force, float facteurDomination, int niveau, String nom) {
    	//int choix=random.nextInt(3);
    	int choix =random.nextInt(3);
    	switch (choix) {
    	case 0:
    		this.categorieAge = "Jeune";
    		break;
    	case 1:
    		this.categorieAge = "Adulte";
    		break;
    	case 2:
    		this.categorieAge = "Vieux";
    		break;
    		
    	}
    	
        this.sexe = sexe;
        this.force = force;
        this.rang = null;
        this.niveau = niveau;
        this.nom = nom;
        this.Meute = null;
    }
   

    // Getter pour le rang
    public String getRang() {
        return this.rang;
    }
    
    public void vieillir() {
    	if(this.getCategorieAge()=="Jeune") {
    		this.setCategorieAge("Adulte");
    	}
    	else if (this.getCategorieAge()=="Adulte"){
    		this.setCategorieAge("Vieux");
    	}
    	else {
    		this.setCategorieAge("Vieux");
    	}
    	System.out.println("Le lycanthrope"+this.getNom()+" a viellit");
    }
    
    public void changerForce() {
    	int force = this.getForce();
    	int proba = random.nextInt(2);
    	if(proba==0) {
    	this.setForce(force-5);
    	System.out.println("La force de "+this.getNom()+" a baisser de 5");
    	}
    	else {
    		this.setForce(force+5);
    	}
    	System.out.println("La force de "+this.getNom()+" a augmenter de 5");
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
    

    public Meute getMeute() {
		return Meute;
	}



	public String getCategorieAge() {
        return this.categorieAge;
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
			System.out.println( "Lycanthrope [sexe= Male" + ", categorieAge=" + this.categorieAge + ", force=" + force + ", rang=" + rang
					+ ", niveau=" + niveau + ", nom=" + nom + "]");
		}
		else {
			System.out.println( "Lycanthrope [sexe= Femelle" + ", categorieAge=" + this.categorieAge + ", force=" + force + ", rang=" + rang
					+ ", niveau=" + niveau + ", nom=" + nom + "]");
		}
		
	}




	public void setRang(String rang) {
		this.rang = rang;
	}


	public void setMeute(Meute meute2) {
		Meute = meute2;
		
	}
    
    

}



