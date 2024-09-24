package learning.java.concepts.miscellaneous;

//https://www.geeksforgeeks.org/can-we-overload-or-override-static-methods-in-java/

/**
 * NOTE:
 * 
 * If static method is redefined by a derived class, then it is not overriding
 * 
 */

//Superclass
class Base_OverrideStatic {

	// Static method - which will be hidden in subclass
	public static void publicStaticDisplay() {
		System.out.println("publicStaticDisplay() from Base");
	}
	
	// Non-static method - which will be overridden in derived class
	public void publicDisplay() {
		System.out.println("publicDisplay() from Base");
	}
	
	// Non-static method - which will be overridden in derived class
	public void publicTestDisplay() {
		System.out.println("publicTestDisplay() from Base");
	}

}

class Derived_OverrideStatic extends Base_OverrideStatic { //Subclass

//	 This method is hidden by publicStaticDisplay() in Base
//	(With Static)
//	 @Override // Error : he method publicStaticDisplay() of type Derived must override or implement a supertype method
//	 Can't Use @Override
	public static void publicStaticDisplay() {
		System.out.println("publicStaticDisplay() from Derived");
	}

//  An instance method cannot override a static method
//	Static is removed here (Causes Compiler Error)
//	ERROR : This instance method cannot override the static method from Base
//	(Without Static)
//	public void publicStaticDisplay() {
//		System.out.println("publicStaticDisplay() from Derived");
//	}

	// This method overrides publicDisplay() in Base
	@Override
	public void publicDisplay() {
		System.out.println("publicDisplay() from Derived");
	}
	
//	Static is added here (Causes Compiler Error)
//	Non-static method in base class, static in Derived class
//	Error : This static method cannot hide the instance method from Base
//	public static void publicTestDisplay() {
//		System.out.println("publicTestDisplay() from Derived");
//	}
	
	public static void publicStaticTestDerivedDisplay() {
		System.out.println("publicStaticTestDerivedDisplay() from Derived");
	}
	
	public void publicNonStaticTestDerivedDisplay() {
		System.out.println("publicNonStaticTestDerivedDisplay() from Derived");
	}
	
}

//Driver class
public class JavaOverrideStaticConcepts {
	
	public static void main(String args[]) {
		
		System.out.println("Base obj1 = new Derived()");
		Base_OverrideStatic obj1 = new Derived_OverrideStatic();

		// As per overriding rules this should call to class Derive's static overridden method.
		// Since static method can not be overridden, it calls Base's display()
		obj1.publicStaticDisplay(); // publicStaticDisplay() from Base

		// Here overriding works and Derive's publicDisplay() is called
		obj1.publicDisplay(); // publicDisplay() from Derived
		
		obj1.publicTestDisplay(); // publicTestDisplay() from Base
		
//		Error: The method publicStaticTestDerivedDisplay() is undefined for the type Base
//		obj1.publicStaticTestDerivedDisplay();
		
//		Error: The method publicStaticTestDerivedDisplay() is undefined for the type Base
//		obj1.publicNonStaticTestDerivedDisplay();
		
		System.out.println();
		System.out.println("Derived obj2 = new Derived()");
		Derived_OverrideStatic obj2 = new Derived_OverrideStatic();

		/** Not Hidden for Sub Object */
		obj2.publicStaticDisplay(); // publicStaticDisplay() from Derived
		obj2.publicDisplay(); // publicDisplay() from Derived
		
		obj2.publicTestDisplay(); // publicTestDisplay() from Base

//		No Error
		obj2.publicStaticTestDerivedDisplay(); // publicStaticTestDerivedDisplay() from Derived
//		No Error
		obj2.publicNonStaticTestDerivedDisplay(); // publicNonStaticTestDerivedDisplay() from Derived
		
	}
	
}
