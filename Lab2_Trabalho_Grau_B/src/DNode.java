
public class DNode {
	private Day dayDate;
	private DNode next;
	private DNode previous;
	
	public DNode(Day dayDate) {
		this.dayDate = dayDate;
		this.next = null;
		this.previous = null;
	}
	
	public DNode(Day dayDate, DNode next, DNode previous) {
		super();
		this.dayDate = dayDate;
		this.next = next;
		this.previous = previous;
	}
	
	public Day getDayDate() {
		return dayDate; 
	}
	
	public void setDayDate(Day dayDate) { 
		this.dayDate = dayDate; 
	}
	
	public DNode getNext() { 
		return next;
	}
	
	public void setNext(DNode next) {
		this.next = next; 
	}
	
	public DNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(DNode previous) {
		this.previous = previous;
	}	
}
