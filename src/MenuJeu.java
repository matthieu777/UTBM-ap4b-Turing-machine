import java.awt.*;
import javax.swing.*;

public class MenuJeu {
    
    private static int nombreJoueur = 1;//par default 1
    private static int nombreCarte = 4;//par default 4

    public void afficherMenu() {

        //Frame menu :
        
        JFrame frame = new JFrame("Turing Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 750);
        frame.getContentPane().setBackground(new Color(225, 225, 225));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);


        //Image logo utbm :

        ImageIcon imageUtbm;
        JLabel label = new JLabel();
        String filePath = "src/images/utbmLogo.png";
        String alternateFilePath = "images/utbmLogo.png";

        try {
            imageUtbm = new ImageIcon(filePath);
            if (imageUtbm.getIconWidth() == -1) { // Vérifie si l'image est invalide
                throw new Exception("Le chemin  src/images/utbmLogo.png ne marche pas : " + filePath);
            }
            
        } catch (Exception e) {
            try {
                imageUtbm = new ImageIcon(alternateFilePath);
                if (imageUtbm.getIconWidth() == -1) { // Vérifie si l'image est invalide
                    throw new Exception("Le chemin : images/utbmLogo.png ne marche pas" + alternateFilePath);
                }
            } catch (Exception e2) {
                imageUtbm = null;
                System.err.println("Erreur de chargement de l'image : " + e2.getMessage());
            }
            
         } if (imageUtbm == null) {
            JOptionPane.showMessageDialog(null, "Le chargement de l'image à echoué", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Image image = imageUtbm.getImage();
            Image resizedImage = image.getScaledInstance( imageUtbm.getIconWidth()/2, imageUtbm.getIconHeight()/2, Image.SCALE_SMOOTH);
            imageUtbm = new ImageIcon(resizedImage);
            label.setIcon(imageUtbm);
            label.setBounds(10, 10, imageUtbm.getIconWidth(), imageUtbm.getIconHeight());
            frame.add(label);
        }

        //Bouton quitter : 

        JButton boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBounds(1050, 20, 180, 60);
        boutonQuitter.setBackground(new Color(250, 85, 85));
        boutonQuitter.setBorder(BorderFactory.createLineBorder(new Color(181, 44, 44 ), 6));
        boutonQuitter.setForeground(Color.white);
        boutonQuitter.setFont(new Font("Arial", Font.BOLD, 20));

        boutonQuitter.addActionListener(e -> quitter(frame));


        //Bouton regle : 

        JButton boutonRegle = new JButton("Regles");
        boutonRegle.setBounds(850, 20, 180, 60);
        boutonRegle.setBackground(new Color(117, 185, 242 ));
        boutonRegle.setBorder(BorderFactory.createLineBorder(new Color(21, 141, 241  ), 6));
        boutonRegle.setForeground(Color.white);
        boutonRegle.setFont(new Font("Arial", Font.BOLD, 20));

        RegleDuJeu regleDuJeu = new RegleDuJeu();
        boutonRegle.addActionListener(e -> { try{ regleDuJeu.afficherRegle(); } catch (Exception ex) {
            JOptionPane.showMessageDialog(
            null,
            "Erreur : affichage des regles : " + ex.getMessage(),
            "Erreur",
            JOptionPane.ERROR_MESSAGE
        ); }
        });
        


        //choix nombres de joueurs

        String[] nbrJoueurchoix = {"        1 Joueur", "        2 Joueurs", "       3 Joueurs", "       4 Joueurs"};

        JComboBox<String> boutonChoixJoueur = new JComboBox<>(nbrJoueurchoix);
        boutonChoixJoueur.setBounds(200, 200, 900, 90);
        boutonChoixJoueur.setOpaque(true);
        boutonChoixJoueur.setBackground(new Color(200, 200, 200 ));
        boutonChoixJoueur.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixJoueur.setFont(new Font("Arial", Font.BOLD, 35));

        boutonChoixJoueur.addActionListener(e -> selectionJoueurBoutonChoixJoueur(boutonChoixJoueur));



        //choix nombre carte

        String[] nbrCarteChoix = {"        4 Revelateurs", "       5 Revelateurs", "       6 Revelateurs"};
        JComboBox<String> boutonChoixCarte = new JComboBox<>(nbrCarteChoix);
        boutonChoixCarte.setBounds(200, 350, 900, 90);
        boutonChoixCarte.setOpaque(true);
        boutonChoixCarte.setBackground(new Color(200, 200, 200 ));
        boutonChoixCarte.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixCarte.setFont(new Font("Arial", Font.BOLD, 35));

        boutonChoixCarte.addActionListener(e -> selectionCartesBoutonChoixCartes(boutonChoixCarte));

        //bouton valider/lancer :

        JButton boutonLancer = new JButton("Lancer");
        boutonLancer.setBounds(300, 525, 550, 80);
        boutonLancer.setBackground(new Color(51, 170, 3   ));
        boutonLancer.setBorder(BorderFactory.createLineBorder(new Color(38, 120, 4  ), 6));
        boutonLancer.setForeground(Color.white);
        boutonLancer.setFont(new Font("Arial", Font.BOLD, 28));

        boutonLancer.addActionListener(e -> actionBoutonLancerPartie());

        //ajout des composant : 


        frame.add(boutonQuitter);
        frame.add(boutonRegle);
        frame.add(boutonChoixJoueur);
        frame.add(boutonChoixCarte);
        frame.add(boutonLancer);
        
 
        frame.setVisible(true);
    }


    
    //methodes 


    //methodes pour quitte le jeu 
    private static void quitter(JFrame frame) {
        int choix = JOptionPane.showConfirmDialog( //demande confirmation
            frame,
            "Voulez-vous vraiment quitter ?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        ); 
        if (choix == JOptionPane.YES_OPTION) {
            frame.dispose(); 
        }
    }


    //methodes pour selectioner le nombre de joueur voulue 
    private void selectionJoueurBoutonChoixJoueur(JComboBox<String> comboBox) {
        String selectedOption = (String) comboBox.getSelectedItem(); //recupere l'option selectionée
    
        if (selectedOption != null && !selectedOption.isEmpty()) {
            try{
            String[] partieNombreJoueur = selectedOption.split("J"); //divise la chaine pour recupere le nombre avant J 
            if (partieNombreJoueur.length > 1) {
                nombreJoueur = Integer.parseInt(partieNombreJoueur[0].trim()); //convertie en int et supprime les espaces
                System.out.println("Nbr de joueurs : " + nombreJoueur); //affichage dans la console pour verification
            }
            } catch (NumberFormatException e) { System.err.println("Erreur : format selection joueurs");
            JOptionPane.showMessageDialog(null, "Erreur avec la selection du nombre de joueurs", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

     //methodes pour selectioner le nombres de cartes voulue 
    private void selectionCartesBoutonChoixCartes(JComboBox<String> comboBox) {
        String selectedOption = (String) comboBox.getSelectedItem(); //Meme methodes que la selection de joueur
    
        if (selectedOption != null && !selectedOption.isEmpty()) {
            try{
            String[] partieNombreCarte = selectedOption.split("R");
            if (partieNombreCarte.length > 1) {
                nombreCarte = Integer.parseInt(partieNombreCarte[0].trim());
                System.out.println("Nbr de cartes : " + nombreCarte); 
            }
            } catch (NumberFormatException e) { System.err.println("Erreur : format selection cartes");
            JOptionPane.showMessageDialog(null, "Erreur avec la selection du nombre de cartes", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //methodes du bouton lancer
    private void actionBoutonLancerPartie() {
        try {
        Partie partie = new Partie(nombreJoueur, nombreCarte); //creation partie avec le nombres d'elements choisis
        partie.afficherPartie(); //affichage de la partie creer
        System.out.println("Partie avec " + nombreJoueur + " joueurs et " + nombreCarte + " cartes"); //affichage console pour verifiaction
        } catch (Exception e) {
            System.err.println("Erreur : creation de la partie : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur lors de la creation de la partie", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
