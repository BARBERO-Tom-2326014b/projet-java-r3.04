package tp4;

/**
 * Représente un tuple contenant deux éléments de type générique {@code T}.
 * Cette classe permet de stocker et manipuler un couple d'éléments de même type.
 * 
 * @param <T> Le type des éléments du tuple
 */
public class Tuple<T> {
    private T first;
    private T second;

    /**
     * Constructeur de la classe {@code Tuple}.
     * 
     * @param first Le premier élément du tuple
     * @param second Le second élément du tuple
     */
    public Tuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Récupère le premier élément du tuple.
     * 
     * @return Le premier élément du tuple
     */
    public T getFirst() {
        return first;
    }

    /**
     * Récupère le second élément du tuple.
     * 
     * @return Le second élément du tuple
     */
    public T getSecond() {
        return second;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du tuple.
     * La chaîne est formatée sous la forme "(first, second)".
     * 
     * @return La chaîne représentant le tuple
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
