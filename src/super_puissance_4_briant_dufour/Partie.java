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
    int compteur=0;
    for (int i=0;i<5;i++){
        int ligne_trou_noir=rand.nextInt(6);
        int colonne_trou_noir=rand.nextInt(7);
        if (compteur<2){
            if (!grille.placerDesintegrateur(ligne_trou_noir,colonne_trou_noir)){
            compteur--;}
        compteur+=1;}
    if (!grille.placerTrouNoir(ligne_trou_noir,colonne_trou_noir)){
        i--;}         
    }
    for (int i=0;i<3; i++){
        int ligne_desint=rand.nextInt(6);
        int colonne_desint=rand.nextInt(7);
        if (!grille.placerDesintegrateur(ligne_desint,colonne_desint)||grille.Cellules[ligne_desint][colonne_desint])
    }
    
}

}
