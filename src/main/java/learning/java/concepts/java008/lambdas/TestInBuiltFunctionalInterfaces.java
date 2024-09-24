package learning.java.concepts.java008.lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestInBuiltFunctionalInterfaces {
	
	public static void main(String[] args) {
	
		//1. Function<T, R>:
		
		//Function<String, Integer> stringLength = (String str) -> str.length();
		Function<String, Integer> stringLength = str -> str.length();
		int length = stringLength.apply("Hello world!"); // length will be 12
		
		
		//2. Consumer<T>:
		
		//Consumer<String> printer = (String str) -> System.out.println(str);
		Consumer<String> printer = str -> System.out.println(str);
		printer.accept("This is a message to be printed!");

		
		//3. Predicate<T>:
		Predicate<Integer> isEven = num -> num % 2 == 0;
		boolean is20Even = isEven.test(20); // is20Even will be true
		
		//4. Supplier<T>:
		Supplier<String> randomGreeting = () -> "Hello from a random supplier!";
		String greeting = randomGreeting.get();
		System.out.println(greeting); // Prints a random greeting message

		
		//5. BiFunction<T, U, R>:
		BiFunction<String, Integer, String> fullName = (firstName, age) -> firstName + " " + age;
		String nameWithAge = fullName.apply("Alice", 30); // nameWithAge will be "Alice 30"

		
		//6. BinaryOperator<T>:
		BinaryOperator<Integer> addition = (x, y) -> x + y;
		int sum = addition.apply(5, 10); // sum will be 15

		
	}

}







