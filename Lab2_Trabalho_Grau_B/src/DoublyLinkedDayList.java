
public class DoublyLinkedDayList implements DayList {
	protected DNode head;
	protected DNode tail;
	protected int numElements;

	public DoublyLinkedDayList() {
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
	
	public void insertFirst(Day dayDate) {
		// cria um novo nó e o torna o novo "head"
		DNode newNode = new DNode(dayDate);
		if (isEmpty())
			head = tail = newNode;
		else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		// ajusta o total de elementos
		numElements++;
	}

	public void insertLast(Day dayDate) {
		// cria um novo nó e o torna o novo "tail"
		DNode newNode = new DNode(dayDate);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		numElements++;
	}	
	
	public void insert(Day dayDate, int pos) {
		// verifica se a posição é válida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
		// casos especiais: inserção no início
		if (pos == 0)
			insertFirst(dayDate);
		else if (pos == numElements) //ou inserção no final
			insertLast(dayDate);
		else { // caso geral: inserção no meio da lista
			// localiza o nó imediatamente anterior à posição
			// onde o novo será inserido
			DNode prev = head;
			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();
			// cria um novo nó e o posiciona logo após "prev",
			// ajustando os apontamentos e o total de elementos
			DNode newNode = new DNode(dayDate);
			newNode.setNext(prev.getNext());
			newNode.setPrevious(prev);
			newNode.getNext().setPrevious(newNode);
			prev.setNext(newNode);
			
			numElements++;
		}
	}

	public Day removeFirst() {
		// verifica se há pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();

		// guarda uma referência temporária ao elemento sendo removido
		Day dayDate= head.getDayDate();

		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else
			// ...senão, o segundo elemento passa a ser o "head"
			head = head.getNext();
		// ajusta o total de elementos e retorna o removido
		numElements--;
		return dayDate;
	}
	
	public Day removeLast() {
		// verifica se há pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();
		// guarda uma referência temporária ao elemento sendo removido
		Day dayDate = tail.getDayDate();
		
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else {
			// senão, é necessário percorrer o encadeamento
			// até chegar ao nó imediatamente anterior ao último
			DNode prev = tail.getPrevious();
	
			tail = prev;
			prev.setNext(null);
		}
		// ajusta o total de elementos e retorna o removido
		numElements--;
		return dayDate;
	}
	
	public Day remove(int pos) {
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
		
		// casos especiais: remoção do início
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements-1) // ou remoção do final
			return removeLast();
		else { // caso geral: remoção do meio da lista
			// localiza o nó imediatamente anterior à posição
			// de onde o elemento será removido
			DNode prev = head;
			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();
			
			// guarda uma ref. temporária ao elemento sendo removido
			Day dayDate = prev.getNext().getDayDate();

			// ajusta o encadeamento "pulando" o nó sendo removido
			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);

			// ajusta o total de elementos e retorna o removido
			numElements--;
			return dayDate;
		}
	}

	public Day get(int pos) {
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		// percorre o encadeamento até chegar ao elemento
		DNode current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();
		
		return current.getDayDate();
	}

	public int search(Day dayDate) {
		// percorre o encadeamento até encontrar o elemento
		DNode current = head;
		int i = 0;
		while (current != null) {
			if (dayDate.equals(current.getDayDate()))
					return i;
			i++;
			current = current.getNext();
		}
		// se chegar até aqui, é porque não encontrou
		return -1;
	}

	public String toString() {
		String s = "";

		DNode current = head;
		while (current != null) {
			s += current.getDayDate().toString() + " ";
			current = current.getNext();
		}
		return s;
	}
}
