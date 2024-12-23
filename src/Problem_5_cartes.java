import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Problem_5_cartes extends Problem {

    private CarteCritere[] listeCartes = new CarteCritere[5];

    Map<Integer, int[]> probEtId = new HashMap<>(); // key= numero de problem  value:id des cartes criteres
    Map<Integer, int[]> probEtCode = new HashMap<>();// key= numero de problem  value:code
    
    int nbprob;
    int[] idcartes;
    int[] code;


public int genererandom()
{
    int nombre;
     Random rand = new Random();
    nombre = rand.nextInt(6); // Genere une nombre entre 0 et 5
    return nombre;
}

public Map<Integer,int[]> genererprobcode() 
{
    Map<Integer, int[]> questionCodeMap = new HashMap<>();
    
    String filePath = "src/texteproblem/texte5.txt";

    String alternateFilePath = "texteproblem/texte5.txt";

    File file = new File(filePath);

    if (!file.exists()) {
        filePath = alternateFilePath;
        file = new File(filePath);
    }

    if (!file.exists()) {
        System.err.println("Le fichier contenant les problemes à 5 cartes est introuvable");
    }

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length == 3) {
                int questionNumber = Integer.parseInt(parts[0].trim()); // Recuperer la numero de probleme
                String codestr = (parts[2].trim()); //Recuperer le code en chaine
                int[] tabCode=new int[codestr.length()];
                for(int i=0;i<codestr.length();i++)
                {
                    tabCode[i]=Character.getNumericValue(codestr.charAt(i));//Convertir le code en int et stock dans tableau
                }
                questionCodeMap.put(questionNumber,tabCode);// Stocker la numero de probleme et le code
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return questionCodeMap;



}
    public Map<Integer,int[]> genererprobid()
    {
        Map<Integer, int[]> questionCardsMap = new HashMap<>();
        String filePath = "src/texteproblem/texte5.txt";
        String alternateFilePath = "texteproblem/texte5.txt";

        File file = new File(filePath);

        if (!file.exists()) {
            filePath = alternateFilePath;
            file = new File(filePath);
        }

        if (!file.exists()) {
            System.err.println("Le fichier contenant les problemes à 5 cartes est introuvable");
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
            e.printStackTrace();
        }
        

        return questionCardsMap;

    }


    
    
    @Override
    public JComponent[] afficherProbleme() {

        nbprob=genererandom(); //generer le numero de probleme au random
        System.out.println("nbprob="+nbprob);
        probEtId=genererprobid();//generer un map contenant un problemes et les id des cartes
        probEtCode=genererprobcode();//generer un map contenant un problemes et le codestr concerne

        //test afficher
        /*************************************************************************** */
         idcartes=probEtId.get(nbprob); //Recuperer les id depuis le map
        //afficher les ids
        System.out.print("id cartes= " );
        for(int i=0;i<idcartes.length;i++)
        {
            System.out.print( idcartes[i] + " ");
        } 
        System.out.println("" );

        //afficher les code
        System.out.print("code= " );
         code = probEtCode.get(nbprob); //Recuperer le code depuis le map
            for(int i = 0; i < code.length; i++)
            {
                 System.out.print(code[i] + " ");
            }
        System.out.println("");
        /*************************************************************************** */

        ButtonGroup group = new ButtonGroup();//pour gerer les radiobuttons


        JPanel panneau = new JPanel();
        panneau.setLayout(null);
        panneau.setBounds(70, 200, 1700, 800);
        panneau.setOpaque(false);
        
        CarteCritere carte1 = BaseDeCartes.getCarte(idcartes[0]);
        JComponent[] composants1 = carte1.afficherCarte(0, 0);
        panneau.add(composants1[0]);
        panneau.add(composants1[1]); 
        JRadioButton rb1 = new JRadioButton();
        rb1.setBounds(90, 200, 20, 20);
        rb1.setBorderPainted(true);
        group.add(rb1);
        panneau.add(rb1);

        
        CarteCritere carte2 = BaseDeCartes.getCarte(idcartes[1]);
        JComponent[] composants2 = carte2.afficherCarte(250, 0);
        panneau.add(composants2[0]);
        panneau.add(composants2[1]);

        JRadioButton rb2 = new JRadioButton();
        rb2.setBounds(340, 200, 20, 20);
        rb2.setBorderPainted(true);
        group.add(rb2);
        panneau.add(rb2);
        
        CarteCritere carte3 = BaseDeCartes.getCarte(idcartes[2]);
        JComponent[] composants3 = carte3.afficherCarte(500, 0);
        panneau.add(composants3[0]);
        panneau.add(composants3[1]);

        JRadioButton rb3 = new JRadioButton();
        rb3.setBounds(585, 200, 20, 20);
        rb3.setBorderPainted(true);
        group.add(rb3);
        panneau.add(rb3);

        CarteCritere carte4 = BaseDeCartes.getCarte(idcartes[3]);
        JComponent[] composants4 = carte4.afficherCarte(750, 0);
        panneau.add(composants4[0]);
        panneau.add(composants4[1]);

        JRadioButton rb4 = new JRadioButton();
        rb4.setBounds(840, 200, 20, 20);
        rb4.setBorderPainted(true);
        group.add(rb4);
        panneau.add(rb4);

        CarteCritere carte5 = BaseDeCartes.getCarte(idcartes[4]);
        JComponent[] composants5 = carte5.afficherCarte(1000, 0);
        panneau.add(composants5[0]);
        panneau.add(composants5[1]);

        JRadioButton rb5 = new JRadioButton();
        rb5.setBounds(1090, 200, 20, 20);
        rb5.setBorderPainted(true);
        group.add(rb5);
        panneau.add(rb5);


        


        panneau.setComponentZOrder(rb1, 0); // Bring rb1 to the front
        panneau.setComponentZOrder(rb2, 0);
        panneau.setComponentZOrder(rb3, 0);
        panneau.setComponentZOrder(rb4, 0);
        panneau.setComponentZOrder(rb5, 0);
        

        
        return new JComponent[] { panneau };
    }
}
