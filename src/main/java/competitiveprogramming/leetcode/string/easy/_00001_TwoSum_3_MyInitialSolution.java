package competitiveprogramming.leetcode.string.easy;

public class _00001_TwoSum_3_MyInitialSolution implements _00001_TwoSum_1_Problem {

	// Brute Force Approach : Time Complexity: O(n^2) | Space Complexity: O(1)
	@Override
	public int[] twoSum(int[] nums, int target) {

		int i = 0, j = 0;

		for (i = 0; i < nums.length; i++) {

			for (j = i + 1; j < nums.length; j++) {

				if (nums[i] + nums[j] == target)
					return new int[] { i, j };

			}

		}

		// An anonymous array is an array that is created and initialized in the same line.
		return new int[] { i, j };
	}

}