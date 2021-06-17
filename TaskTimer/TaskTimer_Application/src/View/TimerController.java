package View;


import Models.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class TimerController {
    @FXML
    Button startTimer;
    @FXML
    Button cancelTimer;
    @FXML
    TextField Hours;
    @FXML
    TextField Minutes;
    @FXML TextField Seconds;


    public void cancelTimerListener(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainForm.fxml"));
        Scene timerFormScene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(timerFormScene);
        window.show();
    }
}
