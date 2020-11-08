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
public boolean ajouterJetonDansColonne(Joueur joueur, int nb){
    for (int i=0; i<6; i++){
        if (Cellules[5-i][nb].jetonCourant == null){
            Jeton jeton = null;
            for (int j = 0; j<21; j++){
                if (joueur.ListeJetons[j] != null){
                    jeton = joueur.ListeJetons[j];
                    joueur.ListeJetons[j] = null;
                    break;
                }
            }
            Cellules[5-i][nb].affecterJeton(jeton);
            joueur.nombreJetonsRestants+=-1;
            if (Cellules[5-i][nb].presenceDesintegrateur()){
                Cellules[5-i][nb].recupererDesintegrateur();
                joueur.nombreDesintegrateurs+=1;
                System.out.println("Vous avez gagné un désintégrateur.");
            }
            if (Cellules[5-1][nb].presenceTrouNoir()){
                Cellules[5-i][nb].activerTrouNoir();
                System.out.println("Vous avez été aspiré par un trou noir!!");
            }
            return true;
            
    }
        if (Cellules[0][nb].jetonCourant != null){
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
    for (int i=0; i<6; i++){
        for (int j=0; j<7; j++){
            if (Cellules[i][j].jetonCourant == null){
                if (Cellules[i][j].presenceTrouNoir()&& Cellules[i][j].presenceDesintegrateur()){
                    System.out.print("[t]");
                }else if (Cellules[i][j].presenceDesintegrateur()){
                    System.out.print("[d]");
                }else if (Cellules[i][j].presenceTrouNoir()) {
                    System.out.print("[t]");
                } else {
                    System.out.print("[ ]");
                }
            } else if (Cellules[i][j].jetonCourant.Couleur.equals("rouge")){
                System.out.print("[r]");
            } else if (Cellules[i][j].jetonCourant.Couleur.equals("jaune")){
                System.out.print("[j]");
            }
        }
        System.out.println("");
    }
    
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
    compteur = 0;
    for (int j = 0; j<7; j++){
        for (int i = 0; i<6; i++){
            if (Cellules[i][j].jetonCourant == null){
                compteur=0;
            }
            else if (!Cellules[i][j].jetonCourant.Couleur.equals(couleur)){
                compteur=0;
            }else{
                compteur +=1;
            }
            if (compteur==4){
                return true;
            }
        }
        compteur=0;
    }
    for (int i = 0; i<3; i++){
        for (int j = 0; j<4; j++){
            if (Cellules[i][j].jetonCourant != null && Cellules[i+1][j+1].jetonCourant != null && Cellules[i+2][j+2].jetonCourant != null && Cellules[i+3][j+3].jetonCourant != null){
                if (Cellules[i][j].jetonCourant.Couleur.equals(couleur) && Cellules[i+1][j+1].jetonCourant.Couleur.equals(couleur) && Cellules[i+2][j+2].jetonCourant.Couleur.equals(couleur) && Cellules[i+3][j+3].jetonCourant.Couleur.equals(couleur)){
                    return true;
                }   
            }
        }
    }
    for (int i = 0; i<3; i++){
        for (int j = 3; j<7; j++){
            if (Cellules[i][j].jetonCourant != null && Cellules[i+1][j-1].jetonCourant != null && Cellules[i+2][j-2].jetonCourant != null && Cellules[i+3][j-3].jetonCourant != null){
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

    





