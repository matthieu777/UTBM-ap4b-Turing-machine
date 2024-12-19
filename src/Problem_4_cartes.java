import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Problem_4_cartes extends Problem {

    private CarteCritere[] listeCartes = new CarteCritere[4];

    
    
    @Override
    public JComponent[] afficherProbleme() {

         ButtonGroup group = new ButtonGroup();//pour gerer les radiobuttons



        JPanel panneau = new JPanel();
        panneau.setLayout(null);
        panneau.setBounds(70, 200, 1100, 800);
        panneau.setOpaque(false);
        
        CarteCritere carte1 = BaseDeCartes.getCarte(1);
        JComponent[] composants1 = carte1.afficherCarte(0, 0);
        panneau.add(composants1[0]);
        panneau.add(composants1[1]); 
        
        JRadioButton rb1 = new JRadioButton();
        rb1.setBounds(90, 200, 20, 20);
        group.add(rb1);
        panneau.add(rb1);


        CarteCritere carte2 = BaseDeCartes.getCarte(2);
        JComponent[] composants2 = carte2.afficherCarte(300, 0);
        panneau.add(composants2[0]);
        panneau.add(composants2[1]);
        
        JRadioButton rb2 = new JRadioButton();
        rb2.setBounds(390, 200, 20, 20);
        group.add(rb2);
        panneau.add(rb2);

        CarteCritere carte3 = BaseDeCartes.getCarte(3);
        JComponent[] composants3 = carte3.afficherCarte(600, 0);
        panneau.add(composants3[0]);
        panneau.add(composants3[1]);

        JRadioButton rb3 = new JRadioButton();
        rb3.setBounds(690, 200, 20, 20);
        group.add(rb3);
        panneau.add(rb3);


        CarteCritere carte4 = BaseDeCartes.getCarte(4);
        JComponent[] composants4 = carte4.afficherCarte(900, 0);
        panneau.add(composants4[0]);
        panneau.add(composants4[1]);

        JRadioButton rb4 = new JRadioButton();
        rb4.setBounds(990, 200, 20, 20);
        group.add(rb4);
        panneau.add(rb4);

        panneau.setComponentZOrder(rb1, 0); // Bring rb1 to the front
        panneau.setComponentZOrder(rb2, 0);
        panneau.setComponentZOrder(rb3, 0);
        panneau.setComponentZOrder(rb4, 0);
        
        return new JComponent[] { panneau };
    }
}