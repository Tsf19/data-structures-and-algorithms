package competitiveprogramming.leetcode.string.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
 * 
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * 
 * #Medium #String #StringMatching #Counting #HashTable
 * 
 * You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 * Example 1:
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is an anagram of s.
 *
 * Example 2:
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t an anagram of s.
 *
 * Example 3:
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * 
 * Constraints:
 * 1 <= s.length <= 5 * 10^4
 * s.length == t.length
 * s and t consist of lowercase English letters only.
 */
public class LeetCode_1347_MinimumStepsToAnagram {

    public static void main(String[] args) {
    	
    	LeetCode_1347_MinimumStepsToAnagram solution = new LeetCode_1347_MinimumStepsToAnagram();

        // Example usage
//        System.out.println(solution.minSteps("bab", "aba")); // Output: 1
//        System.out.println(solution.minSteps("leetcode", "practice")); // Output: 5
//        System.out.println(solution.minSteps("anagram", "mangaar")); // Output: 0

        /** #################### LeetCode Given Solution Debug Version #################### */
        System.out.println(solution.minSteps_LeetCodeSolution_DebugVersion("bab", "aba")); // Output: 1
        System.out.println(solution.minSteps_LeetCodeSolution_DebugVersion("leetcode", "practice")); // Output: 5
        System.out.println(solution.minSteps_LeetCodeSolution_DebugVersion("anagram", "mangaar")); // Output: 0
    }
    
	/**
     * @param s The first string.
     * @param t The second string.
     * @return The minimum number of steps.
     */
    public int minSteps(String s, String t) {
        // Your solution implementation here
        return 0; // Placeholder, replace with your actual solution
    }
    
    
    /**
     * #################### INTUITION ####################
     * # Intuition
     * The two strings s and t have the same length.
     * 
     * We need to find the minimum characters that need to be replaced in t to make it an anagram of s
     * or (any one, not both)
     * We need to find the minimum characters that need to be replaced in s to make it an anagram of t
     * 
     * We do not need to touch the instances of a character that are present in both strings.
     * 
     * For example, if the two strings are s = ba and t = aa,
     * we do not need to change one of the 'a' characters in both two strings.
     * s = ba --> aa, // 1 char change, or 
     * t = aa --> ba // 1 char change, 
     * (Not 1+1 = 2 char change for both s and t)
     * 
     * 
     * 
     * The minimum characters that need to be replaced in t to make it an anagram of s:
     * t --> s
     * 
     * we can find the count of characters in t which are not present in s
     * (those characters needs to be replaced)
     * 
     * s = "ssaabxy"
     * t = "tbbapqp"
     * 
     * After removing common chars:
     * s = "ssaxy" //5, either replace these 5 in s
     * t = "tbpqp" //5, or replace these 5 in t
     * 
     * To find this, we can record the frequency of each character in both strings s and t,
     * and calculate the frequency difference of each character.
     * Difference can be positive or negative.
     * 
     * However, we only need to focus on positive values
     * s = "ssaabxy" //{s=2, a=2, b=1, x=1, y=1}
     * t = "tbbapqp" //{t=1, b=2, a=1, p=2, q=1}
     * 
     * Count of characters in t which are not present in s:
     * freq(t) in t - freq(t) in s = 1 - 0 = 1
     * freq(b) in t - freq(b) in s = 2 - 1 = 1
     * freq(a) in t - freq(a) in s = 1 - 2 = -1 // Ignore this negative value, as we are replacing characters in t and not in s.
     * freq(p) in t - freq(p) in s = 2 - 0 = 2
     * freq(q) in t - freq(q) in s = 1 - 0 = 1
     * 
     * sum of all positive values: 5
     * 
     * Count of other remaining characters which are not present in t, but are present in s:
     * freq(s) in t - freq(s) in s = 0 - 2 = -2
     * freq(x) in t - freq(x) in s = 0 - 1 = -1
     * freq(y) in t - freq(y) in s = 0 - 1 = -1
     * 
     * sum of all negative values: -5
     * 
     * 
     * In above, ignore the negative value, as we are replacing characters in t, not in s.
     * 
     * This is because the two values (the sum of the positive and negative differences) are equal in absolute value!
     * The positive value comes from the character in t that needs to be replaced, the negative value comes from the character in s that waits for the corresponding replacement in t.
     * 
     * Example:
     * s = "aab"
     * t = "abb" --> aab // 'a' is untouched, 'b' is replaced with 'a', 'b is untouched'
     * 
     * freq(a) in t - freq(a) in s = 1 - 2 = -1.
     * freq(b) in t - freq(b) in s = 2 - 1 = 1.
     * 
     * t = "abb" --> aab // 'a' is untouched, 'b' is replaced with 'a', 'b is untouched'
     * Therefore, minimum characters that need to be replaced in t = 1, i.e. 'b' of t is being replaced with that extra 'a' of s.
     * 
     * Since t and s are of equal length, and both remain the same after modifying t to make it an anagram of s,
     * the absolute values of the two positive and negative values must be equal.
     * Therefore, we can either sum only the negative differences or only the positive differences,
     * and the result is the same for both.
     * 
     * #################### SOLUTION ####################
     * SOLUTION:
     * One way to find the frequencies of characters in both strings is to use two different maps and then find the difference.
     * Instead of storing the frequencies for both strings separately and then calculating the difference,
     * we can simply add the frequencies for string t,
     * and subtract the frequencies for string s on the fly.
     * This way we will only have to keep one map to store the final difference in frequencies.
     * We can then add up all the positive values and return the sum.
     * 
     * #################### ALGORITHM ####################
     * ALGORITHM:
     * 1. Initialize an array count of size 26, all indices point to 0 initially to denote the frequency of each character.
     * 
     * 2.Iterate over the integer from 0 to the last index in s or t, for each index i:
     * 	a. Increment the frequency of character t[i] in the array count
     * 	b. Decerement the frequency of character s[i] in the array count.
     * 
     * 3. Initialize the variable ans to 0
     * 
     * 4. Iterate over the integers from 0 to 25, and for each positive frequency difference, add it to the variable ans.
     * 
     * 5. Return ans.
     * 
     * 
     * #################### Complexity Analysis ####################
     * # Complexity Analysis
     * 
     * Here, N is the size of the string s and t
     * 
     * ## Time complexity: O(N)
     * We are iterating over the indices of string s or t to find the frequencies in the array freq.
     * Then we iterate over the integers from 0 to 26 to find the final answer.
     * Hence, the total time complexity is equal to O(N).
     * 
     * ## Space complexity: O(1)
     * The only space required is the array count which has the constant size of 26.
     * Therefore, the total space complexity is constant.
     * 
     */
    public int minSteps_LeetCodeSolution(String s, String t) {
    
    	int[] count = new int[26];
    	
    	// Storing the difference of frequencies of characters in t and s.
    	for (int i = 0; i < s.length(); i++) {
    		
    		count[t.charAt(i) - 'a']++;
    		count[s.charAt(i) - 'a']--;
    	}

    	int ans = 0;
    	
    	// Adding the difference where string t has more instances than s.
    	// Ignoring where t has fewer instances as they are redundant and
    	// can be covered by the first case.
    	for (int i = 0; i < 26; i++) {
    		ans += Math.max(0, count[i]);
    	}

    	return ans;
    }
    
    
	public int minSteps_LeetCodeSolution_DebugVersion(String s, String t) {
		
		System.out.println("String s: " + s);
		System.out.println("String t: " + t);
		System.out.println();

		/** SC: O(26) = O(1) */
        int[] count = new int[26]; //frequency count of a to z - 26 chars
        
        char[] atoz = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        System.out.println("Initially...");
        System.out.println(Arrays.toString(atoz));
        System.out.println(Arrays.toString(count));
        System.out.println();
        
        /** TC: O(n) */
        for (int i = 0; i < s.length(); i++) {

        	System.out.println("-------------------- " + "ITERATION NUMBER: #" + i + " --------------------");
        	System.out.println();
        	
        	char charAt_t = t.charAt(i);
        	char charAt_s = s.charAt(i);
        	
        	int asciiOfChar_a = 'a';
        	int asciiOfCharAt_t = charAt_t;
        	int asciiOfCharAt_s = charAt_s;
        	
        	int indexOfCharAt_t = t.charAt(i) - 'a';
        	int indexOfCharAt_s = s.charAt(i) - 'a';
        	
            count[t.charAt(i) - 'a']++;
            System.out.println("charAt_t: " + charAt_t + "++");
            System.out.println(Arrays.toString(atoz));
            System.out.println(Arrays.toString(count));

            System.out.println();
            
            count[s.charAt(i) - 'a']--;
            System.out.println("charAt_s: " + charAt_s + "--");
            System.out.println(Arrays.toString(atoz));
            System.out.println(Arrays.toString(count));
            
            System.out.println();
            
        }

        System.out.println("Final count array...");
        System.out.println(Arrays.toString(atoz));
        System.out.println(Arrays.toString(count));
        
        int ans = 0;
        // Adding the difference where string t has more instances than s.
        // Ignoring where t has fewer instances as they are redundant and can be covered by the first case.

        /** TC: O(26) = O(1) */
        for (int i = 0; i < 26; i++) {
            ans += Math.max(0, count[i]);
            System.out.print("");
        }

        return ans;
	}
    

	
	
