/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */
public interface LinkedListService {

	ListNode getHead();
	
	void setHead(ListNode head);
	
	int getLengthOfLinkedList();
	
	void insertAtEnd(int data);
	
	void insertAtBegining(int data);

	void insertAtPosition(int data, int position);
	
	void removeFromEnd();
	
	void removeFromBegining();

	void removeFromPosition_V1(int position);
	
	void removeFromPosition_V2(int position);
	
	void getNodeAtPosition(int data);
	
	void getFrquencyOfNode(int data);
	
	void displayLinkedList();

	ListNode reverseIterative();

	ListNode reverseTailRecursive(ListNode current, ListNode previous);

	ListNode reverseNonTailRecursive(ListNode node);

}
