package learning.java.concepts.miscellaneous;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestStaticFinalConcepts {

	private final int blankFinal;
	private static final int staticBlankFinal;

	static {
		staticBlankFinal = 1;
	}

	TestStaticFinalConcepts(int c) { // constructor
		blankFinal = c;
	}

	// TestMainDriverClass() { } // Error: The blank final field b may not have been initialized
		
	TestStaticFinalConcepts() {
		this(10); // constructor chaining
	}

	public static void main(String s[]) {

		TestStaticFinalConcepts obj1 = new TestStaticFinalConcepts(10); // calling constructor to initialize final int b
		TestStaticFinalConcepts obj2 = new TestStaticFinalConcepts(20); // calling constructor to initialize final int b

		System.out.println(obj1.blankFinal); // 10
		System.out.println(obj2.blankFinal); // 20
		
		System.out.println(TestStaticFinalConcepts.staticBlankFinal); // 1
	}
}
