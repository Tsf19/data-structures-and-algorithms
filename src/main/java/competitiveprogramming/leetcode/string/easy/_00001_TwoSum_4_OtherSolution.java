package competitiveprogramming.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

public class _00001_TwoSum_4_OtherSolution implements _00001_TwoSum_1_Problem {

	/**
	 * A more efficient approach is to use a hash table.
	 * We can iterate through the array once, and for each element, check if the
	 * target minus the current element exists in the hash table.
	 * If it does, we have found a valid pair of numbers.
	 * If not, we add the current element to the hash table.
	 * 
	 * Approach using a hash table: (Two-pass Hash Table)
	 * 1. Create an empty hash table to store elements and their indices.
	 * 2. Iterate through the array from left to right.
	 * 3. For each element nums[i], calculate the complement by subtracting it from the target: complement = target - nums[i].
	 * 4. Check if the complement exists in the hash table. If it does, we have found a solution.
	 * 5. If the complement does not exist in the hash table, add the current element nums[i] to the hash table with its index as the value.
	 * 6. Repeat steps 3-5 until we find a solution or reach the end of the array.
	 * 7. If no solution is found, return an empty array or an appropriate indicator.
	 * 
	 */
	
	// Using a Hash Table : Time Complexity: O(n) | Space Complexity: O(n)
	@Override
	public int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> valueMapIndex = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++)
			valueMapIndex.put(nums[i], i);

		for (int i = 0; i < nums.length; i++) {
			
			int complement = target - nums[i];
			
//			if(valueMapIndex.get(complement) != null) X
//			valueMapIndex.get(complement) != i // ignoring same index
			if (valueMapIndex.containsKey(complement) && valueMapIndex.get(complement) != i)
				return new int[] {i, valueMapIndex.get(complement)};		
			
		}

		return new int[]{}; // No solution found
	}


}