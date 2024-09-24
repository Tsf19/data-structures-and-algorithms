package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestInfiniteStreams {
	
	public static void main(String[] args) {
	
		
		/**_____________________________________________________________________________________________________*/
		System.out.println("________________________________________________________________________________");
		System.out.println("=============== | .iterate(0, n -> n + 1) | ===============");
		
		// A. Using Stream.iterate
		// numbers is an infinite stream of numbers starting from 0.
		Stream<Integer> numbers = Stream.iterate(0, n -> n + 1);
		// numbers.toList(); // Infinite
		// System.out.println(numbers); // Control won't come here

		
		// This creates an infinite stream of even numbers and prints the first 10.
		List<Integer> list1 = numbers.filter(n -> n % 2 == 0).limit(10).toList();
		System.out.println(list1); // [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
		

		
		Stream<Integer> evenNumbers1 = Stream.iterate(0, n -> n + 2);
		evenNumbers1.limit(10).forEach(System.out::print);
		// 024681012141618
		System.out.println();
		
		
		
		Stream.iterate(0, n -> n + 1).limit(10).filter(n -> n % 2 == 0).forEach(System.out::print);
		// 02468
		System.out.println();
		

		
		Stream.iterate(0, n -> n + 1).filter(n -> n % 2 == 0).limit(10).forEach(System.out::print);
		//024681012141618
		System.out.println();
		
		
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
		System.out.println("=============== | .generate(Math::random) | ===============");
		
		// randomStream is an infinite stream of random double values. 
		Stream<Double> randomStream = Stream.generate(Math::random);
		
		// randomStream.filter(n -> n % 2 == 0).forEach(n -> System.out.println(n)); // Infinite, won't print anything

		// List<Double> doubleList = randomStream.filter(n -> n % 2 == 0).toList(); // Infinite

		Optional<Double> firstRandomNumber = randomStream.findFirst();
		System.out.println(firstRandomNumber); // Optional[0.3506010419808243]
		
		
		Optional<Double> firstRandomNumber1 = Stream.generate(Math::random).findFirst();
		System.out.println(firstRandomNumber1); // Optional[0.17276480964842678]
		
		
		Optional<Double> firstRandomNumber2 = Stream.generate(Math::random).findAny();
		System.out.println(firstRandomNumber2); // Optional[0.820838856596584]
		
		
		Stream<long[]> fibonacci = Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]});
		fibonacci.limit(10).forEach(f -> System.out.println(f[0]));

		
		
		
		
		System.out.println();
	}

}







