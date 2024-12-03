package tp4;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une meute de lycanthropes, qui peut contenir des membres (lycanthropes) et définir un couple Alpha.
 * La meute permet de gérer les membres, définir leur hiérarchie, afficher les informations des lycanthropes et gérer les couples Alpha.
 */
public class Meute {
    
    /** Nom de la meute */
    private String nom;
    
    /** Liste des lycanthropes qui appartiennent à cette meute */
    private ArrayList<Lycanthrope> lycanthropes = new ArrayList<Lycanthrope>();
    
    /** Couple Alpha (mâle et femelle les plus forts de la meute) */
    private Couple couple = new Couple(null, null);

    /**
     * Constructeur de la classe Meute.
     * 
     * @param nom Le nom de la meute
     */
    public Meute(String nom) {
        this.nom = nom;
        this.lycanthropes = new ArrayList<>();
    }

    /**
     * Ajoute un lycanthrope à la meute.
     * 
     * @param lycanthrope Le lycanthrope à ajouter à la meute
     */
    public void ajouterMembre(Lycanthrope lycanthrope) {
        this.lycanthropes.add(lycanthrope);
        lycanthrope.setMeute(this);
    }

    /**
     * Définit le couple Alpha de la meute, en sélectionnant le mâle et la femelle les plus forts (adultes).
     * 
     * @return Le couple Alpha de la meute
     */
    public Couple definirCoupleAlpha() {
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
            System.out.println("Impossible de définir un couple Alpha: Mâle Adulte et/ou Femelle Adulte non trouvés.");
        }
        return couple;
    }

    /**
     * Affiche les caractéristiques de tous les membres de la meute.
     */
    public void afficherLycanthropesDeLaMeute() {
        System.out.println("Membres de la meute: " + nom + ":");
        for (Lycanthrope l : lycanthropes) {
            l.afficherCaracteristiques();
        }
    }

    /**
     * Récupère le nom de la meute.
     * 
     * @return Le nom de la meute
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Récupère la liste des lycanthropes dans la meute.
     * 
     * @return La liste des lycanthropes
     */
    public List<Lycanthrope> getLycanthropes() {
        return this.lycanthropes;
    }

    /**
     * Modifie le nom de la meute.
     * 
     * @param nom Le nouveau nom de la meute
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Enlève un lycanthrope de la meute.
     * 
     * @param l Le lycanthrope à retirer de la meute
     */
    public void enleverLycanthropes(Lycanthrope l) {
        lycanthropes.remove(l);
    }

    /**
     * Définit la hiérarchie des lycanthropes dans la meute.
     * Les lycanthropes sont séparés par sexe, triés par force, puis rangs attribués.
     */
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

    /**
     * Méthode utilitaire pour attribuer des rangs à une liste de lycanthropes.
     * Les rangs sont attribués en fonction de la position dans la liste triée par force.
     * 
     * @param lycanthropes Liste de lycanthropes triée par force
     */
    private void attribuerRangs(ArrayList<Lycanthrope> lycanthropes) {
        int total = lycanthropes.size();

        for (int i = 0; i < total; i++) {
            Lycanthrope lycanthrope = lycanthropes.get(i);

            // Attribuer les rangs en fonction de la position
            if (i == 0) {
                lycanthrope.setRang("α");
            } else if (i < total / 3) {
                lycanthrope.setRang("β");
            } else if (i < (2 * total) / 3) {
                lycanthrope.setRang("ε");
            } else {
                lycanthrope.setRang("ω");
            }

            // Afficher le rang
            System.out.println(lycanthrope.getNom() + " - Rang : " + lycanthrope.getRang());
        }
    }

    /**
     * Récupère le couple Alpha de la meute.
     * 
     * @return Le couple Alpha de la meute
     */
    public Couple getCouple() {
        return this.couple;
    }

    /**
     * Modifie le couple Alpha de la meute.
     * 
     * @param couple Le nouveau couple Alpha
     */
    public void setCouple(Couple couple) {
        this.couple = couple;
    }
}
