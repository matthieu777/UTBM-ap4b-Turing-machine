import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static int nombreJoueur = 1;//de base 1
    private static int nombreCarte = 4;//de base 4

    private static void createAndShowGUI() {

        //Param Frame : 

        JFrame frame = new JFrame("Turing Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 750);
        frame.getContentPane().setBackground(new Color(225, 225, 225));
        frame.setLayout(null);




        ImageIcon imageUtbm = new ImageIcon("images/utbmLogo.png");
        Image image = imageUtbm.getImage();
        Image resizedImage = image.getScaledInstance( imageUtbm.getIconWidth()/2, imageUtbm.getIconHeight()/2, Image.SCALE_SMOOTH);
        imageUtbm = new ImageIcon(resizedImage);
        JLabel label = new JLabel();
        label.setIcon(imageUtbm);
        label.setBounds(10, 10, imageUtbm.getIconWidth(), imageUtbm.getIconHeight());



        //Bouton quitter : 

        JButton boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBounds(1050, 20, 180, 50);
        boutonQuitter.setBackground(new Color(250, 85, 85));
        boutonQuitter.setBorder(BorderFactory.createLineBorder(new Color(181, 44, 44 ), 6));
        boutonQuitter.setForeground(Color.white);
        boutonQuitter.setFont(new Font("Arial", Font.BOLD, 20));


        boutonQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitter(frame);
            }
        });


        //Bouton regle : 

        JButton boutonRegle = new JButton("Regles");
        boutonRegle.setBounds(850, 20, 180, 50);
        boutonRegle.setBackground(new Color(117, 185, 242 ));
        boutonRegle.setBorder(BorderFactory.createLineBorder(new Color(21, 141, 241  ), 6));
        boutonRegle.setForeground(Color.white);
        boutonRegle.setFont(new Font("Arial", Font.BOLD, 20));


        boutonRegle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegleDuJeu.afficherRegle();
            }
        });


        //choix nombre de joueurs

        String[] nbrJoueurchoix = {"        1 Joueur", "        2 Joueurs", "       3 Joueurs", "       4 Joueurs"};
        JComboBox<String> boutonChoixJoueur = new JComboBox<>(nbrJoueurchoix);
        boutonChoixJoueur.setBounds(200, 200, 900, 90);
        boutonChoixJoueur.setOpaque(true);
        boutonChoixJoueur.setBackground(new Color(200, 200, 200 ));
        boutonChoixJoueur.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixJoueur.setFont(new Font("Arial", Font.BOLD, 35));


        boutonChoixJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedOption = (String) boutonChoixJoueur.getSelectedItem(); // recupere la chaine de caractere choisis
                
                if (selectedOption != null && !selectedOption.isEmpty()) {
                    
                        String[] partieNombreJoueur = selectedOption.split("J"); //on divise la chaine pour prendre que le nombre avant le J
                        if (partieNombreJoueur.length > 1) {
                            nombreJoueur = Integer.parseInt(partieNombreJoueur[0].trim());//convertie en int et suprimer les espace et stocke dans l'attribut global
                            System.out.println("nombre joueur : " + nombreJoueur); //affiche dans la console pour test
                        }
                }
            }
        });




        //choix nombre carte

        String[] nbrCarteChoix = {"        4 Revelateurs", "       5 Revelateurs", "       6 Revelateurs"};
        JComboBox<String> boutonChoixCarte = new JComboBox<>(nbrCarteChoix);
        boutonChoixCarte.setBounds(200, 350, 900, 90);
        boutonChoixCarte.setOpaque(true);
        boutonChoixCarte.setBackground(new Color(200, 200, 200 ));
        boutonChoixCarte.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixCarte.setFont(new Font("Arial", Font.BOLD, 35));

        boutonChoixCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedOption = (String) boutonChoixCarte.getSelectedItem(); // recupere la chaine de caractere choisis
                
                if (selectedOption != null && !selectedOption.isEmpty()) {
                    
                        String[] partieNombreCarte = selectedOption.split("R"); //on divise la chaine pour prendre que le nombre avant le R
                        if (partieNombreCarte.length > 1) {
                            nombreCarte = Integer.parseInt(partieNombreCarte[0].trim());//convertie en int et suprimer les espace et stocke dans l'attribut global
                            System.out.println("choix carte : " + nombreCarte); //affiche dans la console pour test
                        }
                }
            }
        });

        //bouton valider :

        JButton boutonLancer = new JButton("Lancer");
        boutonLancer.setBounds(300, 525, 550, 80);
        boutonLancer.setBackground(new Color(51, 170, 3   ));
        boutonLancer.setBorder(BorderFactory.createLineBorder(new Color(38, 120, 4  ), 6));
        boutonLancer.setForeground(Color.white);
        boutonLancer.setFont(new Font("Arial", Font.BOLD, 20));


        boutonLancer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Partie partie = new Partie(nombreJoueur, nombreCarte);
                partie.afficherPartie();
            }
        });

        //ajout des composant : 

        frame.add(label);
        frame.add(boutonQuitter);
        frame.add(boutonRegle);
        frame.add(boutonChoixJoueur);
        frame.add(boutonChoixCarte);
        frame.add(boutonLancer);

        frame.setVisible(true);
    }

    private static void quitter(JFrame frame) {
        int choix = JOptionPane.showConfirmDialog(
            frame,
            "Voulez-vous vraiment quitter ?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );
        
        if (choix == JOptionPane.YES_OPTION) {
            frame.dispose(); 
        }
    }
    
    

    public static void main(String[] args) throws Exception {
         javax.swing.SwingUtilities.invokeLater(new Runnable() { 
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
