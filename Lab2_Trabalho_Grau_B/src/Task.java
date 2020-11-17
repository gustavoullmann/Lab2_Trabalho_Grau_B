import java.time.LocalDate;

public class Task {

	private final LocalDate creationDate;
	private final LocalDate scheduledDateToAccomplish;
	private LocalDate reScheduledDateToAccomplish;
	private LocalDate accomplishedDate;
	private Boolean isTaskCompleted;
	private String taskDescription;
	private String taskPriority;

	public Task(int year, int month, int day, String taskDescription) {
		this.creationDate = LocalDate.now();
		this.scheduledDateToAccomplish = LocalDate.of(year, month, day);
		this.reScheduledDateToAccomplish = null;
		this.accomplishedDate = null;
		this.isTaskCompleted = false;
		this.taskDescription = taskDescription;
		this.taskPriority = "";
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public LocalDate getScheduledDateToAccomplish() {
		return scheduledDateToAccomplish;
	}

	public LocalDate getReScheduledDateToAccomplish() {
		return reScheduledDateToAccomplish;
	}

	public void setReScheduledDateToAccomplish(int year, int month, int day) {
		this.reScheduledDateToAccomplish = LocalDate.of(year, month, day);
	}

	public LocalDate getAccomplishedDate() {
		return accomplishedDate;
	}

	public void setAccomplishedDate(int year, int month, int day) {
		this.accomplishedDate = LocalDate.of(year, month, day);
		this.isTaskCompleted = true;
	}

	public Boolean getIsTaskCompleted() {
		return isTaskCompleted;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	
	@Override
	public String toString() {
		return 	"Data de criação: " + creationDate + "\n" +
				"Data para conclusão: " + scheduledDateToAccomplish + "\n" +
				"Nova data para conclusão: " + reScheduledDateToAccomplish + "\n" +
				"Data de conclusão: " + accomplishedDate + "\n" +
				"Tarefa conluída? " + isTaskCompleted + "\n" +
				"Descrição da tarefa: " + taskDescription + "\n" +
				"Prioridade da tarefa: " + taskPriority;
	}

	
}