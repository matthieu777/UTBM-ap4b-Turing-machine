import java.util.Map;

import javax.swing.JComponent;


public abstract class Problem {
    private int[] code;
    private CarteCritere[] listeCartes;

    public abstract  JComponent[] afficherProbleme(int nbprob);
    public abstract int[] getCode();
}


