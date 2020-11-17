public class SinglyLinkedTaskList implements TaskList {
	Node head;
	Node tail;
	int numElements;

	public SinglyLinkedTaskList() {
		head = tail = null;
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return false;
	}
	
	public void insertFirst(Task tarefa) {
		Node newNode = new Node(tarefa);
		
		if(isEmpty()) {
			head = tail = newNode;
		} 
		else {
			newNode.setNext(head);
			head = newNode;
		}
		numElements++;
	}
		
	public void insertLast(Task tarefa) {
		Node newNode = new Node(tarefa);
		
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		numElements++;
	}

	public void insert(Task tarefa, int pos) {
		if(pos < 0  ||  pos > numElements) {
			throw new IndexOutOfBoundsException();
		}
		if(pos == 0) {
			insertFirst(tarefa);
		}
		else if(pos == numElements) {
			insertLast(tarefa);
		}
		else {
			Node previous = head;
			for(int i = 0; i < pos - 1; i++) {
				previous = previous.getNext();
			}
			Node newNode = new Node(tarefa);
			newNode.setNext(previous.getNext());
			previous.setNext(newNode);
			numElements++;
		}
	}

	public Task removeFirst() {
		if(isEmpty()) {
			throw new UnderflowException();
		}
		Task tarefa = head.getTask();
		if(head == tail) {
			head = tail = null;
		}			
		else {
			head = head.getNext();
		}
		numElements--;
		return tarefa;
	}
	
	public Task removeLast() {
		if(isEmpty()) {
			throw new UnderflowException();
		}
		Task tarefa = tail.getTask();
		if(head == tail) {
			head = tail = null;
		}
		else {
			Node previous = head;
			while (previous.getNext() != tail)
			tail = previous;
			previous.setNext(null);
		}
		numElements--;
		return tarefa;
	}

	public Task remove(int pos) {
		if(pos < 0  ||  pos >= numElements) {
			throw new IndexOutOfBoundsException();
		}
		if(pos == 0) {
			return removeFirst();
		}
		else if(pos == numElements-1) {
			return removeLast();
		}
		else {
			Node previous = head;
			for(int i = 0; i < pos - 1; i++) {
				previous = previous.getNext();
			}
			Task tarefa = previous.getNext().getTask();
			previous.setNext(previous.getNext().getNext());
			numElements--;
			return tarefa;
		}
	}

	public Task get(int pos) {
		if(pos < 0  ||  pos >= numElements) {
			throw new IndexOutOfBoundsException();
		}
		Node current = head;
		for(int i = 0; i < pos; i++) {
			current = current.getNext();
		}
		return current.getTask();
	}
	
	public int search(Task tarefa) {
		Node current = head;
		int i = 0;
		while(current != null) {
			if(tarefa.equals(current.getTask())) {
				return i;
			}
			i++;
			current = current.getNext();
		}
		return -1;
	}

	public String toString() {
		String s = "";

		Node current = head;
		while (current != null) {
			s += current.getTask().toString() + "\n\n";
			current = current.getNext();
		}
		return s;
	}
}