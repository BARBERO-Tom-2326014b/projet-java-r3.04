package tp4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
	private static Random random = new Random();
	
	public static int verfiEntier(String chaine) throws Exception {
		boolean isNumeric = true;
		for (int i = 0; i < chaine.length(); i++) {
		      if (!Character.isDigit(chaine.charAt(i))) {
		        isNumeric = false;
		        break;
		      }
		}
		if(isNumeric) {
			return Integer.parseInt(chaine);
		}
		throw new Exception("Vous devez rentrer un entier !");
		
	}
	
	
	
	
    public static void main(String[] args) {
    	
    	
        // Scanner pour l'entrée utilisateur
        Scanner scanner = new Scanner(System.in);
        boolean quitter = false;
        ArrayList<Meute> meuteL = new ArrayList<Meute>();
        ArrayList<Lycanthrope> lycanthropeL = new ArrayList<Lycanthrope>();
        ArrayList<Colonie> colonieL = new ArrayList<Colonie>();
        
        
        Meute meute10= new Meute("Test");
        Lycanthrope lycan10 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Tom",random.nextInt(3));
        Lycanthrope lycan11 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Enzo",random.nextInt(3));
        Lycanthrope lycan12 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Mathias",random.nextInt(3));
        Lycanthrope lycan13 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Evan",random.nextInt(3));
        Lycanthrope lycan14 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Lucas",random.nextInt(3));
        Lycanthrope lycan17 = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Tim",random.nextInt(3));
        Lycanthrope lycan15 = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Test1",random.nextInt(3));
        Lycanthrope lycan16 = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10), random.nextInt(10),"Test2",random.nextInt(3));
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
        	
        	
        	for(Lycanthrope l : lycanthropeL) {
        		int probaF=random.nextInt(4);
        		if(probaF==0) {
        			l.changerForce();
        		}
        		int probaV=random.nextInt(7);
        		if(probaV==0) {
        			l.vieillir();
        		}
        		int probaH=random.nextInt(10);
        		if(probaH==0) {
        			l.transformerHumain(l.getMeute());
        		}
        	}
        	for(Meute m : meuteL) {
        		int probaR=random.nextInt(6);
        		if(m.getCouple()!=m.definirCoupleAlpha()) {
    				m.definirCoupleAlpha();
    			}
        		if(probaR==0) {
        		if(m.getCouple().getCouple()==true) {
        			for(Lycanthrope l : m.getCouple().realiserReproduction()) {
        				m.ajouterMembre(l);
        			}
        			
        			}
        		}
        	}
        	
        	
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1. Lycanthropes");
            System.out.println("2. Meute");
            System.out.println("3. Colonie");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            String choix = scanner.next();
            
            try {
				int choix21 = verfiEntier(choix);
			
            
     
            
           
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix21) {
                case 1:
                	System.out.println("\nQue souhaitez-vous faire ?");
                    System.out.println("1. Créer lycanthrope");
                    System.out.println("2. Choisir lycanthrope");
                    System.out.println("3. Afficher lycanthrope");
                    System.out.println("4. Quitter");
          
                    
                    
                    choix = scanner.next();
                    int choix2 = verfiEntier(choix);
                    scanner.nextLine();
                    
                    switch(choix2) {
                    	case 1:
                    		System.out.println("nQuel nom voulez-vous donner ?");
                    		String Nom = scanner.nextLine();
                            if(random.nextInt(3)==1) {
	                            Lycanthrope lycan = new Lycanthrope(false, random.nextInt(100), random.nextFloat(10),  random.nextInt(10),Nom,random.nextInt(3));
	                            lycanthropeL.add(lycan);
	                            lycan.afficherCaracteristiques();
                            	}
                            else {
                            	Lycanthrope lycan = new Lycanthrope(true, random.nextInt(100), random.nextFloat(10), random.nextInt(10),Nom,random.nextInt(3));
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
                    		
                    		 choix = scanner.next();
                             int choix3 = verfiEntier(choix);
                             scanner.nextLine();
                    	
                            
	                        if(choix3!=0) {
	                        boolean boucle =true;
	                            while(boucle) {
	                            	System.out.println(" Vous avez choisi le lycanthrope : "+lycanthropeL.get(choix3-1).getNom());
	                            	System.out.println("1. L'ajouter a une meute");
	                            	System.out.println("2. Retirer d'une meute");
	                            	System.out.println("3. Quitter");
	                            	
	                            	choix = scanner.next();
	                                int choix4 = verfiEntier(choix);
	                                scanner.nextLine();
	                            
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
                    
                    choix = scanner.next();
                    int Nom1= verfiEntier(choix);
                    scanner.nextLine();
                   
                    
                    switch (Nom1) {
                    	case 0:
                    		break;
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
                    		choix = scanner.next();
                            int choix10 = verfiEntier(choix);
                            scanner.nextLine();
                          
                            
	                        if(choix10!=0) {
	                        	boolean boucle2 =true;

                            	
	                            while(boucle2) {
	                            	System.out.println("Vous avez choisi la meute : "+meuteL.get(choix10-1).getNom());
	                            	System.out.println("0. Quitter");
	                            	System.out.println("1. Voir les loups dans la meute");
	                            	System.out.println("2. Créer couple (si possible)");
	                            	System.out.println("3. Voir Hiérarchie");
	                            	System.out.println("4. Ajouter à une colonie");
	                            	choix = scanner.next();
	                                int choix11= verfiEntier(choix);
	                                scanner.nextLine();
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
	                            	case 4:
	                            		cpt=0;
	                            		System.out.println("Voici les différentes colonie : ");
                            			for (Colonie c : colonieL) {
                                        	System.out.println(cpt+" "+c.getNom());
                                        	cpt+=1;
                                        	System.out.println("Dans quel colonie voulez-vous l'ajouter ?");
                                        	int choix5 = scanner.nextInt();
                                        	colonieL.get(choix5).ajouterMeute(meuteL.get(choix10-1));
                                        	System.out.println("La meute  "+meuteL.get(choix10-1).getNom()+" a bien été ajouté !");
                            			}
                            			break;
	                            	}break;
	                            }
	                        	break;
	                        	}
	                        else {
	                        	break;
	                        }
	                        default:
	                        	System.out.println("Choix invalide. Veuillez réessayer.");
	                        	
	                        	
	                        }
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    
                case 3:
                	System.out.println("\nQue souhaitez-vous faire ?");
                	System.out.println("0. Quitter");
                    System.out.println("1. Afficher colonie");
                    System.out.println("2. Créer colonie");
                    System.out.println("3. Choisir colonie");
                    
          
                    
                    
                    choix = scanner.next();
                    int choix23 = verfiEntier(choix);
                    scanner.nextLine();
                    switch(choix23) {
                    	case 0:
                    		break;
                    	case 1:
                    		System.out.println("voici les colonie :");
                    		for(Colonie c : colonieL) {
                    			System.out.println(c.getNom());
                    		}
                    		break;
                    	case 2:
                    		System.out.println("Quel nom voulez-vous choisir ?");
                    		choix = scanner.next();
                    		scanner.nextLine();
                    		Colonie col = new Colonie(choix);
                    		colonieL.add(col);
                    		System.out.println("La colonie "+ col.getNom()+" a été créer !");
                    		break;
                    	case 3:
                    		System.out.println("0. Quitter");
	                    	int cpt=1;
                    		for (Colonie c : colonieL) {
                                	System.out.println(cpt+" "+c.getNom());
                                	cpt+=1;
                                	}
                    		choix = scanner.next();
                            int choix10 = verfiEntier(choix);
                            scanner.nextLine();
                          
                            
	                        if(choix10!=0) {
	                        	boolean boucle2 =true;

                            	
	                            while(boucle2) {
	                            	System.out.println("Vous avez choisi la meute : "+colonieL.get(choix10-1).getNom());
	                            	System.out.println("0. Quitter");
	                            	System.out.println("1. Voir les meutes dans la colonie");
	                                int choix11= verfiEntier(choix);
	                                scanner.nextLine();
	                            	switch(choix11) {
	                            	case 0:
	                            		boucle2=false;
	                            		break;
	                            	case 1:
	                            		System.out.println("Voici les meute dans la colonie");
	                            		for(Meute m :colonieL.get(choix10-1).getMeutes()) {
	                            			System.out.println(m.getNom());
	                            		}
	                            		boucle2=false;
	                            		break;
	                            		
                    		
                    }
	                            	}break;
                    
                    
            }
            }}} catch (Exception e) {
				System.out.println( (e.getMessage()));
				
			}
            
        }
        scanner.close();  
    }
        
    
    
}

