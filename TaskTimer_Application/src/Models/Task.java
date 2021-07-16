package Models;


public class Task {
    private int taskID;
    private String taskName;
    private String taskDescription;
    private String startDate;
    private String endDate;


    public Task(int taskID, String taskName, String taskDescription, String startDate, String endDate)
    {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
