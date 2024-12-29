public class Joueur {

    private StringBuffer nom;
    private final int id;
    private int nbrEssaie;

    //constructeur d'un joueur
    public Joueur(StringBuffer nom,int id) {
        this.nom = nom;
        this.id = id;
        this.nbrEssaie = 0;
    }

    //getter du nom du joueur
    public StringBuffer getNom() {
        return this.nom;
    }

    //getter de l'id du joueur
    public int getId() {
        return this.id;
    }

    //setter pour moddifier le nombre d'essaie du joueur 
    public void setNbrEssaie(int e){
        this.nbrEssaie = e;
    }

    //getter du nobmre d'essaie du joueur
    public int getnbrEssaie(){
        return this.nbrEssaie; 
    } 

    //setter pour changer le nom du joueur
    public void setNom(StringBuffer nouveauNom) {
        this.nom = nouveauNom;
    }

    //methodes pour augmenter de 1 le nombre d'essaie du joueur
    public void augmentationEssai() {
        this.nbrEssaie++;
    }

    //methodes pour savoir si le joueur a le droit de jouer
    public boolean autorisationJouer(){
        return this.nbrEssaie < 3;
    }


}
