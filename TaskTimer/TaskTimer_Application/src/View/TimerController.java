package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TimerController {

    @FXML private Button saveTime;

    @FXML private Button cancelTime;

    @FXML private TextField setTime;

    public String Hours;
    public String Minutes;
    public String Seconds;

    /**
     * Get the users input for the time to be displayed
     * @param event
     * @throws Exception
     */
    public void getTime(ActionEvent event) throws Exception {

        String time = setTime.getText();

        Hours = time.substring(0, 2);
        Minutes = time.substring(3, 5);
        Seconds = time.substring(6, 8);

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    /**
     * Goes back to the main form without making changes to the time.
     *
     * @param event
     * @throws Exception
     */
    public void cancelTimeListener(ActionEvent event) throws Exception
    {
        Hours = "00";
        Minutes = "00";
        Seconds = "00";

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}