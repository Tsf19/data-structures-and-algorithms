/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */

public class LinkedListApp {
	
	public static void main(String[] args) {

		LinkedListService list = new LinkedListServiceImplementation();
		list.insertAtEnd(9);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.insertAtEnd(50);
		list.insertAtEnd(60);

		list.displayLinkedList();

		//0 based indexing
		list.insertAtPosition(40, 3);
		list.displayLinkedList();
		
		list.insertAtPosition(10, 1);
		list.displayLinkedList();
		
		list.insertAtPosition(8, 0);
		list.displayLinkedList();
		
		list.insertAtBegining(7);
		list.insertAtBegining(6);
		
		list.displayLinkedList();

		list.insertAtPosition(5, 0);
		list.insertAtBegining(4);
		
		list.displayLinkedList();
		
		list.removeFromBegining();

		list.displayLinkedList();
		
		list.removeFromEnd();
		
		list.displayLinkedList();
		
		list.removeFromEnd();
		list.displayLinkedList();

		list.removeFromPosition_V1(1);
		list.displayLinkedList();
		
		list.removeFromPosition_V1(0);
		list.displayLinkedList();
		
		list.removeFromPosition_V1(6);
		list.displayLinkedList();
		
		list.removeFromPosition_V2(1);
		list.displayLinkedList();
		
		list.removeFromPosition_V2(0);
		list.displayLinkedList();
		
		list.removeFromPosition_V2(4);
		list.displayLinkedList();
		
		System.out.println(list);
		
		System.out.println("LengthOfLinkedList : "+list.getLengthOfLinkedList());
	}

}
