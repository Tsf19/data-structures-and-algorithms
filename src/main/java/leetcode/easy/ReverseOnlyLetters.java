/**
From <https://leetcode.com/problems/reverse-only-letters/> 

Given a string s, reverse the string according to the following rules:
	• All the characters that are not English letters remain in the same position.
	• All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.
 
Example 1:
Input: s = "ab-cd"
Output: "dc-ba"

Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 
Constraints:
	• 1 <= s.length <= 100
	• s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
*/

package leetcode.easy;

class ReverseOnlyLetters {

	
	public static void main(String[] args) {

		//Test cases :
//		String s = "a-bC-dEf-ghIj";
		String s = "Test1ng-Leet=code-Q!";
		
		System.out.println("<<<<<<<------- Input : "+s+" ------->>>>>>>");
		System.out.println("<<<<<<<------- Output 1 : "+mySolution1_reverseOnlyLetters(s)+" ------->>>>>>>");
		
	}

	//MySolution - Basic
	public static String mySolution1_reverseOnlyLetters(String s) {
		
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
