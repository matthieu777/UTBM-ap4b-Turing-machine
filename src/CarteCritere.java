import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CarteCritere {
    private Critere critere;
    private String texte;

    public CarteCritere(String texte, Critere critere) {
        this.critere = critere;
        this.texte = texte; 
    }


    
   public JComponent[] afficherCarte(int x, int y) {
    
        JPanel carre = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //fond :
                g2.setColor(new Color(204, 204, 204 ));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                //bordure : 
                g2.setColor(new Color(148, 148, 148 ));
                g2.setStroke(new BasicStroke(7));
                g2.drawRoundRect(2, 2, getWidth() - 5, getHeight() - 5, 30, 30);
            }
        };
        carre.setBounds(x, y, 210, 250);
        carre.setOpaque(false);
        
        JLabel textetest = new JLabel(texte, SwingConstants.CENTER);
        textetest.setVerticalAlignment(SwingConstants.CENTER);
        textetest.setBounds(x+30, y+45, 150, 125);
        textetest.setOpaque(true);
        textetest.setBackground(new Color(102, 102, 102));
        Border roundedBorder = BorderFactory.createLineBorder(new Color(91, 91, 91), 5, true);
        textetest.setBorder(roundedBorder);
        textetest.setFont(new Font("Arial", Font.BOLD, 15));
        textetest.setForeground(Color.white);

        return new JComponent[] { textetest, carre };
    }

    public Critere getCritere() {
        return critere;
    }
}