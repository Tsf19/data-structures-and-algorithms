package learning.java.concepts.java008.lambdas;

import java.util.function.Predicate;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestEffectiveFinal {
	
	int n4 = 2; // instance variable
	
	public static void main(String[] args) {
		
		int n1 = 2;
		int n2;
		final int n3;
		
		//Predicate<Integer> predicate = a -> a % 2 == 0;
		//Predicate<Integer> predicate = a -> {return a % 2 == 0;};
		
		Predicate<Integer> predicate = a -> {
			//int n1 = 2; //Error
			//n1 = 2; //Error: scope must be final or effectively final
			return a % n1 == 0;
		};
		
		Predicate<Integer> predicate2 = a -> {
			//n2 = 2; //Error: scope must be final or effectively final
			return a % n1 == 0;
		};
		
		Predicate<Integer> predicate3 = a -> {
			// n3 = 2; //Error: final
			return a % n1 == 0;
		};
		
		Predicate<Integer> predicate4 = a -> {
			int n4 = 2; //Local variable | No Error
			return a % n4 == 0;
		};
		
	}

	public void fun() {
		
		Predicate<Integer> predicate5 = a -> {
			n4 = 2; //No Error, we can change instance variable inside lambda
			return a % n4 == 0;
		};
		
		
		int n4 = 2; //No Error
		Predicate<Integer> predicate6 = a -> {
			//n4 = 2; //Error: scope must be final or effectively final
			return a % n4 == 0;
		};
		
		int n7;
		Predicate<Integer> predicate7 = a -> {
			//n7 = 2; //Error: scope must be final or effectively final
			return a % n4 == 0;
		};
		

		Predicate<Integer> predicate8 = a -> {
			return a % this.n4 == 0;
		};
		
		Predicate<Integer> predicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer a) {
				//return a % this.n4 == 0; // can't access this.n4, as it is separate class
				return false;
			}
		};
		
	}
	
}







