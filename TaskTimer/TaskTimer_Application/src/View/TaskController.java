package View;

import Models.ManageTasks;
import Models.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


public class TaskController implements Initializable {

    @FXML private TextField taskID;

    @FXML private TextField taskName;

    @FXML private TextArea taskDescription;

    @FXML private TextField startDate;

    @FXML private TextField endDate;

    @FXML private RadioButton taskCompleted;

    @FXML private Label labelTitle;

    @FXML private Button cancelTask;

    @FXML private Button saveTask;

    int selectedIndex;

    public void setSelectedTask(Task selected, int index)
    {
        selectedIndex = index;

        this.taskID.setText(Integer.toString(selected.getTaskID()));
        this.taskName.setText(selected.getTaskName());
        this.taskDescription.setText(selected.getTaskDescription());
        this.startDate.setText(selected.getStartDate());
        this.endDate.setText(selected.getEndDate());

    }

    public void setLabelTitle(String text)
    {
        this.labelTitle.setText(text);
    }

    public void enableRadioButton()
    {
        taskCompleted.setVisible(true);
    }

    /**
     * Adds a new task to the main forms table
     */
    public void saveTaskListener(ActionEvent event) throws Exception
    {
        if(this.labelTitle.getText().equals("Add Task")) {
            // Get start and end date to be a time stamp
            Task myTask = new Task(Integer.parseInt(taskID.getText()), taskName.getText(), taskDescription.getText(), startDate.getText(), endDate.getText());

            ManageTasks.addTask(myTask);
        }
        else {
            // Save updates made to the task.
            Task modifiedTask = new Task(Integer.parseInt(taskID.getText()), taskName.getText(), taskDescription.getText(), startDate.getText(), endDate.getText());

            ManageTasks.updateTask(selectedIndex, modifiedTask);
        }

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
    }


    /**
     * Goes back to the main form without making changes
     * @param event
     * @throws Exception
     */
    public void cancelTasklistener(ActionEvent event) throws Exception
    {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        taskCompleted.setVisible(false);

        // Create a startDate for when the task is saved
        Date taskStartDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        this.startDate.setText(formatter.format(taskStartDate));
        this.endDate.setText("-");


    }

}
