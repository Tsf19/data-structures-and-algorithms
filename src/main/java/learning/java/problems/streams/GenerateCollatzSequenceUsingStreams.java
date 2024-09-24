package learning.java.problems.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class GenerateCollatzSequenceUsingStreams {
	
	public static void main(String[] args) {
	
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Collatz Sequence (3n+1) Using Infinite Streams | ===============");
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Incorrect Result ---------------");
		
		long start = 27;
		LongStream.iterate(start, n -> (n % 2 == 0) ? n / 2 : 3 * n + 1)
		          .limit(20)
		          .forEach(System.out::println);



		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Version 1 ---------------");
		System.out.println("--------------- After Fixing ---------------");

		
		
		


		
		
		/**####################################################################################################*/

		
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Test Start ---------------");
		

		
		
		
		
		System.out.println("--------------- Test End ---------------");
		
		
		

		


		
		

		
		

		
		
		
		
		System.out.println();
	}

}







