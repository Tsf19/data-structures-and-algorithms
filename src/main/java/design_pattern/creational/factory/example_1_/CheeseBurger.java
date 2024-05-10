/**
 * 
 */
package design_pattern.creational.factory.example_1_;

/**
 * @author Tousif
 *
 */

//Concrete Burger classes
class CheeseBurger implements Burger {
	
	@Override
	public void assemble() {
		System.out.println("Assembled Cheese Burger");
	}

}
