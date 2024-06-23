package competitiveprogramming.leetcode.string.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 * 
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Constraints:
 * 	• 1 <= strs.length <= 200
 * 	• 0 <= strs[i].length <= 200
 * 	• strs[i] consists of only lowercase English letters.
 * 
 */
public interface _14_LongestCommonPrefix_1_Problem {

	/**
     * @param strs Array of strings.
     * @return Longest common prefix
     */
	public String longestCommonPrefix(String[] strs);
    
}