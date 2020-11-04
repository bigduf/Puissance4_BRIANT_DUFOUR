/*
TP3 - BRIANT Emma DUFOUR Romain
SUPER PUISSANCE 4
 */
package super_puissance_4_briant_dufour;

/**
 *
 * @author romdu
 */
public class Jeton {
    String Couleur;
 
    
public Jeton (String uneCouleur){
    Couleur = uneCouleur;
}
public void LireCouleur (){
    System.out.println("Le jeton est "+ Couleur);
}
}
