
public class Test {
	
	static void test1() {
		
		String s1 = "Hello";
		String s2 = "World";
		
		String s3 = "Hello" + "World";
		String s4 = "Hello" + "World";
		
		Boolean b1 = s3 == s4;
		Boolean b2 = s3.equals(s4);
		
		System.out.println(b1);
		System.out.println(b2);		
		
	}
	
	static void test2() {
		
		String s1 = "Hello";
		String s2 = "World";
		
		String s3 = s1 + s2;
		String s4 = s1 + s2;
		
		Boolean b1 = s3 == s4;
		Boolean b2 = s3.equals(s4);
		
		System.out.println(b1);
		System.out.println(b2);		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("---------- calling test1()... ----------");
		test1();

		System.out.println("---------- calling test2()... ----------");
		test2();
		
	}
}
