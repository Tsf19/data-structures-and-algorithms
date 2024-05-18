package competitiveprogramming.leetcode.string.easy;

import java.util.Arrays;
import java.util.logging.Logger;

public class _1_TwoSum_2_SolutionDriverClass {

	static Logger logger = Logger.getLogger(_1_TwoSum_2_SolutionDriverClass.class.getName());
		
	public static void main(String[] args) {
		
		_1_TwoSum_1_Problem solution;
		
		
		int target = 9;
		int[] nums = new int[] { 2, 7, 11, 15 };
		
		// An anonymous array is an array that is created and initialized in the same line.
		
		// Brute Force Approach : Time Complexity: O(n^2) | Space Complexity: O(1)
		solution = new _1_TwoSum_3_MyInitialSolution();
    	System.out.println("========== Solution: ==========");
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9))); // Output: [0, 1]
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 2, 4 }, 6))); // Output: [1, 2]
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 3}, 6))); // Output: [0, 1]

		
		/** A more efficient approach is to use a hash table.*/
		// Using a Hash Table : Time Complexity: O(n) | Space Complexity: O(n)
		solution = new _1_TwoSum_4_OtherSolution();
		System.out.println("========== Solution: ==========");
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9))); // Output: [0, 1]
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 2, 4 }, 6))); // Output: [1, 2]
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 3}, 6))); // Output: [0, 1]

//		solution = new _1_TwoSum_5_BestSolution();
//		System.out.println("========== Solution: ==========");
//		System.out.println(Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9))); // Output: [0, 1]
//		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 2, 4 }, 6))); // Output: [1, 2]
//		System.out.println(Arrays.toString(solution.twoSum(new int[] { 3, 3}, 6))); // Output: [0, 1]
	}

}