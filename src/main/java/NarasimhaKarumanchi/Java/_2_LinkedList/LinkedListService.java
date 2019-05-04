/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */
public interface LinkedListService {

	int getLengthOfLinkedList();
	
	void insertAtEnd(int data);
	
	void insertAtBegining(int data);

	void insertAtPosition(int data, int position);
	
	void removeFromEnd(int data);
	
	void removeFromBegining(int data);

	void removeFromPosition(int data, int position);
	
	void getNodeAtPosition(int data);
	
	void getPositionOfNode(int data);
	
	void displayLinkedList();


}
