import java.awt.*;
import javax.swing.*;


public class Partie {
    
    private int nombreJoueur;
    private int nombreCarte;

    public Partie(int nombreJoueur, int nombreCarte) {
        this.nombreJoueur = nombreJoueur;
        this.nombreCarte = nombreCarte;
    }

    public void afficherPartie() {
        JFrame framePartie = new JFrame("Turing Machine / Partie");
        framePartie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePartie.setSize(2000, 750);
        framePartie.getContentPane().setBackground(new Color(225, 225, 225));
        framePartie.setLayout(null);

        // afichage test 
        JLabel textetest = new JLabel("Partie avec " + nombreJoueur + " joueur et " + nombreCarte + " revelateur :");
        textetest.setBounds(100, 30, 900, 50);
        textetest.setFont(new Font("Arial", Font.PLAIN, 25));

        Problem problem;


        
        switch (nombreCarte) {
            case 4:
                problem = new Problem_4_cartes();
                break;
            case 5:
                problem = new Problem_5_cartes();
                break;
            case 6:
                problem = new Problem_6_cartes();
                break;
            default:
                problem = new Problem_4_cartes(); 
                break;
        }
        //problem.afficherProbleme();

        JComponent[] composants = problem.afficherProbleme();
        framePartie.add(composants[0]);  

        //Bouton selection joueur :

        GroupeDeJoueur choixJoueur = new GroupeDeJoueur(nombreJoueur);
        String[] listeNomJoueurs = choixJoueur.getNomsJoueurs();

        JComboBox<String> boutonChoixJoueur = new JComboBox<>(listeNomJoueurs);
        boutonChoixJoueur.setBounds(100, 550, 350, 90);
        boutonChoixJoueur.setOpaque(true);
        boutonChoixJoueur.setBackground(new Color(200, 200, 200 ));
        boutonChoixJoueur.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixJoueur.setFont(new Font("Arial", Font.BOLD, 30));
        //boutonChoixJoueur.addActionListener(e -> selectionCartesBoutonChoixCartes(boutonChoixJoueur));

        //Bouton verification : 

        JButton boutonVerif=new JButton("Verifier");
        boutonVerif.setBounds(1150, 550, 300, 90);
        boutonVerif.setOpaque(true);
        boutonVerif.setBackground(new Color(51, 170, 3 ));
        boutonVerif.setBorder(BorderFactory.createLineBorder(new Color(38, 120, 4  ), 6));
        boutonVerif.setFont(new Font("Arial", Font.BOLD, 28));
        boutonVerif.setForeground(Color.white);


        //ajout des composant à la frame : 
        
        framePartie.add(boutonVerif);
        framePartie.add(textetest);
        framePartie.add(boutonChoixJoueur);
        
        framePartie.setVisible(true);
    }
}