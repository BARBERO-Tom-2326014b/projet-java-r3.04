package tp4;

import java.util.Random;

/**
 * Représente un lycanthrope (être surnaturel capable de se transformer en loup).
 * Un lycanthrope a des caractéristiques comme le sexe, l'âge, la force, le niveau et le rang, ainsi qu'une meute associée.
 */
public class Lycanthrope {
    
    /** Sexe du lycanthrope (true = mâle, false = femelle) */
    private boolean sexe;
    
    /** Catégorie d'âge du lycanthrope (jeune, adulte, vieux) */
    private String categorieAge;
    
    /** Force physique du lycanthrope */
    private int force;
    
    /** Rang du lycanthrope dans la meute */
    private String rang;
    
    /** Niveau du lycanthrope (critère de qualité) */
    private int niveau;
    
    /** Nom du lycanthrope */
    private String nom;
    
    /** Instance de Random pour la génération de valeurs aléatoires */
    private Random random = new Random();
    
    /** Meute à laquelle appartient le lycanthrope */
    private Meute Meute;
  
    /**
     * Constructeur de la classe Lycanthrope.
     * Initialise un lycanthrope avec un sexe, une force, un niveau, un nom et une catégorie d'âge aléatoire.
     * 
     * @param sexe Le sexe du lycanthrope (true = mâle, false = femelle)
     * @param force La force physique du lycanthrope
     * @param facteurDomination Facteur de domination pour déterminer des comportements liés à la force
     * @param niveau Le niveau du lycanthrope (critère de qualité)
     * @param nom Le nom du lycanthrope
     */
    public Lycanthrope(boolean sexe, int force, float facteurDomination, int niveau, String nom, int age) {
        switch (age) {
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

    /**
     * Récupère le rang du lycanthrope.
     * 
     * @return Le rang du lycanthrope
     */
    public String getRang() {
        return this.rang;
    }

    /**
     * Fait vieillir le lycanthrope, en changeant sa catégorie d'âge (Jeune -> Adulte -> Vieux).
     */
    public void vieillir() {
        if (this.getCategorieAge().equals("Jeune")) {
            this.setCategorieAge("Adulte");
        } else if (this.getCategorieAge().equals("Adulte")) {
            this.setCategorieAge("Vieux");
        } else {
            this.setCategorieAge("Vieux");
        }
        System.out.println("Le lycanthrope " + this.getNom() + " a vieilli");
    }

    /**
     * Modifie la force du lycanthrope aléatoirement (augmente ou diminue de 5).
     */
    public void changerForce() {
        int force = this.getForce();
        int proba = random.nextInt(2);
        if (proba == 0) {
            this.setForce(force - 5);
            System.out.println("La force de " + this.getNom() + " a baissé de 5");
        } else {
            this.setForce(force + 5);
            System.out.println("La force de " + this.getNom() + " a augmenté de 5");
        }
    }

    /**
     * Effectue un hurlement de la part du lycanthrope.
     * 
     * @return Le hurlement du lycanthrope sous forme de chaîne
     */
    public String hurler() {
        return "Hurlement de " + nom + " (Rang: " + rang + ")";
    }

    /**
     * Transforme le lycanthrope en humain si son niveau est supérieur à 5,
     * sinon il reste un lycanthrope et ne peut pas se transformer.
     * Le lycanthrope est également retiré de sa meute dans le cas d'une transformation.
     * 
     * @param meute La meute à laquelle le lycanthrope appartient
     */
    public void transformerHumain(Meute meute) {
        if (niveau > 5) {
            System.out.println(nom + " se transforme en humain. Il ne fait donc plus partie de la meute.");
            meute.enleverLycanthropes(this);
        } else {
            System.out.println(nom + " ne peut pas se transformer en humain.");
        }
    }

    // Getters et setters pour chaque attribut

    /**
     * Récupère le nom du lycanthrope.
     * 
     * @return Le nom du lycanthrope
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du lycanthrope.
     * 
     * @param nom Le nouveau nom du lycanthrope
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le sexe du lycanthrope.
     * 
     * @return true si mâle, false si femelle
     */
    public boolean isSexe() {
        return sexe;
    }

    /**
     * Modifie le sexe du lycanthrope.
     * 
     * @param sexe Le sexe du lycanthrope
     */
    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    /**
     * Récupère la meute du lycanthrope.
     * 
     * @return La meute à laquelle appartient le lycanthrope
     */
    public Meute getMeute() {
        return Meute;
    }

    /**
     * Récupère la catégorie d'âge du lycanthrope.
     * 
     * @return La catégorie d'âge du lycanthrope (Jeune, Adulte, Vieux)
     */
    public String getCategorieAge() {
        return this.categorieAge;
    }

    /**
     * Modifie la catégorie d'âge du lycanthrope.
     * 
     * @param categorieAge La nouvelle catégorie d'âge
     */
    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    /**
     * Récupère la force du lycanthrope.
     * 
     * @return La force du lycanthrope
     */
    public int getForce() {
        return force;
    }

    /**
     * Modifie la force du lycanthrope.
     * 
     * @param force La nouvelle force du lycanthrope
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Récupère le niveau du lycanthrope.
     * 
     * @return Le niveau du lycanthrope
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Modifie le niveau du lycanthrope.
     * 
     * @param niveau Le nouveau niveau du lycanthrope
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    /**
     * Affiche les caractéristiques complètes du lycanthrope.
     */
    public void afficherCaracteristiques() {
        if (sexe) {
            System.out.println("Lycanthrope [sexe= Mâle, categorieAge=" + this.categorieAge + ", force=" + force + ", rang=" + rang
                    + ", niveau=" + niveau + ", nom=" + nom + ", age=" + categorieAge +"]");
        } else {
            System.out.println("Lycanthrope [sexe= Femelle, categorieAge=" + this.categorieAge + ", force=" + force + ", rang=" + rang
                    + ", niveau=" + niveau + ", nom=" + nom +", age=" + categorieAge + "]");
        }
    }

    /**
     * Modifie le rang du lycanthrope.
     * 
     * @param rang Le nouveau rang du lycanthrope
     */
    public void setRang(String rang) {
        this.rang = rang;
    }

    /**
     * Modifie la meute à laquelle appartient le lycanthrope.
     * 
     * @param meute2 La nouvelle meute
     */
    public void setMeute(Meute meute2) {
        Meute = meute2;
    }
}
