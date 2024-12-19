import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Problem_6_cartes extends Problem {

    private CarteCritere[] listeCartes = new CarteCritere[5];

    
    
    @Override
    public JComponent[] afficherProbleme() {

        ButtonGroup group = new ButtonGroup();//pour gerer les radiobuttons


        JPanel panneau = new JPanel();
        panneau.setLayout(null);
        panneau.setBounds(70, 200, 1700, 800);
        panneau.setOpaque(false);
        
        CarteCritere carte1 = BaseDeCartes.getCarte(1);
        JComponent[] composants1 = carte1.afficherCarte(0, 0);
        panneau.add(composants1[0]);
        panneau.add(composants1[1]); 
        JRadioButton rb1 = new JRadioButton();
        rb1.setBounds(90, 200, 20, 20);
        rb1.setBorderPainted(true);
        rb1.setBackground(Color.BLACK);        group.add(rb1);
        panneau.add(rb1);

        
        CarteCritere carte2 = BaseDeCartes.getCarte(2);
        JComponent[] composants2 = carte2.afficherCarte(250, 0);
        panneau.add(composants2[0]);
        panneau.add(composants2[1]);

        JRadioButton rb2 = new JRadioButton();
        rb2.setBounds(340, 200, 20, 20);
        rb2.setBorderPainted(true);
        rb2.setBackground(Color.BLACK);
        group.add(rb2);
        panneau.add(rb2);
        
        CarteCritere carte3 = BaseDeCartes.getCarte(3);
        JComponent[] composants3 = carte3.afficherCarte(500, 0);
        panneau.add(composants3[0]);
        panneau.add(composants3[1]);

        JRadioButton rb3 = new JRadioButton();
        rb3.setBounds(585, 200, 20, 20);
        rb3.setBorderPainted(true);
        rb3.setBackground(Color.BLACK);
        group.add(rb3);
        panneau.add(rb3);

        CarteCritere carte4 = BaseDeCartes.getCarte(4);
        JComponent[] composants4 = carte4.afficherCarte(750, 0);
        panneau.add(composants4[0]);
        panneau.add(composants4[1]);

        JRadioButton rb4 = new JRadioButton();
        rb4.setBounds(840, 200, 20, 20);
        rb4.setBorderPainted(true);
        rb4.setBackground(Color.BLACK);
        group.add(rb4);
        panneau.add(rb4);

        CarteCritere carte5 = BaseDeCartes.getCarte(5);
        JComponent[] composants5 = carte5.afficherCarte(1000, 0);
        panneau.add(composants5[0]);
        panneau.add(composants5[1]);

        JRadioButton rb5 = new JRadioButton();
        rb5.setBounds(1090, 200, 20, 20);
        rb5.setBorderPainted(true);
        rb5.setBackground(Color.BLACK);
        group.add(rb5);
        panneau.add(rb5);

        CarteCritere carte6 = BaseDeCartes.getCarte(6);
        JComponent[] composants6 = carte6.afficherCarte(1250, 0);
        panneau.add(composants6[0]);
        panneau.add(composants6[1]);

        JRadioButton rb6 = new JRadioButton();
        rb6.setBounds(1340, 200, 20, 20);
        rb6.setBorderPainted(true);
        rb6.setBackground(Color.BLACK);
        group.add(rb6);
        panneau.add(rb6);


        panneau.setComponentZOrder(rb1, 0); // Bring rb1 to the front
        panneau.setComponentZOrder(rb2, 0);
        panneau.setComponentZOrder(rb3, 0);
        panneau.setComponentZOrder(rb4, 0);
        panneau.setComponentZOrder(rb5, 0);
        panneau.setComponentZOrder(rb6, 0); 
        

        
        return new JComponent[] { panneau };
    }
}
