package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestIntermediateOperations {

	public static void main(String[] args) {


		/** Filter: used to include only elements that match a given predicate.
		 	It allows you to narrow down the elements in a stream based on a condition.

			Stream <T> java.util.stream.Stream.filter (Predicate <? super T> predicate)

			Example: Filtering Even Numbers
		 */

		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | filter() | ===============");

		
		System.out.println("Filter: Filtering Even Numbers");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		numbers.stream().filter(n -> n % 2== 0)
		.forEach(n -> System.out.println(n + ", ")); // Output: 2, 4, 6,

		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | map() | ===============");

		/** Map: transform each element in the stream by applying a given function.
		 		It is useful for converting elements to a different type or format.

 			<T> Stream <T> java.util.stream.Stream.map (Function <? super T, ? extends T> mapper)
		 */
		System.out.println("Map: converting each string to uppercase");

		List<String> words = Arrays.asList("apple", "banana", "cherry");

		words.stream().map(String::toUpperCase)
		.forEach(System.out::println); // Output: APPLE, BANANA, CHERRY

		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | flatMap() | ===============");



		/** FlatMap: used to transform each element into a stream and then
		 	flatten the resulting streams into a single stream.
		 	It is useful for handling nested structures.

		 	<T> Stream <T> java.util.stream.Stream.flatMap 
		 		(Function <? super List <T>, ? extends Stream <? extends T>> mapper)
		 */

		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("a", "b"),
				Arrays.asList("c", "d"),
				Arrays.asList("e", "f")
				);

		listOfLists.stream().flatMap(List::stream)
		.forEach(System.out::println); // Output: a, b, c, d, e, f


		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | distinct() | ===============");



		/** Distinct: used to remove duplicate elements from the stream,
		 	ensuring that only unique elements are included.

			Stream <T> java.util.stream.Stream.distinct()

			Example: Removing Duplicates from a List
		 */

		List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
		duplicateNumbers.stream().distinct()
		.forEach(System.out::println); // Output: 1, 2, 3, 4, 5


		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | sorted() | ===============");

		
		/** Sorted: used to sort the elements of the stream.
		 
		 	You can either use the natural ordering or provide a custom comparator.
			
			Example: Sorting a List of Strings alphabetically
			
			To sort the list we can use the following approaches:
			
			 Simplified version (without explicit comparator):
			 	.sorted()
			 	
			 	
			Using compareTo method:
				.sorted((o1, o2) -> o1.compareTo(o2))
				OR
				.sorted((o1, o2) -> o2.compareTo(o1))
				
				
			Using natural order (lexicographically):
				.sorted(Comparator.naturalOrder())
				OR
				.sorted(Comparator.reverseOrder())
		 */
		
		List<String> wordsToSort = Arrays.asList("banana", "apple", "cherry");
		
		
		System.out.println("--------------- sorted() ---------------");
		
		wordsToSort.stream().sorted()
			.forEach(System.out::println); // Output: apple, banana, cherry
		
		
		
		System.out.println("--------------- .sorted( (s1, s2) -> s1.compareTo(s2) ) ---------------");
		
		wordsToSort.stream()
			.sorted(
					(s1, s2) -> s1.compareTo(s2)
				)
			.forEach(System.out::println);

		
		
		System.out.println("--------------- Comparator.naturalOrder() ---------------");
		
		wordsToSort.stream()
		.sorted(
				Comparator.naturalOrder()
				)
		.forEach(System.out::println);

		
		System.out.println("--------------- Comparator.comparing(s -> s) ---------------");
		
		wordsToSort.stream()
		.sorted(
				Comparator.comparing(s -> s)
				)
		.forEach(System.out::println);
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- Reverse Order: ---------------");
		
		
		System.out.println("--------------- .sorted( (s1, s2) -> s2.compareTo(s1) ) ---------------");
		
		wordsToSort.stream()
		.sorted(
				(s1, s2) -> s2.compareTo(s1)
				)
		.forEach(System.out::println);
		

		
		System.out.println("--------------- .sorted( Comparator.reverseOrder() ) ---------------");
		
		wordsToSort.stream()
		.sorted(
				Comparator.reverseOrder()
				)
		.forEach(System.out::println);
		
		
		
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- By Length: ---------------");


		System.out.println("--------------- .sorted( .sorted(lengthComparator) ) ---------------");
		
		Comparator<String> lengthComparator = Comparator.comparingInt(String::length);

		wordsToSort.stream()
			.sorted(lengthComparator)
		    .forEach(System.out::println);
		
		
		System.out.println("-------- .sorted( Comparator.comparingInt(String::length).reversed() ) --------");
		
		wordsToSort.stream()
		.sorted(
				Comparator.comparingInt(String::length).reversed()
				)
		.forEach(System.out::println);
		
		
		/**
		wordsToSort.stream()
		.sorted(
				(s1, s2) -> s2.length().compareTo(s1.length())
				)
		.forEach(System.out::println);
		
		The code wont work because the compareTo method is designed for objects
		that implement the Comparable interface.
		Strings in Java do implement Comparable, but the comparison happens 
		lexicographically (character by character), which wouldn't sort by length.
		*/
		
		System.out.println("----- .sorted( (s1, s2) -> Integer.compare(s2.length(), s1.length()) ) -----");
		
		wordsToSort.stream().sorted(
				(s1, s2) -> Integer.compare(s2.length(), s1.length()))
		  .forEach(System.out::println);
		
		
		
		/**_____________________________________________________________________________________________________*/
		/**####################################################################################################*/
		
		

		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | peek() | ===============");

		
		/** Peek
			Stream<T> peek(Consumer<? superT> action)
			used to perform an action on each element as it is processed by the stream.
			It is useful for debugging or performing additional operations without modifying the stream.

			peek method is a non-terminal operation.
			It allows you to perform an action on each element without modifying the stream itself.

			• You can apply peek() after any intermediate operation (e.g., filter, map, flatMap).
			• The provided Consumer function is executed for each element in the stream.


			forEach is NOT Alternatives to peek:
			forEach: If your goal is to simply process each element,
			forEach is a terminal operation that consumes the stream.

		 */

		
		
		System.out.println("--------------- Example 1 ---------------");

		List<String> fruitWords = Arrays.asList("apple", "banana", "cherry");
		Stream<String> debugStream = fruitWords.stream().peek(System.out::println);
		
		debugStream.forEach(s -> {}); // Output: apple, banana, cherry

		
		
		System.out.println("--------------- Example 2 ---------------");
		
		List<String> fruits = Arrays.asList("apple", "banana", "cherry");
		
		fruits.stream().filter(fruit -> fruit.length() > 5)
			.peek(fruit -> System.out.println("Processing: " + fruit))
			.map(String::toUpperCase)
			.forEach(System.out::println);

			
		
		System.out.println("--------------- Example 3 ---------------");
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		
		nums.stream()
			.peek(System.out::println)
			.filter(n -> n % 2 == 0)
			.peek(System.out::println)
			.collect(Collectors.toList());

		// 1, 2, 2, 3, 4, 4, 5
		// NOT: 1, 2, 3, 4, 5, 2, 4, 5
		
		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | limit() | ===============");
		
		
		/** Limit
			used to truncate the stream to a specified number of elements.
			Suppose you have a list of integers and you want to limit the stream to the first three elements.
		*/

		System.out.println("--------------- .limit(3) ---------------");
		
		List<Integer> _5Numbers = Arrays.asList(1, 2, 3, 4, 5);
		_5Numbers.stream()
		.limit(3)
		.forEach(System.out::println); // Output: 1, 2, 3

		
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("--------------- skip() ---------------");
		
		
		/** Skip
			used to discard the first n elements of the stream.

			Suppose you have a list of integers and you want to skip the first two elements.
		*/

		System.out.println("--------------- .skip(2) ---------------");
		
		_5Numbers.stream()
		.skip(2)
		.forEach(System.out::println); // Output: 3, 4, 5
		
		
	}

}







