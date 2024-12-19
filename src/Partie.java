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
        JLabel textetest = new JLabel("Partie avec " + nombreJoueur + " joueur et " + nombreCarte + " revelateur");
        textetest.setBounds(200, 150, 900, 50);
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

        JButton boutonverif=new JButton("Verifier!");
        boutonverif.setBounds(500, 550, 250, 100);

        framePartie.add(boutonverif);
        framePartie.add(textetest);
        
        framePartie.setVisible(true);
    }
}