	/****************************************** LeetCode My Approach 1 - START *****************************************/
    public int minSteps_MySolution(String s, String t) {

    	if (s.equals(t))
    		return 0;

    	if (s.length() == 1)
    		return 1;

    	Map<Character, Integer> charMapCountOfS = new HashMap<>();
    	Map<Character, Integer> charMapCountOfT = new HashMap<>();
    	Map<Character, Integer> charMapCountOfST = new HashMap<>();

    	for (char charOfS : s.toCharArray()) {

    		if(!charMapCountOfS.containsKey(charOfS))
    			charMapCountOfS.put(charOfS, 1);
    		else
    			charMapCountOfS.put(charOfS, charMapCountOfS.get(charOfS) + 1);

    		if(!charMapCountOfST.containsKey(charOfS))
    			charMapCountOfST.put(charOfS, 1);
    		else
    			charMapCountOfST.put(charOfS, charMapCountOfST.get(charOfS) + 1);

    	}


    	for (char charOfT : t.toCharArray()) {

    		if(!charMapCountOfT.containsKey(charOfT))
    			charMapCountOfT.put(charOfT, 1);
    		else
    			charMapCountOfT.put(charOfT, charMapCountOfT.get(charOfT) + 1);

    		if(!charMapCountOfST.containsKey(charOfT))
    			charMapCountOfST.put(charOfT, 1);
    		else
    			charMapCountOfST.put(charOfT, charMapCountOfST.get(charOfT) + 1);

    	}

    	int minSteps = 0;

    	for (Entry<Character, Integer> entrySetOfST : charMapCountOfST.entrySet()) {

    		Character key = entrySetOfST.getKey();

    		int x = charMapCountOfS.containsKey(key) ? charMapCountOfS.get(key) : 0;
    		int y = charMapCountOfT.containsKey(key) ? charMapCountOfT.get(key) : 0;

    		int z = x-y;

    		if(z < 0)
    			z = z * -1;

    		minSteps = minSteps + z;
    	}

    	return minSteps/2;

    }
    /****************************************** LeetCode My Approach 1 - END *****************************************/

    
}
