package competitiveprogramming.leetcode.string.medium;

import java.util.Arrays;

//public class TestMainDriverClass {public static void main(String[] args) {}}

/**_____________________________________________________________________________________________________*/
/**
https://leetcode.com/problems/longest-palindromic-substring/description/

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.


Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

*/
/**_____________________________________________________________________________________________________*/

@FunctionalInterface
interface _00005_LongestPalindromicSubstring_Problem {
	String longestPalindrome(String s);
}

public class _00005_LongestPalindromicSubstring_$ {
	
	
	public void testSortBinaryArray(_00005_LongestPalindromicSubstring_Problem solution, String solutionNumber) {
		
		System.out.println();
		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + ": " + solutionNumber + " ==========");
		System.out.println();
		
		System.out.println(solution.longestPalindrome(null));
		System.out.println(solution.longestPalindrome(""));
		System.out.println(solution.longestPalindrome("a"));
		System.out.println(solution.longestPalindrome("ab"));
		System.out.println(solution.longestPalindrome("aba"));
		
		System.out.println(solution.longestPalindrome("babad"));
		System.out.println(solution.longestPalindrome("cbbd"));
		
		System.out.println(solution.longestPalindrome("bxysbs"));
		System.out.println(solution.longestPalindrome("bbysbsxbzybz"));

	}
	
	
	public static void main(String[] args) {

		
		_00005_LongestPalindromicSubstring_$ obj = new _00005_LongestPalindromicSubstring_$();

		_00005_LongestPalindromicSubstring_Problem solutionV1 = (s) -> {
			
			System.out.println("________________________________________________________________________________");
			System.out.println("-------------------------------- | Version 1 | --------------------------------");

			if (s == null || s.length() <= 1)
				return s;

			if (isPalindrome(s))
				return s;

			int len = s.length();

			int l = 0;
			int r = len;
			int win = len - 1;

			while (win > 0) { // win > 1 fails for length() = 2
				for (int i = 0; i <= (len - win); i++) {

					String subStr = s.substring(i, win + i);

					System.out.println("len: " + len + ", win: " + win + " i: " + i);

					if (isPalindrome(subStr))
						return subStr;
				}
				win--;
			}
			return "";
		};
		
		obj.testSortBinaryArray(solutionV1, "solutionV1");
		
		

		System.out.println("________________________________________________________________________________");
		System.out.println("-------------------------------- | Version 2 | --------------------------------");
		
		_00005_LongestPalindromicSubstring_Problem solutionV2 = (s) -> {return s;};
		
		obj.testSortBinaryArray(solutionV2, "solutionV2");
	}
	
	
    static Boolean isPalindrome(String s) {

        System.out.println(s);

        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }

        return true;
    }

}