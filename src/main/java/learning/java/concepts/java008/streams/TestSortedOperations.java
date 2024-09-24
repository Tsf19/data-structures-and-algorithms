package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestSortedOperations {

	public static void main(String[] args) {

		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		
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
			

				.sorted( (a, b) -> (a - b) )
				OR
				.sorted( (a, b) -> (b - a) )
				
				
			Using natural order (lexicographically):
				.sorted(Comparator.naturalOrder())
				OR
				.sorted(Comparator.reverseOrder())
		 */
		
		
		System.out.println("________________________________________________________________________________");
		
		/**
		Integer.compare(x, y): is a static method in the Integer class
		Use Integer.compare() for simple numeric comparisons.

		compareTo(): part of the Comparable interface.
		compares the current object with another object (of the same type)
		Use compareTo() when defining natural ordering for your class

		comparing(): This method is part of the Comparator interface
		It creates a comparator based on a specified key extractor function
		Use comparing() when you want to create a custom comparator based on a specific attribute or key
		Example (using Person class with an age field)
		Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);
		
		expression (o1.compareTo(o2)) is more general
		and works with any type that implements Comparable.

		expression ((a, b) -> (a - b)) is specific to numeric types
		(e.g., int, double) and performs subtraction directly.
		
		*/
		
		System.out.println("________________________________________________________________________________");
		
		List<String> wordsToSort = Arrays.asList("banana", "apple", "cherry");
		
		
		System.out.println("<<<<<<<<<< sorted() >>>>>>>>>>");
		
		wordsToSort.stream().sorted()
			.forEach(System.out::println); // Output: apple, banana, cherry
		

		System.out.println("________________________________________________________________________________");
		
		
		System.out.println("<<<<<<<<<< .sorted( (s1, s2) -> s1.compareTo(s2) ) >>>>>>>>>>");
		
		wordsToSort.stream()
			.sorted(
					(s1, s2) -> s1.compareTo(s2)
				)
			.forEach(System.out::println);

		
		System.out.println("________________________________________________________________________________");

		
		System.out.println("<<<<<<<<<< Comparator.naturalOrder() >>>>>>>>>>");
		
		wordsToSort.stream()
		.sorted(
				Comparator.naturalOrder()
				)
		.forEach(System.out::println);

		
		System.out.println("________________________________________________________________________________");

		
		System.out.println("<<<<<<<<<< Comparator.comparing(s -> s) >>>>>>>>>>");
		
		wordsToSort.stream()
		.sorted(
				Comparator.comparing(s -> s)
				)
		.forEach(System.out::println);
		
		
		System.out.println("________________________________________________________________________________");
		
		System.out.println("<<<<<<<<<< =================== >>>>>>>>>>");
		System.out.println("<<<<<<<<<< Reverse Order: >>>>>>>>>>");
		System.out.println("<<<<<<<<<< =================== >>>>>>>>>>");
		
		System.out.println("________________________________________________________________________________");
		
		
		System.out.println("<<<<<<<<<< .sorted( (s1, s2) -> s2.compareTo(s1) ) >>>>>>>>>>");
		
		wordsToSort.stream()
		.sorted(
				(s1, s2) -> s2.compareTo(s1)
				)
		.forEach(System.out::println);
		
		
		System.out.println("________________________________________________________________________________");

		
		System.out.println("<<<<<<<<<< .sorted( Comparator.reverseOrder() ) >>>>>>>>>>");
		
		wordsToSort.stream()
		.sorted(
				Comparator.reverseOrder()
				)
		.forEach(System.out::println);
		
		
		System.out.println("________________________________________________________________________________");
		

		System.out.println("<<<<<<<<<< =================== >>>>>>>>>>");
		System.out.println("<<<<<<<<<< By Length: >>>>>>>>>>");
		System.out.println("<<<<<<<<<< =================== >>>>>>>>>>");


		System.out.println("________________________________________________________________________________");
		
		
		System.out.println("<<<<<<<<<< .sorted( .sorted(lengthComparator) ) >>>>>>>>>>");
		
		Comparator<String> lengthComparator = Comparator.comparingInt(String::length);

		wordsToSort.stream()
			.sorted(lengthComparator)
		    .forEach(System.out::println);
		

		System.out.println("________________________________________________________________________________");
		
		
		System.out.println("<<<<<<<<<< .sorted( Comparator.comparingInt(String::length).reversed() ) >>>>>>>>>>");
		
		wordsToSort.stream()
		.sorted(
				Comparator.comparingInt(String::length).reversed()
				)
		.forEach(System.out::println);
		
		
		
		System.out.println("________________________________________________________________________________");
		
		
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

		System.out.println("________________________________________________________________________________");

		
		System.out.println("<<<<<<<<<< .sorted( (a, b) -> (b - a) ) >>>>>>>>>>");
		
		wordsToSort.stream()
		.sorted(
				(s1, s2) -> s2.length() - s1.length()
				)
		.forEach(System.out::println);
		
		
		System.out.println("________________________________________________________________________________");

		
		System.out.println("<<<<<<<<<< .sorted( (s1, s2) -> Integer.compare(s2.length(), s1.length()) ) >>>>>>>>>>");
		
		wordsToSort.stream().sorted(
				(s1, s2) -> Integer.compare(s2.length(), s1.length()))
		  .forEach(System.out::println);
		
	}

}







