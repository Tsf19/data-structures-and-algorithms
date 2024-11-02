package learning.java.code.snippets.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**********************************************************************/

class Quiz2DriverClass {
	
	public static void main(String[] args) {}
	
}

/**********************************************************************/

class Test1 {

	public static void main(String[] args) {

		try {
			throw new NullPointerException();
		} catch (RuntimeException e) {
			System.out.println(" -- RuntimeException -- ");
		} catch (Exception e) {
			System.out.println(" -- Exception -- ");
		}

	}
}



/**********************************************************************/

class Test2 {

	public static void main(String[] args) {
		try {
			throw new Error("Fatal error");
		} catch (Exception e) {
			System.out.println("Exception");
		} catch (Error e) {
			System.out.println("Error");
		}

	}
}


/**********************************************************************/

class Test3 {

	public static void main(String[] args) {
		try {
			throw new Exception("First Exception");
		} catch (Exception e) {
			try {
				throw new Exception("Second Exception");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}


/**********************************************************************/

class Test4 {
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("Peris", "London", "New York", "Sydney", "Washington");
		String result = words.stream().filter(w -> w.length() > 10).findFirst().orElse("none");
		System.out.println(result);
		
	}
}


/**********************************************************************/

class Test5 {
	
	public static void main(String[] args) {
		
		IntStream.range(1, 6)
			.mapToObj(i -> i + " ")
			.forEach(System.out::print);

		
	}
}


/**********************************************************************/

//class Test6 {

class Base_6 {
	public void test() {
	}
}

class Base1_6 extends Base_6 {
	public void test() {
		System.out.println("Base1");
	}
}

class Base2_6 extends Base_6 {
	public void test() {
		System.out.println("Base2");
	}
}

class Test6 {
	public static void main(String[] args) {
		Base_6 obj = new Base1_6();
		((Base2_6) obj).test(); // CAST
	}
}

//}

/**********************************************************************/

class SuperClass_7 {
	
	SuperClass_7() {
		foo();
	}

	public void foo() {
		System.out.println("In SuperClass.foo()");
	}
}

class SubClass_7 extends SuperClass_7 {

	private String member;

	public SubClass_7() {
		member = "HI";
	}

	public void foo() {
		System.out.println("In SubClass.foo(): " + member.toLowerCase());
	}
}

class Test7 {
	public static void main(String[] args) {
		SuperClass_7 reference = new SubClass_7();
		reference.foo();
	}
}

	
/**********************************************************************/

class Shape_8 {
	protected void display() {
		System.out.println("Display-base");
	}
}

class Circle_8 extends Shape_8 {

//	private void display() { --> X
//	protected void display() {
	public void display() {
		System.out.println("Display-derived");
	}
}


/**********************************************************************/

class Test8 {
	
	public static void main(String[] args) {
		
		
		
	}
}



/**********************************************************************/

class Testn {
	
	public static void main(String[] args) {
		
	}
}

