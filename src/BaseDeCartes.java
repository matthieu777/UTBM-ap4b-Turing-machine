import java.util.HashMap;
import java.util.Map;

public class BaseDeCartes {
    
    private static final Map<Integer, CarteCritere> carte = new HashMap<>(); //creation d'un hashmap avec un id et une carte critere

    static {
        //creation des cartes criteres avec un id de hash map et des cartes avec leur texte et un id de critere
        carte.put(1,new CarteCritere("<html> cm > td</html>",new Critere(1)));
        carte.put(2,new CarteCritere("<html> cm + td > tp</html> ",new Critere(2)));
        carte.put(3,new CarteCritere("<html> cm = td</html>",new Critere(3)));
        carte.put(4,new CarteCritere("<html> cm + td ≤ 3 heures</html>",new Critere(4)));
        carte.put(5,new CarteCritere("<html> cm + tp ≤ 3 heures</html>",new Critere(5)));
        carte.put(6,new CarteCritere("<html> td + tp ≤ 3 heures</html> ",new Critere(6)));
        carte.put(7, new CarteCritere("<html> cm + td + tp = 6 heures</html>", new Critere(7)));
        carte.put(8, new CarteCritere("<html> cm + tp ≤ td</html>", new Critere(8)));
        carte.put(9, new CarteCritere("<html> td + tp ≤ cm</html>", new Critere(9)));
        carte.put(10, new CarteCritere("<html> cm ≤ td</html>", new Critere(10)));
        carte.put(11, new CarteCritere("<html> cm > tp</html>", new Critere(11)));
        carte.put(12, new CarteCritere("<html> td > tp</html>", new Critere(12)));
    
    }
    
    //getter pour recuperer une carte a partir d'un id
    public static CarteCritere getCarte(int id){ 
        return carte.get(id);
    }
}
