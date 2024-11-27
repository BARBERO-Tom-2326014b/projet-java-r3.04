package tp4;

public class TypeHurlement {
    private String type; // Type de hurlement (dominant, appel, alerte, etc.)
    private String description;

    // Constructeur
    public TypeHurlement(String type, String description) {
        this.type = type;
        this.description = description;
    }

    // Afficher le type de hurlement
    public String afficherTypeHurlement() {
        return "Type de Hurlement: " + type + " - Description: " + description;
    }

}

