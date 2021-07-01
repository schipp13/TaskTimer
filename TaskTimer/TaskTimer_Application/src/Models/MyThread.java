package Models;

import View.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class MyThread implements Runnable{

    int hours, minutes, seconds;
    public MyThread(String Hours, String Minutes, String Seconds) {
        hours = Integer.parseInt(Hours);
        minutes = Integer.parseInt(Minutes);
        seconds = Integer.parseInt(Seconds);

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
