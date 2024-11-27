package tp4;

public class Hurlement {
    private Lycanthrope lycanthrope;
    private String typeHurlement; // Type de hurlement (dominant, appel, etc.)

    // Constructeur
    public Hurlement(Lycanthrope lycanthrope, String typeHurlement) {
        this.lycanthrope = lycanthrope;
        this.typeHurlement = typeHurlement;
    }

    // Afficher le hurlement
    public String afficherHurlement() {
        return lycanthrope.hurler() + " de type " + typeHurlement;
    }

}


