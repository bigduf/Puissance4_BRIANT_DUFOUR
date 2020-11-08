/*
TP3 - BRIANT Emma DUFOUR Romain
SUPER PUISSANCE 4
 */

package super_puissance_4_briant_dufour;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author romdu
 */

public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille GrilleDeJeu = new Grille();
    
public void attribuerCouleurAuxJoueurs(){
    ListeJoueurs[0].affecterCouleur("rouge");
    ListeJoueurs[1].affecterCouleur("jaune");
}

public void initialiserPartie(){
    GrilleDeJeu.viderGrille();
    Random rand = new Random();
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Choix du pseudo du J1 : ");
    Joueur joueur1 = new Joueur(sc.nextLine());
    System.out.println("Choix du pseudo du J2 : ");
    Joueur joueur2 = new Joueur(sc.nextLine());
    ListeJoueurs[0] = joueur1;
    ListeJoueurs[1] = joueur2;
    
    attribuerCouleurAuxJoueurs();
    System.out.println("La couleur de " + joueur1.Nom + " est " + joueur1.Couleur);
    System.out.println("La couleur de " + joueur2.Nom + " est " + joueur2.Couleur);
    
    
    for (int i = 0; i<21; i++){
        Jeton jeton1 = new Jeton(joueur1.Couleur);
        joueur1.ajouterJeton(jeton1);
        Jeton jeton2 = new Jeton(joueur2.Couleur);
        joueur2.ajouterJeton(jeton2);
    }
    
    boolean premier = rand.nextBoolean();
    if (premier==true){
        joueurCourant=ListeJoueurs[0];
    }else{
        joueurCourant=ListeJoueurs[1];
    }
    
   
    for (int i=0;i<2;i++){
        int ligne=rand.nextInt(6);
        int colonne=rand.nextInt(7);
        GrilleDeJeu.placerDesintegrateur(ligne,colonne);
        GrilleDeJeu.placerTrouNoir(ligne,colonne);    
    }
    for (int i=0;i<3; i++){
        int ligne=rand.nextInt(6);
        int colonne=rand.nextInt(7);
        GrilleDeJeu.placerDesintegrateur(ligne,colonne);
    }
    for (int i=0;i<3; i++){
        int ligne=rand.nextInt(6);
        int colonne=rand.nextInt(7);
        GrilleDeJeu.placerTrouNoir(ligne,colonne);
    }
    
}

 public void debuterPartie(){
     Joueur joueur1 = ListeJoueurs[0];
     Joueur joueur2 = ListeJoueurs[1];
     while ((GrilleDeJeu.etreGagnantePourJoueur(joueur1) != true) || (GrilleDeJeu.etreGagnantePourJoueur(joueur2) != true )){
        Scanner sc=new Scanner(System.in);
        System.out.println("Actions possibles :");
        System.out.println("1. Placer un jeton");
        System.out.println("2. Récupérer un jeton");
        System.out.println("3. Utiliser un désintégrateur");
        System.out.println("Que voulez-vous faire ?");
        int action=sc.nextInt();
        while (action<1 || action>3){
            System.out.println("Entrer un chiffre entre 1 et 3.");
            action=sc.nextInt();
        }
        switch (action){
            case 1 : 
                System.out.println("Vous avez décidé de jouer un jeton !");
                System.out.println("Veuillez entrer une colonne");
                int colonne = sc.nextInt()-1;
                while (colonne < 0 || colonne > 6){
                    System.out.println("Veuillez entrer une colonne");
                    colonne = sc.nextInt()-1;
                }
                Jeton jetonAJouer = null;
                for (int i = 0; i<21; i++){
                   if (joueurCourant.ListeJetons[i] != null){
                       jetonAJouer = joueurCourant.ListeJetons[i];
                       break;
                   }
                }
                boolean jetonJoue = GrilleDeJeu.ajouterJetonDansCollone(jetonAJouer,colonne);
                while (jetonJoue == false){
                    System.out.println("Colonne pleine. Veuillez en choisir une autre: ");
                    colonne = sc.nextInt()-1;
                    jetonJoue = GrilleDeJeu.ajouterJetonDansCollone(jetonAJouer,colonne);
                }
                if (joueurCourant == ListeJoueurs[0]){
                    joueurCourant = ListeJoueurs[1];
                }else{
                    joueurCourant = ListeJoueurs[0];
                }
                break;
            case 2 :
                int colonneRecup;
                int ligneRecup;
                System.out.println("Vous avez décidé de récupérer un jeton !");
                System.out.println("Veuillez saisir la colonne : ");
                colonneRecup = sc.nextInt()-1;
                while (colonneRecup<0 || colonneRecup>6){
                    System.out.println("Veuillez saisir une colonne valide (entre 1 et 7).");
                    colonneRecup = sc.nextInt()-1;
                }
                System.out.println("Veuillez saisir la ligne : ");
                ligneRecup = sc.nextInt()-1;               
                while (ligneRecup<0 || ligneRecup>5){
                    System.out.println("Veuillez saisir une ligne valide (entre 1 et 6.");
                    ligneRecup = sc.nextInt()-1;
                }   
                if (GrilleDeJeu.Cellules[ligneRecup][colonneRecup].jetonCourant != null && GrilleDeJeu.Cellules[ligneRecup][colonneRecup].lireCouleurDuJeton().equals(joueurCourant.Couleur)){
                    joueurCourant.ajouterJeton(GrilleDeJeu.recupererJeton(ligneRecup, colonneRecup));
                    GrilleDeJeu.tasserGrille(colonneRecup);
                }
                break;
            case 3:
                if(joueurCourant.nombreDesintegrateurs==0){
                    break;
                }
                int colonneDesint;
                int ligneDesint;
                System.out.println("Vous avez décidé de désintégrer un jeton !");
                System.out.println("Veuillez saisir la colonne : ");
                colonneDesint = sc.nextInt()-1;
                while (colonneDesint<0 || colonneDesint>6){
                    System.out.println("Veuillez saisir une colonne valide (entre 1 et 7).");
                    colonneDesint = sc.nextInt()-1;
                }
                System.out.println("Veuillez saisir la ligne : ");
                ligneDesint = sc.nextInt()-1;               
                while (ligneDesint<0 || ligneDesint>5){
                    System.out.println("Veuillez saisir une ligne valide (entre 1 et 6.");
                    ligneDesint = sc.nextInt()-1;
                } 
                if (GrilleDeJeu.Cellules[ligneDesint][colonneDesint].jetonCourant != null){
                    GrilleDeJeu.supprimerJeton(ligneDesint, colonneDesint);
                    GrilleDeJeu.tasserGrille(colonneDesint);
                    joueurCourant.utiliserDesintegrateur();
                }
                break;
    }
}
 
 
 
}
}