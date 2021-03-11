// Programmer: Saige Chipp
// Date Last modified: 3/2/21
// This is a to do list that allows the user to keep track of what they have/have not completed yet.

import java.util.*;


public class Main {
	
	// Global Variables
	static ArrayList<String> Task_List = new ArrayList<String>();
	
	// Deletes the completed task
	static void deleteTask() {
		
		int task_Index = 0;
		int Task_Completed = 0;
				
		Scanner completed = new Scanner(System.in);
		try {
		// Have the user delete which task is completed
		while(Task_Completed != -1)
		{
			
		System.out.println("Please Enter the task number that you wish to complete: ");
		System.out.println("(Press -1 when you are ready to quit.) ");
		
		// Displays all current tasks
		for (String i : Task_List) {
			System.out.println(task_Index + 1 + ". "+ i);
			task_Index++;
		}
		
		
		Task_Completed = completed.nextInt();
		
		// Deletes selected task
		for(int index = 0; index < Task_List.size(); index++) {
			
			if (Task_Completed == index + 1) {
				Task_List.remove(Task_Completed - 1);
				task_Index = 0;
			}
		  }
		}
		} 
		finally {
			completed.close();
		}
				
	}
	
	// Adds new task to the array
	static void addTask() {
		 String Tasks = "";
	
		 Scanner userInput = new Scanner(System.in);
		 try {
		 System.out.println("Enter a task: ");
		 System.out.println("(Press q when you are ready to exit)");
		 
		// Adds task into the list.
		while(!Tasks.equals("q"))
		{
			
		 Tasks = userInput.nextLine();
		 if(Tasks.equals("q"))break;
		 Task_List.add(Tasks);
		
		}
		 }
		 finally {
			 userInput.close();
		 }
	}
	
	public static void main(String[] args) {
		
		int choice = 0;
		int index = 0;
		
		 // Get what the user wants to do
		 Scanner userInput = new Scanner(System.in);
		 try {
		 // Loops until the user presses 3 to leave the application
		 while(choice != 3) {
		 System.out.println("Please enter what you would like to do: ");
		 System.out.println("1. Create Task ");
		 System.out.println("2. Task Completed ");
		 System.out.println("3. Exit ");
		
		 choice = userInput.nextInt();
		 
		switch(choice) {
		
		case 1:
			// Calls the addTask method
			addTask();
			
			System.out.println("Tasks to be completed:");
			// Display all the tasks that have been added
			for (String i : Task_List) {
				System.out.println(index + 1 + ". "+ i);
				index++;
			}
			
			break;
		case 2:
			// calls the deleteTask method
			deleteTask();
			
			// Display all the tasks that are still needing to be completed
			for (String i : Task_List) {
				System.out.println(index + ". "+ i);
				index++;
			}

			break;
		}	
	  }
		 }finally {
			 userInput.close();
		 }
		
	}

}
