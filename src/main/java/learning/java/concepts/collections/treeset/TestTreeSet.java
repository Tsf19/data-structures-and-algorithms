package learning.java.concepts.collections.treeset;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestTreeSet {
	
	public static void main(String[] args) {
	
		List list1 = Arrays.asList(2, 7, 5, 4, 0, 3, 1, 9, 8, 6, 3, 5, 9, 7, 6, 2);
		System.out.println("Initially list: " + list1);
		
		Set<Integer> treeSet1 = new TreeSet<>(list1);
		System.out.println("treeSet1: " + treeSet1);
		
//		2, 7, 5, 4, 0, 3, 1, 9, 8, 6
		Set<Integer> treeSet2 = new TreeSet<>();
		treeSet2.add(2); treeSet2.add(7);
		treeSet2.add(5); treeSet2.add(4);
		treeSet2.add(0); treeSet2.add(3);
		treeSet2.add(1); treeSet2.add(9);
		treeSet2.add(8); treeSet2.add(6);
		System.out.println("treeSet2: " + treeSet2);
		
		
		Set<Integer> treeSet3 = new TreeSet<>((a, b) -> (b - a));
		treeSet3.add(2); treeSet3.add(7);
		treeSet3.add(5); treeSet3.add(4);
		treeSet3.add(0); treeSet3.add(3);
		treeSet3.add(1); treeSet3.add(9);
		treeSet3.add(8); treeSet3.add(6);
		System.out.println("treeSet3: " + treeSet3);
		
	}

}







