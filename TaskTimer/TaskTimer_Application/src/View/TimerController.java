package View;


import Models.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TimerController {

    @FXML private Button saveTime;

    @FXML private TextField setTime;

    public void getTime(ActionEvent event) throws Exception{

        /*
          String time = setTime.getText();
        Timer myTime = new Timer(time.substring(0,2), time.substring(3,5), time.substring(6,8));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainForm.fxml"));
        loader.load();

        Controller controller = loader.getController();
        controller.setTime(myTime);


        Stage stage = (Stage) saveTime.getScene().getWindow();
        stage.show();

         */

        String time = setTime.getText();
        Timer myTime = new Timer(time.substring(0,2), time.substring(3,5), time.substring(6,8));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainForm.fxml"));
        Parent root = loader.load();

        Main controller = loader.getController();
        controller.setTime(myTime);

        // This needs to change to only populate the main form

        Stage stage = (Stage) saveTime.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //stage.show();

    }
}