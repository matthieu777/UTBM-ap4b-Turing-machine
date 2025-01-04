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
            case 6 -> v3 < v1 && v3 < v2;
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
                String code = String.valueOf(v1) + String.valueOf(v2) + String.valueOf(v3);
                    int oneCount = countOnes(code);
                    yield oneCount == 1;
            }
            case 19 -> v1 % 2 == 0;
            case 20 -> v2 < 3;
            case 21 -> v1 > v3;
            case 22 -> (v1 + v2 + v3) % 2 == 0;
            case 23 -> v1 + v2 < 6;
            case 24 -> v2 == 5;
            case 25 -> v1 % 2 != 0;
            case 26 -> v1 < 4;
            case 27 -> v3 == 5;
            case 28 -> v3 % 2 != 0;
            case 29 -> v2 > v3 && v2 > v1;
            case 30 -> v1 < 1;
            case 31 -> v1 == v2;
            case 32 -> v1 > 3;
            case 33 -> v2 % 2 != 0;
            case 34 -> v2 < 4;
            case 35 -> v2 < v1 && v2 < v3;
            case 36 -> v3 > v1 && v3 > v2;
            case 37 -> {
                String code = String.valueOf(v1) + String.valueOf(v2) + String.valueOf(v3);
                int threeCount = countThrees(code);
                yield threeCount == 1;
            }
            case 38 -> {
                
                String code = String.valueOf(v1) + String.valueOf(v2) + String.valueOf(v3);
                int[] digitCounts = countDigitOccurrences(code);

                // Comparer les occurrences des chiffres avec le code associé à l'ID
                boolean isValid = true;
                for (int i = 0; i < digitCounts.length; i++) {
                    if (digitCounts[i] > 1) {
                        System.out.println("Digit " + i + " appears " + digitCounts[i] + " times.");
                        isValid = false;
                    }
                }
                yield isValid;
            }
            default -> false;
        };
    }
    // Méthode pour compter les occurrences du chiffre "1" dans une chaîne de caractères
    private int countOnes(String codeSnippet) {
        return (int) codeSnippet.chars().filter(ch -> ch == '1').count();
    }

    // Méthode pour compter les occurrences du chiffre "3" dans une chaîne de caractères
    private int countThrees(String codeSnippet) {
        return (int) codeSnippet.chars().filter(ch -> ch == '3').count();
    }
     // Méthode pour compter les occurrences de chaque chiffre de 0 à 9 dans une chaîne
    private int[] countDigitOccurrences(String codeSnippet) {
        int[] digitCounts = new int[10]; // Tableau pour suivre le nombre d'occurrences des chiffres 0 à 9
        codeSnippet.chars()
            .filter(Character::isDigit) // Filtrer uniquement les caractères numériques
            .forEach(ch -> digitCounts[ch - '0']++); // Incrémenter le compteur du chiffre correspondant
        return digitCounts;
    }
}


