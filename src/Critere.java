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
            case 1 -> v1 > 1;
            case 2 -> v2 > v1;
            case 3 -> v1 + v2 == 6;
            case 4 -> v1 == 3;
            case 5 -> v1 == v3 ;
            case 6 -> v3 < v1 + v2;
            case 7 -> (v1 + v2 + v3) % 2 != 0;
            case 8 -> v2 == 4;
            case 9 -> v3 % 2 == 0;
            case 10 -> v2 > v3;
            case 11-> v1 > v2 + v3;
            case 12 -> v1 < 3;
            case 13 -> v1 + v2 + v3 == 6;
            case 14 -> v2 % 2 == 0;
            case 15 -> v2 == v3;
            case 16 -> v3 == 3;
            case 17 -> v3 > v1;
            case 18 -> {
                // Vérification nombre "1" dans le code
                String code = """
                        case 1 -> v1 > 1;
                        case 2 -> v2 > v1;
                        case 3 -> v1 + v2 == 6;
                        case 4 -> v1 == 3;
                        case 5 -> v1 == v3 ;
                        case 6 -> v3 < v1 + v2;
                        case 7 -> (v1 + v2 + v3) % 2 != 0;
                        case 8 -> v2 == 4;
                        case 9 -> v3 % 2 == 0;
                        case 10 -> v2 > v3;
                        case 11-> v1 > v2 + v3;
                        case 12 -> v1 < 3;
                        case 13 -> v1 + v2 + v3 == 6;
                        case 14 -> v2 % 2 == 0;
                        case 15 -> v2 == v3;
                        case 16 -> v3 == 3;
                        case 17 -> v3 > v1;
                        """;
                    int oneCount = countOnes(code);
                    yield oneCount == 1;
            }
            default -> false;
        };
    }
    // Méthode pour compter les occurrences du chiffre "1" dans une chaîne de caractères
    private int countOnes(String codeSnippet) {
        return (int) codeSnippet.chars().filter(ch -> ch == '1').count();
    }
}

