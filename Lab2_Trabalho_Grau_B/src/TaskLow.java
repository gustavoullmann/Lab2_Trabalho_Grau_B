
public class TaskLow extends Task {
	
	public TaskLow(int year, int month, int day, String taskDescription) {
		super(year, month, day, taskDescription);
		this.setTaskPriority("Baixa");
	}
}
