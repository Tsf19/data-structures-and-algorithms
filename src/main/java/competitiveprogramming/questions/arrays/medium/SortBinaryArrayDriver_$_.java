package competitiveprogramming.questions.arrays.medium;

import java.util.Arrays;

//public class TestMainDriverClass {public static void main(String[] args) {}}

/**

https://www.geeksforgeeks.org/sort-binary-array-using-one-traversal/

Given a binary array, sort it using one traversal (single loop) and no extra space/data structure
(Do not use inbuilt sort function)

Examples: 

Input:	1 0 0 1 0 1 0 1 1 1 1 1 1 0 0 1 1 0 1 0 0 
Output:	0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1

Explanation: The output is a sorted array of 0 and 1

Input:	1 0 1 0 1 0 1 0 
Output:	0 0 0 0 1 1 1 1

Explanation: The output is a sorted array of 0 and 1
 */
@FunctionalInterface
interface SortBinaryArrayProblem {
	int [] sortBinaryArray(int a[]);
}

public class SortBinaryArrayDriver_$_ {
	
	
	public void testSortBinaryArray(SortBinaryArrayProblem solution, String solutionStr) {
		
		System.out.println();
		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + ": " + solutionStr + " ==========");
		System.out.println();
		
		System.out.println(Arrays.toString(solution.sortBinaryArray(null)));
		System.out.println(Arrays.toString(solution.sortBinaryArray(new int[] { })));
		System.out.println(Arrays.toString(solution.sortBinaryArray(new int[] { 0 })));
		System.out.println(Arrays.toString(solution.sortBinaryArray(new int[] { 1 })));
		System.out.println(Arrays.toString(solution.sortBinaryArray(new int[] { 1, 0, 1, 0, 1, 0, 1, 0 })));
		System.out.println(Arrays.toString(solution.sortBinaryArray(new int[] { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 })));
	}
	
	
	public static void main(String[] args) {

		
		SortBinaryArrayDriver_$_ obj = new SortBinaryArrayDriver_$_();

		//SortBinaryArrayProblem solutionV1 = (a) -> a;
		//SortBinaryArrayProblem solutionV1 = (a) -> new int [] {};
		
		
		/* ----- | Version 1 | ----- */
		
		SortBinaryArrayProblem solutionV1 = (a) -> {

			if (a == null || a.length == 0 || a.length == 1)
				return a;

			for (int l = 0, r = 0; r < a.length; r++) {

				if (a[r] == a[l])
					continue;

				int t = a[r];
				a[r] = a[l];
				a[l] = t;
				l++;
			}

			return a;
		};		
		
		obj.testSortBinaryArray(solutionV1, "solutionV1");
		
		
		
		
		
		
		

		/* ----- | Version 2 | ----- */
		
		SortBinaryArrayProblem solutionV2 = (a) -> {
			
			if (a == null || a.length == 0 || a.length == 1)
				return a;
			
			int n = a.length;
			
	        // Initialize one at the beginning and one at the end
	        int i = 0;
	        int j = n - 1;

	        // Iterate until the two pointers meet.
	        while (i < j) {

	            // If current index is 1 and end is 0 -> swap
	            if (a[i] == 1 && a[j] == 0) {
	                int temp = a[i];
	                a[i] = a[j];
	                a[j] = temp;

	                // Move left one position to the right.
	                i++;

	                // Move right pointer one position to the left.
	                j--;
	            }

	            // If the element at current index is 0,
	            // move left pointer one position to right.
	            else if (a[i] == 0) {
	                i++;
	            }

	            // If the element at end of array is 1,
	            // move right pointer one position to left.
	            else if (a[j] == 1) {
	                j--;
	            }
	        }
	        return a;
		};
		
		obj.testSortBinaryArray(solutionV2, "solutionV2");
	}
	


}