package learning.java.problems.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class GeneratePrimeUsingStreams {
	
	public static void main(String[] args) {
	
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Prime Using Infinite Streams | ===============");
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Incorrect Result ---------------");
		

		IntStream.iterate(2, n -> n + 1)
			.filter(
				n -> IntStream.rangeClosed(2, n).allMatch(i -> n % i != 0)		
			)
		.limit(10)
//		.forEach(System.out::println) // Infinite : Won't Generate Output
		;
		
		/** 
		 There’s an issue with the filtering condition.
		 The problem lies in the allMatch(i -> n % i != 0) part.
		 This condition will always evaluate to true because it checks whether all numbers from 2 to n (inclusive) do not evenly divide n.
		 Since n itself is included in the range, it will always divide itself without a remainder.
		 */


		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 1 ---------------");
		System.out.println("--------------- After Fixing ---------------");

		IntStream.iterate(2, n -> n + 1)
		.filter(
//				n -> IntStream.rangeClosed(2, n).allMatch(i -> n % i != 0)		
				n -> IntStream.rangeClosed(2, n - 1).allMatch(i -> n % i != 0)		
				)
		.limit(10)
		.forEach(System.out::println) // Infinite : Won't Generate Output
		;
		
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 2 ---------------");
		System.out.println("--------------- (int) Math.sqrt(n) ---------------");

		//we only need to check its divisibility by other numbers up to its square root
		//So Create another IntStream from 2 to the square root of the number.
		
		IntStream.iterate(2, n -> n + 1)
			.filter(
					n -> IntStream.rangeClosed(2, (int) Math.sqrt(n))
						.allMatch(i -> n % i != 0))
		.limit(10)
		.forEach(System.out::println);
		
		
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 3 ---------------");
		System.out.println("--------------- (int) Math.pow(n, 0.5) ---------------");
		
		
		IntStream.iterate(2, n -> n + 1)
			.filter(
					n -> IntStream.rangeClosed(2, (int) Math.pow(n, 0.5))
					.allMatch(i -> n % i != 0))
			.limit(10)
			.forEach(System.out::println);
		
		
		
		/**####################################################################################################*/

		
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Test Start ---------------");
		

		
		
		
		
		System.out.println("--------------- Test End ---------------");
		
		
		

		


		
		

		
		

		
		
		
		
		System.out.println();
	}

}







