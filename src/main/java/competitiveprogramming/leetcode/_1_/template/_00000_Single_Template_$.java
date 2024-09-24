package competitiveprogramming.leetcode._1_.template;

//public class TestMainDriverClass {public static void main(String[] args) {}}

/**_____________________________________________________________________________________________________*/
/**

https://leetcode.com/problems/ <?> /description/

0. <?>


Description... Given an ... , return ... such that ...

Example 1:
Input:
Output:
Explanation:

Example 2:
Input:
Output:
Explanation:


Constraints:
• 2 <= nums.length <= 104
• -109 <= nums[i] <= 109
• -109 <= target <= 109

*/


/**_____________________________________________________________________________________________________*/

@FunctionalInterface
interface _00000_Single_Template_Problem {
	
	public Object template(Object object);
}

public class _00000_Single_Template_$ {
	
	
	public void testSortBinaryArray(_00000_Single_Template_Problem solution, String solutionNumber) {
		
		System.out.println();
		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + ": " + solutionNumber + " ==========");
		System.out.println();
		
		System.out.println(solution.template(null));
		System.out.println(solution.template(""));
	}
	
	
	public static void main(String[] args) {

		
		_00000_Single_Template_$ obj = new _00000_Single_Template_$();

		
		System.out.println("-------------------------------- | Version 1 | --------------------------------");
		_00000_Single_Template_Problem solutionV1 = (o) -> {
			
			System.out.println("<<<<<<<<<< Input: " + o.toString() + " >>>>>>>>>>");
			
			return o;
		};
		
		obj.testSortBinaryArray(solutionV1, "solutionV1");
		System.out.println("________________________________________________________________________________");
		

		
		
		/**####################################################################################################*/
		
		
		
		
		System.out.println("-------------------------------- | Version 2 | --------------------------------");
		_00000_Single_Template_Problem solutionV2 = (o) -> {
			
			System.out.println("<<<<<<<<<< Input: " + o.toString() + " >>>>>>>>>>");
			
			return o;
		};
		
		obj.testSortBinaryArray(solutionV2, "solutionV2");
		System.out.println("________________________________________________________________________________");
		
	}
	

}