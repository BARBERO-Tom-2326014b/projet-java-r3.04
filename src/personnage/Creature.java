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
    private int moral;//donne la plus importante
    private List<String> maladies;

    // Constructeur de base
    public Creature(String nomComplet, String sexe, double poids, double taille, int age) {
        this.nomComplet = nomComplet;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.moral = 100; // Moral initial, supposons qu'il commence à 100
        this.maladies = new ArrayList<>();
    }


    // Getters et Setters
    public String getNomComplet() {
        return nomComplet;
    }

    public String getSexe() {
        return sexe;
    }

    public double getPoids() {
        return poids;
    }

    public double getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getMoral() {
        return moral;
    }
    
    

    public void setMoral(int moral) {
		this.moral = moral;
	}

	public List<String> getMaladies() {
        return maladies;
    }

    public void attendre() {
    	 int chance = (int)(Math.random() * 1);
         System.out.println(chance);
        moral -= 10;
        if (moral < 0) moral = 0;
        System.out.println(nomComplet + " attend... Moral actuel : " + moral);
        if (moral<30 && chance == 1)
        if (moral == 0) {
            hurler();
        }
        
    }
    
    
    
    public void sEmporter(List<Creature> proches) {
        System.out.println(nomComplet + " s'emporte avec fureur !");
        contaminerAutres(proches);
    }
    // Contamine une autre créature aléatoire
    private void contaminerAutres(List<Creature> proches) {
        if (!maladies.isEmpty() && !proches.isEmpty()) {
            Creature cible = proches.get(new Random().nextInt(proches.size()));
            String maladie = maladies.get(new Random().nextInt(maladies.size()));
            cible.tomberMalade(maladie);
            System.out.println(nomComplet + " contamine " + cible.getNomComplet() + " avec " + maladie + " en s'emportant.");
        }
    }

  


    

    
    public void hurler() {
        System.out.println(nomComplet + " hurle de désespoir !");
    }

    // S’emporter : alternative aux hurlements consécutifs
    public void sEmporter() {
        System.out.println(nomComplet + " s'emporte avec fureur !");
    }

    // Tomber malade : ajoute une maladie
    public void tomberMalade(String maladie) {
        maladies.add(maladie);
        moral -= 5; // Chute du moral à chaque nouvelle maladie
        System.out.println(nomComplet + " tombe malade de " + maladie + ". Moral : " + moral);
    }

    // Être soignée : soigne une maladie et augmente le moral
    public void etreSoignee() {
        if (!maladies.isEmpty()) {
            String maladieSoignee = maladies.remove(0);
            moral += 20;
            System.out.println(nomComplet + " est soigné de " + maladieSoignee + ". Moral : " + moral);
        } else {
            System.out.println(nomComplet + " n'a pas de maladies à soigner.");
        }
    }

    // Trépasser : lorsque le nombre de maladies est trop élevé
    public boolean estMort() {
        if (maladies.size() > 5) { // Critère de trépas : 5 maladies
            System.out.println(nomComplet + " a trépassé à cause de ses maladies.");
            return true;
        }
        return false;
    }
}
