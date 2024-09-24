package learning.java.concepts.java009.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestStreamImprovementsInJava9 {

	public static void main(String[] args) {

		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Streams Improvements in Java 9 | ===============");
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | takeWhile((n -> n < 4) | ===============");
		{
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3);
			List<Integer> takenNumbers = numbers.stream()
					.takeWhile(n -> n < 4)
					.collect(Collectors.toList());

			System.out.println(takenNumbers); // Output: [1, 2, 3]
			System.out.println();
		}


		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | dropWhile(n -> n < 5) | ===============");
		{
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 4, 6, 7, 1, 9);
			List<Integer> droppedNumbers = numbers.stream()
					.dropWhile(n -> n < 5)
					.collect(Collectors.toList());
			System.out.println(droppedNumbers); // Output: [5, 4, 6, 7, 1, 9]
			System.out.println();
		}

		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- .dropWhile(n -> n < 4).allMatch(n -> n > 2) ---------------");
		{
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

			boolean allMatch = numbers.stream()
					.dropWhile(n -> n < 4)
					.allMatch(n -> n > 2);
			System.out.println(allMatch); // Output: true
			System.out.println();
		}

		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Stream.ofNullable(...) | ===============");
		{
			Stream<String> nonEmptyStream = Stream.ofNullable("Hello");
			nonEmptyStream.forEach(System.out::println); // Output: Hello

			Stream<String> emptyStream = Stream.ofNullable(null);
			emptyStream.forEach(System.out::println); // No output
			
			System.out.println();
		}
		
		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- Stream.of(a, null, b) ---------------");
			
			Stream<String> stream = Stream.of("a", null, "b");
			stream.forEach(System.out::println); // Does Not Throws NullPointerException


			
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- Stream.ofNullable(null) ---------------");
			
			Stream.ofNullable(null).forEach(System.out::println); // No output

			
			
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .flatMap(Stream::ofNullable) ---------------");

			Stream.of("a", "b", null)
			.flatMap(Stream::ofNullable)
			.forEach(System.out::println); // Output: a, b

			System.out.println();
		}

		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/


		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("========== | .iterate (seed, Predicate hasNext, UnaryOperator next) | ==========");
		
		
		{
			Stream<Integer> iteratedStream = Stream.iterate(1, n -> n <= 10, n -> n + 1);
			iteratedStream.forEach(System.out::println); // Output: 1, 2, 3, ..., 10
			
			System.out.println();
		}



	}

}
