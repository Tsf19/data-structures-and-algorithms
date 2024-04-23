package competitiveprogramming.leetcode.string.easy;

public class _917_ReverseOnlyLetters_3_MyInitialSolution implements _917_ReverseOnlyLetters_1_Problem {

    /**
     * #################### INTUITION ####################
     * 
     * 
     * #################### SOLUTION ####################
     * 
     * 
     * #################### ALGORITHM ####################
     * ALGORITHM:
     * 1. 
     * 
     * 2.:
     * 	a. 
     * 	b. 
     * 
     * 3. ...
     * 
     * 
     * n. Return ans.
     * 
     * 
     * #################### Complexity Analysis ####################
     * # Complexity Analysis
     * 
     * Here, N is the size of the string s and t
     * 
     * ## Time complexity: O(?)
     * 
     * ## Space complexity: O(?)
     * 
     */
	
	/**
     * @param s The string.
     * @return The reversed string.
     */
	@Override
	public String reverseOnlyLetters(String s) {
		
		char[] charArray = new char[s.length()];

		int i = 0, j = s.length() - 1;
		while (i < s.length() || j >= 0) {

			if (j >= 0) {
				int jAscii = (int) s.charAt(j);
				if ((jAscii < 65 || jAscii > 90) && (jAscii < 97 || jAscii > 122)) {
					j--;
					continue;
				}
			}

			if (i < s.length()) {

				int iAscii = (int) s.charAt(i);

				if ((iAscii >= 65 && iAscii <= 90) || (iAscii >= 97 && iAscii <= 122)) {
					charArray[j] = s.charAt(i);
					i++;
					j--;
				} else {
					charArray[i] = s.charAt(i);
					i++;
				}

			}
		}

		String result = "";
		for (i = 0; i < charArray.length; i++)
			result = result + charArray[i];
		
		return result;
	}

    
}
