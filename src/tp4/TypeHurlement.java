package tp4;

/**
 * Représente un type de hurlement d'un lycanthrope, avec une description associée.
 * Cette classe permet de spécifier le type de hurlement et d'afficher sa description.
 */
public class TypeHurlement {
    private String type; // Type de hurlement (dominant, appel, alerte, etc.)
    private String description;

    /**
     * Constructeur de la classe {@code TypeHurlement}.
     * 
     * @param type Le type de hurlement (par exemple, "dominant", "appel", "alerte", etc.)
     * @param description La description du type de hurlement
     */
    public TypeHurlement(String type, String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du type de hurlement et de sa description.
     * 
     * @return Une chaîne représentant le type de hurlement et sa description
     */
    public String afficherTypeHurlement() {
        return "Type de Hurlement: " + type + " - Description: " + description;
    }
}
