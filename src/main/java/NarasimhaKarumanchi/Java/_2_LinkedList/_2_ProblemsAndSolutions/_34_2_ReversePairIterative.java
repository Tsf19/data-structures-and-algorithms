package NarasimhaKarumanchi.Java._2_LinkedList._2_ProblemsAndSolutions;

import java.util.LinkedList;
import java.util.List;

import NarasimhaKarumanchi.Java._2_LinkedList.LinkedListService;
import NarasimhaKarumanchi.Java._2_LinkedList.LinkedListServiceImplementation;
import NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions.ListNode;

/**
 * @author md.tousif
 *
 */
public class _34_2_ReversePairIterative {

	/**
	 * Reverse the linked list in pairs.
	 * If you have a linked list that holds
	 * 1 → 2 → 3 → 4 → X, then
	 * after the function has been called the linked list would hold
	 * 2 → 1 → 4 → 3 → X
	 */

	
	private static LinkedList reversePairIterative(ListNode<Integer> head) {
		
		ListNode<Integer> temp1 = null;
		ListNode<Integer> temp2 = null;
		
		while (head != null && head.getNext() != null) {
			
			temp1 = head.getNext();
			temp2 = head;
			
			head = temp1;
			head.setNext(temp2);
			
			head = head.getNext().getNext();
			
		}
		
		System.out.println();
		return null;
	}
	
	public static void main(String[] args) {
		
		ListNode<Integer> head = new ListNode<>(10);
		ListNode<Integer> node1 = new ListNode<>(20);
		ListNode<Integer> node2 = new ListNode<>(30);
		ListNode<Integer> node3 = new ListNode<>(40);
		ListNode<Integer> node4 = new ListNode<>(50);
		ListNode<Integer> node5 = new ListNode<>(60);
		ListNode<Integer> node6 = new ListNode<>(70);
		
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		
		System.out.println(head.toString());
		
		reversePairIterative(head);
		
	}

}
