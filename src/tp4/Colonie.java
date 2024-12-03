package tp4;

import java.util.*;

/**
 * Représente une colonie composée de plusieurs meutes.
 * Une colonie a un nom et peut contenir une liste de meutes.
 */
public class Colonie {
    
    /** Liste des meutes appartenant à la colonie */
    private List<Meute> meutes;
    
    /** Nom de la colonie */
    private String nom;

    /**
     * Constructeur de la classe Colonie.
     * Initialise une nouvelle colonie avec le nom donné et une liste vide de meutes.
     * 
     * @param nom Le nom de la colonie
     */
    public Colonie(String nom) {
        this.nom = nom;
        meutes = new ArrayList<>();
    }

    /**
     * Ajoute une meute à la colonie.
     * 
     * @param meute La meute à ajouter à la colonie
     */
    public void ajouterMeute(Meute meute) {
        meutes.add(meute);
    }

    /**
     * Affiche toutes les meutes de la colonie, en appelant la méthode 
     * afficherLycanthropesDeLaMeute pour chaque meute.
     */
    public void afficherMeutes() {
        for (Meute meute : meutes) {
            meute.afficherLycanthropesDeLaMeute();
        }
    }

    /**
     * Récupère le nom de la colonie.
     * 
     * @return Le nom de la colonie
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la colonie.
     * 
     * @param nom Le nouveau nom de la colonie
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère la liste des meutes de la colonie.
     * 
     * @return La liste des meutes
     */
    public List<Meute> getMeutes() {
        return meutes;
    }

    /**
     * Modifie la liste des meutes de la colonie.
     * 
     * @param meutes La nouvelle liste de meutes
     */
    public void setMeutes(List<Meute> meutes) {
        this.meutes = meutes;
    }
}
