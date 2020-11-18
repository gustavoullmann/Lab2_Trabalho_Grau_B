
public class DoublyLinkedList<E> implements List<E> {
	protected DNode<E> head;
	protected DNode<E> tail;
	protected int numElements;

	public DoublyLinkedList() {
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
	
	public void insertFirst(E element) {
		// cria um novo nó e o torna o novo "head"
		DNode<E> newNode = new DNode<E>(element);
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

	public void insertLast(E element) {
		// cria um novo nó e o torna o novo "tail"
		DNode<E> newNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
		}
		numElements++;
	}	
	
	public void insert(E element, int pos) {
		// verifica se a posição é válida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
		// casos especiais: inserção no início
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements) //ou inserção no final
			insertLast(element);
		else { // caso geral: inserção no meio da lista
			// localiza o nó imediatamente anterior à posição
			// onde o novo será inserido
			DNode<E> prev = head;
			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();
			// cria um novo nó e o posiciona logo após "prev",
			// ajustando os apontamentos e o total de elementos
			DNode<E> newNode = new DNode<E>(element);
			newNode.setNext(prev.getNext());
			newNode.setPrevious(prev);
			newNode.getNext().setPrevious(newNode);
			prev.setNext(newNode);
			
			numElements++;
		}
	}

	public E removeFirst() {
		// verifica se há pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();

		// guarda uma referência temporária ao elemento sendo removido
		E element = head.getElement();

		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else
			// ...senão, o segundo elemento passa a ser o "head"
			head = head.getNext();
		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}
	
	public E removeLast() {
		// verifica se há pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException();
		// guarda uma referência temporária ao elemento sendo removido
		E element = tail.getElement();
		
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else {
			// senão, é necessário percorrer o encadeamento
			// até chegar ao nó imediatamente anterior ao último
			DNode<E> prev = tail.getPrevious();
	
			tail = prev;
			prev.setNext(null);
		}
		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}
	
	public E remove(int pos) {
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
			DNode<E> prev = head;
			for (int i = 0; i < pos - 1; i++)
				prev = prev.getNext();
			
			// guarda uma ref. temporária ao elemento sendo removido
			E element = prev.getNext().getElement();

			// ajusta o encadeamento "pulando" o nó sendo removido
			prev.setNext(prev.getNext().getNext());
			prev.getNext().setPrevious(prev);

			// ajusta o total de elementos e retorna o removido
			numElements--;
			return element;
		}
	}

	public E get(int pos) {
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		// percorre o encadeamento até chegar ao elemento
		DNode<E> current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();
		
		return current.getElement();
	}

	public int search(E element) {
		// percorre o encadeamento até encontrar o elemento
		DNode<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
					return i;
			i++;
			current = current.getNext();
		}
		// se chegar até aqui, é porque não encontrou
		return -1;
	}

	public String toString() {
		String s = "";

		DNode<E> current = head;
		while (current != null) {
			s += current.getElement().toString() + " ";
			current = current.getNext();
		}
		return s;
	}
}
