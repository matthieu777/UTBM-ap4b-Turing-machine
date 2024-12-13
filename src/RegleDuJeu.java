import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class RegleDuJeu {

    private static final String texteRegles = "les regles : ";

    public static void afficherRegle() {

        JFrame frameRegle = new JFrame("Turing Machine / Regles");
        frameRegle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//ferme uniquement cette fenetre quand on quitte
        frameRegle.setSize(1300, 750);
        frameRegle.getContentPane().setBackground(new Color(225, 225, 225));
        frameRegle.setLayout(null);

        // bouton retour
        JButton boutonRetour = new JButton("Retour");
        boutonRetour.setBounds(1050, 20, 180, 50);
        boutonRetour.setBackground(new Color(117, 185, 242 ));
        boutonRetour.setBorder(BorderFactory.createLineBorder(new Color(21, 141, 241  ), 6));
        boutonRetour.setForeground(Color.white);
        boutonRetour.setFont(new Font("Arial", Font.BOLD, 20));
        
        boutonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour(frameRegle);
            }
        });

        //titre
        JLabel labelTitre = new JLabel("<html><u>Regles du Jeu</u></html>");
        labelTitre.setHorizontalAlignment(JLabel.CENTER);
        labelTitre.setVerticalAlignment(JLabel.CENTER);
        labelTitre.setBounds(350, 50, 500, 50);
        labelTitre.setOpaque(true);
        labelTitre.setBackground(new Color(117, 185, 242 ));
        labelTitre.setForeground(Color.white);
        labelTitre.setBorder(BorderFactory.createLineBorder(new Color(21, 141, 241  ), 6));
        labelTitre.setFont(new Font("Arial", Font.BOLD, 35));
       

        JTextArea texteRegle = new JTextArea();
        texteRegle.setText(texteRegles);
        texteRegle.setFont(new Font("Arial", Font.PLAIN, 16));
        texteRegle.setBounds(50, 140, 1100, 500);
        texteRegle.setEditable(false);
        texteRegle.setBorder(BorderFactory.createLineBorder(new Color(21, 141, 241  ), 6));
        texteRegle.setForeground(Color.white);
        texteRegle.setBackground(new Color(117, 185, 242 ));
        


        

        //ajout des composant : 
        frameRegle.add(boutonRetour);
        frameRegle.add(texteRegle);
        frameRegle.add(labelTitre);
        
        frameRegle.setVisible(true);
    }

    private static void retour(JFrame frame) {
        frame.dispose();
    }

}
