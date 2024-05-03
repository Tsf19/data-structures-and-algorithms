/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */
public class LinkedListServiceImplementation implements LinkedListService {

	// Instance variable: to access instance members, you need an instance of the class
	// Private: It specifies that the head variable is accessible only within
	private ListNode head;

	private int length = 0;
	
	@Override
	public synchronized ListNode getHead() {
		return head;
	}

	@Override
	public void setHead(ListNode head) {
		this.head = head;
		length = getLengthOfLinkedList();
	}

	/**
	 * Time Complexity: O(n), for scanning the list of size n.
	 * Space Complexity: O(1), for creating a temporary variable.
	 */
	@Override
	public synchronized int getLengthOfLinkedList() {

		int length = 0;

		if (head == null)
			return length;

		for (ListNode p = head; p != null; p = p.getNext(), ++length);
		
		return length;
	}

	
	@Override
	public synchronized void insertAtEnd(int data) {

		/** 
		 In order to insert a node at the last, there are two following scenarios:
			1. The node is being added to an empty list
			2. The node is being added to the end of the linked list
			
			Time Complexity: O(N) where N is the length of the linked list
			Space Complexity: O(1)
		 */

		ListNode newNode = new ListNode(data);

		if(head == null) {
			head = newNode;
			length ++;
			return;
		}
		
		ListNode lastNode;
		for(lastNode = head; lastNode.getNext() != null; lastNode = lastNode.getNext());

		//OR
//		ListNode lastNode = head;
//		while (lastNode.getNext() != null) {
//			lastNode = lastNode.getNext();
//		}
		
		lastNode.setNext(newNode);
		
		length ++;
	}

	@Override
	public void insertAtBegining(int data) {

		/** 
		 To insert a node at the start/beginning/front of a Linked List, we need to:
			1. Make the first node of Linked List linked to the new node
			2. If the position is 0, insert the new node at the beginning of the list by updating the head reference
			3. Traverse the list to find the node at the position just before the insertion point
			4. Insert the new node between the current node and the next node
			
			Time Complexity: O(1)
			Space Complexity: O(1)
		 */
		
		ListNode newNode = new ListNode(data);
		newNode.setNext(head);
		head = newNode;
		
		length ++;
	}

	@Override
	public void insertAtPosition(int data, int position) {

		// Add a new value to the list at a given position.
		// All values at that position to the end move over to make room.
		
		/** 
		 To insert a node at the specified position in a Linked List, we need to:
			1. Create a new ListNode containing the given data
			2. Traverse the list to find the previous node at the specified position
			3. Insert the new node between the current node and the next node
			
			Time Complexity: O(n)
			Space Complexity: O(1)
		 */
		
		// If position is < 0, insert newNode at the beginning of the list
		if(position < 0 ) {
			position = 0;
		}
		
		// If position is > LengthOfLinkedList , insert newNode at the end of the list
		if (position > getLengthOfLinkedList()) {
			position = getLengthOfLinkedList();
		}
		
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			head = newNode;
			length ++;
			return;
		}
		
		// If position is 0, insert newNode at the beginning of the list
		if(position == 0) {
			newNode.setNext(head);
			head = newNode;
			length ++;
			return;
		}
		
		// Traverse the list to find the node at the position just before the insertion point
		ListNode current = head;
		
		//https://www.geeksforgeeks.org/loop-optimization-in-compiler-design/
//		for (int i = 0; i < position - 1; i++)
		for (int i = 1; i < position; i++) // loop-invariant code motion AKA loop optimization
			current = current.getNext();
		
		/**
		// OR, Without calling getLengthOfLinkedList(), use 'current != null'
	    for (int i = 0; i < position - 1 && current != null; i++)
	        current = current.getNext();
		
	    // If current is null, the position is out of bounds
	    if (current == null) {
	        System.out.println("Invalid position");
	        return;
	    }
		*/
		
