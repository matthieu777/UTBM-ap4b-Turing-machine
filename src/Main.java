import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            javax.swing.SwingUtilities.invokeLater(() -> new MenuJeu().afficherMenu()); //on lance le menu du jeu
        } catch (Exception e) { //si une erreur survient
            System.err.println("Erreur : ouverture du menu");
            JOptionPane.showMessageDialog(null, "Erreur lors de l'ouverture du menu du jeu", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
