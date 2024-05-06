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
public class _3_GenerateAllTheStringsOfNBits {

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
	
	/**
	@Approach_2_:
	Calculate total number of binary strings to generate, which is 2^n.
	For each number i, convert i to its binary representation of length n by checking each bit position from right to left.
	Append '1' or '0' to a StringBuilder binaryString based on the value of the bit at position j in i.
	After generating all binary strings, sort binaryList in ascending order.

	Time complexity: O(2^n) //it generates all possible binary strings of length n.
	Space complexity: O(2^n) //as it stores all the generated binary strings in memory.

	The line:
	binaryString.append((i & (1 << j)) != 0 ? "1" : "0");
	is used to append either a '1' or a '0' to the binaryString based on the value of the bit at position j in i.

	Let's break it down:
	(1 << j) shifts the binary number 1 to the left by j positions.
	This effectively creates a binary number with all zeros except for a single '1' at the j-th position.
	For example, (1 << 2) is equivalent to the binary number 100 in decimal.

	i & (1 << j) performs a bitwise AND operation between the number i and the binary number created above.
	This operation sets all bits of i to 0 except for the j-th bit.
	If the j-th bit of i is 1, the result of this operation will be non-zero. Otherwise, it will be 0.

	To summarize, this line of code is used to convert the binary representation of i to a String and
	append the corresponding '1' or '0' to binaryString based on the value of the j-th bit in i.
	 */
	public static void generateBinary_V2(int n) {

		Set<String> binaryStrings = new HashSet<>();
		List<String> binaryList = new ArrayList<>();

		double powerOfTwo = Math.pow(2, n);

		for (int i = 0; i < powerOfTwo; i++) {

			StringBuilder binaryString = new StringBuilder();

//			for (int j = 0; j < n; j++)
//				binaryString.append((i & (1 << j)) != 0 ? "1" : "0");

			System.out.println("i: " + i);
			for (int j = 0; j < n; j++) {

				int t1 = (1 << j);
				int t2 = (i & (1 << j));

				System.out.println("i: " + i + " | j: " + j);
				System.out.println("(i & (1 << j))");
				System.out.println("(" + i + " & (1 << " + j + "))");
				System.out.println("(" + i + " & (" + t1 + "))");
				System.out.println(" " + t2);

				binaryString.append((i & (1 << j)) != 0 ? "1" : "0");
				System.out.println("binaryString: " + binaryString);
				System.out.println();
			}

			System.out.println();
			System.out.println("final binaryString: " + binaryString);
			System.out.println();

			binaryStrings.add(binaryString.toString());
			binaryList.add(binaryString.toString());
		}

		binaryList.sort(String::compareTo);

		for (String binaryString : binaryList)
			System.out.println(binaryString);

	}
	
    
	public static void main(String[] args) {
		
		int n = 3;
		int[] nBitArray = new int[n];
		
		System.out.println(" ------- Approach_1_  ------- ");
		generateBinary_V1(n, nBitArray);
		
		System.out.println(" ------- Approach_2_  ------- ");
		generateBinary_V2(n);
		
		
	}

}
