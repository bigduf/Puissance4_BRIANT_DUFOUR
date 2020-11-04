/*
TP3 - BRIANT Emma DUFOUR Romain
SUPER PUISSANCE 4
 */
package super_puissance_4_briant_dufour;

/**
 *
 * @author romdu
 */
public class Joueur {
    String Nom;
    String Couleur;
    Jeton [] ListeJetons = new Jeton[21];
    int nombreDesintegrateurs = 0;
    int nombreJetonsRestants = 21;

public Joueur(String unNom){
    Nom = unNom;
}
public void affecterCouleur(String uneCouleur){
    Couleur = uneCouleur;
}
public void ajouterJeton(Jeton unJeton){
    /*if (ListeJetons[20] != null){
        break;
    } else {
        liste_voitures[nbVoitures] = voiture_a_ajouter;
        nbVoitures += 1;
        voiture_a_ajouter.proprietaire = this; 
        return true;
    };
    */
    for (int i=0; i<21; i++){
        if (ListeJetons[i] == null){
            ListeJetons[i]=unJeton;
            break;
        }
    }
}
public void obtenirDesintegrateur(){
    nombreDesintegrateurs += 1;
}
public boolean utiliserDesintegrateur(){
    if (nombreDesintegrateurs == 0){
        return false;
    }else{
    System.out.println("Désintégrateur utilisé");
    nombreDesintegrateurs += -1;
    return true;
}
}
}
