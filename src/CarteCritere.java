import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarteCritere {
    private Critere critere;
    private String texte;

    public CarteCritere(String texte, Critere critere) {
        this.critere = critere;
        this.texte = texte; 
    }


    
   public JComponent[] afficherCarte(int x, int y) {
    
        JPanel carre = new JPanel();
        carre.setBounds(x, y, 200, 200);
        carre.setBackground(new Color(117, 185, 242));
        carre.setBorder(BorderFactory.createLineBorder(Color.blue, 5));

        JLabel textetest = new JLabel(texte);
        textetest.setBounds(x, y, 900, 50);

        return new JComponent[] { textetest, carre };
    }
}