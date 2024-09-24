/**
 * 
 */
package designpattern._1_creational._002_factory.example_01_Burger;

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
