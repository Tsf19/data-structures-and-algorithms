package competitiveprogramming.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

public class _00001_TwoSum_5_OtherSolutionUpdated implements _00001_TwoSum_1_Problem {

	/** One-pass Hash Table */
	@Override
	public int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> valueMapIndex = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			
			int complement = target - nums[i];
			
//			if (valueMapIndex.containsKey(complement) && valueMapIndex.get(complement) != i)
			if (valueMapIndex.containsKey(complement))
//				return new int[] {i, valueMapIndex.get(complement)};		
				return new int[] {valueMapIndex.get(complement), i};		
			
			valueMapIndex.put(nums[i], i);
		}

		return new int[]{}; // No solution found
	}
	
}