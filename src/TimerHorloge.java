import java.util.Timer;
import java.util.TimerTask;


public class TimerHorloge {
    private int heures = 0, minutes = 0, secondes = 0;
    private Timer timer;
    private TimerListener listener;

    public TimerHorloge() {
        debut(); //debut du timer a la creation
    }

    
    private void debut() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                incrementerTemps();
                if (listener != null) {
                    listener.onTimeUpdated(getTemps());
                }
            }
        }, 0, 1000);
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
        return String.format("%02d:%02d:%02d", heures, minutes, secondes);
    }

    //timer qui observe les maj
    public void setTimerListener(TimerListener listener) {
        this.listener = listener;
    }

    public interface TimerListener {
        void onTimeUpdated(String tempsFormate);
    }
}
