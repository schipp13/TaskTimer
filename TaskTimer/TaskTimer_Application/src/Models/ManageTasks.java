package Models;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ManageTasks {
    private static ObservableList<Task> allTasks = FXCollections.observableArrayList();

    public static void addTask(Task newTask)
    {
        allTasks.add(newTask);
    }

    public static void updateTask(int index, Task modifiedTask)
    {
        allTasks.remove(index);
        allTasks.add(index, modifiedTask);
    }

    public static boolean deleteTask(Task completedTask)
    {
        allTasks.remove(completedTask);
        return true;
    }

    public static ObservableList<Task> getAllTasks()
    {
        return allTasks;
    }
}
