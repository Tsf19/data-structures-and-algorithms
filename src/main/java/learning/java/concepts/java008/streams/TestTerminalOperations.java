package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestTerminalOperations {
	
	public static void main(String[] args) {
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		
		
		/**
		Terminal Operations in Java 8 Streams

		Terminal operations are the final operations that trigger the processing of the stream pipeline
		and produce a result or a side effect.
		Unlike intermediate operations, which are lazy and build the pipeline,
		terminal operations are eager and process the entire pipeline.
		Once a terminal operation is applied to a stream, the stream is considered consumed and cannot be reused

		Key Terminal Operations
			1. forEach
			2. collect
			3. reduce
			4. toArray: Converts a stream into an array.
			5. min and max
			6. count
			7. anyMatch, allMatch, noneMatch
			8. findFirst, findAny
		 */
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | forEach() | ===============");

		/** 1. forEach
		The forEach method performs an action for each element of the stream.
		It's typically used to print out elements or perform some side-effects.
		 */

		{
			List<String> words = Arrays.asList("apple", "banana", "cherry");
			words.stream().forEach(System.out::println);
			// Output: apple, banana, cherry
			
			System.out.println();
		}
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | collect() | ===============");

		/**2. collect
		The collect method is used to accumulate elements of the stream into a collection
		or other data structures.
		It is one of the most powerful terminal operations.
		Collects elements from the stream into a result container like
		a List, Set, Map, or a custom collection using a Collector.
		*/
		
		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .collect( Collectors.toList() ) ---------------");
			
			List<String> words = Arrays.asList("apple", "banana", "cherry");
			
			List<String> filteredWordsList = words.stream()
			    .filter(word -> word.startsWith("a"))
			    .collect(Collectors.toList());
			
			System.out.println(filteredWordsList); // Output: [apple]

			
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .collect( Collectors.toSet() ) ---------------");
			
			Set<String> filteredWordsSet = words.stream()
					.filter(word -> word.startsWith("a"))
					.collect(Collectors.toSet());
			
			System.out.println(filteredWordsSet); // Output: [apple]
			
			System.out.println();
		}
		
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | collect() : Advanced Stream Operations | ===============");
		

		/**_____________________________________________________________________________________________________
		 Advanced Stream Operations:
		 Streams also support more advanced operations, such as grouping and partitioning.
		
		 1. Grouping
		 You can group elements using the Collectors.groupingBy collector.

		 2. Partitioning
		 Partitioning divides elements into two groups based on a predicate using Collectors.partitioningBy.

			groupingBy and partitioningBy are collectors that allow you to group or partition elements 
			of a stream based on a classifier function.
			groupingBy groups elements by a classifier function, 
			while partitioningBy partitions elements into two groups based on a predicate.
		_____________________________________________________________________________________________________*/
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Collectors.groupingBy() | ===============");

		
		System.out.println("________________________________________________________________________________");
		System.out.println("----- Map<Integer, List<String>> Collectors.groupingBy(String::length) -----");
		
		{
		/**In this example, groupingBy is used to group strings by their length.*/

		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");

		
		Map<Integer, List<String>> groupedByLength = list.stream()
				.collect(Collectors.groupingBy(String::length));

		System.out.println(groupedByLength); // {5=[Apple], 6=[Banana, Cherry]}
		}
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("-- Map<Character, List<String>> Collectors.groupingBy(name -> name.charAt(0)) --");

		{
		/**In this example, groupingBy is used to group names by their first letter.*/
		
		List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
		
		
		Map<Character, List<String>> namesByFirstLetter = names.stream()
				.collect(Collectors.groupingBy(name -> name.charAt(0)));
		
		namesByFirstLetter.forEach((letter, nameList) -> 
		    System.out.println("Letter: "+ letter + " Names: "+ nameList));
		}

		
		
		/**_____________________________________________________________________________________________________*/
		
		
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | Collectors.partitioningBy() | ===============");

		
		System.out.println("________________________________________________________________________________");
		System.out.println("----- Map<Boolean, List<String>> Collectors.partitioningBy(s -> s.length() > 5) -----");
		
		{
		/**PartitioningBy is used to partition strings into those longer than five characters and those not.*/

		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");

		Map<Boolean, List<String>> partitionedByLength = list.stream()
			    .collect(Collectors.partitioningBy(s -> s.length() > 5));

		System.out.println(partitionedByLength); // {false=[Apple], true=[Banana, Cherry]}
		
		}
		
		

		
		System.out.println("________________________________________________________________________________");
		System.out.println("----- Map<Boolean, List<Integer>> Collectors.partitioningBy(n -> n % 2== 0) -----");

		{
		/**In this example, partitioningBy is used to partition numbers into even and odd groups.*/
		
		List<Integer> partitionNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			
		Map<Boolean, List<Integer>> partitioned = partitionNumbers.stream()
			    .collect(Collectors.partitioningBy(n -> n % 2== 0));
		
		System.out.println(partitioned); // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}

		
		partitioned.forEach((isEven, numberList) -> {
			  System.out.print(isEven ? "Even: " : "Odd: "); // Print label first
			  System.out.println(numberList); // Then print the number list
			});
		
		// OR 
		
		partitioned.forEach(
				(isEven, numberList) -> 
				System.out.println(
						(isEven ? "Even: ": "Odd: ") + numberList));
			
		System.out.println();
		}
		
		
		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | reduce() | ===============");


		/**3. reduce

		<T> Optional<T> reduce(T identity, BinaryOperator<T> biFunction);

		T identity: This is the initial value used for the reduction.
		It serves as the base case for the accumulation process.

		BinaryOperator<T> biFunction: This is the function that defines how elements are combined.
		It takes two arguments of type T (elements from the stream) and returns a single value of type T.


		java.util.function.BinaryOperator <T>
		Represents an operation upon two operands of the same type,
		producing a result of the same type as the operands.
		This is a specialization of BiFunction for the case where the operands
		and the result are all of the same type. 

		This is a functional interface whose functional method is apply(Object, Object).

		The reduce method combines elements of the stream to produce a single result.
		It can be used for summing numbers, concatenating strings, etc.

		The reduce method is a powerful terminal operation in Streams that allows you to reduce all elements
		in the stream to a single value.
		It achieves this by applying a binary operator function (BiFunction) to pairs of elements iteratively.
		*/
		
		/**_____________________________________________________________________________________________________*/

		{
			/**
			 int java.lang.Integer.sum(int a, int b):
				Adds two integers together as per the + operator.
				Parameters: a the first operand, b the second operand
				Returns:the sum of a and b
			 */
			
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .reduce(0, Integer::sum) ---------------");
			
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
			
			int sum = numbers.stream().reduce(0, Integer::sum); // 0 is the identity
			
			System.out.println(sum); // Output: 15
		
			System.out.println();
		}
		
		/**_____________________________________________________________________________________________________*/

		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .reduce(0, (subtotal, n) -> subtotal + n) ---------------");

			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
			
			int sum = numbers.stream()
			                 .reduce(0, (subtotal, n) -> subtotal + n);
	
			System.out.println("Sum of numbers: " + sum); // Prints "Sum of numbers: 15"

			System.out.println();
		}
		
		/**_____________________________________________________________________________________________________*/

		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .reduce(10, Integer::sum) ---------------");

			List<String> words = Arrays.asList("apple", "banana", "cherry");
			
			int totalCharsInList = words.stream()
					.map(s -> s.length())
					.reduce(10, Integer::sum); //27
					//.reduce(0, (s1, s2) -> s1 + s2); //17
					//.reduce(10, (s1, s2) -> s1 + s2); //27
			
			System.out.println("totalCharsInList: " + totalCharsInList); // 17
			
			System.out.println();
		}
		
		/**_____________________________________________________________________________________________________*/

		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .reduce(Combined String: , (s1, s2) -> s1 - s2) ---------------");

			List<String> words = Arrays.asList("apple", "banana", "cherry");
			
			String combinedString = words.stream()
			.reduce("Combined String: ", (s1, s2) -> s1 + " - " + s2);

			
			System.out.println("combinedString: " + combinedString);
			// combinedString: Combined String:  - apple - banana - cherry
			
			System.out.println();
		}

		
		
		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/
		
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | toArray() | ===============");

		/**4. toArray
		The toArray method collects the elements of the stream into an array.

		*/
		
		{
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .toArray(String[]::new) ---------------");

			List<String> words = Arrays.asList("apple", "banana", "cherry");
			
			String[] wordArray = words.stream().toArray(String[]::new);
			
			System.out.println(Arrays.toString(wordArray)); // Output: [apple, banana, cherry]

			
			/**_____________________________________________________________________________________________________*/
			
			System.out.println("________________________________________________________________________________");
			System.out.println("--------------- .toArray(s -> new String[s]) ---------------");

			String[] wordArray2 = words.stream().toArray(s -> new String[s]);
			System.out.println(Arrays.toString(wordArray2)); // Output: [apple, banana, cherry]
			
			
			System.out.println();
		}
		
		
		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/
		
		
		/** For Object Arrays:
		 	The toArray() method converts the stream into an array.
		 	The argument (String[]::new) OR (Integer[]::new) is a method reference
		 	that tells toArray() how to create a new array of the correct type
		 */
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | .toArray(Integer[]::new) | ===============");
		
		{
		Integer[] integerArr = Stream.iterate(0, num -> num + 1)
				.limit(15)
				.toArray(Integer[]::new);
		
		System.out.println("integerArr: " + Arrays.toString(integerArr));
		
		
		System.out.println("Arrays.stream(T[] array, int startInclusive, int endExclusive).toArray(Integer[]::new)");
		
		// <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive)
		Integer[] array = Arrays.stream(integerArr, 5, 10).toArray(Integer[]::new);
		
		
		System.out.println("Arrays.stream: " + Arrays.toString(integerArr));
		// Arrays.stream: [5, 6, 7, 8, 9]
		
		
		}


		/**_____________________________________________________________________________________________________*/
		
		
		/** For Primitive Arrays:
		 	If we want a primitive array (like int[] instead of Integer[]),
		 	we can use specialized streams and methods
		 	The toArray() method converts the stream into an array.
		 	
		 	Variations : 
		 	 public static  Stream stream(T[] array)
			 public static  Stream stream(T[] array, int startInclusive, int endExclusive)

		 */
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | IntStream.toArray() | ===============");
		
		{
			int[] intArr = IntStream.iterate(0, num -> num + 1)
					.limit(15)
					.toArray();
			
			System.out.println("intArr: " + Arrays.toString(intArr));
			// intArr: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
			
			
			System.out.println("Arrays.stream(int[] array, int startInclusive, int endExclusive).toArray()");

			// IntStream stream(int[] array, int startInclusive, int endExclusive)
			int[] array = Arrays.stream(intArr, 5, 10).toArray();
			
			
			System.out.println("Arrays.stream: " + Arrays.toString(array));
			// Arrays.stream: [5, 6, 7, 8, 9]
		}
		
		{
			
			System.out.println("----- IntStream.rangeClosed(int startInclusive, int endInclusive).boxed() -----");
			
			List<Integer> numberList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
			
			System.out.println("numberList: " + numberList);
			
			
			System.out.println("----- IntStream.rangeClosed(int startInclusive, int endInclusive).toArray() -----");
			
			int[] numberArray = IntStream.rangeClosed(1, 10).toArray();
			
			System.out.println("IntStream.rangeClosed(): " + Arrays.toString(numberArray));
		}
		

		/**_____________________________________________________________________________________________________*/
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | .mapToInt(i -> i) | ===============");

		{
		/** .mapToInt(i -> i):
		 	Returns an IntStream consisting of the results of applying thegiven function to the elements of this stream.
		 */
		int[] intArr = IntStream.rangeClosed(1, 10).boxed()
		.mapToInt(i -> i).toArray();
		
		}

		/**_____________________________________________________________________________________________________*/
		
		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/
		
		
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | min() & max() | ===============");

		/**5. min and max
		min(Comparator comparator) & max(Comparator comparator):

		The min and max methods return the minimum and maximum element of the stream,
		according to the provided comparator.
		
		If no comparator is specified, the natural ordering of the elements is used.
		*/

		{
			List<Integer> numbers = Arrays.asList(3, 1, 2, 5, 4);
			
			Optional<Integer> min = numbers.stream().min(Integer::compareTo);
			
			Optional<Integer> max = numbers.stream().max(Integer::compareTo);

			System.out.println();
		}
		
		/**_____________________________________________________________________________________________________*/
		
		{
			System.out.println("________________________________________________________________________________");
			
			List<Integer> numbers = Arrays.asList(3, 1, 2, 5, 4);
			
			
			
			// Reversed
			Optional<Integer> maxUsingMin = numbers.stream().min(					
					(a, b) -> b.compareTo(a));
			
			
			/**_____________________________________________________________________________________________________*/

			
			// Reversed
			Optional<Integer> maxUsingMin2 = numbers.stream().min(					
					(a, b) -> (b - a));
			
			
			/**_____________________________________________________________________________________________________*/

			
			// Reversed
			Optional<Integer> minUsingMax = numbers.stream().max(					
					Comparator.reverseOrder()
					);
			
			
			/**_____________________________________________________________________________________________________*/

			
			// Reversed
			Optional<Integer> minUsingMax2 = numbers.stream().max(					
					Comparator.comparing(s -> -s)
					);
			

			/**_____________________________________________________________________________________________________*/
			
			
			// Reversed
			Optional<Integer> maxUsingMin3 = numbers.stream().min(
					
					(s1, s2) -> Integer.compare(s2, s1)
					
					);
			
			
			System.out.println();
		}

		
		/**_____________________________________________________________________________________________________*/

		{
			List<Integer> numbers = Arrays.asList(3, 1, 2, 5, 4);
			
			int min = numbers.stream().min(Integer::compareTo).orElse(-1);
			
			int max = numbers.stream().max(Integer::compareTo).orElse(-1);
			
			System.out.println("Min: "+ min); // Output: Min: 1
			System.out.println("Max: "+ max); // Output: Max: 5

			System.out.println();
		}
		
		
		
		
		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/
		
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | count() | ===============");

		/**6. count
		The count method returns the number of elements in the stream as a long value.
		*/

		{
			List<String> words = Arrays.asList("apple", "banana", "cherry");
			long count = words.stream().count();
			System.out.println(count); // Output: 3

			System.out.println();
		}

		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | anyMatch(), allMatch(), noneMatch() | ===============");

		/**7. anyMatch, allMatch, noneMatch

		anyMatch(Predicate predicate), allMatch(Predicate predicate), noneMatch(Predicate predicate):

		These methods check the elements of the stream against a predicate and return a boolean result.

		anyMatch(predicate):Checks if at least one element in the stream matches the given Predicate condition.
							Returns true if a match is found, false otherwise.
		
		allMatch(predicate): Checks if all elements in the stream match the Predicate condition.
							Returns true if all elements match, false otherwise.
		
		noneMatch(predicate): Checks if no elements in the stream match the Predicate condition.
							Returns true if no matches are found, false otherwise.
		*/

		{
			System.out.println("________________________________________________________________________________");
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
			
			boolean anyMatch = numbers.stream().anyMatch(n -> n > 3);
			boolean allMatch = numbers.stream().allMatch(n -> n > 0);
			boolean noneMatch = numbers.stream().noneMatch(n -> n < 0);
			
			System.out.println("Any Match: " + anyMatch); // Output: Any Match: true
			System.out.println("All Match: " + allMatch); // Output: All Match: true
			System.out.println("None Match: " + noneMatch); // Output: None Match: true

			System.out.println();
		}
		

		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | findFirst(), findAny() | ===============");

		/**8. findFirst, findAny
		The findFirst method returns the first element of the stream,
		while findAny may return any element of the stream.
		These methods are typically used with parallel streams to find elements efficiently.

		findFirst(): Attempts to find the first element in the stream and
		returns an Optional object containing the element if found, or empty if not.
		
		findAny(): Similar to findFirst(), but may return any element from the stream
		(useful for parallel streams).
		*/

		{
			System.out.println("________________________________________________________________________________");
			
			List<String> words = Arrays.asList("apple", "banana", "cherry");
			String firstWord=words.stream().findFirst().orElse("No word");
			String anyWord=words.stream().findAny().orElse("No word");

			System.out.println("First Word: "+ firstWord); // Output: First Word: apple
			
			System.out.println("Any Word: "+ anyWord); // Output: Any Word: apple
			// (or any other word in a parallel stream)

			System.out.println();
		}
		

		System.out.println("________________________________________________________________________________");
		/**_____________________________________________________________________________________________________*/
		
	}

}







