package personnage;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Instanciation de l'hôpital
        HopitalFantastique hopital = new HopitalFantastique("mte",10);
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("Bienvenue dans Fantasy Hospital !");
        
        // Boucle principale du jeu
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Admettre une nouvelle créature");
            System.out.println("2. Soigner une créature");
            System.out.println("3. Afficher les créatures admises");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Capture newline

            switch (choix) {
                case 1:
                    System.out.print("Entrez le type de créature (ex : Elfe, Orque) : ");
                    String type = scanner.nextLine();
                    Creature nouvelleCreature = hopital.admettreCreature(type); // Admet une nouvelle créature
                    System.out.println("Nouvelle créature admise : " + nouvelleCreature.getNom());
                    break;
                
                case 2:
                    System.out.print("Entrez le nom de la créature à soigner : ");
                    String nomCreature = scanner.nextLine();
                    boolean soigne = hopital.soignerCreature(nomCreature); // Soigne une créature existante
                    if (soigne) {
                        System.out.println("La créature " + nomCreature + " a été soignée !");
                    } else {
                        System.out.println("La créature " + nomCreature + " n'a pas été trouvée ou n'a pas besoin de soins.");
                    }
                    break;
                
                case 3:
                    hopital.afficherCreatures(); // Affiche toutes les créatures admises
                    break;
                
                case 4:
                    running = false;
                    System.out.println("Merci d'avoir joué à Fantasy Hospital !");
                    break;
                
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
        
        scanner.close();
    }
}
