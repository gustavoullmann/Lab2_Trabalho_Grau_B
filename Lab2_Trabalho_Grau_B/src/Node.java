
public class Node {
	private Task tarefa;
	private Node next;

	public Node(Task tarefa) {
		this.tarefa = tarefa;
		next = null;
	}

	public Task getTask() {
		return tarefa; 
	}
	
	public void setTask(Task tarefa) { 
		this.tarefa = tarefa; 
	}

	public Node getNext() { 
		return next;
	}

	public void setNext(Node node) {
		next = node; 
	}
}
