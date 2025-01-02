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

    //methode pour interroger un critere (change les condition en fonction de l'id du critere)
    public boolean verifier(int v1, int v2, int v3) {
        return switch (id) {
            case 1 -> v1 > v2;
            case 2 -> v1 + v2 > v3;
            case 3 -> v1 == v2 && v2 == v3;
            case 4 -> v1 + v2 < 3;
            case 5 -> v1 + v3 < 3;
            case 6 -> v2 + v3 < 3;
            case 7 -> v1 + v2 + v3 == 6;
            case 8 -> v1 + v3 < v2;
            case 9 -> v2 + v3 < v1;
            case 10 -> v1 < v2;
            case 11-> v1 > v3;
            case 12 -> v2 < v3;
            default -> false;
        };
    }
}