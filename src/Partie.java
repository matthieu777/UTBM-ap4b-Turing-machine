import java.awt.*;
import java.util.Arrays;
import javax.swing.*;


public class Partie {
    
    private final int nombreJoueur;
    private final int nombreCarte;
    private final GroupeDeJoueur choixJoueur;
    private Joueur joueurSelectionne;
    private Problem problem;
    private TimerHorloge timer;
    private int nbprob;
    private final int[] codeEntrer = new int[3];
    private JLabel texteNbrEssaie;


    public Partie(int nombreJoueur, int nombreCarte) {
        this.nombreJoueur = nombreJoueur;
        this.nombreCarte = nombreCarte;
        this.choixJoueur = new GroupeDeJoueur(nombreJoueur);
        this.joueurSelectionne = choixJoueur.getListDeJoueurs().get(0);
    }

    public void afficherPartie() {

        problem = changementProblemNbrCarte(nombreCarte); //on initialise un probleme de la taille voulue
        
        //frame principale : 

        JFrame framePartie = new JFrame("Turing Machine / Partie avec problem numero " + nbprob);
        framePartie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePartie.setSize(2000, 750);
        framePartie.getContentPane().setBackground(new Color(225, 225, 225));
        framePartie.setLayout(null);
        framePartie.setLocationRelativeTo(null);

        // afichage d'un titre 

        JLabel texteTitre = new JLabel("<html><u>Partie avec " + nombreJoueur + " joueur, " + nombreCarte + " revelateur et le probleme n°" +nbprob+ ":</u></html>");
        texteTitre.setBounds(300, 15, 900, 90);
        texteTitre.setFont(new Font("Arial", Font.BOLD, 30));

        // affichage d'un timer

        timer = new TimerHorloge();
        JLabel labelTemps = new JLabel(timer.getTemps());
        timer.setTimerListener(temps -> SwingUtilities.invokeLater(() -> labelTemps.setText(temps)));
        labelTemps.setFont(new Font("Arial", Font.BOLD, 40));
        labelTemps.setBounds(30, 15, 250, 90);

        // affichage du probleme : 

        JComponent[] composants = problem.afficherProbleme(nbprob);
        framePartie.add(composants[0]);  

        //Bouton quitter : 
        JButton boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBounds(1300, 40, 180, 60);
        boutonQuitter.setBackground(new Color(250, 85, 85));
        boutonQuitter.setBorder(BorderFactory.createLineBorder(new Color(181, 44, 44 ), 6));
        boutonQuitter.setForeground(Color.white);
        boutonQuitter.setFont(new Font("Arial", Font.BOLD, 20));

        boutonQuitter.addActionListener( e -> quitter(framePartie,timer,problem));

        //Bouton selection joueur :

        String[] listeNomJoueurs = choixJoueur.getNomsJoueurs(); //recupe la liste des noms des joueurs 

        JComboBox<String> boutonChoixJoueur = new JComboBox<>(listeNomJoueurs);
        boutonChoixJoueur.setBounds(100, 550, 330, 70);
        boutonChoixJoueur.setOpaque(true);
        boutonChoixJoueur.setBackground(new Color(200, 200, 200 ));
        boutonChoixJoueur.setBorder(BorderFactory.createLineBorder(new Color(88, 88, 88 ), 6));
        boutonChoixJoueur.setFont(new Font("Arial", Font.BOLD, 30));

        boutonChoixJoueur.addActionListener( e -> selectionJoueurBoutonChoixJoueurs(boutonChoixJoueur, choixJoueur));

        //affichage nombre d'essaie

        texteNbrEssaie = new JLabel("Nombre essaie : "+ joueurSelectionne.getnbrEssaie() +"/3");
        texteNbrEssaie.setBounds(120, 610, 300, 50);
        texteNbrEssaie.setFont(new Font("Arial", Font.BOLD, 15));

        //Bouton parametre : 

        JButton boutonParametre = new JButton("Paramètres");
        boutonParametre.setBounds(1100, 40, 180, 60);
        boutonParametre.setBackground(new Color(117, 185, 242 ));
        boutonParametre.setBorder(BorderFactory.createLineBorder(new Color(21, 141, 241 ), 6));
        boutonParametre.setForeground(Color.white);
        boutonParametre.setFont(new Font("Arial", Font.BOLD, 20));
 
        Parametres parametres = new Parametres();
 
        boutonParametre.addActionListener( e -> { try{ parametres.afficherParametres(timer, joueurSelectionne, boutonChoixJoueur, this); } catch (Exception ex) {
            JOptionPane.showMessageDialog(
            null,
            "Erreur : affichage des parametres : " + ex.getMessage(),
            "Erreur",
            JOptionPane.ERROR_MESSAGE
        ); }
        });


        // 3 Champs pour entrer le code :
        
        JTextField codeField1 = new JTextField(1);
        codeField1.setBounds(600, 550, 50, 70);
        codeField1.setFont(new Font("Arial", Font.BOLD, 28));
        codeField1.setHorizontalAlignment(JTextField.CENTER);
    
        JTextField codeField2 = new JTextField(1);
        codeField2.setBounds(660, 550, 50, 70);
        codeField2.setFont(new Font("Arial", Font.BOLD, 28));
        codeField2.setHorizontalAlignment(JTextField.CENTER);
    
        JTextField codeField3 = new JTextField(1);
        codeField3.setBounds(720, 550, 50, 70);
        codeField3.setFont(new Font("Arial", Font.BOLD, 28));
        codeField3.setHorizontalAlignment(JTextField.CENTER);
    

        //Bouton pour lancer la verification : 
        
        JButton boutonVerif=new JButton("Verifier");
        boutonVerif.setBounds(1150, 550, 290, 70);
        boutonVerif.setOpaque(true);
        boutonVerif.setBackground(new Color(51, 170, 3 ));
        boutonVerif.setBorder(BorderFactory.createLineBorder(new Color(38, 120, 4  ), 6));
        boutonVerif.setFont(new Font("Arial", Font.BOLD, 28));
        boutonVerif.setForeground(Color.white);
        boutonVerif.addActionListener( e -> methodeButonVerification(framePartie, codeField1, codeField2, codeField3,timer));
        
        //ajout des composants à la frame 
       
        framePartie.add(texteTitre);
        framePartie.add(labelTemps);
        framePartie.add(boutonParametre);
        framePartie.add(boutonQuitter);
        framePartie.add(boutonVerif);
        framePartie.add(boutonChoixJoueur);
        framePartie.add(texteNbrEssaie);
        framePartie.add(codeField1);
        framePartie.add(codeField2);
        framePartie.add(codeField3);
        
        
        framePartie.setVisible(true);
    }




