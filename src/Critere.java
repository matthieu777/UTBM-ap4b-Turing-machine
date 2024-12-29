public class Critere {

    private final int id;
    
    //constructeur de la classe critere
    public Critere(int id) {
        this.id = id;
    }

    //getter pour avoir l'id d'un critere
    public int getid(){
        return id;
    }

    //methode pour intergoer un critere (change les condition en fonction de l'id du critere)
    public boolean verifier(int v1, int v2, int v3) {
        return switch (id) {
            case 1 -> v1 > v2 && v1 > v3;
            case 2 -> false;
            default -> false;
        };
    }
}