package competitiveprogramming.leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class _1347_MinimumStepsToAnagram_5_MyInitialSolution_HashMap implements _1347_MinimumStepsToAnagram_1_Problem {

    //My Initial Solution Using HashMap
	
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
     * @param s The first string.
     * @param t The second string.
     * @return The minimum number of steps.
     */
	@Override
    public int minSteps(String s, String t) {

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

    
}
