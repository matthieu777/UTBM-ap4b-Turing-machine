import java.util.ArrayList;
import java.util.List;

public class GroupeDeJoueur {

    private int nombreDeJoueurs;
    private List<Joueur> listDeJoueurs = new ArrayList<>();

    public GroupeDeJoueur(int nombreDeJoueurs) {
        this.nombreDeJoueurs = nombreDeJoueurs;
        for (int i = 1; i <= nombreDeJoueurs; i++) {
            StringBuffer nom = new StringBuffer("Joueur ").append(i);
            listDeJoueurs.add(new Joueur(nom, i));
        }
    }

    public String[] getNomsJoueurs() {
        String[] nomsJoueurs = new String[listDeJoueurs.size()];
        for (int i = 0; i < listDeJoueurs.size(); i++) {
            nomsJoueurs[i] = listDeJoueurs.get(i).getNom().toString();
        }
        return nomsJoueurs;
    }

    public List<Joueur> getListDeJoueurs() {
        return listDeJoueurs;
    }
}
