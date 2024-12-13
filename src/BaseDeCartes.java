import java.util.HashMap;
import java.util.Map;

public class BaseDeCartes {
    
    private static final Map<Integer, CarteCritere> carte = new HashMap<>();

    static {
        carte.put(1,new CarteCritere("     test",new Critere(1)));
        carte.put(2,new CarteCritere("     carte cm > tp et td ",new Critere(2)));
        carte.put(3,new CarteCritere("     carte 3 ",new Critere(3)));
        carte.put(4,new CarteCritere("     carte 5 ",new Critere(4)));
    }
    
    public static CarteCritere getCarte(int id){
        return carte.get(id);
    }
}
