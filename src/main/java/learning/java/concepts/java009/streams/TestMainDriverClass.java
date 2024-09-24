package learning.java.concepts.java009.streams;

import java.util.*;
import java.util.stream.Collectors;

public class TestMainDriverClass {
	
	public static void main(String[] args) {
		
		System.out.println("start ... ");

		List<String> list = Arrays.asList("banana", "apple", "cherry", "apple2");
		
		
		Boolean b = list.stream().anyMatch(e -> e.contains("a"));
		System.out.println(b);
		
		System.out.println(list);
		
		List<String> list2 = list.stream().filter(f -> f.startsWith("a")).collect(Collectors.toList());
		System.out.println(list2);
		
		System.out.println("end ... ");
		
	}
}