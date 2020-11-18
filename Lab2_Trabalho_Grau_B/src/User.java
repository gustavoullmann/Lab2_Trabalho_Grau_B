
public class User {
	
	private final String name;
	private final DaysWithTasks taskList;
	
	public User(String name) {
		this.name = name;
		this.taskList = new DaysWithTasks();
	}

	public String getName() {
		return name;
	}

	public DaysWithTasks getTaskList() {
		return taskList;
	}

	@Override
	public String toString() {
		return 	"Nome: " + name + "\n" +
				"TaskList: " + taskList;
	}
	
	
}
