package learning.java.concepts.java008.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//public class TestMainDriverClass {public static void main(String[] args) {}}

@Data
@NoArgsConstructor
@AllArgsConstructor
class TransactionToTestStreamsClass {
	Integer id; String type; Integer value;
}

record TransactionToTestStreamsRecord(Integer id, String type, Integer value) {}

public class TestStreamTransactionExamples {
	
	public static void main(String[] args) {
		
		List<TransactionToTestStreamsClass> transactions1 = Arrays.asList(
				new TransactionToTestStreamsClass(1, "BUY", 100),
				new TransactionToTestStreamsClass(3, "SELL", 80),
				new TransactionToTestStreamsClass(6, "SELL", 120),
				new TransactionToTestStreamsClass(7, "BUY", 40),
				new TransactionToTestStreamsClass(10, "SELL", 50));
		
		// TODO:
		// 1.Filter for type SELL | 2.Sort by value | 3.Collect sorted ids | 4.Return Integer list
		
		
		// using map().toList() of instead map().collect(Collectors.toList());
		// map().toList() approach uses method chaining on the stream
		// applies the map operation to the stream
		// This method is called for each object in the stream, and the return value (the id)
		// .toList() is a terminal operation
		List<Integer> transactionsIds1 = transactions1.stream()
				.filter(t -> t.getType() == "SELL")
				.sorted(Comparator.comparing(TransactionToTestStreamsClass::getValue)
						.reversed())
				.map(TransactionToTestStreamsClass::getId)
				.toList();
		
		System.out.println("transactionsIds1: " + transactionsIds1);
		
		
		//using comparingInt
		List<Integer> transactionsIds2 = transactions1.stream()
				.filter(t -> t.getType() == "SELL")
				.sorted(Comparator.comparingInt(TransactionToTestStreamsClass::getValue)
						.reversed())
				.map(TransactionToTestStreamsClass::getId)
				.toList();
		
		System.out.println("transactionsIds2: " + transactionsIds2);
		
		
		// using map().collect(Collectors.toList()) of instead  map().toList();
		// This approach uses the collect operation on the stream
		// .collect(Collectors.toList()) is a terminal operation that takes 
		// a Collector as an argument. A collector knows how to accumulate the elements 
		// of a stream into a specific result structure (like a list in this case).
		// Collectors.toList() is a built-in collector that collects the elements into a List.
		List<Integer> transactionsIds3 = transactions1.stream()
				.filter(t -> t.getType() == "SELL")
				.sorted(Comparator.comparingInt(TransactionToTestStreamsClass::getValue)
						.reversed()) //using comparingInt
				.map(TransactionToTestStreamsClass::getId)
				.collect(Collectors.toList());
		
		System.out.println("transactionsIds3: " + transactionsIds3);
		
		
		
		
		//using record
		
		List<TransactionToTestStreamsRecord> transactions2 = Arrays.asList(
				new TransactionToTestStreamsRecord(1, "BUY", 100),
				new TransactionToTestStreamsRecord(3, "SELL", 80),
				new TransactionToTestStreamsRecord(6, "SELL", 120),
				new TransactionToTestStreamsRecord(7, "BUY", 40),
				new TransactionToTestStreamsRecord(10, "SELL", 50));
		
		List<Integer> transactionsIds4 = transactions2.stream()
				.filter(t -> t.type() == "SELL")
				.sorted(Comparator.comparingInt(TransactionToTestStreamsRecord::value)
						.reversed())
				.map(TransactionToTestStreamsRecord::id)
				.collect(Collectors.toList());
		
		System.out.println("transactionsIds4: " + transactionsIds4);
		
		
		System.out.println();
	}


	
}