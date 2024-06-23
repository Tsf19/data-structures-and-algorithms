package competitiveprogramming.leetcode.string.easy;

import java.util.Arrays;
import java.util.logging.Logger;

public class _00001_TwoSum_2_SolutionDriverClass {

	static Logger logger = Logger.getLogger(_00001_TwoSum_2_SolutionDriverClass.class.getName());
		
	public static void main(String[] args) {
		
		// Brute Force Approach : Time Complexity: O(n^2) | Space Complexity: O(1)
    	testTwoSum(new _00001_TwoSum_3_MyInitialSolution());

		/** A more efficient approach is to use a hash table.*/
		// Using a Hash Table : Time Complexity: O(n) | Space Complexity: O(n)
		testTwoSum(new _00001_TwoSum_4_OtherSolution());

		/** One-pass Hash Table */
		testTwoSum(new _00001_TwoSum_5_OtherSolutionUpdated());
	}

	static void testTwoSum(_00001_TwoSum_1_Problem solution) {
		
		System.out.println("========== Solution: ==========");
		// An anonymous array is an array that is created and initialized in the same line.
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9))); // Output: [0, 1]
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 2, 4 }, 6))); // Output: [1, 2]
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 3 }, 6))); // Output: [0, 1]
		
	}
}