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
}
