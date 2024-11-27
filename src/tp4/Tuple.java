package tp4;

public class Tuple<T> {
    private T first;
    private T second;

    // Constructeur
    public Tuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    // Getter pour le premier élément
    public T getFirst() {
        return first;
    }

    // Getter pour le second élément
    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
