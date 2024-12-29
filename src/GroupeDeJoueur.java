import java.util.ArrayList;
import java.util.List;

public class GroupeDeJoueur {

    //private int nombreDeJoueurs;
    private final List<Joueur> listDeJoueurs = new ArrayList<>();

    //construction du groupe de joueur avec le nombre de joueur voulue
    public GroupeDeJoueur(int nombreDeJoueurs) {
        //this.nombreDeJoueurs = nombreDeJoueurs;
        for (int i = 1; i <= nombreDeJoueurs; i++) { //boucle de creation de nouveau joueur 
            StringBuffer nom = new StringBuffer("       Joueur ").append(i);
            listDeJoueurs.add(new Joueur(nom, i));
        }
    }

    //methodes pour avoir une liste des noms des joueurs
    public String[] getNomsJoueurs() { 
        String[] nomsJoueurs = new String[listDeJoueurs.size()];
        for (int i = 0; i < listDeJoueurs.size(); i++) {
            nomsJoueurs[i] = listDeJoueurs.get(i).getNom().toString();
        }
        return nomsJoueurs;
    }

    //getter pour recuperer la liste de joueur
    public List<Joueur> getListDeJoueurs() {
        return listDeJoueurs;
    }

    //verification si tout les joeurs sont a 3 essaie ou non
    public boolean groupePeutJouer() {
        for (Joueur joueur : listDeJoueurs) {
            if (joueur.autorisationJouer()) {
                return true; // si un joueur peut encore jouer
            }
        }
        return false; //si tout les joueur on jouer
    }

    //methodes pour remetre à 0 le nombre d'essaie de tous les joueurs
    public void reinitialiserEssais() {
        for (Joueur joueur : listDeJoueurs) {
            joueur.setNbrEssaie(0);
        }
    }
}
