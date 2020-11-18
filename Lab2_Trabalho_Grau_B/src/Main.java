
public class Main {

	public static void main(String[] args) {
		
		User usuarioGustavo = new User("Gustavo");
		
		Task tarefa1 = new TaskHigh(2020, 11, 20, "fazer um bolo");
		Task tarefa2 = new TaskHigh(2020, 11, 20, "fazer um churrasco");
		
		Day dia20201120 = new Day(2020,11,20);
		
		dia20201120.getHighTaskList().insertFirst(tarefa2);
		dia20201120.getHighTaskList().insertFirst(tarefa1);
		
		usuarioGustavo.getTaskList().insertFirst(dia20201120);
		
		System.out.println(dia20201120.toString());
	}

}
