import java.awt.*;
import javax.swing.*;


public class Parametres {

    public void afficherParametres() {
        
        //frame parametres :

        JFrame frameParametres = new JFrame("Paramètres");
        frameParametres.setSize(400, 300);
        frameParametres.getContentPane().setBackground(new Color(225, 225, 225));
        frameParametres.setLayout(null);
        frameParametres.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameParametres.setLocationRelativeTo(null);

        //texte : 

        JLabel labelTexte1 = new JLabel("Parametres :");
        labelTexte1.setBounds(4, 4, 300, 30);
        frameParametres.add(labelTexte1);

        //Bouton fermer 
        JButton boutonFermer = new JButton("Fermer");
        boutonFermer.setBounds(50, 150, 100, 30);
        boutonFermer.addActionListener(e -> frameParametres.dispose());




        //ajout des composant a la frame :

        frameParametres.add(boutonFermer);
        frameParametres.add(labelTexte1);
        

  
        frameParametres.setVisible(true);
    }
}
