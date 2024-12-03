package tp4;

/**
 * Représente un hurlement émis par un lycanthrope.
 * Un hurlement est associé à un lycanthrope spécifique et à un type de hurlement (par exemple, dominant, appel, etc.).
 */
public class Hurlement {

    /** Le lycanthrope qui émet le hurlement */
    private Lycanthrope lycanthrope;
    
    /** Type du hurlement (par exemple, "dominant", "appel") */
    private String typeHurlement;

    /**
     * Constructeur de la classe Hurlement.
     * Initialise un hurlement avec un lycanthrope et un type de hurlement donnés.
     * 
     * @param lycanthrope Le lycanthrope qui émet le hurlement
     * @param typeHurlement Le type de hurlement (par exemple, "dominant", "appel")
     */
    public Hurlement(Lycanthrope lycanthrope, String typeHurlement) {
        this.lycanthrope = lycanthrope;
        this.typeHurlement = typeHurlement;
    }

    /**
     * Affiche le hurlement émis par le lycanthrope, avec le type de hurlement.
     * 
     * @return Une chaîne de caractères représentant le hurlement émis par le lycanthrope et son type
     */
    public String afficherHurlement() {
        return lycanthrope.hurler() + " de type " + typeHurlement;
    }

}
