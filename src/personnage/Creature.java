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
    private List<Maladie> maladies;
    private int hurlementsConsecutifs = 0; // Compteur de hurlements consécutifs

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

	public List<Maladie> getMaladies() {
        return maladies;
    }

    public void attendre(List<Creature> proches) {
    	 int chance = (int)(Math.random() * 1);
         System.out.println(chance);
        moral -= 10;
        if (moral < 0) moral = 0;
        System.out.println(nomComplet + " attend... Moral actuel : " + moral);
        if (moral<30 && chance == 1)
        if (moral == 0) {
            hurler(proches);
        }
        
    }
    
    public void hurler(List<Creature> proches) {
    	if (hurlementsConsecutifs>1) {
    		sEmporter(proches);
    	}  
    	else if (moral <= 10) {
        System.out.println(nomComplet + " hurle de désespoir !");
        hurlementsConsecutifs++;
    	}
    }

    // S’emporter : alternative aux hurlements consécutifs
    public void sEmporter(List<Creature> proches) {
    	if (hurlementsConsecutifs>1) {
    		System.out.println(nomComplet + " s'emporte avec fureur !");
    	}   
    	else {
            System.out.println(nomComplet + " ne peut pas s'emporter car il n'a pas assez hurlé (hurlementsConsecutifs = " + hurlementsConsecutifs + ").");
        }
    	// Ajout d'une chance de contamination
        double chanceDeContamination = Math.random(); // Génère un nombre entre 0 et 1
        if (chanceDeContamination > 0.25 && !proches.isEmpty()) { // 75% de chance de contaminer
            contaminerAutres(proches);
        }
        else {
            if (chanceDeContamination <= 0.25) {
                System.out.println("Pas de contamination cette fois (chanceDeContamination = " + chanceDeContamination + ").");
            }
            if (proches.isEmpty()) {
                System.out.println("Aucune créature proche à contaminer.");
            }
        }
    }
    
 // Contamine une autre créature aléatoire
    private void contaminerAutres(List<Creature> proches) {
        if (!maladies.isEmpty() && !proches.isEmpty()) {
            Creature cible = proches.get(new Random().nextInt(proches.size()));
            Maladie maladie = maladies.get(new Random().nextInt(maladies.size()));
            cible.tomberMalade(maladie);
            System.out.println(nomComplet + " contamine " + cible.getNomComplet() + " avec " + maladie + " en s'emportant.");
        }
        else {
        	System.out.println(nomComplet+" n'est pas malade donc ne contamine pas");
        }
    }

    // Tomber malade : ajoute une maladie
    public void tomberMalade(Maladie maladie) {
        maladies.add(maladie);
        moral -= 30; // Chute du moral à chaque nouvelle maladie
        System.out.println(nomComplet + " tombe malade de " + maladie + ". Moral : " + moral);
        if (maladie.estLetale()) {
            System.out.println(nomComplet + " est en danger immédiat à cause de " + maladie.getNomComplet() + " !");
        }
    }

    // Être soignée : soigne une maladie et augmente le moral
    public void etreSoignee() {
        if (!maladies.isEmpty()) {
        	Maladie maladieSoignee = maladies.remove(0);
            moral += 20;
            System.out.println(nomComplet + " est soigné de " + maladieSoignee + ". Moral : " + moral);
        } else {
            System.out.println(nomComplet + " n'a pas de maladies à soigner.");
        }
    }

    // Trépasser : lorsque le nombre de maladies est trop élevé ou maladie létale
    public boolean estMort() {
        for (Maladie maladie : maladies) {
            if (maladie.estLetale()) { // Si une maladie est létale
                System.out.println(nomComplet + " a trépassé à cause de " + maladie.getNomComplet() + ".");
                return true;
            }
        }
        if (maladies.size() > 5) { // Ou s'il y a trop de maladies
            System.out.println(nomComplet + " a trépassé à cause du trop grand nombre de maladies.");
            return true;
        }
        return false;
    }

}
