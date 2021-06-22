package View;


import Models.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import jdk.javadoc.internal.doclets.formats.html.resources.standard;


public class TimerController {

    @FXML
    private Button startTimer;
    @FXML
    private Button cancelTimer;
    @FXML
    private TextField setTime;

   public static Timer countdownTimer;

    public void startTimerListener(ActionEvent event) throws Exception
    {
        // Sets hours, minutes, and seconds
        String hours = "", minutes = "", seconds = "";
        String time = setTime.getText();

        // Function that is given a time in the format of 00:00:00.
        // Return the Hours, Minutes, and Seconds
        hours = time.substring(0,2);
        minutes = time.substring(3,5);
        seconds = time.substring(6,8);

        // Creates a new instance of a timer
        countdownTimer = new Timer(hours, minutes, seconds);



    }

    public void cancelTimerListener(ActionEvent event) throws Exception
    {
        Stage stage = new Stage();
        stage=(Stage) cancelTimer.getScene().getWindow();
        stage.close();

    }
}