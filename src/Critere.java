public class Critere {
    private int id;
    

    public Critere(int id) {
        this.id = id;
    }

    public boolean verifier(int v1, int v2, int v3){
        switch(id){
            case 1:
                return v1 < v2 && v1 < v3;
            case 2:
                return v1 > v2 && v1 > v3;
            default:
                return false;
        }

    }
}
