import java.util.HashMap;
import java.util.Map;

public class BaseDeCartes {
    
    private static final Map<Integer, CarteCritere> carte = new HashMap<>(); //creation d'un hashmap avec un id et une carte critere

    static {
        //creation des cartes criteres avec un id de hash map et des cartes avec leur texte et un id de critere
        carte.put(1, new CarteCritere("<html> cm = 1<br /><br /> cm > 1</html>", new Critere(1)));
        carte.put(2, new CarteCritere("<html> td ≤ tp<br /><br /> td = tp<br /><br /> td > tp</html> ", new Critere(2)));
        carte.put(3, new CarteCritere("<html> cm + td ≤ 6h<br /><br /> cm + td = 6h<br /><br /> cm + td > 6h</html>", new Critere(3)));
        carte.put(4, new CarteCritere("<html> cm ≤ 3h<br /><br /> cm = 3h<br /><br /> cm > 3h</html>", new Critere(4)));
        carte.put(5, new CarteCritere("<html> cm ≤ tp<br /><br /> cm = tp<br /><br /> cm > tp</html>", new Critere(5)));
        carte.put(6, new CarteCritere("<html> td ≤ cm + tp<br /><br /> td = cm + tp<br /><br /> td > cm + tp</html> ", new Critere(6)));
        carte.put(7, new CarteCritere("<html> cm + td + tp = pair<br /><br /> cm + td + tp = impair</html>", new Critere(7)));
        carte.put(8, new CarteCritere("<html> td ≤ 4h<br /><br /> td = 4h<br /><br /> td > 4h</html>", new Critere(8)));
        carte.put(9, new CarteCritere("<html> tp = pair<br /><br /> tp = impair</html>", new Critere(9)));
        carte.put(10, new CarteCritere("<html> td ≤ tp<br /><br /> td = tp<br /><br /> td > tp</html>", new Critere(10)));
        carte.put(11, new CarteCritere("<html> cm ≤ td ET tp<br /><br /> cm = td ET tp<br /><br /> cm > td ET tp</html>", new Critere(11)));
        carte.put(12, new CarteCritere("<html> cm ≤ 3h<br /><br /> cm = 3h<br /><br /> cm > 3h</html>", new Critere(12)));
        carte.put(13, new CarteCritere("<html> cm + td + tp ≤ 6h<br /><br /> cm + td + tp = 6h<br /><br /> cm + td + tp > 6h</html>", new Critere(13)));
        carte.put(14, new CarteCritere("<html> td = pair<br /><br /> td = impair</html>", new Critere(14)));
        carte.put(15, new CarteCritere("<html> td ≤ tp<br /><br /> td = tp<br /><br /> td > tp</html>", new Critere(15)));
        carte.put(16, new CarteCritere("<html> tp ≤ 3h<br /><br /> tp = 3h<br /><br /> tp > 3h</html>", new Critere(16)));
        carte.put(17, new CarteCritere("<html> tp ≤ cm<br /><br /> tp = cm<br /><br /> tp > cm</html>", new Critere(17)));
        carte.put(18, new CarteCritere("<html> le chiffre 1 apparait une seule fois<br /><br /> le chiffre 1 n'apparait pas<html>", new Critere(18)));
        carte.put(19, new CarteCritere("<html> cm = pair<br /><br /> cm = impair<html>", new Critere(19)));
        carte.put(20, new CarteCritere("<html> td ≤ 3h<br /><br /> td = 3h <br /><br /> td > 3h<html>", new Critere(20)));
        carte.put(21, new CarteCritere("<html> cm ≤ tp<br /><br /> cm = tp<br /><br /> cm > tp<html>", new Critere(21)));
        carte.put(22, new CarteCritere("<html> cm + td + tp = pair<br /><br /> cm + td + tp = impair</html>", new Critere(22)));
        carte.put(23, new CarteCritere("<html> cm + td ≤ 6h<br /><br /> cm + td = 6h<br /><br /> cm + td > 6h</html>", new Critere(23)));
        carte.put(24, new CarteCritere("<html> td ≤ 5h<br /><br /> td = 5h<br /><br /> td > 5h<html>", new Critere(24)));
        carte.put(25, new CarteCritere("<html> cm = pair<br /><br /> cm = impair<html>", new Critere(25)));
        carte.put(26, new CarteCritere("<html> cm ≤ 4h<br /><br /> cm = 4h<br /><br /> cm > 4h<html>", new Critere(26)));
        carte.put(27, new CarteCritere("<html> tp ≤ 5h<br /><br /> tp = 5h<br /><br /> tp > 5h<html>", new Critere(27)));
        carte.put(28, new CarteCritere("html> cm + td + tp = pair<br /><br /> cm + td + tp = impair</html>", new Critere(28)));
        carte.put(29, new CarteCritere("<html> td ≤ cm ET tp<br /><br /> td = cm ET tp<br /><br /> td > cm ET tp<html>", new Critere(29)));
        carte.put(30, new CarteCritere("<html> cm = 1<br /><br /> cm > 1</html>", new Critere(30)));
        carte.put(31, new CarteCritere("<html> cm ≤ td ET tp<br /><br /> cm = td ET tp<br /><br /> cm > td ET tp</html>", new Critere(31)));
        carte.put(32, new CarteCritere("<html> cm ≤ 3h<br /><br /> cm = 3h<br /><br /> cm > 3h</html>", new Critere(32)));
        carte.put(33, new CarteCritere("<html> td = pair<br /><br /> td = impair</html>", new Critere(33)));
        carte.put(34, new CarteCritere("<html> td ≤ 4h<br /><br /> td = 4h<br /><br /> td > 4h<html>", new Critere(34)));
        carte.put(35, new CarteCritere("<html> td ≤ cm ET tp<br /><br /> td = cm ET tp<br /><br /> td > cm ET tp<html>", new Critere(35)));
        carte.put(36, new CarteCritere("<html> tp ≤ cm ET td<br /><br /> tp = cm ET td<br /><br /> tp > cm ET td<html>", new Critere(36)));
        carte.put(37, new CarteCritere("<html> le chiffre 3 apparait 1 seule fois<br /><br /> le chiffre 3 n'apparait pas<html>", new Critere(37)));
        carte.put(38, new CarteCritere("<html> le chiffre apparait une seule fois<br /><br /> le chiffre apparait plusieurs fois<html>", new Critere(38)));
    }
    
    //getter pour recuperer une carte a partir d'un id
    public static CarteCritere getCarte(int id){ 
        return carte.get(id);
    }
}
