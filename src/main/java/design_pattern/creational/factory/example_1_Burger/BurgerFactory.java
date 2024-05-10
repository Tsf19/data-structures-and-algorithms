/**
 * 
 */
package design_pattern.creational.factory.example_1_Burger;

/**
 * @author Tousif
 *
 */

//Factory class to create Burger objects
class BurgerFactory {
	
	public static Burger createBurger(String type) {
		
		switch (type) {
		case "cheese":
			return new CheeseBurger();
		
		case "deluxe_cheese":
			return new DeluxeCheeseBurger();
		
		default:
			throw new IllegalArgumentException("Invalid burger type");
		}
	
	}
}