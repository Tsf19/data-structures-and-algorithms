/**
 * 
 */
package designpattern._1_creational._002_factory.example_01_Burger;

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
