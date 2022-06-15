
public class Queue {
	
	MyLinkedList my = new MyLinkedList();
	
	private Element head;
	
	public Queue() {
		head = null;
	}
	
	public void pushItem(String ment) {
		my.addLast(ment);
		
	}
	
	public String popItem() {
		String item = head.getMent();
		my.deleteHead();
		return item;
	}
	
	public void printList() {		
		Element temp = head;
		
		while(temp!=null) {
			System.out.println(temp.getMent());
			temp=temp.getNext();
		}
	}
	
	public boolean isNull() {
		if(head != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
