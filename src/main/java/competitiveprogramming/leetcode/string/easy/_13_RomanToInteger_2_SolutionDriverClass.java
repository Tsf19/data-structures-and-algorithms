package competitiveprogramming.leetcode.string.easy;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class _13_RomanToInteger_2_SolutionDriverClass {

	static Logger logger = Logger.getLogger(_13_RomanToInteger_2_SolutionDriverClass.class.getName());
	
    @Test
    public void testRomanToInt() {
    	
    	_13_RomanToInteger_1_Problem solution = new _13_RomanToInteger_3_MyInitialSolution();

        assertEquals(3, solution.romanToInt("III"));
        assertEquals(4, solution.romanToInt("IV"));
        assertEquals(5, solution.romanToInt("V"));
        assertEquals(8, solution.romanToInt("VIII"));
        assertEquals(9, solution.romanToInt("IX"));
        assertEquals(49, solution.romanToInt("XLIX"));
        assertEquals(50, solution.romanToInt("L"));
    }
	
	public static void main(String[] args) {
		
		_13_RomanToInteger_1_Problem solution;
		
		solution = new _13_RomanToInteger_3_MyInitialSolution();
    	System.out.println("========== Solution: ==========");
    	System.out.println(solution.romanToInt("III")); // Output: 3
    	System.out.println(solution.romanToInt("IV")); // Output: 4
    	System.out.println(solution.romanToInt("V")); // Output: 5
        System.out.println(solution.romanToInt("LVIII")); // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994 // M:1000
		
        
		solution = new _13_RomanToInteger_4_$_UpdatedSolution();
		System.out.println("========== Solution: ==========");
    	System.out.println(solution.romanToInt("III")); // Output: 3
    	System.out.println(solution.romanToInt("IV")); // Output: 4
    	System.out.println(solution.romanToInt("V")); // Output: 5
        System.out.println(solution.romanToInt("LVIII")); // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994 // M:1000
		
        
		solution = new _13_RomanToInteger_5_$_OtherSolution();
		System.out.println("========== Solution: ==========");
    	System.out.println(solution.romanToInt("III")); // Output: 3
    	System.out.println(solution.romanToInt("IV")); // Output: 4
    	System.out.println(solution.romanToInt("V")); // Output: 5
        System.out.println(solution.romanToInt("LVIII")); // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994 // M:1000
		
        
		solution = new _13_RomanToInteger_6_$_OtherAdvancedSolution();
		System.out.println("========== Solution: ==========");
    	System.out.println(solution.romanToInt("III")); // Output: 3
    	System.out.println(solution.romanToInt("IV")); // Output: 4
    	System.out.println(solution.romanToInt("V")); // Output: 5
        System.out.println(solution.romanToInt("LVIII")); // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994 // M:1000 

//	    logger.info("romanToInt(III): " + solution.romanToInt("III")); // Output: 3
//	    logger.info("romanToInt(IV): " + solution.romanToInt("IV")); // Output: 4
//	    logger.info("romanToInt(V): " + solution.romanToInt("V")); // Output: 5
//	    logger.info("romanToInt(LVIII): " + solution.romanToInt("LVIII")); // Output: 58
//	    logger.info("romanToInt(MCMXCIV): " + solution.romanToInt("MCMXCIV")); // Output: 1994 // M:1000
	}

}