
public class Main {

	public static void main(String[] args) {
		
		Task tarefa = new Task(2020,11,20, "fazer um bolo");
		
		System.out.println(tarefa.toString());
		
		tarefa.setReScheduledDateToAccomplish(2020, 11, 22);
		
		System.out.println("\n\n" + tarefa.toString());
		
		tarefa.setAccomplishedDate(2020, 11, 22);
		
		System.out.println("\n\n" + tarefa.toString());		
		
	
		

	}

}