    // methodes pour changer le joueur selectioner

    private void selectionJoueurBoutonChoixJoueurs(JComboBox<String> comboBox, GroupeDeJoueur choixJoueur) {
        String selectedOption = (String) comboBox.getSelectedItem(); //recupere en string l'option selection dans le combobox

        if (selectedOption != null && !selectedOption.isEmpty()) { // si la selection n'est pas vide 
            int indexSelectionne = comboBox.getSelectedIndex(); //recupere l'index du bouton 
            joueurSelectionne = choixJoueur.getListDeJoueurs().get(indexSelectionne); //recupere le nouveau joueur selectioner grace a l'index 
            System.out.println("Joueur selectionne : " + joueurSelectionne.getNom()); //affichage dans la console pour verification
            texteNbrEssaie.setText("Nombre essai : " + joueurSelectionne.getnbrEssaie() + "/3"); //maj afficahge du nombre d'essaie du joueurs
        }
    }

    //methodes utiliser pour genere un probleme de la taille voulue dans le menue

    public Problem changementProblemNbrCarte(int nombreCarte) {
        return switch (nombreCarte) {
            case 4 -> {
                Problem newProblem = new Problem_4_cartes(); //nouveau problem de 4 carte
                nbprob = newProblem.genererandom(2); //choix au hasard dans la liste de problem a 4 cartes dans le fichier texte
                yield newProblem;
            }
            case 5 -> {
                Problem newProblem = new Problem_5_cartes();
                nbprob = newProblem.genererandom(6);
                yield newProblem;
            }
            case 6 -> {
                Problem newProblem = new Problem_6_cartes();
                nbprob = newProblem.genererandom(6);
                yield newProblem;
            }
            default -> {
                Problem newProblem = new Problem_4_cartes();
                nbprob = newProblem.genererandom(2);
                yield newProblem;
            }
        };
    }

    //methodes pour quitter la partie : 

