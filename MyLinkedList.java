
public class MyLinkedList {
	
	private Element head;
	private Element last;
	
	public MyLinkedList() {
		head = null;
		last = null;
	}
	
	public boolean isNull() {
		if(head != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addHead(String ment) {
		
		Element newElement = new Element(ment);
		
		if(isNull()) {
			newElement.setNext(head);
			head=newElement;
		}
		else {
			head=newElement;
			last=newElement;
		}
		
	}
	
	public void addIn(String ment, int index) {

		Element newElement = new Element(ment);
		
		if(isNull()) {
			if(index==0) {
				newElement.setNext(head);
				head=newElement;
			}
			else {
				Element temp = head;
				Element temp2 = null;
				int count=0;
				while(temp!=null && index!=count) {
					temp2=temp;
					temp=temp.getNext();
					count++;
				}
				if (temp == null) {
					last.setNext(newElement);
					last = newElement;
				}
				else{
					newElement.setNext(temp);
					temp2.setNext(newElement);
				}
			}
		}
		else {
			head=newElement;
			last=newElement;
		}
	}
	
	public void addLast(String ment) {
		
		Element newElement = new Element(ment);
		
		if(isNull()) {
			last.setNext(newElement);
			last = newElement;
		}
		else {
			head=newElement;
			last=newElement;
		}
	}
	
	public void deleteHead() {

		if(isNull()) {
			if(head==last) {
				head=null;
				last=null;
			}
			else {
				Element newHead = head.getNext();
				head.setNext(null);
				head = newHead;
			}
			
		}
		else {
		}
	}
	
	public void deleteIn(int index) {
		if(isNull()){
			if(head==last) {
				head=null;
				last=null;
			}
			else if(index==0){
				Element newHead = head.getNext();
				head.setNext(null);
				head = newHead;
			}
			else {
				Element temp = head;
				Element temp2 = null;
				int count=0;
				
				while(count!=index && temp!=null) {
					temp2=temp;
					temp=temp.getNext();
					count++;
				}
				if(temp!= null) {
					if(temp==last) {
						last=temp2;
						temp2.setNext(null);
					}
					else {
						Element temp3=temp.getNext();
						temp.setNext(null);
						temp2.setNext(temp3);
					}
				}
			}
		}
		else {
		}
	}
	
	public void deleteLast() {
		if(isNull()) {
			if(head==last) {
				head=null;
				last=null;
			}
			else {
				Element temp = head;
				while(temp.getNext()!= last) {
					temp=temp.getNext();
				}
				temp.setNext(null);
				last=temp;
			}
		}
		else {
		}
	}
	
	public void printList() {		
		Element temp = head;
		
		while(temp!=null) {
			System.out.println(temp.getMent());
			temp=temp.getNext();
		}
	}
	
	
}





























