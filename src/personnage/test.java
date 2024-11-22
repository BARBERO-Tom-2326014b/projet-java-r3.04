package personnage;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
        // Créer des creatures
		Orque orque = new Orque("The Orqueee", "M", 120, 2.1, 30);
		Elfe elfe = new Elfe("Mathias l'elfe","M",80,1.8,20);
		Lycanthrope loupG = new Lycanthrope("Loup-garou", "F", 100.0, 1.75, 40);
		
		//Liste des creatures proches
		List<Creature> proches = new ArrayList<>();
	    proches.add(elfe);
	    proches.add(loupG);
		
		// 1. Vérification des caractéristiques de base
        System.out.println("=== Test 1: Vérification des caractéristiques de base ===");
        System.out.println("Nom : " + orque.getNomComplet());
        System.out.println("Sexe : " + orque.getSexe());
        System.out.println("Poids : " + orque.getPoids());
        System.out.println("Taille : " + orque.getTaille());
        System.out.println("Âge : " + orque.getAge());
        System.out.println("Moral : " + orque.getMoral());
        System.out.println("Liste de maladies : " + orque.getMaladies());
        
     // 2. Faire attendre une créature
        System.out.println("\n=== Test 2: Faire attendre une créature ===");
        elfe.attendre(proches);
        System.out.println("Moral après attente : " + elfe.getMoral());
        
     // 3. Hurler si le moral est bas
        System.out.println("\n=== Test 3: Hurler si le moral est bas ===");
        elfe.hurler(proches);//ne doit pas hurler car moral > 10 
        elfe.setMoral(5); 
        elfe.hurler(proches);// doit hurler car moral < 10
        
     // 4. S’emporter si hurlements consécutifs
        System.out.println("\n=== Test 4: S’emporter ==="); 
        elfe.hurler(proches); 
        elfe.hurler(proches); 
        
     // 5. Tomber malade
        System.out.println("\n=== Test 5: Tomber malade ===");
        Maladie mdc = Maladie.creerMaladie("MDC");
        orque.tomberMalade(mdc);
        System.out.println(orque.getMaladies());
        
     // 6. Être soignée
        System.out.println("\n=== Test 6: Être soignée ===");
        orque.etreSoignee();
        System.out.println("Maladies après traitement : " + orque.getMaladies());
        System.out.println("Moral après traitement : " + orque.getMoral());

       
        // 7. Trépasser si trop malade
        System.out.println("\n=== Test 7: Trépasser ===");
        elfe.tomberMalade(mdc); // Recontaminer
        mdc.augmenterNiveau(mdc.getNiveauMax()); // Augmenter au maximum pour rendre létale
        if (elfe.estMort()) {
            System.out.println(elfe.getNomComplet() + " est décédé.");
        } else {
            System.out.println(elfe.getNomComplet() + " est toujours en vie.");
        }
        
        // 8. S'emporter contamine proches
        System.out.println("\n=== Test 8: S'emporter contamine proches ===");
        orque.hurler(proches);
        orque.hurler(proches);
        orque.sEmporter(proches);
	}
}