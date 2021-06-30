package View;


import Models.MyThread;
import javafx.application.Application;
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


        Runnable countdownThread = new MyThread(timeController.Hours,timeController.Minutes,timeController.Seconds);
        Thread thread2 = new Thread(countdownThread);
        thread2.start();


    }

}