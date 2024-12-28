import java.awt.*;
import java.util.Random;
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

        int nbprob=genererandom();
        JFrame framePartie = new JFrame("Turing Machine / Partie avec problem numero " + nbprob);
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

        // affichage du probleme : 

        problem = changementProblemNbrCarte(nombreCarte);//creer un probleme de la taille voulue
        System.out.println("Joueur sélectionné : " + joueurSelectionne.getNom());
        JComponent[] composants = problem.afficherProbleme(nbprob);
        framePartie.add(composants[0]);  

        //Bouton quitter : 
        JButton boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBounds(1300, 40, 180, 60);
        boutonQuitter.setBackground(new Color(250, 85, 85));
        boutonQuitter.setBorder(BorderFactory.createLineBorder(new Color(181, 44, 44 ), 6));
        boutonQuitter.setForeground(Color.white);
        boutonQuitter.setFont(new Font("Arial", Font.BOLD, 20));

        boutonQuitter.addActionListener(e -> quitter(framePartie,timer,problem));

        //Bouton selection joueur :

        String[] listeNomJoueurs = choixJoueur.getNomsJoueurs(); //recupe la liste des noms des joueurs 

        JComboBox<String> boutonChoixJoueur = new JComboBox<>(listeNomJoueurs);
        boutonChoixJoueur.setBounds(100, 550, 330, 70);
        boutonChoixJoueur.setOpaque(true);
        boutonChoixJoueur.setBackground(new Color(200, 200, 200 ));
        boutonChoixJoueur.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixJoueur.setFont(new Font("Arial", Font.BOLD, 30));

        boutonChoixJoueur.addActionListener(e -> selectionJoueurBoutonChoixJoueurs(boutonChoixJoueur, choixJoueur));

        //affichage nombre d'essaie

        JLabel texteNbrEssaie = new JLabel("Nombre essaie : "+ joueurSelectionne.getnbrEssaie() +"/3");
        texteNbrEssaie.setBounds(120, 610, 300, 50);
        texteNbrEssaie.setFont(new Font("Arial", Font.BOLD, 15));

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


        //Champs pour entrer le code :
        
        JTextField codeField1 = new JTextField(1);
        codeField1.setBounds(600, 550, 50, 70);
        codeField1.setFont(new Font("Arial", Font.BOLD, 28));
        codeField1.setHorizontalAlignment(JTextField.CENTER);
    
        JTextField codeField2 = new JTextField(1);
        codeField2.setBounds(660, 550, 50, 70);
        codeField2.setFont(new Font("Arial", Font.BOLD, 28));
        codeField2.setHorizontalAlignment(JTextField.CENTER);
    
        JTextField codeField3 = new JTextField(1);
        codeField3.setBounds(720, 550, 50, 70);
        codeField3.setFont(new Font("Arial", Font.BOLD, 28));
        codeField3.setHorizontalAlignment(JTextField.CENTER);
    


        //Bouton pour lancer la verification : 
        CarteCritere carte = BaseDeCartes.getCarte(problem.getCode()[0]);
        Verificateur verificateur = new Verificateur(problem, carte);

        JButton boutonVerif=new JButton("Verifier");
        boutonVerif.setBounds(1150, 550, 290, 70);
        boutonVerif.setOpaque(true);
        boutonVerif.setBackground(new Color(51, 170, 3 ));
        boutonVerif.setBorder(BorderFactory.createLineBorder(new Color(38, 120, 4  ), 6));
        boutonVerif.setFont(new Font("Arial", Font.BOLD, 28));
        boutonVerif.setForeground(Color.white);
        boutonVerif.addActionListener(e -> { 
            String code = codeField1.getText() + codeField2.getText() + codeField3.getText();
            if (code.matches("\\d{3}")) {
                System.out.println("Code valide : " + code);
                verificateur.verifierCode(code, framePartie);
                
            } else {
                JOptionPane.showMessageDialog(framePartie, "Veuillez entrer un code valide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
        
       
        framePartie.add(texteTitre);
        framePartie.add(labelTemps);
        framePartie.add(boutonParametre);
        framePartie.add(boutonQuitter);
        framePartie.add(boutonVerif);
        framePartie.add(boutonChoixJoueur);
        framePartie.add(texteNbrEssaie);
        framePartie.add(codeField1);
        framePartie.add(codeField2);
        framePartie.add(codeField3);
        
        
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

    private static void quitter(JFrame framePartie, TimerHorloge timer,Problem problem) {

        int choix = JOptionPane.showConfirmDialog(
            framePartie,
            "La partie a durre : "+ timer.getTemps() +"\nVoulez-vous voir la solution avant de quitter ?",
            "Solution",
            JOptionPane.YES_NO_OPTION
        ); 
        if (choix == JOptionPane.YES_OPTION) {
            int [] coderecup=problem.getCode();
            int choix2 = JOptionPane.showOptionDialog(
                framePartie,
                "La solution etait : "+ coderecup[0]+ coderecup[1]+ coderecup[2] ,
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
        //maj de liste de joueur apres changement de nom
        String[] listeNomJoueurs = choixJoueur.getNomsJoueurs();
        comboBox.setModel(new DefaultComboBoxModel<>(listeNomJoueurs));
    }

    public int genererandom()
{
    int nombre;
    Random rand = new Random();
    nombre = rand.nextInt(6);  // Genere une nombre entre 0 et 5
    return nombre;
}


    


}
