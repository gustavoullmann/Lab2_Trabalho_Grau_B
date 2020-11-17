
public class Main {

	public static void main(String[] args) {
		
		Task tarefa1 = new TaskHigh(2020,11,20, "fazer um bolo");
		Task tarefa2 = new TaskHigh(2020,11,21, "fazer um churrasco");
		Task tarefa3 = new TaskHigh(2020,11,22, "fazer uma pizza");
		
		SinglyLinkedTaskList lista = new PriorityHighTasks();
		
		lista.insertLast(tarefa1);
		lista.insertLast(tarefa2);
		lista.insertLast(tarefa3);
		
		System.out.println(lista.toString());
		
		lista.remove(1);
		
		System.out.println(lista.toString());
		
		
		
		
	
		

	}

}
