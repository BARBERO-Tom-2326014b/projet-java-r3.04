package tp4;

public class Lycanthrope {
    private boolean sexe; // true = mâle, false = femelle
    private String categorieAge; // "jeune", "adulte", "vieux"
    private int force; // Force physique
    private float facteurDomination; // Différence entre dominations exercées et subies
    private String rang; // Rang de domination (α, β, γ, etc.)
    private int niveau; // Critère de qualité
    private float facteurImpétuosité; // Facteur de comportement impulsif
    private String meute; // Meute à laquelle appartient le lycanthrope
    private String nom; // Nom du lycanthrope

    // Constructeur
    public Lycanthrope(boolean sexe, String categorieAge, int force, float facteurDomination, String rang, int niveau, float facteurImpétuosité, String meute, String nom) {
        this.sexe = sexe;
        this.categorieAge = categorieAge;
        this.force = force;
        this.facteurDomination = facteurDomination;
        this.rang = rang;
        this.niveau = niveau;
        this.facteurImpétuosité = facteurImpétuosité;
        this.meute = meute;
        this.nom = nom;
    }

    // Getter pour le rang
    public String getRang() {
        return this.rang;
    }

    // Afficher les caractéristiques du lycanthrope
    public void afficherCaracteristiques() {
        System.out.println("Nom: " + nom + ", Sexe: " + (sexe ? "Mâle" : "Femelle") + ", Age: " + categorieAge + ", Force: " + force + ", Rang: " + rang + ", Niveau: " + niveau);
    }

    // Méthode pour vérifier si ce lycanthrope est soumis à un autre
    public boolean estSoumis(Lycanthrope a) {
        if (this.rang.compareTo(a.getRang()) > 0) {
            return true; // Si son rang est inférieur (α > β, etc.), il est soumis
        }
        if (this.force < a.force) {
            return true; // Ce lycanthrope est soumis à l'autre
        }
        return false; // Sinon, il n'est pas soumis
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

    // Méthode pour vérifier si un lycanthrope peut dominer un autre
    public boolean peutDominer(Lycanthrope autre) {
        if (this.rang.compareTo(autre.getRang()) < 0 || (this.force > autre.force && this.facteurImpétuosité > 0.5)) {
            return true;
        }
        return false;
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

    public float getFacteurDomination() {
        return facteurDomination;
    }

    public void setFacteurDomination(float facteurDomination) {
        this.facteurDomination = facteurDomination;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public float getFacteurImpétuosité() {
        return facteurImpétuosité;
    }

    public void setFacteurImpétuosité(float facteurImpétuosité) {
        this.facteurImpétuosité = facteurImpétuosité;
    }

    public String getMeute() {
        return meute;
    }

    public void setMeute(String meute) {
        this.meute = meute;
    }

}



