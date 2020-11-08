/*
TP3 - BRIANT Emma DUFOUR Romain
SUPER PUISSANCE 4
 */

package super_puissance_4_briant_dufour;

/**
 *
 * @author romdu
 */
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
public Cellule(){
    jetonCourant = null;
    trouNoir = false;
    desintegrateur = false;
}
public boolean affecterJeton(Jeton unJeton){
    if (jetonCourant == null){
        jetonCourant = unJeton;
        return true;
    }else{
        return false;
    }
}
public Jeton recupererJeton(){
    return jetonCourant;
}
public boolean supprimerJeton(){
    if (jetonCourant != null){
        jetonCourant = null;
        return true;
    }else{
        return false;
}
}
public boolean placerTrouNoir(){
    if (trouNoir == false){
        trouNoir = true;
        return true;
    }else{
        return false;
}
}
public boolean placerDesintegrateur(){
    if (desintegrateur == false){
        desintegrateur = true;
        return true;
    }else{
        return false;
}       
}
public boolean presenceTrouNoir(){
    if (trouNoir == true){
        return true;
    }else{
        return false;
    }
}
public boolean presenceDesintegrateur(){
    if (desintegrateur == true){
        return true;
    }else{
        return false;
    }
}
public String lireCouleurDuJeton(){
    return jetonCourant.Couleur;
}
public boolean recupererDesintegrateur(){
    if (desintegrateur == true){
        desintegrateur = false;
        return true;
    }else{
        return false;
}
}
public boolean activerTrouNoir(){
    if (trouNoir == true){
        jetonCourant = null;
        trouNoir = false;
        return true;
    }else{
        return false;
}
}
}