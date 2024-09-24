package learning.java.problems.streams;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class _$$_BinaryUsingStreams_$_ {
	
	public static void main(String[] args) {
	
		/*
		 
		 

```java
 public static String toBinary(long naturalNumber){
 if(naturalNumber< 0){
 throw new NumberFormatException("Negative Integer, this snippet only accepts "
 +"positive integers");
 }
 if(naturalNumber==0){
 return"0";
 }
final Stack<Long> binaryBits=
 Stream.iterate(naturalNumber,n->n>0,n->n/2).map(n->n%2)
 .collect(Stack::new,Stack::push,Stack::addAll);
 return Stream.generate(binaryBits::pop)
 .limit(binaryBits.size()).map(String::valueOf).collect(Collectors.joining());
 }

public static Long fromBinary(String binary){
 binary.chars().filter(c->c!='0'&&c!='1').findFirst().ifPresent(in->{
 throw new NumberFormatException(
 "Binary string contains values other than '0' and '1'");
 });
 return IntStream.range(0,binary.length())
 .filter(in->binary.charAt(binary.length()-1-in)=='1')
 .mapToLong(in->((long)0b1)<<in).sum();
 }

```
		 
		 */
		
	}

}







