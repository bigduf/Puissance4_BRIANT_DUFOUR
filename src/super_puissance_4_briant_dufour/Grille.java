/*
TP3 - BRIANT Emma DUFOUR Romain
SUPER PUISSANCE 4
 */
package super_puissance_4_briant_dufour;

/**
 *
 * @author romdu
 */
public class Grille {
    Cellule [][] Cellules = new Cellule[6][7];

public Grille(){
    for (int i=0 ; i<6 ; i++) {
        for (int j=0; j<7; j++){
            Cellules[i][j] = new Cellule();    
        }
}
}
public boolean ajouterJetonDansCollone(Jeton jeton, int nb){
    for (int i=0; i<6; i++){
        if (Cellules[5-i][nb] == null){
            Cellules[5-i][nb].affecterJeton(jeton);
            return true;
    }
        if (Cellules[0][nb] != null){
            return false;
        }
}  
    return true;
}

public boolean etreRemplie(){
    boolean pleine = true;
    for (int i=0; i<7; i++){
        if (Cellules[0][i]!=null){
            pleine = true;
        }else{
            return false;
        }                    
    }
        return pleine;

}

public void viderGrille(){
    for (int i=0; i<6; i++){
        for (int j=0; j<7; j++){
            Cellules[i][j].jetonCourant = null;
        }
    }
}
public void afficherGrilleSurConsole(){
    
    
}
public boolean celluleOccupee(int ligne, int colonne){
    if (Cellules[ligne][colonne].recupererJeton() != null){
        return true;
    }else{
        return false;
    }
 
}

public String lireCouleurDuJeton (int ligne, int colonne){
    return Cellules[ligne][colonne].lireCouleurDuJeton();
}


public boolean etreGagnantePourJoueur(Joueur Bob){
    String couleur = Bob.Couleur;
    int compteur = 0;
    for (int i = 0; i<6; i++){
        for (int j = 0; j<7; j++){
            if (Cellules[i][j].jetonCourant == null){
                compteur=0;
            }
            else if (!Cellules[i][j].jetonCourant.Couleur.equals(couleur)){
                compteur=0;
            }else{
                compteur += 1;
            }
            if (compteur==4){
                return true;
            }
        }
        compteur=0;
    } 
    for (int j = 0; j<7; j++){
        for (int i = 0; i<6; i++){
            if (Cellules[i][j].jetonCourant == null){
                compteur=0;
            }
            else if (!Cellules[i][j].jetonCourant.Couleur.equals(couleur)){
                compteur=0;
            }else{
                compteur = 0;
            }
            if (compteur==4){
                return true;
            }
        }
        compteur=0;
    }
    for (int i = 0; i<3; i++){
        for (int j = 0; j<4; j++){
            if (Cellules[i][j].jetonCourant != null){
                if (Cellules[i][j].jetonCourant.Couleur.equals(couleur) && Cellules[i+1][j+1].jetonCourant.Couleur.equals(couleur) && Cellules[i+2][j+2].jetonCourant.Couleur.equals(couleur) && Cellules[i+3][j+3].jetonCourant.Couleur.equals(couleur)){
                    return true;
                }   
            }
        }
    }
    for (int i = 0; i<3; i++){
        for (int j = 3; j<7; j++){
            if (Cellules[i][j].jetonCourant != null){
                if (Cellules[i][j].jetonCourant.Couleur.equals(couleur) && Cellules[i+1][j-1].jetonCourant.Couleur.equals(couleur) && Cellules[i+2][j-2].jetonCourant.Couleur.equals(couleur) && Cellules[i+3][j-3].jetonCourant.Couleur.equals(couleur)){
                    return true;
            }
        }
    } 
}
return false;
}
    

public void tasserGrille(int j){
    for (int i=0;i<5;i++){
        if(Cellules[5-i][j].jetonCourant==null){
           Cellules[5-i][j].jetonCourant=Cellules[4-i][j].jetonCourant;
           Cellules[4-i][j].jetonCourant=null;
        }
    }
}
    

public boolean colonneRemplie(int colonne){
    if (Cellules[0][colonne].recupererJeton() != null){
        return true;
    }
    return false;
}

public boolean placerTrouNoir(int i, int j){
    if (Cellules[i][j].presenceTrouNoir()==false){
        Cellules[i][j].placerTrouNoir();
        return true;
    }
    return false;
}
public boolean placerDesintegrateur(int i,int j){
    if (Cellules[i][j].presenceDesintegrateur()==false){
        Cellules[i][j].placerDesintegrateur();
        return true;
    }
    return false;
}
public boolean supprimerJeton(int i,int j){
    if (Cellules[i][j].recupererJeton()!=null){
        Cellules[i][j].supprimerJeton();
        return true;
    }
    return false;
}
public Jeton recupererJeton(int i, int j){
    Jeton jeton=Cellules[i][j].recupererJeton();
    Cellules[i][j].supprimerJeton();
    return jeton;
}

}

    





