
public interface DayList {
	public int numElements();
	public boolean isEmpty();
	public boolean isFull();
	public void insert(Day dayDate, int pos);
	public Day remove(int pos);
	public Day get(int pos);
	public int search(Day dayDate);
}
