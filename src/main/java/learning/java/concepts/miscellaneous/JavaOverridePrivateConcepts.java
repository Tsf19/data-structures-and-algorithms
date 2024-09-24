package learning.java.concepts.miscellaneous;

//https://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/

/**
 * NOTE:
 * 
 * you cannot override private methods in Java
 * 
 */

//Superclass
class Base_OverridePrivate {
	
	private void privateTestDisplay() {
		System.out.println("privateTestDisplay() from Base");
	}
	
	private void privateTestDisplay2() {
		System.out.println("privateTestDisplay() from Base");
	}

	class BaseInner_OverridePrivate extends Base_OverridePrivate {
		
//		@Override // This annotation will cause a compile-time error
//		Error: The method privateTestDisplay() of type Derived_OverridePrivate must override or implement a supertype method
//		private void privateTestDisplay() {
//			System.out.println("privateTestDisplay() from Derived");
//		}
		
		private void privateTestDisplay2() {
			System.out.println("privateTestDisplay() from Derived");
		}
		
	}
	
}

class Derived_OverridePrivate extends Base_OverridePrivate { //Subclass

//	@Override // This annotation will cause a compile-time error
//	Error: The method privateTestDisplay() of type Derived_OverridePrivate must override or implement a supertype method
//	private void privateTestDisplay() {
//		System.out.println("privateTestDisplay() from Derived");
//	}
	
	private void privateTestDisplay2() {
		System.out.println("privateTestDisplay() from Derived");
	}
	
}

//Driver class
public class JavaOverridePrivateConcepts {
	
	public static void main(String args[]) {
		
		System.out.println("Base obj1 = new Derived()");
		Base_OverridePrivate obj1 = new Derived_OverridePrivate();

		// Error: The method privateTestDisplay() from the type Base_OverridePrivate is not visible
//		obj1.privateTestDisplay();
		
		// Error: The method privateTestDisplay() from the type Base_OverridePrivate is not visible
//		obj1.privateTestDisplay2();
		
		System.out.println();
		System.out.println("Derived obj2 = new Derived()");
		Derived_OverridePrivate obj2 = new Derived_OverridePrivate();

		// Error: The method privateTestDisplay() from the type Base_OverridePrivate is not visible
//		obj2.privateTestDisplay();

		// Error: The method privateTestDisplay2() from the type Derived_OverridePrivate is not visible
//		obj2.privateTestDisplay2();

		
//		BaseInner_OverridePrivate innerObj = new BaseInner_OverridePrivate(); // Error
		
        // In order to create instance of Inner class, we need an Outer class instance.
		// So, first create Outer class instance and then inner class instance.
		Base_OverridePrivate outerObj = new Base_OverridePrivate();
		
//		BaseInner_OverridePrivate innerObj1 = outerObj.new BaseInner_OverridePrivate(); //ERROR
		Base_OverridePrivate innerObj2 = outerObj.new BaseInner_OverridePrivate();
		
	}
	
	

}
