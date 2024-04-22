package competitiveprogramming.leetcode.string.medium;

public class _1347_MinimumStepsToAnagram_2_SolutionDriverClass {

    public static void main(String[] args) {
    	
//    	_1347_MinimumStepsToAnagram_1_Problem solution = new _1347_MinimumStepsToAnagram_3_LeetCodeSolution_1_ArrayCount();
//    	_1347_MinimumStepsToAnagram_1_Problem solution = new _1347_MinimumStepsToAnagram_4_LeetCodeSolution_1_ArrayCountExplanation();
    	_1347_MinimumStepsToAnagram_1_Problem solution = new _1347_MinimumStepsToAnagram_5_MyInitialSolution_HashMap();

        System.out.println(solution.minSteps("bab", "aba")); // Output: 1
        System.out.println(solution.minSteps("leetcode", "practice")); // Output: 5
        System.out.println(solution.minSteps("anagram", "mangaar")); // Output: 0
        
    }
    
            
}
