import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class TimerHorloge {

    private int heures = 0, minutes = 0, secondes = 0; //varriable pour stocker le temps en min, secondes et heures
    private Timer timer; //instance de la classe Timer
    private TimerListener listener; //instance de timelistener pour notifier les maj de temps
    private boolean actif; //boolean pour savoir si le timer est en pause

    public TimerHorloge() {
        debut(); //debut du timer a la creation
        actif = false;
    }

    
    private void debut() {
        try {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (!actif) {
                        incrementerTemps(); //on augemente le temps
                        if (listener != null) {
                            listener.onTimeUpdated(getTemps()); //on notifie la maj du temps
                        }
                    }
                }
            }, 0, 1000);
        } catch (IllegalStateException e) {
            System.err.println("Erreur : Timer deja en cours");
            JOptionPane.showMessageDialog(null, "Erreur lors du lancement du timer", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }


    //incrmentation du temps :
    private void incrementerTemps() {
        secondes++;
        if (secondes == 60) {
            secondes = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            heures++;
        }
    }

    //temps de facon formate
    public String getTemps() {
        try {
            return String.format("%02d:%02d:%02d", heures, minutes, secondes);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération du temps : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erreur lors lors de la récupération du temps ", "Erreur", JOptionPane.ERROR_MESSAGE);
            return "00:00:00";
        }
    }

    public void pause() {
        actif = true;
    }

    public void relancer() {
        if (actif) {
            actif = false;
        }
    }

    //timer qui observe les maj
    public void setTimerListener(TimerListener listener) {
        this.listener = listener;
    }

    public interface TimerListener {
        void onTimeUpdated(String tempsFormate);
    }
}
