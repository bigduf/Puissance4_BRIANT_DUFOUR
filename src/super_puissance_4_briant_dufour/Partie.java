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
    for (int i = 0; i<21; i++){
        Jeton jeton = new Jeton("rouge");
        ListeJoueurs[0].ListeJetons[i] = jeton;
    }
    for (int i = 0; i<21; i++){
        Jeton jeton = new Jeton("jaune");
        ListeJoueurs[1].ListeJetons[i] = jeton;
    }
}

/*
 public void debuterPartie(){
     while ()

}
*/
}