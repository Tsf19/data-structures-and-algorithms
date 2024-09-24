/**
 * 
 */
package design_pattern.creational.builder.example_1_Burger;

/**
 * @author Tousif
 *
 */

public class BurgerApp {
	
	public static void main(String[] args) {
		
		//Now we do	not need to remember the order of the parameters
		//Each set method returns the BurgerBuilder object
		Burger cheeseBurger = new BurgerBuilder()
								.setBun("Sesame Seed Bun")
								.setPatty("Chicken Patty")
								.setCheese("Cheddar Cheese").build();

		System.out.println("Burger: " + cheeseBurger); // Output: Burger: Sesame Seed Bun, Chicken Patty, Cheddar Cheese
	}
}