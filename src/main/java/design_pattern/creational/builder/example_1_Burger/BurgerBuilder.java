/**
 * 
 */
package design_pattern.creational.builder.example_1_Burger;

/**
 * @author Tousif
 *
 */

/**
 The BurgerBuilder class is a creational design pattern that is used to construct complex objects step by step.
 build(): Builder method that constructs and returns the final object of type Burger based on the set properties of bun, patty, and cheese.

 Purpose:
 The BurgerBuilder class separates the construction of a complex object (Burger in this case) from its representation.
 It allows the client code to construct a Burger object step by step without directly creating an object with a complex constructor.
 The class provides methods to set different properties of the Burger object (such as bun, patty, and cheese) individually, and finally, the build method constructs the Burger object with the specified properties.
 
 Usage:
 The BurgerBuilder class simplifies the process of creating a Burger object by chaining method calls to set various properties in a fluent manner.
 Clients can create different types of burgers with varying bun, patty, and cheese combinations using the BurgerBuilder pattern.
 
 Benefits:
 Helps in managing complex object creation by breaking it down into smaller, manageable steps.
 Provides flexibility to construct different variations of objects without directly exposing the object's construction details.

*/
public class BurgerBuilder {
	
	//Contain same class members as of Burger class
	
	private String bun;
	private String patty;
	private String cheese;

	public BurgerBuilder setBun(String bun) {
		this.bun = bun;
		return this;
	}

	public BurgerBuilder setPatty(String patty) {
		this.patty = patty;
		return this;
	}

	public BurgerBuilder setCheese(String cheese) {
		this.cheese = cheese;
		return this;
	}

	//Builder method to return the final object of type Burger
	public Burger build() {
		return new Burger(bun, patty, cheese);
	}
}
