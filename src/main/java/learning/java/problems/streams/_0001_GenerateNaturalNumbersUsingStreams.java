package learning.java.problems.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class _0001_GenerateNaturalNumbersUsingStreams {
	
	public static void main(String[] args) {
		
		int n = 5;
		
		int[] intArr = IntStream.rangeClosed(1, n).toArray();
		
		int[] intArr2 = IntStream.iterate(0, num -> num + 1).limit(n).toArray();
		
		int[] intArr3 = IntStream.rangeClosed(1, 10).boxed().mapToInt(i -> i).toArray();

		Integer[] integerArr = Stream.iterate(0, num -> num + 1).limit(n).toArray(Integer[]::new);
		
		Integer[] integerArr2 = IntStream.rangeClosed(1, n).boxed().toArray(Integer[]::new);
		
	}

}







