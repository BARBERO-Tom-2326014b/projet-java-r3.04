package personnage;

/**
 * Interface représentant un VIP (Very Important Person).
 * Les VIP ont des comportements spécifiques dans le jeu, tels qu'une perte rapide de moral.
 */
public interface VIP {

    /**
     * Méthode à implémenter pour réduire rapidement le moral d'un VIP.
     * Cette méthode est destinée à représenter des situations où un VIP
     * perd du moral plus vite que d'autres entités.
     * @return 
     */
    boolean estVip();
}