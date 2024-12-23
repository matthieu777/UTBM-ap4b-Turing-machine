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
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Vérificateur de Carte");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        
        JTextField codeField = new JTextField();
        panel.add(new JLabel("Entrez le code :"));
        panel.add(codeField);
        
        JButton verifyButton = new JButton("Vérifier");
        panel.add(verifyButton);
        
        frame.add(panel);
        frame.setVisible(true);
        
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codeText = codeField.getText();
                codeProposer = parseCode(codeText);
                boolean result = verifierCarte();
                JOptionPane.showMessageDialog(frame, "Résultat de la vérification : " + result);
            }
        });
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
