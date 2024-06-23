package competitiveprogramming.leetcode.string.easy;

import java.util.logging.Logger;

public class _00014_LongestCommonPrefix_2_SolutionDriverClass {

	static Logger logger = Logger.getLogger(_00014_LongestCommonPrefix_2_SolutionDriverClass.class.getName());
		
	public static void main(String[] args) {
		
    	testLongestCommonPrefix(new _00014_LongestCommonPrefix_3_MyInitialSolution());
    	testLongestCommonPrefix(new _00014_LongestCommonPrefix_4_Solution_HorizontalScanning());

	}
	
	static void testLongestCommonPrefix(_00014_LongestCommonPrefix_1_Problem solution) {
		
		// An anonymous array is an array that is created and initialized in the same line.
		System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" })); // Output: "fl"
		System.out.println(solution.longestCommonPrefix(new String[] { "dog", "racecar", "car" })); // Output: ""
		
		System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flower", "flower" })); // Output: "fl"
	
		
	}
}