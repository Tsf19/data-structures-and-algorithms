/**
 * 
 */
package NarasimhaKarumanchi.Java._1_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tousif
 *
 */

/**

@Problem:
Given a positive integer number N.
The task is to generate all the binary strings of N bits.
These binary strings should be in ascending order.

@Example:
Input: 3
Output: 0 0 0, 0 0 1, 0 1 0, 0 1 1, 1 0 0, 1 0 1, 1 1 0, 1 1 1

*/
public class _3_1_GenerateAllTheStringsOfNBits {

	/**
	@Approach_1_:
	The idea is to try every permutation.
	For every position, there are 2 options, either ‘0’ or ‘1’.
	Backtracking is used in this approach to try every possibility/permutation


	Time Complexity: O(2^n) //Because it generates all possible binary strings of length n
	Space Complexity: O(n)

	Time Complexity: O(2^n)
	This is because at each recursive step, it has two choices: either to add a '0' or a '1' to the binary string.
	This results in a binary tree with 2^n leaves, each corresponding to a different binary string of length n.

	Space Complexity: O(n)
	This is because the method uses an integer array nBitArray to store the current binary string.

	*/
	public static void generateBinary_V1(int n, int[] nBitArray) {

		if(n < 1)
			System.out.println(Arrays.toString(nBitArray));
		else {
			nBitArray[n-1] = 0;
			generateBinary_V1(n-1, nBitArray);
			nBitArray[n-1] = 1;
			generateBinary_V1(n-1, nBitArray);
		}
	}
	
    
	public static void main(String[] args) {
		
		int n = 3;
		int[] nBitArray = new int[n];
		
		System.out.println(" ------- Approach_1_  ------- ");
		generateBinary_V1(n, nBitArray);
		
	}

}
