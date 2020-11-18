import java.time.LocalDate;

public class Day {

	private final LocalDate dayDate;
	private PriorityLowTasks lowTaskList;
	private PriorityMediumTasks mediumTaskList;
	private PriorityHighTasks highTaskList;
	
	public Day(int year, int month, int day) {
		this.dayDate = LocalDate.of(year, month, day);
		this.lowTaskList = new PriorityLowTasks();
		this.mediumTaskList = new PriorityMediumTasks();
		this.highTaskList = new PriorityHighTasks();
	}

	public LocalDate getDayDate() {
		return dayDate;
	}
	
	public PriorityLowTasks getLowTaskList() {
		return lowTaskList;
	}

	public PriorityMediumTasks getMediumTaskList() {
		return mediumTaskList;
	}
	
	public PriorityHighTasks getHighTaskList() {
		return highTaskList;
	}


	
	
}
