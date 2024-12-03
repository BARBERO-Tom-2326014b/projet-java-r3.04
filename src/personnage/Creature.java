package personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature {
    private String nomComplet;
    private String sexe;
    private double poids;
    private double taille;
    private int age;
    private int moral; // Niveau de moral de la créature, représentant son état mental.
    private List<Maladie> maladies; // Liste des maladies dont souffre la créature.
    private int hurlementsConsecutifs = 0; // Compteur de hurlements consécutifs.

    /**
     * Constructeur de base pour initialiser une créature avec ses caractéristiques de base.
     * 
     * @param nomComplet Le nom complet de la créature.
     * @param sexe Le sexe de la créature.
     * @param poids Le poids de la créature.
     * @param taille La taille de la créature.
     * @param age L'âge de la créature.
     */
    public Creature(String nomComplet, String sexe, double poids, double taille, int age) {
        this.nomComplet = nomComplet;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.moral = 100; // Le moral initial est défini à 100.
        this.maladies = new ArrayList<>();
    }

    // Getters et Setters

    /**
     * @return Le nom complet de la créature.
     */
    public String getNomComplet() {
        return nomComplet;
    }

    /**
     * @return Le sexe de la créature.
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @return Le poids de la créature.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * @return La taille de la créature.
     */
    public double getTaille() {
        return taille;
    }

    /**
     * @return L'âge de la créature.
     */
    public int getAge() {
        return age;
    }

    /**
     * @return Le moral actuel de la créature.
     */
    public int getMoral() {
        return moral;
    }

    /**
     * Définit le moral de la créature.
     * 
     * @param moral Le nouveau niveau de moral.
     */
    public void setMoral(int moral) {
        this.moral = moral;
    }

    /**
     * @return La liste des maladies dont souffre la créature.
     */
    public List<Maladie> getMaladies() {
        return maladies;
    }

    /**
     * Fait attendre la créature, réduisant son moral et déclenchant potentiellement des hurlements.
     * 
     * @param proches Liste des créatures proches pouvant être affectées.
     */
    public void attendre(List<Creature> proches) {
        int chance = (int) (Math.random() * 2);
        moral -= 10;
        if (moral < 0) moral = 0;
        System.out.println(nomComplet + " attend... Moral actuel : " + moral);
        if (moral < 30 && chance == 1) {
            if (moral == 0) {
                hurler(proches);
            }
        }
    }

    /**
     * La créature hurle lorsque son moral est bas, exprimant son désespoir.
     * 
     * @param proches Liste des créatures proches pouvant être affectées.
     */
    public void hurler(List<Creature> proches) {
        if (hurlementsConsecutifs > 1) {
            sEmporter(proches);
        } else if (moral <= 10) {
            System.out.println(nomComplet + " hurle de désespoir !");
            hurlementsConsecutifs++;
        }
    }

    /**
     * La créature s'emporte lorsqu'elle a hurlé plusieurs fois et peut contaminer d'autres créatures.
     * 
     * @param proches Liste des créatures proches pouvant être contaminées.
     */
    public void sEmporter(List<Creature> proches) {
        if (hurlementsConsecutifs > 1) {
            System.out.println(nomComplet + " s'emporte avec fureur !");
        } else {
            System.out.println(nomComplet + " ne peut pas s'emporter car il n'a pas assez hurlé (hurlementsConsecutifs = " + hurlementsConsecutifs + ").");
        }
        double chanceDeContamination = Math.random();
        if (chanceDeContamination > 0 && !proches.isEmpty()) {
            contaminerAutres(proches);
        } else {
            if (chanceDeContamination <= 0) {
                System.out.println("Pas de contamination cette fois.");
            }
            if (proches.isEmpty()) {
                System.out.println("Aucune créature proche à contaminer.");
            }
        }
    }

    /**
     * Contamine une autre créature proche en lui transmettant une maladie aléatoire.
     * 
     * @param proches Liste des créatures proches pouvant être contaminées.
     */
    private void contaminerAutres(List<Creature> proches) {
        List<Creature> ciblesValides = proches.stream().filter(proche -> !proche.equals(this)).toList();
        if (!maladies.isEmpty() && !ciblesValides.isEmpty()) {
            Creature cible = ciblesValides.get(new Random().nextInt(ciblesValides.size()));
            Maladie maladie = maladies.get(new Random().nextInt(maladies.size()));
            cible.tomberMalade(maladie);
            System.out.println(nomComplet + " contamine " + cible.getNomComplet() + " avec " + maladie + " en s'emportant.");
        } else {
            System.out.println(nomComplet + " n'est pas malade donc ne contamine pas.");
        }
    }

    /**
     * Ajoute une maladie à la créature, réduisant son moral.
     * 
     * @param maladie La maladie contractée par la créature.
     */
    public void tomberMalade(Maladie maladie) {
        maladies.add(maladie);
        moral -= 30;
        System.out.println(nomComplet + " tombe malade de " + maladie + ". Moral : " + moral);
        if (maladie.estLetale()) {
            System.out.println(nomComplet + " est en danger immédiat à cause de " + maladie.getNomComplet() + " !");
        }
    }

    /**
     * Soigne une maladie de la créature, augmentant légèrement son moral.
     */
    public void etreSoignee() {
        if (!maladies.isEmpty()) {
            Maladie maladieSoignee = maladies.remove(0);
            moral += 20;
            System.out.println(nomComplet + " est soigné de " + maladieSoignee + ". Moral : " + moral);
        } else {
            System.out.println(nomComplet + " n'a pas de maladies à soigner.");
        }
    }

    /**
     * Vérifie si la créature est morte à cause d'une maladie létale ou d'un trop grand nombre de maladies.
     * 
     * @return {@code true} si la créature est morte, sinon {@code false}.
     */
    public boolean estMort() {
        for (Maladie maladie : maladies) {
            if (maladie.estLetale()) {
                System.out.println("\n" + nomComplet + " a trépassé à cause de " + maladie.getNomComplet() + "\n");
                return true;
            }
        }
        if (maladies.size() > 5) {
            System.out.println(nomComplet + " a trépassé à cause du trop grand nombre de maladies.");
            return true;
        }
        return false;
    }
}
