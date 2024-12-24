import java.awt.*;
import javax.swing.*;


public class Partie {
    
    private int nombreJoueur;
    private int nombreCarte;
    private GroupeDeJoueur choixJoueur;
    private Joueur joueurSelectionne;
    private Problem problem;
    private TimerHorloge timer;
    


    public Partie(int nombreJoueur, int nombreCarte) {
        this.nombreJoueur = nombreJoueur;
        this.nombreCarte = nombreCarte;
        this.choixJoueur = new GroupeDeJoueur(nombreJoueur);
        this.joueurSelectionne = choixJoueur.getListDeJoueurs().get(0);
    }

    public void afficherPartie() {

        JFrame framePartie = new JFrame("Turing Machine / Partie");
        framePartie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePartie.setSize(2000, 750);
        framePartie.getContentPane().setBackground(new Color(225, 225, 225));
        framePartie.setLayout(null);
        framePartie.setLocationRelativeTo(null);

        // afichage titre

        JLabel texteTitre = new JLabel("<html><u>Partie avec " + nombreJoueur + " joueur et " + nombreCarte + " revelateur :</u></html>");
        texteTitre.setBounds(300, 15, 900, 90);
        texteTitre.setFont(new Font("Arial", Font.BOLD, 30));



        //timer

        timer = new TimerHorloge();
        JLabel labelTemps = new JLabel(timer.getTemps());
        timer.setTimerListener(temps -> SwingUtilities.invokeLater(() -> labelTemps.setText(temps)));
        labelTemps.setFont(new Font("Arial", Font.BOLD, 40));
        labelTemps.setBounds(30, 15, 250, 90);

        //Bouton quitter : 

        JButton boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBounds(1300, 40, 180, 60);
        boutonQuitter.setBackground(new Color(250, 85, 85));
        boutonQuitter.setBorder(BorderFactory.createLineBorder(new Color(181, 44, 44 ), 6));
        boutonQuitter.setForeground(Color.white);
        boutonQuitter.setFont(new Font("Arial", Font.BOLD, 20));

        boutonQuitter.addActionListener(e -> quitter(framePartie,timer));

       

        // affichage du probleme : 

        problem = changementProblemNbrCarte(nombreCarte);//creer un probleme de la taille voulue

        System.out.println("Joueur sélectionné : " + joueurSelectionne.getNom());
        JComponent[] composants = problem.afficherProbleme();
        framePartie.add(composants[0]);  

        //Bouton selection joueur :


        String[] listeNomJoueurs = choixJoueur.getNomsJoueurs(); //recupe la liste des noms des joueurs 

        JComboBox<String> boutonChoixJoueur = new JComboBox<>(listeNomJoueurs);
        boutonChoixJoueur.setBounds(100, 550, 330, 70);
        boutonChoixJoueur.setOpaque(true);
        boutonChoixJoueur.setBackground(new Color(200, 200, 200 ));
        boutonChoixJoueur.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixJoueur.setFont(new Font("Arial", Font.BOLD, 30));

        boutonChoixJoueur.addActionListener(e -> selectionJoueurBoutonChoixJoueurs(boutonChoixJoueur, choixJoueur));

         //Bouton parametre : 

         JButton boutonParametre = new JButton("Paramètres");
         boutonParametre.setBounds(1100, 40, 180, 60);
         boutonParametre.setBackground(new Color(117, 185, 242 ));
         boutonParametre.setBorder(BorderFactory.createLineBorder(new Color(21, 141, 241 ), 6));
         boutonParametre.setForeground(Color.white);
         boutonParametre.setFont(new Font("Arial", Font.BOLD, 20));
 
         Parametres parametres = new Parametres();
 
         boutonParametre.addActionListener(e -> { try{ parametres.afficherParametres(timer, joueurSelectionne, boutonChoixJoueur, this); } catch (Exception ex) {
             JOptionPane.showMessageDialog(
             null,
             "Erreur : affichage des parametres : " + ex.getMessage(),
             "Erreur",
             JOptionPane.ERROR_MESSAGE
         ); }
         });
         

        //Bouton pour lancer la verification : 

        JButton boutonVerif=new JButton("Verifier");
        boutonVerif.setBounds(1150, 550, 290, 70);
        boutonVerif.setOpaque(true);
        boutonVerif.setBackground(new Color(51, 170, 3 ));
        boutonVerif.setBorder(BorderFactory.createLineBorder(new Color(38, 120, 4  ), 6));
        boutonVerif.setFont(new Font("Arial", Font.BOLD, 28));
        boutonVerif.setForeground(Color.white);


        //ajout des composant à la frame :

        framePartie.add(texteTitre);
        framePartie.add(labelTemps);
        framePartie.add(boutonParametre);
        framePartie.add(boutonQuitter);
        framePartie.add(boutonVerif);
        framePartie.add(boutonChoixJoueur);
        
        
        framePartie.setVisible(true);
    }


    private void selectionJoueurBoutonChoixJoueurs(JComboBox<String> comboBox, GroupeDeJoueur choixJoueur) {
        String selectedOption = (String) comboBox.getSelectedItem();
    
        if (selectedOption != null && !selectedOption.isEmpty()) {
            int indexSelectionne = comboBox.getSelectedIndex();
            Joueur joueurSelectionne = choixJoueur.getListDeJoueurs().get(indexSelectionne);
            System.out.println("Joueur selectionne : " + joueurSelectionne.getNom());//affichage console pour verification
        }
    }


    public Problem changementProblemNbrCarte(int nombreCarte) {
        switch (nombreCarte) {
            case 4:
                return new Problem_4_cartes();
            case 5:
                return new Problem_5_cartes();
            case 6:
                return new Problem_6_cartes();
            default:
                return new Problem_4_cartes(); 
        }
    }

    private static void quitter(JFrame framePartie, TimerHorloge timer) {

        int choix = JOptionPane.showConfirmDialog(
            framePartie,
            "La partie a durre : "+ timer.getTemps() +"\nVoulez-vous voir la solution avant de quitter ?",
            "Solution",
            JOptionPane.YES_NO_OPTION
        ); 
        if (choix == JOptionPane.YES_OPTION) {
            int choix2 = JOptionPane.showOptionDialog(
                framePartie,
                "La solution etait : ",
                "Solution",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[] { "ok" },
                "ok"
            );
            if (choix2 == JOptionPane.CLOSED_OPTION || choix2 == 0) {
                framePartie.dispose();
            }
        } else {
            framePartie.dispose();
        }
    }



    public void updateJoueurList(JComboBox<String> comboBox) {
        // Mettre à jour la liste déroulante avec les nouveaux noms de joueurs
        String[] listeNomJoueurs = choixJoueur.getNomsJoueurs(); // récupérer les noms des joueurs
        comboBox.setModel(new DefaultComboBoxModel<>(listeNomJoueurs)); // Met à jour le modèle de la comboBox
    }


    


}