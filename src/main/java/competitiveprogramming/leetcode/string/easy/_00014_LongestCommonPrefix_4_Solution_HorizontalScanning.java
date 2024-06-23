package competitiveprogramming.leetcode.string.easy;

public class _00014_LongestCommonPrefix_4_Solution_HorizontalScanning implements _00014_LongestCommonPrefix_1_Problem {

/** Horizontal Scanning : Time Complexity: O(s) | Space Complexity: O(1)
	Time complexity : O(S), where S is the sum of all characters in all strings */
	@Override
	public String longestCommonPrefix(String[] strs) {

		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + " ==========");
		
		if (strs.length == 0)
			return "";

		if (strs.length == 1)
			return strs[0];
		
		String prefix = strs[0];
		
		for (int i = 1; i < strs.length; i++) {
			
			while (strs[i].indexOf(prefix) != 0) {

				prefix = prefix.substring(0, prefix.length() - 1);
				
				if (prefix.isBlank())
					return "";
			}
			
		}

		return prefix;
	}

}
