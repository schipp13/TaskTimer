package View;


import Models.ManageTasks;
import Models.Task;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main extends Application implements Initializable {

    @FXML public Label hoursPlace;

    @FXML public Label minutesPlace;

    @FXML public Label secondsPlace;

    @FXML private TableView<Task> TaskTableView;

    @FXML private TableColumn<Task, Integer> taskIDColumn;

    @FXML private TableColumn<Task, String> taskNameColumn;

    @FXML private TableColumn<Task, String> taskDescriptionColumn;

    @FXML private TableColumn<Task, String> taskStartDateColumn;

    @FXML private TableColumn<Task, String> taskEndDateColumn;

    Thread taskThread;

    Parent root;
    boolean running = true;


           /**
            * Loads saved task into the table view
            */
           // todo: Allow the user to choose which file to load from.
   public void loadFile() throws Exception
    {
        List<Task> readTask = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get("Tasks.txt"));
        String line;
        while((line = reader.readLine()) != null)
        {
            String[] readTasks = line.split(",");

            readTask.add(new Task(Integer.parseInt(readTasks[0]), readTasks[1], readTasks[2], readTasks[3], readTasks[4]));

        }

    reader.close();

        for(Task task : readTask)
        {
            ManageTasks.addTask(task);
        }


    }
    /**
     * Write to a textfile to be saved
     * @throws Exception
     */
    // Todo: Allow the user to choose where they want to save the information.
   public void saveFile()throws Exception
    {
        ObservableList<Task> writeTasks = ManageTasks.getAllTasks();
        File file = new File("Tasks.txt");
        FileWriter writer = new FileWriter(file);

       for(Task task : writeTasks)
       {
           writer.write(task.getTaskID() + "," + task.getTaskName() + "," + task.getTaskDescription() + "," + task.getStartDate() + "," + task.getEndDate() + "\n");
       }

        writer.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        taskIDColumn.setCellValueFactory(new PropertyValueFactory<Task, Integer>("taskID"));
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        taskDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskDescription"));
        taskStartDateColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("startDate"));
        taskEndDateColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("endDate"));

        TaskTableView.setItems(ManageTasks.getAllTasks());

    }

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
    // todo: Implement a way to pause the timer
    // todo: redesign the countdown logic
    public void startTimerListener(ActionEvent event) throws IOException{
        // If time hasn't been set open the timerform to set the time
        // else start the timer from being paused

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/TimerForm.fxml"));
            root = loader.load();

            TimerController timeController = loader.getController();

            // Opens the TimerForm as a popup window
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        // Set the time to be displayed
        String hours = timeController.Hours, minutes = timeController.Minutes, seconds = timeController.Seconds;

        this.hoursPlace.setText(timeController.Hours);
        this.minutesPlace.setText(timeController.Minutes);
        this.secondsPlace.setText(timeController.Seconds);


        taskThread = new Thread(new Runnable() {
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

                    Platform.runLater(() -> {
                        hoursPlace.setText(String.valueOf(hours));
                        minutesPlace.setText(String.valueOf(minutes));
                        secondsPlace.setText(String.valueOf(seconds));
                    });
                }
            }
        });

        taskThread.start();

    }
        // todo: implement a way to pause the timer
    public void pauseTimerListener(ActionEvent event) throws Exception
    {

    }

    /**
     * Add a new task to the main forms table
     *
     */
    public void addTaskListener(ActionEvent event) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/TaskForm.fxml"));
        root = loader.load();

        TaskController controller = loader.getController();

        // Set the title label here
        controller.setLabelTitle("Add Task");

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    /**
     * Modify a task an re-upload task to the task table
     *
     */
    public void editTaskListener(ActionEvent event)throws Exception
    {
        Task selectedTask = TaskTableView.getSelectionModel().getSelectedItem();
        int index = TaskTableView.getSelectionModel().getSelectedIndex();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/TaskForm.fxml"));
        root = loader.load();

        TaskController controller = loader.getController();

        // Set the title label here
        controller.setLabelTitle("Modify Task");

        // Enable the radio button to complete task
        controller.enableRadioButton();
        controller.setSelectedTask(selectedTask, index);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    /**
     * Delete a task from the task table
     *
     */
    public void deleteTaskListener(ActionEvent event)throws Exception
    {
        Task selectedTask = TaskTableView.getSelectionModel().getSelectedItem();

        ManageTasks.deleteTask(selectedTask);
    }

}