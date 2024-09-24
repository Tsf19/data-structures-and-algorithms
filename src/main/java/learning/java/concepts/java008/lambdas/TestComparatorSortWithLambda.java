package learning.java.concepts.java008.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestComparatorSortWithLambda {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		
		System.out.println("Initially list: " + list);
		
		Collections.sort(list);
		System.out.println("After Collections.sort() list: " + list);
		
		
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		//Traditional anonymous inner class
		Comparator<Integer> comparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				
				/**int Integer.compareTo (Integer anotherInteger) :
				 	Compares two Integer objects numerically */
				
				//return x.compareTo(y);
				//return - x.compareTo(y); // Reverse the comparison order
				//return y.compareTo(x); // Reverse the comparison order
				
				//return x > y ? 1 : -1;
				//return x > y ? -1 : 0; // Reverse the comparison order
				//return x - y; // Reverse the comparison order
				return y - x; // Reverse the comparison order
				
			}
		};

		
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		// Sorting using the custom comparator
		Collections.sort(list, comparator1);
		System.out.println("comparator1 list: " + list);

		
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		// more concise : Equivalent lambda expression instead anonymous inner class
		Comparator<Integer> comparator2 = (x, y) -> x.compareTo(y);
		Collections.sort(list, comparator2); // Sort using the custom comparator lambda
		System.out.println("After comparator2: " + list);
		
		
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		Comparator<Integer> comparator3 = (x, y) -> {return x.compareTo(y);};
		Collections.sort(list, comparator3);
		System.out.println("After comparator3: " + list);

		
		// Without compareTo()
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		Comparator<Integer> comparator4 = (x, y) -> {return x > y ? 1 : -1;};
		Collections.sort(list, comparator4);
		System.out.println("After comparator4: " + list);

		
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		// Without compareTo()
		// more concise : (x > y ? 1 : -1) instead {return x > y ? 1 : -1;}
		Comparator<Integer> comparator5 = (x, y) -> (x > y ? 1 : -1);
		Collections.sort(list, comparator5);
		System.out.println("After comparator5: " + list);
		
		
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		// Without compareTo()
		// more concise : (x > y ? 1 : -1) instead {return x > y ? 1 : -1;}
		Comparator<Integer> comparator6 = (x, y) -> (x > y ? -1 : 1); // Reverse the comparison order
		Collections.sort(list, comparator6);
		System.out.println("After comparator6: " + list);
		
		
		
		// Without compareTo()
		// more concise : (x - y) instead (x > y ? -1 : 1)
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		Comparator<Integer> comparator7 = (x, y) -> (x - y);
		Collections.sort(list, comparator7);
		System.out.println("After comparator7: " + list);
		

		
		// Without compareTo()
		// (y - x) instead (x - y)
		list = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		Comparator<Integer> comparator8 = (x, y) -> (y - x); // Reverse the comparison order
		Collections.sort(list, comparator8);
		System.out.println("After comparator8: " + list);
		
	}

}
