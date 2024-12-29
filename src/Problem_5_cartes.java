import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;

public class Problem_5_cartes extends Problem {


    private Map<Integer, int[]> probEtId = new HashMap<>(); // key= numero de problem  value:id des cartes criteres
    private Map<Integer, int[]> probEtCode = new HashMap<>();// key= numero de problem  value:code
    
 

    public Problem_5_cartes() {
        super(5);  // Initialiser nbrcarte avec 4
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

        ButtonGroup group = new ButtonGroup(); // Pour gerer les radio buttons
        JPanel panneau = new JPanel();
        panneau.setLayout(null);
        panneau.setBounds(50, 200, 1500, 300); 
        panneau.setOpaque(false);

        // Position des cartes
        int offsetX = 300; // Decalage horizontal entre les cartes
        int offsetY = 0;   // Decalage vertical entre les cartes
        int positionybouton = 200; // decalage entre les cartes et les boutons
        int taillebouton = 18;

        
        JRadioButton[] buttons = new JRadioButton[idcartes.length];
        for (int i = 0; i < idcartes.length; i++) {
            // Recuperer les cartes
            CarteCritere carte = BaseDeCartes.getCarte(idcartes[i]);
            int xPositioncarte = i * offsetX;

            JComponent[] composants = carte.afficherCarte(xPositioncarte, offsetY);
            panneau.add(composants[0]);
            panneau.add(composants[1]);

            // Creation des boutons
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
            

            radioButton.setBounds(xPositioncarte + 90, positionybouton, taillebouton, taillebouton);
            group.add(radioButton);
            panneau.add(radioButton);

            final int index = i; //stock l'index de la carte selectioner
            radioButton.addActionListener(_ -> {
                if (radioButton.isSelected()) { //si un radio bouton est selectioner
                    
                    selectedCarteId = idcartes[index]; //recuper l'id de la carte selectioner avec le radio bouton
                    System.out.println("Carte sélectionnée avec ID : " + selectedCarteId); //affichage console pour verification
                    
                }
            });

            buttons[i] = radioButton;
        }
        JRadioButton rb1 = buttons[0];
        JRadioButton rb2 = buttons[1];
        JRadioButton rb3 = buttons[2];
        JRadioButton rb4 = buttons[3];
        JRadioButton rb5 = buttons[4];

        panneau.setComponentZOrder(rb1, 0);
        panneau.setComponentZOrder(rb2, 0);
        panneau.setComponentZOrder(rb3, 0);
        panneau.setComponentZOrder(rb4, 0);
        panneau.setComponentZOrder(rb5, 0);

        return new JComponent[]{panneau};
    }

    //getter pour recuper le code reponse
        @Override
    public int[] getCode()
    {
        return this.code; 
    }
}
