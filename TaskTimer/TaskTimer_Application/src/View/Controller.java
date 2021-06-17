package View;

import Models.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
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

    /**
     *  Future fixes:
     *  Get Timer to just pop up and not replace the entire Main scene.
     *  Get Timer scene to start up centered.
     *
     *  Opens up the TimerForm
     * @param event
     */
    public void startTimerListener(ActionEvent event) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/TimerForm.fxml"));
        Parent root = loader.load();

        TimerController controller = loader.getController();

        Scene timerFormScene = new Scene(root);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(timerFormScene);
        window.show();

    }
}

