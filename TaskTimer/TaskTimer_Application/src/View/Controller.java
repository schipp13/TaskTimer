package View;

import Models.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Date;


public class Controller {
    @FXML private Button startTimer;

    @FXML private Button stopTimer;

    @FXML private Button addTask;

    @FXML private Button editTask;

    @FXML private Button deleteTask;

    @FXML private TableView <Task> taskTableView;

    @FXML private TableColumn <Task, Integer> taskIdColumn;

    @FXML private TableColumn <Task, String> taskNameColumn;

    @FXML private TableColumn <Task, String> taskDescriptionColumn;

    @FXML private TableColumn<Task, Date> taskStartDateTableColumn;

    @FXML private TableColumn<Task, Date> taskEndDateTableColumn;

    /* ToDo
        -Pause Timer listener
        -Add Functionality for Add, Edit, and Delete Task
        -Allow the user to save and load up a saved file

     */


    /**
     *  Opens up the TimerForm
     *
     */
    public void startTimerListener(ActionEvent event) throws Exception
    {
        // add if timer is set to 0 than just go to set the form else start the countdown again
        Stage stage = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("/View/TimerForm.fxml"));
       stage.setScene(new Scene(root));
       stage.initModality(Modality.APPLICATION_MODAL);
       stage.initOwner(startTimer.getScene().getWindow());
       stage.showAndWait();

    }


}

