package tp4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
	private static Random random = new Random();
    public static void main(String[] args) {
    	
    	
    	
        // Scanner pour l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;
        ArrayList<Lycanthrope> lycanthropeL = new ArrayList<Lycanthrope>();
        while (!quitter) {
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1. Lycanthropes");
            System.out.println("2. Meute");
            System.out.println("3. Créer colonie");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                	System.out.println("\nQue souhaitez-vous faire ?");
                    System.out.println("1. Créer lycanthrope");
                    System.out.println("2. Choisir lycanthrope");
                    System.out.println("3. Afficher lycanthrope");
                    System.out.println("4. Quitter");
                    int choix2 = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch(choix2) {
                    	case 1:
                    		System.out.println("nQuel nom voulez-vous donner ?");
                    		String Nom = scanner.nextLine();
                            if(random.nextInt(3)==1) {
	                            Lycanthrope lycan = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10),  random.nextInt(10), random.nextInt(10),Nom);
	                            lycanthropeL.add(lycan);
	                            lycan.afficherCaracteristiques();
                            	}
                            else {
                            	Lycanthrope lycan = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10),  random.nextInt(10), random.nextInt(10),Nom);
                            	lycanthropeL.add(lycan);
                            	lycan.afficherCaracteristiques();
                            	}
                            break;
                    	case 2:
                    		break;
                    	case 3:
                    		System.out.println("Liste des lycanthropes : \n");
                    		System.out.println(lycanthropeL.size());
                            for (Lycanthrope l : lycanthropeL) {
                                System.out.println(l.getNom());
                            }
                            break;
                    		
                    	
                    	case 4:
                    		break;
                    }
                	
                    
                    
                    
                    
                    break;
                case 2:
                	System.out.println("Quel nom voulez-vous choisir ?");
                    String Nom1 = scanner.nextLine();
                    if(random.nextInt(3)==1) {
                    Lycanthrope lycan = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10),  random.nextInt(10), random.nextInt(10),Nom1); 
                    }
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
    
}


