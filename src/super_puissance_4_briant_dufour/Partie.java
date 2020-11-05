/*
TP3 - BRIANT Emma DUFOUR Romain
SUPER PUISSANCE 4
 */

package super_puissance_4_briant_dufour;

import java.util.Random;

/**
 *
 * @author romdu
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    
public void attribuerCouleurAuxJoueurs(){
    ListeJoueurs[0].affecterCouleur("rouge");
    ListeJoueurs[1].affecterCouleur("jaune");
}

public void initialiserPartie(){
    Cellule [][] Cellules = new Cellule[6][7];
    Grille grille = new Grille(Cellules);
    grille.viderGrille();
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
    
    Random rand = new Random();
    boolean premier = rand.nextBoolean();
    if (premier==true){
        JoueurCourant=Listejoueurs[0];
    }else{
        JoueurCourant=Listejoueurs[1];
    }
    
   
    for (int i=0;i<2;i++){
        int ligne=rand.nextInt(6);
        int colonne=rand.nextInt(7);
        grille.placerDesintegrateur(ligne,colonne);
        grille.placerTrouNoir(ligne,colonne);    
    }
    for (int i=0;i<3; i++){
        int ligne=rand.nextInt(6);
        int colonne=rand.nextInt(7);
        grille.placerDesintegrateur(ligne,colonne);
    }
    for (int i=0;i<3; i++){
        int ligne=rand.nextInt(6);
        int colonne=rand.nextInt(7);
        grille.placerTrouNoir(ligne,colonne);
    }
    
}

 public void debuterPartie(){
     Cellule [][] Cellules = new Cellule[6][7];
     Grille GrilleDeJeu = new Grille(Cellules);
     while (GrilleDeJeu.etreGagnantePourJoueur(ListeJoueurs[0]) != true || GrilleDeJeu.etreGagnantePourJoueur(ListeJoueurs[1]) != true ){
        Scanner sc=new Scanner(System.in);
        System.out.println("Actions possibles :");
        System.out.println("1. Placer un jeton");
        System.out.println("2. Récupérer un jeton");
        System.out.println("3. Utiliser un désintégrateur");
        int action=sc.nextInt();
        while (action<1 || action>3){
            System.out.println("Entrer un chiffre entre 1 et 3.");
            action=sc.nextInt();
    }
        if (action==1){
            boolean
        }
    
}