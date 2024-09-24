package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestCreatingStreams {
	
	public static void main(String[] args) {
		
		String[] fruitsArr = new String[] { "Apple", "Banana", "Cherry" };
		
		// Using Stream.of(T ...) //static method
		//Stream<T> of(T... values) : Creating a stream from an array
		Stream<String> fruitsStream1 = Stream.of(fruitsArr);
		
		
		// Using Arrays.stream() // static method
		Stream<String> fruitsStream1_1 = Arrays.stream(fruitsArr);
		
		
		// Using Stream.of(T ...) //static method
		//Stream<T> of(T... values) : Creating a stream from an array
		Stream<String> fruitsStream2 = Stream.of("Apple", "Banana", "Cherry");
		
		
		// Converts an existing collection (like List, Set, or Array) into a stream
		List<String> fruitList = Arrays.asList("Apple", "Banana", "Cherry");
		Stream<String> fruitsStream3 = fruitList.stream();

		// empty stream is a stream that contains no elements
		Stream<String> emptyStream = Stream.empty();
		
		
//		emptyStream.isEmpty()//Does not work
//		fruitsStream3.isEmpty()//Does not work
		
		
		boolean isEmpty = emptyStream.findAny().isEmpty();
		
		boolean isEmpty1 = fruitsStream1.findAny().isEmpty();
		
		// ERROR : stream has already been operated upon or closed
		// boolean isEmpty3 = fruitsStream3.findFirst().isEmpty();
		
		// ERROR : stream has already been operated upon or closed
		boolean isPresent2 = fruitsStream2.findFirst().isPresent();
		
		
		System.out.println();
	}

}






