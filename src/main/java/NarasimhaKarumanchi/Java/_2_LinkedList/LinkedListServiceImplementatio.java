/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */
public class LinkedListServiceImplementatio implements LinkedListService {
	private int length;
	ListNode head;

	LinkedListServiceImplementatio(){
		length = 0;
	}

	@Override
	public int getLengthOfLinkedList() {
		return length;
	}

	@Override
	public synchronized void insertAtEnd(int data) {
		
		ListNode node = new ListNode(data);
		
		if(head == null)
			head = node;
		else {
			ListNode p,q;
			for(p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length++;
	}
	
	@Override
	public void insertAtBegining(int data) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void insertAtPosition(int data, int position) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void removeFromEnd(int data) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void removeFromBegining(int data) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void removeFromPosition(int data, int position) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void getNodeAtPosition(int data) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void getPositionOfNode(int data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayLinkedList() {
		if(head == null)
			System.out.println("[ ]");
		else {
			System.out.print(head.getData()+"-->");
			ListNode temp = head.getNext();
			while(temp != null) {
				if(temp.getNext() != null)
					System.out.print(temp.getData()+"-->");
				else
					System.out.print(temp.getData());
				temp = temp.getNext();
			}
		}
	}
	
	@Override
	public String toString() {
		String result = "[";
		
		if(head == null)
			return result + "]";
		else {
			result = result + head.getData();
			ListNode temp = head.getNext();
			while(temp != null) {
				result = result + "," + temp.getData();
				temp = temp.getNext();
			}
			return result + "]";
		}
	}
}
