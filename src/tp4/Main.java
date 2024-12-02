package tp4;

import java.util.Random;
import java.util.Scanner;


public class Main {
	private static Random random = new Random();
    public static void main(String[] args) {
    	
        // Scanner pour l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;

        System.out.println("Bienvenue dans Fantasy Hospital !");
        while (!quitter) {
            // Afficher le menu principal
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1. Créer Lycanthropes");
            System.out.println("2. Créer meute");
            System.out.println("3. Créer colonie");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                	System.out.println("Quel nom voulez-vous choisir ?");
                    String Nom = scanner.nextLine();
                    if(random.nextInt(3)==1) {
                    Lycanthrope lycan = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10),  random.nextInt(10), random.nextInt(10),Nom);
                    lycan.afficherCaracteristiques();
                    	}
                    else {
                    	Lycanthrope lycan = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10),  random.nextInt(10), random.nextInt(10),Nom);
                    	lycan.afficherCaracteristiques();
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