		// Insert newNode between current and current.getNext()
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		
		length ++;
		return;
	}

	@Override
	public void removeFromEnd() {

		if (head == null)
			return;

		if (head.getNext() == null) {
			head.setNext(null);
			length --;
			return;
		}

		ListNode current, previous = null;
		for (current = head; current.getNext() != null; previous = current, current = current.getNext());

		/**OR
		for (previous = head; previous.getNext().getNext() != null; previous = previous.getNext());
		*/

		// If we don't 'previous = null;' we get 'The local variable previous may not have been initialized'
		previous.setNext(null);
		
		
		length --;
	}

	@Override
	public void removeFromBegining() {

		if(head == null)
			return;
		
		ListNode temp = head;
		head = head.getNext();
		temp.setNext(null);
		
		length --;
		return;
	}

	
	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	@Override
	public void removeFromPosition_V1(int position) {

		if (head == null)
			return;

		if (head.getNext() == null) {
			head.setNext(null);
			length --;
			return;
		}

		if (position <= 0) {
			ListNode temp = head;
			head = head.getNext();
			temp.setNext(null);
			length --;
			return;
		}

		if (position >= getLengthOfLinkedList())
			position = getLengthOfLinkedList() - 1;

		ListNode current = head, previous = null;

		/**for (int i = 0; i < position; i++) {
			previous = current;
			current = current.getNext();
		} */
		for (int i = 0; i < position ; i++, previous = current, current = current.getNext());

		previous.setNext(current.getNext());
		current.setNext(null);
		
		length --;
	}

	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	@Override
	public void removeFromPosition_V2(int position) {

		if (head == null)
			return;

		if (head.getNext() == null) {
			head.setNext(null);
			length --;
			return;
		}

		if (position <= 0) {
			ListNode temp = head;
			head = head.getNext();
			temp.setNext(null);
			length --;
			return;
		}

		if (position >= getLengthOfLinkedList())
			position = getLengthOfLinkedList() - 1;

		ListNode current = head, temp = null;		
		for (int i = 1; i < position; i++, current = current.getNext());
		
		temp = current.getNext();
		current.setNext(current.getNext().getNext());
		
		temp.setNext(null);
		
		length --;
	}
	
	@Override
	public void getNodeAtPosition(int data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void getFrquencyOfNode(int data) {
		// TODO Auto-generated method stub
	}

	@Override
	public ListNode reverseIterative() {
		
		/** 
		 To reverse a Linked List, we need to:
			1. Initialize three pointers: prev, current, and next
			2. Start from the head node. Set prev to null, current to head, and next to null
			3. In each iteration, reverse the link of the current node to point to the prev node instead of the next node
			4. Move prev, current, and next pointers to the next nodes
			5. Repeat steps 3-4 until reaching the end of the list
			6. Update the head pointer to point to the last node (which is now the first node in the reversed list)
			
			Time Complexity: O(n)
			Space Complexity: O(1)
		 */
		
		if (head == null || head.getNext() == null)
			return head;
		
		ListNode current = head, previous = null, next = null;		
		
		while (current != null) {
			next = current.getNext(); // Store the next node
			current.setNext(previous); // Reverse the link
			previous = current; // Move previous to current node
			current = next; // Move current to next node
		}
		
		head = previous; // Update the head to the last node (previous)
		
		return head;
	}

	@Override
	public ListNode reverseTailRecursive(ListNode current, ListNode previous) {

		/** 
		 To reverse a Linked List, we need to:
			1. Initializes the process by calling method with the head node and null as parameters.
			2. In each recursive call, it takes two parameters:
			 - current (the current node being processed)
			 - previous (the previous node in the reversed list)
			3. At each step, it reverses the link of the current node to point to the previous node instead of the next node.
			4. Then, it makes a recursive call to process the next node with updated pointers.
			5. The recursion continues until the current node becomes null, indicating the end of the original list.
			6. Finally, it returns the previous node, which becomes the new head of the reversed list.
			
			Time Complexity: O(n)
			Space Complexity: O(n)
		 */

		
		//If last node, mark it as head
		if (current == null) {
			head = previous;
			return head;
		}
		
		
		//Save current.next node for recursive call
		ListNode next = current.getNext();

		//Reverse the link
		current.setNext(previous);
		
		
		//Now current will be next and current will be previous
		//reverseTailRecursive(ListNode current, ListNode previous)
		return reverseTailRecursive(next, current);
		
//		return head;
	}

	
	@Override
	public ListNode reverseNonTailRecursive(ListNode current) {
		
		/**
		 * In this function, we recursively visit each element in the linked list until we reach the last one.
		 * This last element will become the new head of the reversed linked list.
		 * Also, we append the visited element to the end of the partially reversed linked list
		 * 		
		 * The idea is to reach the last node of the linked list using recursion then start reversing the linked list.
		 * To reverse a Linked List, we need to:
		 * 1. Divide the list in two parts – first node and rest of the linked list
		 * 2. Call reverse for the rest of the linked list
		 * 3. Link the rest linked list to first
		 * 4. Fix head pointer to NULL
		 * 
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 * 
		 */

		if (current == null || current.getNext() == null) {
			head = current;
			return current;
		}
	
		//Recursively reverse the remaining list
		//reverse the rest list and put the first element at the end
		ListNode rest = reverseNonTailRecursive(current.getNext());
		
		//Reverse the direction of the current node
		current.getNext().setNext(current);

		/* tricky step -- see the diagram */
		current.setNext(null);

		/* Return the new head of the reversed list */
		return rest;

	}
	
	@Override
	public void displayLinkedList() {
		if(head == null) {
			System.out.print("[" + length + "]: " + "[ ]");
			System.out.println();
		}
		else {
			System.out.print("[" + length + "]: " + head.getData()+"-->");
			ListNode temp = head.getNext();
			while(temp != null) {
				if(temp.getNext() != null)
					System.out.print(temp.getData()+"-->");
				else
					System.out.print(temp.getData());
				temp = temp.getNext();
			}
			System.out.println();
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
