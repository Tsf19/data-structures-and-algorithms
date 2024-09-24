package learning.java.problems.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class GenerateFactorialsUsingStreams {
	
	public static void main(String[] args) {
	
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Factorials Using Infinite Streams | ===============");
		
		/**_____________________________________________________________________________________________________
		Stream <Integer> java.util.stream.Stream.iterate(Integer seed, UnaryOperator<Integer> f)
		
		java.util.function.UnaryOperator<T>
		Represents an operation on a single operand that produces a result of the same type as its operand.
		This is a specialization of Function for the case where the operand and result are of the same type. 
		This is a functional interface whose functional method is apply(Object).
		
		_____________________________________________________________________________________________________*/
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Incorrect Result ---------------");
		
		// Wrong Way
		Stream.iterate(1, n -> n * (n + 1)) // X 1*2, 2*3, 6*7, 42*43 X
		.limit(5)
		.forEach(n -> System.out.println(n));
		// Output: 1, 2, 6, 42, 1806
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Printing Just Factorial of n ---------------");
		
		Integer reduce = Stream.iterate(1, n -> n + 1) // [1, 2, 3, 4, 5]
		.limit(5)
		.reduce(1, (a, b) -> a * b);

		System.out.println("reduce: " + reduce); // 120

		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Factorial Series ---------------");
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 1 ---------------");
		System.out.println("--------------- using iterate ---------------");


		Stream.iterate(1, n -> n + 1) // [1, 2, 3, 4, 5]
			.limit(5)
			.map(
					n -> Stream
							.iterate(1, n2 -> n2 + 1) //[1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 3, 4, 5]
							.limit(n)
							.reduce(1, (n1, n2) -> n1 * n2)
							
			)
			.forEach(System.out::println);

		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 2 ---------------");
		System.out.println("--------------- using IntStream ---------------");
		
		
		//IntStream.rangeClosed(1, 5).map(n -> IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b)).forEach(System.out::println);
		
		IntStream
			.rangeClosed(1, 5) // [1, 2, 3, 4, 5]
			.map(n -> 			// For each element n in the stream
					IntStream // Create another IntStream from 1 to n
					.rangeClosed(1, n) //[1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 3, 4, 5]
					.reduce(1, (a, b) -> a * b) // Use .reduce() to calculate the factorial of n.
					
		)
		.forEach(System.out::println);
		
		
		/**####################################################################################################*/

		
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Test Start ---------------");
		

		
		
		
		
		System.out.println("--------------- Test End ---------------");
		
		
		

		


		
		

		
		

		
		
		
		
		System.out.println();
	}

}







