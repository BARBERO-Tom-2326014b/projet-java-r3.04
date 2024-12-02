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
        ArrayList<Meute> meuteL = new ArrayList<Meute>();
        ArrayList<Lycanthrope> lycanthropeL = new ArrayList<Lycanthrope>();
        
        
        Meute meute10= new Meute("Test");
        Lycanthrope lycan10 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Tom");
        Lycanthrope lycan11 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Enzo");
        Lycanthrope lycan12 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Mathias");
        Lycanthrope lycan13 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Evan");
        Lycanthrope lycan14 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Lucas");
        Lycanthrope lycan17 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Tim");
        Lycanthrope lycan15 = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Test1");
        Lycanthrope lycan16 = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Test2");
        meute10.ajouterMembre(lycan10);
        meute10.ajouterMembre(lycan11);
        meute10.ajouterMembre(lycan12);
        meute10.ajouterMembre(lycan13);
        meute10.ajouterMembre(lycan14);
        meute10.ajouterMembre(lycan15);
        meute10.ajouterMembre(lycan16);
        meute10.ajouterMembre(lycan17);
        
        
        meute10.definirCoupleAlpha();
        meute10.hierarchie();
        
        meute10.afficherLycanthropesDeLaMeute();
        
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
	                            Lycanthrope lycan = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10),  random.nextInt(10),Nom);
	                            lycanthropeL.add(lycan);
	                            lycan.afficherCaracteristiques();
                            	}
                            else {
                            	Lycanthrope lycan = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),Nom);
                            	lycanthropeL.add(lycan);
                            	lycan.afficherCaracteristiques();
                            	}
                            break;
                    	case 2:
                    		System.out.println("0. Quitter");
                    		int cpt=1;
                    		for (Lycanthrope l : lycanthropeL) {
                                	System.out.println(cpt+" "+l.getNom());
                                	cpt+=1;
                                	}
                    		int choix3 = scanner.nextInt();
                            scanner.nextLine();
                            
	                        if(choix3!=0) {
	                        boolean boucle =true;
	                            while(boucle) {
	                            	System.out.println(" Vous avez choisi le lycanthrope : "+lycanthropeL.get(choix3-1).getNom());
	                            	System.out.println("1. L'ajouter a une meute");
	                            	System.out.println("2. Retirer d'une meute");
	                            	System.out.println("3. Quitter");
	                            	int choix4 = scanner.nextInt();
	                            	switch(choix4) {
	                            	case 1:
	                            		if(meuteL.size()==0) {
	                            			System.out.println("Il n'y a pas de meute créer");
	                            			boucle=false;
	                            		}
	                            		else {
	                            			cpt=0;
	                            			System.out.println("Voici les différentes meutes : ");
	                            			for (Meute m : meuteL) {
	                                        	System.out.println(cpt+" "+m.getNom());
	                                        	cpt+=1;
	                                        	System.out.println("Dans quel meute voulez-vous l'ajouter ?");
	                                        	int choix5 = scanner.nextInt();
	                                        	meuteL.get(choix5).ajouterMembre(lycanthropeL.get(choix3-1));
	                                        	System.out.println("Le lycanthrope "+lycanthropeL.get(choix3-1).getNom()+" a bien été ajouté !");
	                                        	boucle=false;
	                                        	
	                                        	}
	                            			
	                            		}
	                            		
	                            		boucle=false;
	                            		break;
	                            	case 2:
	                            		if(lycanthropeL.get(choix3-1).getMeute()==null) {
	                            			System.out.println("Il n'est pas dans une meute !");
	                            		}
	                            		else {
	                            			lycanthropeL.get(choix3-1).getMeute().enleverLycanthropes(lycanthropeL.get(choix3-1));;
	                            		}
	                            		boucle=false;
	                            	case 3:
	                            		boucle=false;
	                            	}
	                          
	                            }
	                        }
                    		break;
                    		
                    	case 3:
                    		System.out.println("Liste des lycanthropes : \n");
                    		System.out.println(lycanthropeL.size());
                            for (Lycanthrope l : lycanthropeL) {
                                l.afficherCaracteristiques();
                            }
                            break;
                    		
                    	
                    	case 4:
                    		break;
                    		
                    	 default:
                             System.out.println("Choix invalide. Veuillez réessayer.");
                    }
                    
                	
               
                    
                    break;
                case 2:
                	System.out.println("\nQue souhaitez-vous faire ?");
                	System.out.println("0. Quitter");
                    System.out.println("1. Créer Meute");
                    System.out.println("2. Choisir Meute");
                    
                    int Nom1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (Nom1) {
	                    case 1:
	                    	System.out.println("Quel nom voulez-vous donner ?");
                    		String Nom = scanner.nextLine();
                    		Meute meute = new Meute(Nom);
                    		meuteL.add(meute);
                    		System.out.println("La meute a bien été créer !");
	                    break;
	                    
	                    case 2:
	                    	System.out.println("0. Quitter");
	                    	int cpt=1;
                    		for (Meute m : meuteL) {
                                	System.out.println(cpt+" "+m.getNom());
                                	cpt+=1;
                                	}
                    		int choix10 = scanner.nextInt();
                            scanner.nextLine();
                            
	                        if(choix10!=0) {
	                        	boolean boucle2 =true;
	                            while(boucle2) {
	                            	System.out.println("Vous avez choisi la meute : "+meuteL.get(choix10-1).getNom());
	                            	System.out.println("0. Quitter");
	                            	System.out.println("1. Voir les loups dans la meute");
	                            	System.out.println("2. Créer couple (si possible)");
	                            	System.out.println("3. Voir Hiérarchie");
	                            	int choix11 = scanner.nextInt();
	                            	switch(choix11) {
	                            	case 0:
	                            		boucle2=false;
	                            		break;
	                            	case 1:
	                            		meuteL.get(choix10-1).afficherLycanthropesDeLaMeute();
	                            		boucle2=false;
	                            		break;
	                            	
	                            	case 2:
	                            		meuteL.get(choix10-1).definirCoupleAlpha();
	                            		boucle2=false;
	                            		break;
	                            	case 3:
	                            		meuteL.get(choix10-1).hierarchie();
	                            		boucle2=false;
	                            		break;
	                            	}
	                            }
	                        	break;
	                        	}
	                        default:
	                        	System.out.println("Choix invalide. Veuillez réessayer.");
	                        	
	                        	
	                        }
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
    
}

