package learning.java.concepts.java008.streams;

import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestExampleFibonacciUsingInfiniteStreams {
	
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
		
		Stream.iterate(new long[] { 0, 1 }, f -> new long[] { f[1], f[0] + f[1] })
		.limit(10)
		.forEach(f -> System.out.println(f[0]));
		

		System.out.println();
	}

}






