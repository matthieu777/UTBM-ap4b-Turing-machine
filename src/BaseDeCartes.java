import java.util.HashMap;
import java.util.Map;

public class BaseDeCartes {
    
    private static final Map<Integer, CarteCritere> carte = new HashMap<>(); //creation d'un hashmap avec un id et une carte critere

    static {
        //creation des cartes criteres avec un id de hash map et des cartes avec leur texte et un id de critere
        carte.put(1,new CarteCritere("<html>test</html>",new Critere(1)));
        carte.put(2,new CarteCritere("<html>carte cm > tp et td ",new Critere(1)));
        carte.put(3,new CarteCritere("<html>    carte 3 test<br>  teestgdf  test<br>   t tes tes tes<br>   te st </html>",new Critere(1)));
        carte.put(4,new CarteCritere("<html>carte 4 </html>",new Critere(2)));
        carte.put(5,new CarteCritere("<html>carte 5 </html>",new Critere(1)));
        carte.put(6,new CarteCritere("<html>carte 6</html> ",new Critere(1)));

    }
    
    //getter pour recuperer une carte a partir d'un id
    public static CarteCritere getCarte(int id){ 
        return carte.get(id);
    }
}
