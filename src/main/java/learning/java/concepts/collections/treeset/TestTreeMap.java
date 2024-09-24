package learning.java.concepts.collections.treeset;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestTreeMap {
	
	public static void main(String[] args) {
		
		Map<Integer, String> treeMap1 = new TreeMap<>();
		treeMap1.put(2, "2"); treeMap1.put(7, "7");
		treeMap1.put(5, "5"); treeMap1.put(4, "4");
		treeMap1.put(0, "0"); treeMap1.put(3, "3");
		treeMap1.put(1, "1"); treeMap1.put(9, "9");
		treeMap1.put(8, "8"); treeMap1.put(6, "6");
		
		System.out.println("treeMap1: " + treeMap1);
		
		
		Map<Integer, String> treeMap2 = new TreeMap<>((a, b) -> b - a);
		treeMap2.put(2, "2"); treeMap2.put(7, "7");
		treeMap2.put(5, "5"); treeMap2.put(4, "4");
		treeMap2.put(0, "0"); treeMap2.put(3, "3");
		treeMap2.put(1, "1"); treeMap2.put(9, "9");
		treeMap2.put(8, "8"); treeMap2.put(6, "6");
		
		System.out.println("treeMap2: " + treeMap2);


		
	}

}







