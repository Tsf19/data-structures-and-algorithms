package competitiveprogramming.leetcode.string.medium;

/**_____________________________________________________________________________________________________*/
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * 
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * 
 */
@FunctionalInterface
interface LongestNonRepeatingSubStringProblem {

	public int lengthOfLongestSubstring(String inputString);
}

/**********************************************************************/

public class _00003_LongestNonRepeatingSubString {


	public void testLengthOfLongestSubstring(LongestNonRepeatingSubStringProblem solution, String solutionNumber) {
		
		System.out.println();
		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + ": " + solutionNumber + " ==========");
		System.out.println();
		
		
		System.out.println(solution.lengthOfLongestSubstring(null)); // 0
		System.out.println(solution.lengthOfLongestSubstring("")); // 0
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3 - abc
		System.out.println(solution.lengthOfLongestSubstring("bbbbb")); // 1 - b
		System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // 3 - wke
		System.out.println(solution.lengthOfLongestSubstring("aabcpqrstdbca")); // 9 - abcpqrstd
	}
	
	public static void main(String[] args) {

		_00003_LongestNonRepeatingSubString object = new _00003_LongestNonRepeatingSubString();
		
		/**_____________________________________________________________________________________________________*/
		LongestNonRepeatingSubStringProblem solution;
		
		solution = inputString -> 0;
		
		object.testLengthOfLongestSubstring(solution, "1. bruteForceSolution");

		
		/**_____________________________________________________________________________________________________*/
		
		solution = inputString -> {

			System.out.println("input: " + inputString);
			
			if (inputString == null || inputString.length() == 0)
				return 0;

			if (inputString.length() == 1)
				return 1;

			int max = 1;
			String subStr = "";
			int n = inputString.length();

			for (int i = 0; i < n; i++) {

				subStr = subStr + inputString.charAt(i);

				int subStrLength = subStr.length();
				max = subStrLength > max ? subStrLength : max;

				if (i + 1 < n) {

					int indexOfNextChar = subStr.indexOf(inputString.charAt(i + 1));

					if (indexOfNextChar != -1) {
						System.out.print("subStr: " + subStr + " -> ");
						subStr = subStr.substring(indexOfNextChar + 1, subStrLength);
						System.out.println(subStr);
					}
				}

			}

			return max;
		};
		
		object.testLengthOfLongestSubstring(solution, "2. solution");
		
	}
}