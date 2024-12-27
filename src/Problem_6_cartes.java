import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicRadioButtonUI;

public class Problem_6_cartes extends Problem {

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
    nombre = rand.nextInt(6);// Genere une nombre entre 0 et 5
    return nombre;
}

public Map<Integer,int[]> genererprobcode() 
{

    Map<Integer, int[]> questionCodeMap = new HashMap<>();

    String filePath = "src/texteproblem/texte6.txt";
    String alternateFilePath = "texteproblem/texte6.txt";

    File file = new File(filePath);

    if (!file.exists()) {
        filePath = alternateFilePath;
        file = new File(filePath);
    }

    if (!file.exists()) {
        System.err.println("Le fichier contenant les problemes à 6 cartes est introuvable");
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
        e.printStackTrace();
    }

    return questionCodeMap;



}
    public Map<Integer,int[]> genererprobid()
    {
        Map<Integer, int[]> questionCardsMap = new HashMap<>();

        String filePath = "src/texteproblem/texte6.txt";
        String alternateFilePath = "texteproblem/texte6.txt";

        File file = new File(filePath);

        if (!file.exists()) {
            filePath = alternateFilePath;
            file = new File(filePath);
        }

        if (!file.exists()) {
            System.err.println("Le fichier contenant les problemes à 6 cartes est introuvable");
        }


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int questionNumber = Integer.parseInt(parts[0].trim());// Recuperer la numero de probleme
                    String[] cardIDstr = parts[1].trim().split(",");// Recuperer les ids des cartes pour le probleme dans un tableau
                    int[] cardIDInt = new int[cardIDstr.length];

                    for (int i = 0; i < cardIDstr.length; i++) {
                        cardIDInt[i] = Integer.parseInt(cardIDstr[i].trim()); // Convertir et stocker dans un tableau int[]
                    }

                    questionCardsMap.put(questionNumber, cardIDInt);// Stocker la numero de probleme et les ids
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        return questionCardsMap;

    }


    @Override
public JComponent[] afficherProbleme(int nbprob) {
    System.out.println("nbprob=" + nbprob);

    probEtId = genererprobid();
    probEtCode = genererprobcode();

          //test afficher
        /*************************************************************************** */
        idcartes=probEtId.get(nbprob);//Recuperer les id depuis le map
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

    ButtonGroup group = new ButtonGroup();
    JPanel panneau = new JPanel();
    panneau.setLayout(null);
    panneau.setBounds(50, 200, 1800, 300);
    panneau.setOpaque(false);

     // Position des cartes
     int offsetX = 240; // Decalage horizontal entre les cartes
     int offsetY = 0;   // Decalage vertical entre les cartes
     int positionybouton = 200; // decalage entre les cartes et les boutons
     int taillebouton = 18;

    JRadioButton[] buttons = new JRadioButton[idcartes.length];
    for (int i = 0; i < idcartes.length; i++) {
        CarteCritere carte = BaseDeCartes.getCarte(idcartes[i]);
        int xPosition = i * offsetX;

        JComponent[] composants = carte.afficherCarte(xPosition, offsetY);
        panneau.add(composants[0]);
        panneau.add(composants[1]);

        JRadioButton radioButton = new JRadioButton() {
            @Override
            public void updateUI() {
                setUI(new BasicRadioButtonUI() {
                    @Override
                    public void paint(Graphics g, JComponent c) {
                        AbstractButton b = (AbstractButton) c;
                        ButtonModel model = b.getModel();

                        Graphics2D g2 = (Graphics2D) g;
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2.setColor(model.isSelected() ? new Color(60, 60, 60) : new Color(245, 245, 245));
                        g2.fillRect(0, 0, taillebouton, taillebouton); // Square button
                    }
                });
            }
        };

        radioButton.setBounds(xPosition + 90, positionybouton, taillebouton, taillebouton);
        group.add(radioButton);
        panneau.add(radioButton);

        buttons[i] = radioButton;
    }


    JRadioButton rb1 = buttons[0];
    JRadioButton rb2 = buttons[1];
    JRadioButton rb3 = buttons[2];
    JRadioButton rb4 = buttons[3];
    JRadioButton rb5 = buttons[4];
    JRadioButton rb6 = buttons[5]; 

    //mettre les boutons devant les cartes
    panneau.setComponentZOrder(rb1, 0);
    panneau.setComponentZOrder(rb2, 0);
    panneau.setComponentZOrder(rb3, 0);
    panneau.setComponentZOrder(rb4, 0);
    panneau.setComponentZOrder(rb5, 0);
    panneau.setComponentZOrder(rb6, 0);

    return new JComponent[]{panneau};
}



    public int[] getCode()
    {
        return code; 
    }
}
