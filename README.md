# projet-java-r3.04

*Un jeu Java de gestion d’un hôpital fantastique et une simulation de tribu de loups alpha*

---

## **Description du projet**  
Ce projet est un jeu développé en Java qui intègre :  
1. **Gestion d’un hôpital fantastique** : où le joueur incarne le gerant de l'hopital qui fais des choix dans le but qu'aucune creature ne meurt. Le but est de survivre le nombre de tour choisis (quand on lance une partie on choisis le nombre de tours)
2. **Simulation de tribu de loups alpha** : où le joueur gere sa meute, établit des stratégies...

---

## **Fonctionnalités principales**  
 **Hôpital fantastique**  
- Gestion des patients : admission, soins, gestion de morale, patient transferable d'un service a un autre, consultation d'un service avec toutes les données sur les patients  
- Gestion des ressources : reaprovisionement d'argent, service complet
- Événements aléatoires : nouvelle arrivant a l'hopital, patient qui peuvent tomber malade( maladie aléatoire ), maladie qui peut evoluer , soins qui peuvent rater, 
medecin qui peuvent etre a la pause café, argent qui change de maniere aleatoire, superficie evolue aleatoirement, contamination de la part des gens infecter a des personnes du service de maniere aleatoire 

 **Tribu de loups alpha**  
- Formation et organisation de la meute.  
- Exploration de territoires et gestion des ressources.  
- Défis dynamiques : affrontements avec d'autres meutes, catastrophes naturelles, etc.

---

## **Technologies utilisées**  
- **Langage** : Java  
- **Bibliothèques/Frameworks** : (Junit pour les test).  
- **Outils** : (Eclipse).

---

## **Installation et exécution**  
### Prérequis  
- Java JDK 17 ou supérieur.  
- Un IDE compatible avec Java (facultatif).  

---

## **Étapes **  
1. Cloner le dépôt Git :  
   ```bash  
   git clone https://github.com/BARBERO-Tom-2326014b/projet-java-r3.04

---

## **Structure du projet**  
Voici la structure de votre projet :  
```plaintext  
├── src/  
│   ├── personnage/              # Classes liées aux personnages et à l'hôpital fantastique  
│   │   ├── CentreDeQuarantaine.java  
│   │   ├── Creature.java  
│   │   ├── CreatureBestiale.java  
│   │   ├── CreatureTriage.java  
│   │   ├── Crypte.java  
│   │   ├── Elfe.java  
│   │   ├── HommeBete.java  
│   │   ├── HopitalFantastique.java  
│   │   ├── Lycanthrope.java  
│   │   ├── Maladie.java  
│   │   ├── Medecin.java  
│   │   ├── MortVivant.java  
│   │   ├── Orque.java  
│   │   ├── Reptilien.java  
│   │   ├── ServiceMedical.java  
│   │   ├── ServiceMedicalStandard.java  
│   │   ├── TestCreature.java  
│   │   ├── TestHopitalFantastique.java  
│   │   ├── TestMaladie.java  
│   │   ├── TestMedecin.java  
│   │   ├── TestServiceMedical.java  
│   │   ├── Vampire.java  
│   │   ├── VIP.java  
│   │   └── Zombie.java  
│   ├── tp4/                     # Simulation de meute de loups alpha  
│   │   ├── Colonie.java  
│   │   ├── Couple.java  
│   │   ├── Hurlement.java  
│   │   ├── Lycanthrope.java  
│   │   ├── Main.java  
│   │   ├── Meute.java  
│   │   ├── Tuple.java  
│   │   └── TypeHurlement.java  
├── doc/                         # Documentation du projet  
├── README.md                    # Fichier actuel  
├── JUnit 5/                     # Tests unitaires utilisant JUnit 5  
└── JRE System Library [jre]     # Bibliothèque Java Runtime Environment  
```

---

## **Utilisation**

### Hôpital fantastique
- Admettre une créature en tant que patient.
- lancer le jeux avec un nombre de tours :
- - intervalles de temps simuler : ( nombre de tours ou on joue )
- - 1. Examiner un service médical ( choisir un service (liste des services avec le nombre de creatures dans chaque service apparait ) )
- - 2. Soigner les créatures d'un service médical ( choisir un service (liste des services avec le nombre de creatures dans chaque service apparait ), choisir une creature (la liste des creatures avec leurs maladie apparait ) puis cela a 90% de chance de soigner une des maladies du patient)
- - 3. Réviser le budget d'un service médical ( lui rajouter 10000 de budjet )
- - 4. Transférer une créature entre deux services médicaux ( service de depart et d'arriver)
- - 5. Acceuillir un nouveau patient (si un patient arrive et qu'il attend devant l'hopital on peut choisir de l'integrer dans un service )
- Quitter :


### Tribu de loups alpha
- Former une meute
- établir la dominance territoriale.

---

## **Contributeurs**
- Mathias Foucher
- Enzo Bouchami
- Tom Barbero 

---

## **Contact**  

Pour toute question ou suggestion :

- mathiasfoucherr@gmail.com 0763406024
- enzo.bouchami@gmail.com 0778575742
- tom.om.barbero@gmail.com 07 68 89 30 16