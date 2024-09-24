/**
 * 
 */
package design_pattern.creational.builder.example_1_Burger;

/**
 * @author Tousif
 *
 */

public class Burger {
	
	private String bun;
	private String patty;
	private String cheese;

	public Burger(String bun, String patty, String cheese) {
		this.bun = bun;
		this.patty = patty;
		this.cheese = cheese;
	}

	// Getters and other methods for Burger (optional)

	@Override
	public String toString() {
		return "Burger [bun=" + bun + ", patty=" + patty + ", cheese=" + cheese + "]";
	}
}
