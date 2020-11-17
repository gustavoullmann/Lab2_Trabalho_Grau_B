
public interface TaskList {
	public int numElements();
	public boolean isEmpty();
	public boolean isFull();
	public void insert(Task tarefa, int pos);
	public Task remove(int pos);
	public Task get(int pos);
	public int search(Task tarefa);
}