    private static void quitter(JFrame framePartie, TimerHorloge timer,Problem problem) {

        int choix = JOptionPane.showConfirmDialog( //boite de dialoge pour proposer de voir le code solution avant de quitter
            framePartie,
            "La partie a durre : "+ timer.getTemps() +"\nVoulez-vous voir la solution avant de quitter ?",
            "Solution",
            JOptionPane.YES_NO_OPTION
        ); 
        if (choix == JOptionPane.YES_OPTION) { // si l'utilisateur veut voir le code reponse 
            int [] coderecup=problem.getCode();
            int choix2 = JOptionPane.showOptionDialog(
                framePartie,
                "La solution etait : "+ coderecup[0]+ coderecup[1]+ coderecup[2] , //affichage code reponse
                "Solution",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[] { "ok" },
                "ok"
            );
            if (choix2 == JOptionPane.CLOSED_OPTION || choix2 == 0) {
                framePartie.dispose();
            }
        } else { //sinon on quitte sans afficher le code reponse
            framePartie.dispose();
        }
    }



    public void updateJoueurList(JComboBox<String> comboBox) {
        //maj de la liste de joueurs apres changement de nom avec le nouveau nom
        String[] listeNomJoueurs = choixJoueur.getNomsJoueurs();
        comboBox.setModel(new DefaultComboBoxModel<>(listeNomJoueurs));
    }


    private void methodeButonVerification(JFrame framePartie,JTextField codeField1, JTextField codeField2, JTextField codeField3, TimerHorloge timer) {

        //recuperation des 3 nombres entrés par l'utilisateur
        String text1 = codeField1.getText().trim();
        String text2 = codeField2.getText().trim();
        String text3 = codeField3.getText().trim();
        
        //recuperation de la carte selectionnée
        int idcartesselectioner = problem.getCartesSelectionne();

        // verification si on a bien les 3 chiffres de rempli et si on a bien une carte selectioner
        if ((text1.matches("\\d") && text2.matches("\\d") && text3.matches("\\d")) && (problem.getCartesSelectionne() != -1)) {
            
            //on mets a jour le code proposer par le joueur
            codeEntrer[0] = Integer.parseInt(text1);
            codeEntrer[1] = Integer.parseInt(text2);
            codeEntrer[2] = Integer.parseInt(text3);
    
            //affichage console du code entrer et de la carte selectioner pour verification 
            System.out.println("Code entrer : " + codeEntrer[0] + ", " + codeEntrer[1] + ", " + codeEntrer[2]);    
            System.out.println("Carte selectionner : " + problem.getCartesSelectionne());

                
            //verrifie si le joueur a un nbr d'essaie <3 
            if (joueurSelectionne.autorisationJouer()) {
    
                //Si le joueur joue on augmente son nombre d'essais
                joueurSelectionne.augmentationEssai();
                texteNbrEssaie.setText("Nombre essai : " + joueurSelectionne.getnbrEssaie() + "/3"); //mise a jour de l'affichage du nombre d'essaie du joueur
    
                //System.out.println("nombre essai " + joueurSelectionne + ":" + joueurSelectionne.getnbrEssaie()); //affichage console pour test
    
                //on essaye d'abord si le code entrer par le joueur est le bon
                if (Arrays.equals(codeEntrer, problem.getCode())) {

                    JOptionPane.showMessageDialog(framePartie, "Felicitation "+ joueurSelectionne +" vous avez GAGNER!!!! \n La partie a durer :"+timer.getTemps());//affichage 
                    framePartie.dispose(); //on quitte la partie en cours donc la frame

                } else { //sinon on interoge la carte avec le code proposer
                    
                    Verificateur verificateur = new Verificateur();
                    boolean resVerification = verificateur.verifierCode(codeEntrer, idcartesselectioner); //on interoge le verificateur
                    JOptionPane.showMessageDialog(framePartie, "Résultat de la vérification : " + resVerification); //on affiche a l'utilisateur le resultat de la verifiaction

                }
    
            } else if (!joueurSelectionne.autorisationJouer() && !choixJoueur.groupePeutJouer()) { //sinon si le joueur ne peut pas joueur et que aucun joueur peut jouer
               
                JOptionPane.showMessageDialog(framePartie, "Tous les joueurs ont fait leurs 3 essais. Reinitialisation des essais. Veuillez rejouez");
                choixJoueur.reinitialiserEssais(); //on remets tous les joueurs à 3 essaies

            } else {
                //sinon si un joueur du groupe n'a pas 3 essaie et peut jouer on dit au joueur a 3 essaie d'attendre 
                JOptionPane.showMessageDialog(framePartie, "Vous avez déjà fait vos 3 essais. Attendez que les autres joueurs ont terminés");
            }
    
        } else { //sinon si on a pas 3 chiffres corect et une carte selectioner :
            JOptionPane.showMessageDialog(null, "Veuillez entrer un code valide et/ou selectionner une carte à interoger", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    

}
