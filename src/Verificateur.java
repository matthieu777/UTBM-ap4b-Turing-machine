
public class Verificateur {

    //constructeur de la classe Verificateur
    public Verificateur() {
       
    }

    //Verification d'un code en fonction d'un code donner et d'une id de carte critere
    public boolean  verifierCode(int[] codeEntrer, int idCarte) {

        CarteCritere carte = BaseDeCartes.getCarte(idCarte); //on recupere la carte dans la base de carte grace a l'id de la carte
    
        return  verifierCarte(carte, codeEntrer); //on lance la verification sur la carte avec le code donner
    
    }


    
    //Methode pour verififier une carte criter selon un carte criter et un code
    public boolean verifierCarte(CarteCritere carte, int[] code) {
        Critere critere = carte.getCritere(); //on recupere le critere de la carte
        return critere.verifier(code[0], code[1], code[2]); //on interoge le critere avec le code donner
    }
}

