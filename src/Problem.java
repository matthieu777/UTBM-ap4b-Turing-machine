import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JComponent;


public abstract class Problem {

    private final int nbrcarte;

    protected int selectedCarteId = -1; 
    
    protected int[] code;
    protected CarteCritere[] listeCartes;
    protected int[] idcartes;

    public abstract  JComponent[] afficherProbleme(int nbprob);
    public abstract int[] getCode();

    //constucteur de la calsse Problem
    public Problem(int nbrcarte) {
        this.nbrcarte = nbrcarte;
        this.listeCartes = new CarteCritere[nbrcarte];
    }


    //methode pour generer des nombres random de 0 au nombre donner
    public int genererandom(int x) {
        int nombre;
        Random rand = new Random();
        nombre = rand.nextInt(x);  // Genere une nombre entre 0 et x
        return nombre;
    }


    //recuperation dans le fichier texte le code reponse au probleme
    public Map<Integer,int[]> genererprobcode() {

        Map<Integer, int[]> questionCodeMap = new HashMap<>();

        String filePath = "src/texteproblem/texte"+nbrcarte+".txt";
        String alternateFilePath = "texteproblem/texte"+nbrcarte+".txt";

        File file = new File(filePath);

        if (!file.exists()) {
            filePath = alternateFilePath;
            file = new File(filePath);
        }

        if (!file.exists()) {
            System.err.println("Le fichier contenant les problemes à "+nbrcarte+" cartes est introuvable");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int questionNumber = Integer.parseInt(parts[0].trim()); // Recuperer la numero de probleme
                    String codestr = (parts[2].trim());  //Recuperer le code en chaine
                    int[] tabCode=new int[codestr.length()];
                    for(int i=0;i<codestr.length();i++)
                    {
                        tabCode[i]=Character.getNumericValue(codestr.charAt(i));//Convertir le code en int et stock dans tableau
                    }
                    questionCodeMap.put(questionNumber,tabCode);// Stocker la numero de probleme et le code
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du code du problem : " + e.getMessage());
        }

        return questionCodeMap;
    }



     //recuperation des id dans le fichier des cartes necessaire au probleme
    public Map<Integer,int[]> genererprobid() {
        Map<Integer, int[]> questionCardsMap = new HashMap<>();
        String filePath = "src/texteproblem/texte"+nbrcarte+".txt";
        String alternateFilePath = "texteproblem/texte"+nbrcarte+".txt";

        File file = new File(filePath);

        if (!file.exists()) {
            filePath = alternateFilePath;
            file = new File(filePath);
        }

        if (!file.exists()) {
            System.err.println("Le fichier contenant les problemes à "+nbrcarte+" cartes est introuvable");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int questionNumber = Integer.parseInt(parts[0].trim()); // Recuperer la numero de probleme
                    String[] cardIDstr = parts[1].trim().split(",");// Recuperer les ids des cartes pour le probleme dans un tableau
                    int[] cardIDInt = new int[cardIDstr.length]; 

                    for (int i = 0; i < cardIDstr.length; i++) {
                        cardIDInt[i] = Integer.parseInt(cardIDstr[i].trim()); // Convertir et stocker dans un tableau int[]
                    }

                    questionCardsMap.put(questionNumber, cardIDInt); // Stocker la numero de probleme et les ids
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'id du problem : " + e.getMessage());
        }
        
        return questionCardsMap;

    }


    //getter qui retourne la carte selectioner avec le bouton radio
    public int getCartesSelectionne() {
        return selectedCarteId;
    }



}


