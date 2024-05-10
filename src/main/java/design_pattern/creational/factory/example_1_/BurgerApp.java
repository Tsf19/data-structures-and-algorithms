/**
 * 
 */
package design_pattern.creational.factory.example_1_;

/**
 * @author Tousif
 *
 */

public class BurgerApp {
	
	public static void main(String[] args) {
		
		Burger cheeseBurger = BurgerFactory.createBurger("cheese");
		cheeseBurger.assemble(); // Output: Assembled Cheese Burger
		
		Burger deluxeCheeseBurger = BurgerFactory.createBurger("deluxe_cheese");
		deluxeCheeseBurger.assemble(); // Output: Assembled Cheese Burger
	}
}