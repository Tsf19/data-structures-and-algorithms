package learning.java.problems.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class GenerateFibonacciUsingStreams {
	
	public static void main(String[] args) {
	
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Fibonacci Using Infinite Streams | ===============");
		
		/**_____________________________________________________________________________________________________
		Stream <Integer> java.util.stream.Stream.iterate(Integer seed, UnaryOperator<Integer> f)
		
		java.util.function.UnaryOperator<T>
		Represents an operation on a single operand that produces a result of the same type as its operand.
		This is a specialization of Function for the case where the operand and result are of the same type. 
		This is a functional interface whose functional method is apply(Object).
		
		new long[]{0, 1} is seed: 
		This is the initial value for the stream.
		It's an array with two elements:
		the first Fibonacci number (0) and the second Fibonacci number (1).
		
		f -> new long[] {f[1], f[0] + f[1]} is UnaryOperator function:
		This is the lambda function that defines how each element in the stream is generated
		 based on the previous element (f). It takes a single argument f of type long[].
		
		f[1]:
		 This accesses the second element of the long[] array,
		 which represents the current Fibonacci number.
		
		f[0] + f[1]:
		 This calculates the next Fibonacci number by adding the current number
		 (f[1]) to the previous number (f[0]).
		 
		new long[]{f[1], f[0] + f[1]}:
		 This creates a new long[] with two elements:
		  the second element of the previous array (f[1])
		  and the calculated next Fibonacci number (f[0] + f[1]).
		  This new array becomes the next element in the stream.
		  
		• f[0] represents the current Fibonacci number.
		• f[1] represents the next Fibonacci number.
		The new array contains [f[1], f[0] + f[1]].
		_____________________________________________________________________________________________________*/
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 1 ---------------");
		System.out.println("--------------- .forEach(f -> System.out.println(f[0])) ---------------");

		
		Stream.iterate(new long[] { 0, 1 }, f -> new long[] { f[1], f[0] + f[1] })
		.limit(10)
		.forEach(f -> System.out.println(f[0]));
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 2 ---------------");
		System.out.println("--------------- .mapToLong(f -> f[0]) ---------------");
		
		
		Stream.iterate(new long[] { 0, 1 }, f -> new long[] { f[1], f[0] + f[1] })
		.limit(10)
		.mapToLong(f -> f[0])
		.forEach(System.out::println);
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 3 ---------------");
		System.out.println("--------------- .flatMap(f -> Stream.of(f[0])) ---------------");
		
		Stream.iterate(new long[] { 0, 1 }, f -> new long[] { f[1], f[0] + f[1] })
		.limit(10)
		.flatMap(f -> Stream.of(f[0]))
		.forEach(System.out::println);
		

		/**####################################################################################################*/

		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Understanding ---------------");

		
		/**f -> new int[] {f[1], f[0] + f[1]}
		OR
		f = new int[] {f[1], f[0] + f[1]}		
		
		f[1]: second element of the array -> current Fibonacci number.
		
		f[0] + f[1]: next Fibonacci number
		 
		new int[] { f[1], f[0] + f[1] }:
		 This creates a new array with two elements:
		  the second element of the previous array (f[1])
		  and the calculated next Fibonacci number (f[0] + f[1]).
		  
		The new array contains [f[1], f[0] + f[1]]*/
		
		
		int[] f = new int[] { 0, 1 }; // Seed
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println("f" + Arrays.toString(f) + " | f[0] -> " + f[0]);
			
			f = new int[] { f[1], f[0] + f[1] }; // { n1, n0 + n1 } -> { n1, n2 }
			// f is a new array 
		}
		
		 /*Output:
		 f[0, 1]   | f[0] -> 0
		 f[1, 1]   | f[0] -> 1
		 f[1, 2]   | f[0] -> 1
		 f[2, 3]   | f[0] -> 2
		 f[3, 5]   | f[0] -> 3
		 f[5, 8]   | f[0] -> 5
		 f[8, 13]  | f[0] -> 8
		 f[13, 21] | f[0] -> 13
		 f[21, 34] | f[0] -> 21
		 f[34, 55] | f[0] -> 34
		 */
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Test Start ---------------");
		

		
		Stream
			.iterate(new long[] { 0, 1 }, n -> new long[] { n[1], n[0] + n[1] })
			.limit(10)
			.forEach(n -> System.out.println(n[0]));
		
		
		
		System.out.println("--------------- Test End ---------------");
		
		
		

		


		
		

		
		

		
		
		
		
		System.out.println();
	}

}







