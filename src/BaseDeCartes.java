import java.util.HashMap;
import java.util.Map;

public class BaseDeCartes {
    
    private static final Map<Integer, CarteCritere> carte = new HashMap<>(); //creation d'un hashmap avec un id et une carte critere

    static {
        //creation des cartes criteres avec un id de hash map et des cartes avec leur texte et un id de critere
        carte.put(1,new CarteCritere("<html> cm = 1 | cm > 1</html>",new Critere(1)));
        carte.put(2,new CarteCritere("<html> td ≤ tp | td = tp | td > tp</html> ",new Critere(2)));
        carte.put(3,new CarteCritere("<html> cm + td ≤ 6h | cm + td = 6h | cm + td > 6h</html>",new Critere(3)));
        carte.put(4,new CarteCritere("<html> cm ≤ 3h | cm = 3h | cm > 3h</html>",new Critere(4)));
        carte.put(5,new CarteCritere("<html> cm ≤ tp | cm = tp | cm > tp</html>",new Critere(5)));
        carte.put(6,new CarteCritere("<html> td ≤ cm + tp | td = cm + tp | td > cm + tp</html> ",new Critere(6)));
        carte.put(7, new CarteCritere("<html> cm + td + tp = pair | cm + td + tp = impair</html>", new Critere(7)));
        carte.put(8, new CarteCritere("<html> td ≤ 4h | td = 4h | td > 4h</html>", new Critere(8)));
        carte.put(9, new CarteCritere("<html> tp = pair | tp = impair</html>", new Critere(9)));
        carte.put(10, new CarteCritere("<html> td ≤ tp | td = tp | td > tp</html>", new Critere(10)));
        carte.put(11, new CarteCritere("<html> cm ≤ td + tp | cm = td + tp | cm > td + tp</html>", new Critere(11)));
        carte.put(12, new CarteCritere("<html> cm ≤ 3h | cm = 3h | cm > 3h</html>", new Critere(12)));
        carte.put(13, new CarteCritere("<html> cm + td + tp ≤ 6h | cm + td + tp = 6h | cm + td + tp > 6h</html>", new Critere(13)));
        carte.put(14, new CarteCritere("<html> td = pair | td = impair</html>", new Critere(14)));
        carte.put(15, new CarteCritere("<html> td ≤ tp | td = tp | td > tp</html>", new Critere(15)));
        carte.put(16, new CarteCritere("<html> tp ≤ 3h | tp = 3h | tp > 3h</html>", new Critere(16)));
        carte.put(17, new CarteCritere("<html> tp ≤ cm | tp = cm | tp > cm</html>", new Critere(17)));
        carte.put(18, new CarteCritere("<html> le chiffre 1 apparait une seule fois | le chiffre 1 apparait plus d'une fois<html>", new Critere(18)));
    
    }
    
    //getter pour recuperer une carte a partir d'un id
    public static CarteCritere getCarte(int id){ 
        return carte.get(id);
    }
}
