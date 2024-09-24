package competitiveprogramming.questions.arrays.medium;

import java.util.Arrays;

//public class TestMainDriverClass {public static void main(String[] args) {}}

/**_____________________________________________________________________________________________________*/
/**
https://leetcode.com/problems/average-waiting-time/description

1701. Average Waiting Time

There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
timei is the time needed to prepare the order of the ith customer.
When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.

Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.

 
Example 1:
Input: customers = [[1,2],[2,5],[4,3]]
Output: 5.00000

Explanation:
1) The first customer arrives at time 1, the chef takes his order and starts preparing it immediately at time 1, and finishes at time 3, so the waiting time of the first customer is 3 - 1 = 2.
2) The second customer arrives at time 2, the chef takes his order and starts preparing it at time 3, and finishes at time 8, so the waiting time of the second customer is 8 - 2 = 6.
3) The third customer arrives at time 4, the chef takes his order and starts preparing it at time 8, and finishes at time 11, so the waiting time of the third customer is 11 - 4 = 7.
So the average waiting time = (2 + 6 + 7) / 3 = 5.

Example 2:
Input: customers = [[5,2],[5,4],[10,3],[20,1]]
Output: 3.25000

Explanation:
1) The first customer arrives at time 5, the chef takes his order and starts preparing it immediately at time 5, and finishes at time 7, so the waiting time of the first customer is 7 - 5 = 2.
2) The second customer arrives at time 5, the chef takes his order and starts preparing it at time 7, and finishes at time 11, so the waiting time of the second customer is 11 - 5 = 6.
3) The third customer arrives at time 10, the chef takes his order and starts preparing it at time 11, and finishes at time 14, so the waiting time of the third customer is 14 - 10 = 4.
4) The fourth customer arrives at time 20, the chef takes his order and starts preparing it immediately at time 20, and finishes at time 21, so the waiting time of the fourth customer is 21 - 20 = 1.
So the average waiting time = (2 + 6 + 4 + 1) / 4 = 3.25.
 

Constraints:
• 1 <= customers.length <= 105
• 1 <= arrivali, timei <= 104
• arrivali <= arrivali+1
*/
/**_____________________________________________________________________________________________________*/

@FunctionalInterface
interface _01701_AverageWaitingTime_Problem {
	
	public double averageWaitingTime(int[][] customers);
}

public class _01701_AverageWaitingTime_$_ {
	
	
	public void testSortBinaryArray(_01701_AverageWaitingTime_Problem solution, String solutionNumber) {
		
		System.out.println();
		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + ": " + solutionNumber + " ==========");
		System.out.println();
		
		
		System.out.println(solution.averageWaitingTime(null));
		System.out.println(solution.averageWaitingTime(new int[][] { { 1, 2 }, { 2, 5 }, { 4, 3 } }));
		System.out.println(solution.averageWaitingTime(new int[][] { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } }));
	}
	
	
	public static void main(String[] args) {

		
		_01701_AverageWaitingTime_$_ obj = new _01701_AverageWaitingTime_$_();

		
		System.out.println("-------------------------------- | Version 1 | --------------------------------");
		_01701_AverageWaitingTime_Problem solutionV1 = (customers) -> {

			if(customers == null) return 0;
			
			System.out.println("<<<<<<<<<< Input: " + Arrays.toString(customers) + " >>>>>>>>>>");

			int n = customers.length;

			int finishTime = 0;
			double totalWaitTime = 0;

			int i = 0;

			while(i < n) {

				int arrivalTime = customers[i][0];
				int processTime = customers[i][1];

				finishTime = (finishTime < arrivalTime ? arrivalTime :  finishTime) + processTime;

				int waitTime = finishTime - arrivalTime;

				totalWaitTime = totalWaitTime + waitTime;

				System.out.println("i: " + i);
	            System.out.println("arrivalTime: " + arrivalTime);
	            System.out.println("processTime: " + processTime);
	            System.out.println("finishTime: " + finishTime);
	            System.out.println("waitTime: " + waitTime);
	            System.out.println("totalWaitTime: " + totalWaitTime);
				 
	            
				i++;
			}

			return totalWaitTime/n;
		};
		
		obj.testSortBinaryArray(solutionV1, "solutionV1");
		System.out.println("________________________________________________________________________________");
		

		
		
		/**####################################################################################################*/
		
		
		
		
		System.out.println("-------------------------------- | Version 2 | --------------------------------");
		_01701_AverageWaitingTime_Problem solutionV2 = (o) -> {
			
			System.out.println("<<<<<<<<<< Input: " + o.toString() + " >>>>>>>>>>");
			
			return 0;
		};
		
		obj.testSortBinaryArray(solutionV2, "solutionV2");
		System.out.println("________________________________________________________________________________");
		
	}
	

}