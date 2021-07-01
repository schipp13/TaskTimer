package View;


import Models.MyThread;
import Models.Task;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {


    @FXML private Button startTimer;

    @FXML public Label hoursPlace;

    @FXML public Label minutesPlace;

    @FXML public Label secondsPlace;

    Parent root;
    private Main controller;


    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("/View/MainForm.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);



    }

    /**
     * Opens the TimerPopUpWindow to get the time for the countdown.
     * @param event
     * @throws IOException
     */
    public void startTimerListener(ActionEvent event) throws IOException{

      FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/TimerForm.fxml"));
      root = loader.load();

     TimerController timeController = loader.getController();

        // Opens the TimerForm as a popup window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        // Set the time to be displayed
        this.hoursPlace.setText(timeController.Hours);
        this.minutesPlace.setText(timeController.Minutes);
        this.secondsPlace.setText(timeController.Seconds);

        /*
        Runnable countdownThread = new MyThread(hoursPlace.getText(), minutesPlace.getText(),secondsPlace.getText());
        Thread thread2 = new Thread(countdownThread);
        thread2.start();
        */

        Thread taskThread = new Thread(new Runnable() {
            int hours, minutes, seconds;

            @Override
            public void run() {

                // sets the variables to be computed for the countdown
                hours = Integer.parseInt(hoursPlace.getText());
                minutes = Integer.parseInt(minutesPlace.getText());
                seconds = Integer.parseInt(secondsPlace.getText());

                // loops to count down the timer
                while (hours > 0 || minutes > 0 || seconds > 0) {
                    if (seconds == 0) {
                        minutes -= 1;
                        seconds = 59;
                    }
                    if (minutes == 0) {
                        hours -= 1;
                        minutes = 59;
                    }

                    // Sleeps the thread
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds--;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            hoursPlace.setText(String.valueOf(hours));
                            minutesPlace.setText(String.valueOf(minutes));
                            secondsPlace.setText(String.valueOf(seconds));
                        }
                    });
                }
            }
        });

        taskThread.start();
    }
}