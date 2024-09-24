package learning.java.concepts.miscellaneous;

// we can override private method of outer class inside its inner class 
class Outer {
	
	private String msg = "GeeksforGeeks";

	private void fun() {
		System.out.println("Outer fun()");
	}
	
	private void test() {
		System.out.println("Outer test()");
	}

	class Inner extends Outer {
		
		//@Override // Error: The method fun() of type Outer.Inner must override or implement a supertype method
		private void fun() {
			// An Inner class can access private members of its outer class
			System.out.println("Accessing Private Member of Outer: " + msg);
		}
	}

	public static void main(String args[]) {

		// In order to create instance of Inner class, we need an Outer class instance.
		// So, first create Outer class instance and then inner class instance.
		Outer outerObj = new Outer();
		Inner innerObj = outerObj.new Inner();
		
		// This will call Inner's fun, the purpose of this call is to
		innerObj.fun(); // Accessing Private Member of Outer: GeeksforGeeks
		
		Outer outerInnerObj = outerObj.new Inner();
		outerInnerObj.fun(); // Outer fun()

		// innerObj.test(); // Error: The method test() from the type Outer is not visible
		
		// outerObj.fun() calls Outer's fun (No run-time polymorphism).
		outerObj = innerObj;
		outerObj.fun(); // Outer fun()
	}
}


public class JavaOverridePrivateOuterInnerClass {
	
	public static void main(String args[]) {


	}
}

class Outer2 {

	// Private method of outer class
	private void privateMethod() {
		System.out.println("Private method in outer class");
	}

	// Inner class
	class Inner {
		
		// Note: This will not be overriding private method of outer class
		private void privateMethod() {
			System.out.println("Private method in inner class");
		}

		// Public method inside inner class
		public void callPrivateMethod() {
			// Calling private method of inner class
			privateMethod();
		}
	}

	public static void main(String[] args) {
		
		// Creating object of outer and inner classes
		Outer2 outer2Obj = new Outer2();
		Outer2.Inner innerObj = outer2Obj.new Inner();
		innerObj.callPrivateMethod();
	}
}
