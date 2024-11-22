package personnage;

public class test {
	public static void main(String[] args) {
        // Créer des creatures
		Orque orque = new Orque("The Orqueee", "M", 120, 2.1, 30);
		Elfe elfe = new Elfe("Mathias l'elfe","M",80,1.8,20);
		
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
        elfe.attendre();
        System.out.println("Moral après attente : " + elfe.getMoral());
        
     // 3. Hurler si le moral est bas
        System.out.println("\n=== Test 3: Hurler si le moral est bas ===");
        elfe.setMoral(5); 
        elfe.hurler();
        
     // 4. S’emporter si hurlements consécutifs
        System.out.println("\n=== Test 4: S’emporter ==="); 
        orque.hurler(); 
        orque.hurler(); 
        orque.sEmporter();
        
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
        orque.tomberMalade(mdc); // Recontaminer
        mdc.augmenterNiveau(mdc.getNiveauMax()); // Augmenter au maximum pour rendre létale
        if (orque.estMort()) {
            System.out.println(orque.getNomComplet() + " est décédé.");
        } else {
            System.out.println(orque.getNomComplet() + " est toujours en vie.");
        }
	}
}