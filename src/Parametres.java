import java.awt.*;
import javax.swing.*;


public class Parametres {

    public void afficherParametres(TimerHorloge timer, Joueur joueur,JComboBox<String> boutonChoixJoueur, Partie partie) {
        
        //frame parametres :

        JFrame frameParametres = new JFrame("Paramètres");
        frameParametres.setSize(400, 300);
        frameParametres.getContentPane().setBackground(new Color(225, 225, 225));
        frameParametres.setLayout(null);
        frameParametres.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameParametres.setLocationRelativeTo(null);

        //texte : 

        JLabel labelTexteParametres = new JLabel("Parametres");
        labelTexteParametres .setBounds(150, 6, 300, 15);
        labelTexteParametres .setFont(new Font("Arial", Font.BOLD, 19));
        
        JLabel labelTexteTimer = new JLabel("Timer :");
        labelTexteTimer.setBounds(10, 35, 300, 15);
        labelTexteTimer.setFont(new Font("Arial", Font.BOLD, 15));
    
        //bouton pause

        JButton boutonPause = new JButton("Pause");
        boutonPause.setBounds(60, 60, 100, 30);
        boutonPause.setBackground(new Color(255, 213, 90 ));
        boutonPause.setBorder(BorderFactory.createLineBorder(new Color(252, 187, 0  ), 3));
        boutonPause.setForeground(Color.WHITE);

        boutonPause.addActionListener(e -> {
            try {
                timer.pause();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frameParametres, "Erreur lors de la pause du timer : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        //bouton relancer timer

        JButton boutonRelancer = new JButton("Reprendre");
        boutonRelancer.setBounds(220, 60, 100, 30);
        boutonRelancer.setBackground(new Color(178, 244, 84 ));
        boutonRelancer.setBorder(BorderFactory.createLineBorder(new Color(139, 234, 0   ), 3));
        boutonRelancer.setForeground(Color.WHITE);

        boutonRelancer.addActionListener(e -> {
            try {
                timer.relancer();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frameParametres, "Erreur lors du redemarage du timer : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        // parametres joueur : 

        JLabel labelTexteJoueur = new JLabel("Joueur (actif) :");
        labelTexteJoueur.setBounds(10, 115, 300, 15);
        labelTexteJoueur.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel labelTexteJoueur2 = new JLabel("Nouveau nom :");
        labelTexteJoueur2.setBounds(15, 165, 300, 15);
        labelTexteJoueur2.setFont(new Font("Arial", Font.BOLD, 15));


        JTextField changerNomJoueurTextField = new JTextField(20);
        changerNomJoueurTextField.setText(joueur.getNom().toString());
        changerNomJoueurTextField.setBounds(150, 160, 120, 30);
        changerNomJoueurTextField.setFont(new Font("Arial", Font.BOLD, 15));
        changerNomJoueurTextField.setBorder(BorderFactory.createLineBorder(new Color(148, 148, 148   ), 3));


        //Bouton fermer 
        JButton boutonFermer = new JButton("Fermer");
        boutonFermer.setBounds(260, 215, 100, 30);
        boutonFermer.setBackground(new Color(250, 85, 85));
        boutonFermer.setBorder(BorderFactory.createLineBorder(new Color(181, 44, 44  ), 3));
        boutonFermer.setForeground(Color.WHITE);

        boutonFermer.addActionListener(e -> {
            // Récupérer le nouveau nom du champ de texte
            String nouveauNom = changerNomJoueurTextField.getText();

            // Vérifier si le nom n'est pas vide avant de mettre à jour
            if (!nouveauNom.isEmpty()) {
                joueur.setNom(new StringBuffer(nouveauNom));  // Changer le nom du joueur
            }

            // Fermer la fenêtre et relancer le timer
            frameParametres.dispose();
            timer.relancer();
            partie.updateJoueurList(boutonChoixJoueur); 
        });

        



        //ajout des composant a la frame :

        frameParametres.add(labelTexteParametres );
        frameParametres.add(labelTexteTimer);
        frameParametres.add(boutonPause);
        frameParametres.add(boutonRelancer);
        frameParametres.add(labelTexteJoueur);
        frameParametres.add(labelTexteJoueur2);
        frameParametres.add(changerNomJoueurTextField);
        frameParametres.add(boutonFermer);
        
        

        try {
            frameParametres.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frameParametres, "Erreur lors de l'affichage des parametres : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
