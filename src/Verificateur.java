import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Verificateur {
    
    private int[] codeProposer;
    private Problem problem;
    private CarteCritere carte;

    public Verificateur(Problem problem, CarteCritere carte) {
        this.problem = problem;
        this.carte = carte;
    }

    public void verifierCode(String codeText, JFrame framepartie) {
        codeProposer = parseCode(codeText);
        boolean result = verifierCarte();
        JOptionPane.showMessageDialog(framepartie, "Résultat de la vérification : " + result);
        
    }

    private int[] parseCode(String codeText) {
        String[] parts = codeText.split(",");
        int[] code = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            code[i] = Integer.parseInt(parts[i].trim());
        }
        return code;
    }

    public boolean verifierCarte() {
        Critere critere = carte.getCritere();
        if (codeProposer.length < 3) {
            return false;
        }
        return critere.verifier(codeProposer[0], codeProposer[1], codeProposer[2]);
    }
}
