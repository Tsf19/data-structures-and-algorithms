package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestParallelStream {
	
	public static void main(String[] args) {
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | How to Create Parallel Streams | ===============");
		
		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- stream.parallel() ---------------");
			
			List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
			
			Stream<String> stream = words.stream();
			Stream<String> parallelStream = stream.parallel();
			
			System.out.println(stream.isParallel()); // true // Because of stream.parallel()
			System.out.println(parallelStream.isParallel()); // true
			
			
			Stream<String> stream2 = words.stream();
			System.out.println(stream2.isParallel()); // false
			
			System.out.println();
		}
		
		/**_____________________________________________________________________________________________________*/
		
		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .parallelStream ---------------");

			List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
			
			Stream<String> parallelStream = words.parallelStream();
			
			System.out.println(parallelStream.isParallel()); // true
			
			System.out.println();
		}

		/**_____________________________________________________________________________________________________*/

		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- Stream.of(...).parallel() ---------------");
			
			Stream<String> parallelStream = Stream.of("apple", "banana", "cherry", "date").parallel();
	
			System.out.println(parallelStream.isParallel()); // true
			
			System.out.println();
		}
		
		
		
		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/

		
		System.out.println("________________________________________________________________________________");
		/**_____________________________________________________________________________________________________*/
		System.out.println("=============== | Performance of Parallel Stream | ===============");

		
		List<Integer> numbers = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList());

		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Stream.of(...).parallel() ---------------");

		
		long startTime = System.nanoTime();
		numbers.stream().reduce(0, Integer::sum);
		long endTime = System.nanoTime();
		
		System.out.println("Sequential Stream Time: " + (endTime - startTime)); // 5,50,99,700
		
		System.out.println("________________________________________________________________________________");
		
		startTime = System.nanoTime();
		numbers.parallelStream().reduce(0, Integer::sum);
		endTime = System.nanoTime();
		
		System.out.println("Parallel Stream Time: " + (endTime - startTime)); // 2,41,20,100

	}

}







