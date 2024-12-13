import javax.swing.JComponent;
import javax.swing.JPanel;

public class Problem_4_cartes extends Problem {

    private CarteCritere[] listeCartes = new CarteCritere[4];

    
    
    @Override
    public JComponent[] afficherProbleme() {
        JPanel panneau = new JPanel();
        panneau.setLayout(null);
        panneau.setBounds(70, 200, 1100, 200);
        panneau.setOpaque(false);
        
        CarteCritere carte1 = BaseDeCartes.getCarte(1);
        JComponent[] composants1 = carte1.afficherCarte(0, 0);
        panneau.add(composants1[0]);
        panneau.add(composants1[1]); 
        
        CarteCritere carte2 = BaseDeCartes.getCarte(2);
        JComponent[] composants2 = carte2.afficherCarte(300, 0);
        panneau.add(composants2[0]);
        panneau.add(composants2[1]);
        
        CarteCritere carte3 = BaseDeCartes.getCarte(3);
        JComponent[] composants3 = carte3.afficherCarte(600, 0);
        panneau.add(composants3[0]);
        panneau.add(composants3[1]);

        CarteCritere carte4 = BaseDeCartes.getCarte(4);
        JComponent[] composants4 = carte4.afficherCarte(900, 0);
        panneau.add(composants4[0]);
        panneau.add(composants4[1]);
        
        return new JComponent[] { panneau };
    }
}