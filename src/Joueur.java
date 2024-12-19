public class Joueur {

    private StringBuffer nom;
    private int id;
    private int nbrEssaie;

    public Joueur(StringBuffer nom,int id) {
        this.nom = nom;
        this.id = id;
        this.nbrEssaie = 0;
    }

    public boolean autorisationJouer(Joueur joueur){
        if(joueur.nbrEssaie < 3){
            return true;
        } else {
            return false;
        }
    }
    

}
