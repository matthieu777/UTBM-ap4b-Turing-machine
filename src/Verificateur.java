import javax.swing.JOptionPane;

public class Verificateur {

    //constructeur de la classe Verificateur
    public Verificateur() {
       
    }

    //Verification d'un code en fonction d'un code donner et d'une id de carte critere
    public boolean  verifierCode(int[] codeEntrer, int idCarte) {
        try {

            CarteCritere carte = BaseDeCartes.getCarte(idCarte); //on recupere la carte dans la base de carte grace a l'id de la carte
            
            if (carte == null) {
                    JOptionPane.showMessageDialog(null, "Erreur : Carte avec l'ID " + idCarte + " introuvable.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return false;
            }

            return  verifierCarte(carte, codeEntrer); //on lance la verification sur la carte avec le code donner

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur : Une erreur lors de la vérification : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            return false; // Retourner false en cas d'erreur
        }
    
    }


    
    //Methode pour verififier une carte criter selon un carte criter et un code
    public boolean verifierCarte(CarteCritere carte, int[] code) {
        try {
            if (carte == null) {
                JOptionPane.showMessageDialog(null, "Erreur : Carte invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
            Critere critere = carte.getCritere(); //on recupere le critere de la carte

            if (critere == null) {
                JOptionPane.showMessageDialog(null, "Erreur : Critère non défini pour la carte", "Erreur", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return critere.verifier(code[0], code[1], code[2]); //on interoge le critere avec le code donner
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur : Une erreur lors de la vérification du critère : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
    }
}
