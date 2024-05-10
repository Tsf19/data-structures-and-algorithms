/**
 * 
 */
package design_pattern.creational.factory.example_1_Burger;

/**
 * @author Tousif
 *
 */

class DeluxeCheeseBurger implements Burger {
	
	@Override
	public void assemble() {
		System.out.println("Assembled Deluxe Cheese Burger");
	}

}
