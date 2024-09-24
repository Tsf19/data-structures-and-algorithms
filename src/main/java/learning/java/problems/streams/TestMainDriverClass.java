package learning.java.problems.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestMainDriverClass {

	public static void main(String[] args) {

		{
			
			// Use Stream API to filter and collect duplicate characters
			String str = "Banana";
			str = str.toLowerCase();
			
			Set<Character> duplicates = str.chars()
			//.map(n -> (char) n)
			.mapToObj(c -> (char) c)
			.collect(Collectors.groupingBy(
					c -> c, Collectors.counting()
					))
			.entrySet()
			.stream()
			.filter(e -> e.getValue() > 1)
			.map(n -> n.getKey())
			.collect(Collectors.toSet());
			
			System.out.println(duplicates);
			
		}
		
		
		
		
		
//		// Use Stream API to filter and collect duplicate characters
//		Set<Character> duplicates = str.chars().mapToObj(c -> (char) c) // Convert int to Character
//				.collect(Collectors.groupingBy(c -> c, Collectors.counting())) // Group by character and count
//				.entrySet().stream().filter(entry -> entry.getValue() > 1) // Filter duplicates
//				.map(Map.Entry::getKey) // Get the duplicate characters
//				.collect(Collectors.toSet());
//
//		System.out.println(duplicates);

		int[] numbers = { 2, 5, 7, 8, 99, 1, 22, 4, 3, 77, 66 };

		// Using Stream API to filter and print even numbers
		System.out.println("Even numbers:");
		Arrays.stream(numbers) // Convert the array to a stream
				.filter(n -> n % 2 == 0) // Filter even numbers
				.forEach(System.out::println); // Print each even number
	}

}
