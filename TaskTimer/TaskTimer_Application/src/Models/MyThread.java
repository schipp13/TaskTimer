package Models;

import View.Main;
import View.TimerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

public class MyThread implements Runnable{

    String hrs,min,sec;
    public MyThread(String hours, String minutes, String seconds) {
        hrs = hours;
        min = minutes;
        sec = seconds;
    }

    @Override
    public void run() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainForm.fxml"));
        try {
            Parent root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main controller = loader.getController();

        int hours = Integer.parseInt(hrs);
        int minutes = Integer.parseInt(min);
        int seconds = Integer.parseInt(sec);

        while(hours > 0 || minutes > 0 || seconds > 0)
        {
            if(seconds == 0)
            {
                minutes -= 1;
                seconds = 59;
            }
            if(minutes == 0)
            {
                hours -= 1;
                minutes =59;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            seconds--;

            controller.hoursPlace.setText(String.valueOf(hours));
            controller.minutesPlace.setText(String.valueOf(minutes));
            controller.secondsPlace.setText(String.valueOf(seconds));

        }

    }
}
