package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestCollectGroupingAndPartitioning {
	
	public static void main(String[] args) {
	
/**_____________________________________________________________________________________________________*/
System.out.println("________________________________________________________________________________");
System.out.println("=============== | collect() : Advanced Stream Operations | ===============");


/**_____________________________________________________________________________________________________
 Advanced Stream Operations:
 Streams also support more advanced operations, such as grouping and partitioning.

 1. Grouping
 You can group elements using the Collectors.groupingBy collector.

 2. Partitioning
 Partitioning divides elements into two groups based on a predicate using Collectors.partitioningBy.

	groupingBy and partitioningBy are collectors that allow you to group or partition elements 
	of a stream based on a classifier function.
	groupingBy groups elements by a classifier function, 
	while partitioningBy partitions elements into two groups based on a predicate.
_____________________________________________________________________________________________________*/


System.out.println("________________________________________________________________________________");
System.out.println("=============== | Collectors.groupingBy() | ===============");


System.out.println("________________________________________________________________________________");
System.out.println("----- Map<Integer, List<String>> Collectors.groupingBy(String::length) -----");

{
/**In this example, groupingBy is used to group strings by their length.*/

List<String> list = Arrays.asList("Apple", "Banana", "Cherry");


Map<Integer, List<String>> groupedByLength = list.stream()
		.collect(Collectors.groupingBy(String::length));

System.out.println(groupedByLength); // {5=[Apple], 6=[Banana, Cherry]}
}


System.out.println("________________________________________________________________________________");
System.out.println("-- Map<Character, List<String>> Collectors.groupingBy(name -> name.charAt(0)) --");

{
/**In this example, groupingBy is used to group names by their first letter.*/

List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");


Map<Character, List<String>> namesByFirstLetter = names.stream()
		.collect(Collectors.groupingBy(name -> name.charAt(0)));

namesByFirstLetter.forEach((letter, nameList) -> 
    System.out.println("Letter: "+ letter + " Names: "+ nameList));
}



/**_____________________________________________________________________________________________________*/




System.out.println("________________________________________________________________________________");
System.out.println("=============== | Collectors.partitioningBy() | ===============");


System.out.println("________________________________________________________________________________");
System.out.println("----- Map<Boolean, List<String>> Collectors.partitioningBy(s -> s.length() > 5) -----");

{
/**PartitioningBy is used to partition strings into those longer than five characters and those not.*/

List<String> list = Arrays.asList("Apple", "Banana", "Cherry");

Map<Boolean, List<String>> partitionedByLength = list.stream()
	    .collect(Collectors.partitioningBy(s -> s.length() > 5));

System.out.println(partitionedByLength); // {false=[Apple], true=[Banana, Cherry]}

}




System.out.println("________________________________________________________________________________");
System.out.println("----- Map<Boolean, List<Integer>> Collectors.partitioningBy(n -> n % 2== 0) -----");

{
/**In this example, partitioningBy is used to partition numbers into even and odd groups.*/

List<Integer> partitionNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	
Map<Boolean, List<Integer>> partitioned = partitionNumbers.stream()
	    .collect(Collectors.partitioningBy(n -> n % 2== 0));

System.out.println(partitioned); // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}


partitioned.forEach((isEven, numberList) -> {
	  System.out.print(isEven ? "Even: " : "Odd: "); // Print label first
	  System.out.println(numberList); // Then print the number list
	});

// OR 

partitioned.forEach(
		(isEven, numberList) -> 
		System.out.println(
				(isEven ? "Even: ": "Odd: ") + numberList));
	
System.out.println("________________________________________________________________________________");
}

	}

}







