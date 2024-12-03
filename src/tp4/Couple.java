package tp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représente un couple de lycanthropes.
 * Un couple est composé d'un lycanthrope mâle et d'un lycanthrope femelle, et il est responsable de la reproduction.
 */
public class Couple {
    
    /** Instance de la classe Random pour générer des valeurs aléatoires */
    private Random random = new Random();
    
    /** Liste contenant le mâle et la femelle du couple */
    private ArrayList<Lycanthrope> couple = new ArrayList<Lycanthrope>();

    /**
     * Constructeur de la classe Couple.
     * Initialise un couple de lycanthropes avec un mâle et une femelle donnés.
     * 
     * @param male Le lycanthrope mâle du couple
     * @param femelle Le lycanthrope femelle du couple
     */
    public Couple(Lycanthrope male, Lycanthrope femelle) {
        couple.clear();
        couple.add(male);
        couple.add(femelle);
    }

    /**
     * Modifie le lycanthrope mâle du couple.
     * 
     * @param lycan Le nouveau lycanthrope mâle
     */
    public void setMale(Lycanthrope lycan) {
        couple.set(0, lycan);
    }

    /**
     * Modifie le lycanthrope femelle du couple.
     * 
     * @param lycan Le nouveau lycanthrope femelle
     */
    public void setFemelle(Lycanthrope lycan) {
        couple.set(1, lycan);
    }

    /**
     * Vérifie si le couple est complet (c'est-à-dire s'il y a un mâle et une femelle).
     * 
     * @return true si le couple contient un mâle et une femelle, sinon false
     */
    public boolean getCouple() {
        if (this.couple.get(0) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Affiche les caractéristiques du couple (noms des lycanthropes).
     * 
     * @return Une chaîne de caractères représentant le couple, sous la forme "Couple: nom_male et nom_femelle"
     */
    public String afficherCaracteristiqueCouple() {
        return "Couple: " + couple.get(0).getNom() + " et " + couple.get(1).getNom();
    }

    /**
     * Effectue la reproduction du couple, créant une liste de lycanthropes jeunes.
     * Le nombre de jeunes est généré aléatoirement entre 1 et 7.
     * 
     * @return La liste des lycanthropes jeunes produits par la reproduction
     */
    public List<Lycanthrope> realiserReproduction() {
        List<Lycanthrope> portee = new ArrayList<>();
        int nombreDeJeunes = (int) (Math.random() * 7) + 1; // Nombre aléatoire entre 1 et 7
        for (int i = 0; i < nombreDeJeunes; i++) {
            // Créer un nouveau lycanthrope avec des caractéristiques aléatoires
            Lycanthrope jeune = new Lycanthrope(Math.random() > 0.5, random.nextInt(100), random.nextFloat(10), random.nextInt(10), "nom" + i);
            jeune.setCategorieAge("Jeune");
            portee.add(jeune);
        }
        return portee;
    }
}
