package competitiveprogramming.leetcode.string.easy;

import java.util.logging.Logger;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * 2. Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * Constraints:
 * 	• The number of nodes in each linked list is in the range [1, 100].
 * 	• 0 <= Node.val <= 9
 * 	• It is guaranteed that the list represents a number that does not have leading zeros.
 * 
 */
interface _2_AddTwoNumbers_1_Problem {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2);
    
}

/** Definition for singly-linked list. */
class ListNode {
	
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}


class _2_AddTwoNumbers_2_SolutionDriverClass {

	static Logger logger = Logger.getLogger(_2_AddTwoNumbers_2_SolutionDriverClass.class.getName());
		
	public static void main(String[] args) {
		
    	testAddTwoNumbers(new _2_AddTwoNumbers_3_MyInitialSolution());

	}
	
	static void testAddTwoNumbers(_2_AddTwoNumbers_1_Problem solution) {

		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();
		
		System.out.println(solution.addTwoNumbers(l1, l2)); // Output:
		System.out.println(solution.addTwoNumbers(l1, l2)); // Output:
		System.out.println(solution.addTwoNumbers(l1, l2)); // Output:
	
		
	}
}


class _2_AddTwoNumbers_3_MyInitialSolution implements _2_AddTwoNumbers_1_Problem {

	@Override
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + " ==========");

		int carry = 0;
		ListNode resultHead = new ListNode();
		ListNode r = resultHead;

		while (r != null) {

			int c1 = 0;
			int c2 = 0;

			if (l1 != null) {
				c1 = l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				c2 = l2.val;
				l2 = l2.next;
			}

			int sum = c1 + c2 + carry;

			int val = sum % 10;
			carry = sum / 10;

			r.val = val;

			if (l1 != null || l2 != null || carry != 0)
				r.next = new ListNode();

			r = r.next;
		}

		return resultHead;
	}

}