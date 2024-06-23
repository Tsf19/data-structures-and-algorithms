package competitiveprogramming.leetcode._1_.template;

import java.util.logging.Logger;

public class _00000_Template_2_$_SolutionDriverClass {

	static Logger logger = Logger.getLogger(_00000_Template_2_$_SolutionDriverClass.class.getName());
		
	public static void main(String[] args) {
		
    	testTemplate(new _00000_Template_3_$_MyInitialSolution());
    	testTemplate(new _00000_Template_4_$_Solution_DivideAndConquer());

	}
	
	static void testTemplate(_00000_Template_1_$_Problem solution) {
		
		System.out.println(solution.template(new String[] { "flower", "flow", "flight" })); // Output:
		System.out.println(solution.template(new String[] { "dog", "racecar", "car" })); // Output:
		
	}
}