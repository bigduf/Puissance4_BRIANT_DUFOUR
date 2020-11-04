/*
TP3 - BRIANT Emma DUFOUR Romain
SUPER PUISSANCE 4
 */
package super_puissance_4_briant_dufour;

/**
 *
 * @author romdu
 */
public class Super_Puissance_4_BRIANT_DUFOUR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jeton Jeton1 = new Jeton ("jaune");
        Jeton1.LireCouleur();
        
        Joueur Joueur1 = new Joueur ("Bob");
        Joueur1.affecterCouleur("jaune");
        System.out.println(Joueur1.Couleur);
        Joueur1.ajouterJeton(Jeton1);
        System.out.println(Joueur1.ListeJetons[0].Couleur);
        System.out.println(Joueur1.utiliserDesintegrateur());
    }
    
}
