package View;

import Models.Timer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Main extends Application {

    @FXML
    private Button startTimer;

    @FXML public Label hoursPlace;
    @FXML private Label minutesPlace;
    @FXML private Label secondsPlace;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainForm.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public void startTimerListener(ActionEvent event) throws IOException {

       Parent root = FXMLLoader.load(getClass().getResource("/View/TimerForm.fxml"));

        Stage popupTimer = new Stage();
        popupTimer.setScene(new Scene(root));
        popupTimer.initModality(Modality.WINDOW_MODAL);
        popupTimer.initOwner(startTimer.getScene().getWindow());
        popupTimer.showAndWait();
    }
    public void setTime(Timer time)
    {

        this.hoursPlace.setText(time.getHours());
        this.minutesPlace.setText(time.getMinutes());
        this.secondsPlace.setText(time.getSeconds());

        System.out.print(hoursPlace.getText());
    }
}
