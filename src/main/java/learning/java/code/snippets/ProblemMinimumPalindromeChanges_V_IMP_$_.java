package learning.java.code.snippets;

import java.util.*;
import java.io.*;

/**

https://vjudge.net/problem/Kattis-names

Anna and Bob are having a baby. They both enjoy the advantage of having palindrome names,
meaning that their names are spelled the same way forwards and backwards.
Wanting to be good parents, they decide to give their child a palindrome name too.
The only problem is that they aren’t sure if the one they picked is a palindrome.
If it turns out it isn’t a palindrome, they want to change it to a palindrome using as few changes as possible.
The allowed changes are:

* Change a letter of the name.
* Add a letter to the end of the name.

Input
Input is the name they have chosen.

Output
Output the number of changes they need to make.

Limits
* The length of the name is at least 1 and at most 100 characters.
* The name consists of only lowercase letters a–z.

Sample Input 1
kaia

Sample Output 1
1

Sample Input 1
abcdefgded

Sample Output 1
4

*/

public class ProblemMinimumPalindromeChanges_V_IMP_$_ {

    public static void main(String[] args) {
    	
    	ProblemMinimumPalindromeChanges_V_IMP_$_ obj = new ProblemMinimumPalindromeChanges_V_IMP_$_();
    	
        try(Scanner scanner = new Scanner(System.in)){
        	
//        	String name = scanner.nextLine();
//        	int changesNeeded = obj.minimumChanges(name);
        	
        	System.out.println(obj.minimumChanges("kaia")); // 1
        	System.out.println(obj.minimumChanges("abcdefgded")); // 4
        	System.out.println(obj.minimumChanges("abcgcbaa")); // 3
        	System.out.println(obj.minimumChanges("abcgcb")); // 1
        	
        	System.out.println(obj.minimumChanges("abcgcbb")); // X  abcggcba Not 3, Ans: 1 -> abcgcba
        	
        	System.out.println(obj.minimumChanges("abcdedcc")); // X abcdeedcba Not 4, Ans: 2 -> abcddcba
        	
        	System.out.println(obj.minimumChanges("abcdedccc")); // X abcdededcba Not 4, Ans: 2 -> abcdedcba
        	

        }

    }

    private int minimumChanges(String name) {
    	
    	if (name.isBlank() || name.length() == 1 || isPalindrome(name))
    		return 0;
    	
        int left = 0;
        int right = name.length() - 1;

        int changes = 0;
        String charsToAdd = "";
        	
        Boolean stopAddition = true;
        
        StringBuilder newName = new StringBuilder(name);
        
        while (left < right) {
        	
            if (name.charAt(left) != name.charAt(right) && stopAddition) {
				charsToAdd = name.charAt(left) + charsToAdd;
				changes++;
            } else
            	stopAddition = false;
            
            if(!stopAddition) {
            	
            	if (name.charAt(left) != name.charAt(right)) {
            		newName.setCharAt(right, name.charAt(left));
            		changes++;
            	}
            	
            	right--;
            }
            
            left++;
        }

        newName.append(charsToAdd);
        System.out.println(name + " --> " + newName);
        
        left = 0;
        right = name.length() - 1;
        newName = new StringBuilder(name);
        int changes2 = 0;
        
        while (left < right) {

        	if (name.charAt(left) != name.charAt(right)) {
        		newName.setCharAt(right, name.charAt(left));
        		changes2++;
        	}

        	right--;

        	left++;
        }
        System.out.println(name + " --> " + newName);
        
//      return changes;
        return changes < changes2 ? changes : changes2;
    }

    
    
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}