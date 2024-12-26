import java.util.HashMap;
import java.util.Map;

public class BaseDeCartes {
    
    private static final Map<Integer, CarteCritere> carte = new HashMap<>();

    static {
        carte.put(1,new CarteCritere("<html>test</html>",new Critere(1)));
        carte.put(2,new CarteCritere("<html>carte cm > tp et td ",new Critere(2)));
        carte.put(3,new CarteCritere("<html>    carte 3 test<br>  teestgdf  test<br>   t tes tes tes<br>   te st </html>",new Critere(3)));
        carte.put(4,new CarteCritere("<html>carte 4 </html>",new Critere(4)));
        carte.put(5,new CarteCritere("<html>carte 5 </html>",new Critere(5)));
        carte.put(6,new CarteCritere("<html>carte 6</html> ",new Critere(6)));

    }
    
    public static CarteCritere getCarte(int id){
        return carte.get(id);
    }
}
