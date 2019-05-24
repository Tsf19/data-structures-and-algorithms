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

		LinkedListService list = new LinkedListServiceImplementatio();

		list.insertAtEnd(10);
		
		list.insertAtEnd(20);
		
		list.insertAtEnd(30);
		
		list.insertAtBegining(40);
		
		list.getLengthOfLinkedList();
		System.out.println(list);
		list.displayLinkedList();
	}

}
