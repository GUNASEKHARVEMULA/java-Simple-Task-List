package TaskListaPP;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		TaskList taskList = new TaskList();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			displayMenu();
			int choice = getUserChoice(scan);
			
			switch (choice) {
			case 1:
				taskList.addTask(getTaskName(scan));
				break;
				
			case 2:
				if(!taskList.isEmpty()) {
					taskList.listTasks();
					int taskNumber = getUserInput(scan, "Enter the task number that you want to remove: ");
					if(taskList.isValidTaskNumber(taskNumber)) {
						taskList.removeTask(taskNumber);
					}
				} else {
					System.out.println("Invalid Task Number selected.");
					
				}
				break;
				
			case 3:
				if(!taskList.isEmpty()) {
					taskList.listTasks();
				}else {
					System.out.println("No tasks to list.");
				}
				break;
			
			case 4:
				scan.close();
				return;
				
			default:
				System.out.println("Invalid option is selected,Please try again");
			}
		}
		
	}
	
	private static void displayMenu() {
		System.out.println("Task List Application");
		System.out.println("1. Add Task");
		System.out.println("2. Remove Task");
		System.out.println("3. List Tasks");
		System.out.println("4. Quit from the application");
		System.out.println("Please select an option from the above: ");
		
	}
	
	private static int getUserChoice(Scanner scan) {
		return scan.nextInt();
	}
	
	private static String getTaskName(Scanner scan) {
		System.out.println("Enter the task name: ");
		return scan.next();
	}
	
	private static int getUserInput(Scanner scan,String prompt) {
		System.out.println(prompt);
		return scan.nextInt();
		
	}

}

class TaskList{
	private ArrayList<String> tasks = new ArrayList<>();
	
	public void addTask(String name) {
		tasks.add(name);
		System.out.println("Task added.");
		
	}
	
	public void removeTask(int taskNumer) {
		tasks.remove(taskNumer - 1);
		System.out.println("The selected task is removed");
	}
	public void listTasks() {
		for(int i=0;i<tasks.size();i++) {
			System.out.println((i+1) + ". " + tasks.get(i));
		}
	}
	public boolean isEmpty() {
		
		return tasks.isEmpty();
	}
	public boolean isValidTaskNumber(int taskNumber) {
		return taskNumber >=1 && taskNumber <= tasks.size();
	}
}
