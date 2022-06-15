
public class Element {
	
	private String ment;
	private Element next;
	
	public Element (String ment) {
		this.ment=ment;
		this.setNext(null);
	}
	
	public String toString() {
		return ment;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}
	
	public void setMent(String ment) {
		this.ment = ment;
	}
	
	public String getMent() {
		return ment;
	}
	
}
