/**
 * 
 */
package designpattern._1_creational._001_singleton.example_02_config_manager;

/**
 * @author Tousif
 *
 * @Resources:
 * https://www.youtube.com/watch?app=desktop&v=tAuRQs_d9F8
 * https://www.youtube.com/watch?v=tSZn4wkBIu8&t=1s
 * 
 */
/**
Be Cautious with Singletons:
While Singletons can be useful in some scenarios, it's important to be cautious when using them.
They can make your code less testable and more difficult to maintain.
Consider alternative approaches like dependency injection if you need more flexibility in your application design.

Alternatives:
Dependency Injection:
This approach promotes loose coupling by providing objects with their dependencies rather than relying on global access points.
This can make your code more modular and easier to test.

Here's an analogy:
Imagine a library with a single copy of a valuable reference book (the Singleton).
It's easy for anyone to find and access the book (global access).
However, testing becomes difficult because you can't easily create a substitute copy for testing purposes (testability).
Additionally, if someone is already using the book, others have to wait (thread safety concerns).
Dependency injection is like borrowing the book from the library and bringing it to your study area (loose coupling).
You have more control over when and how you use the book (flexibility).
*/

public class ConfigManager_V3 {

	// volatile added for thread safety: guarantees that multiple threads can see the updated value of the instance variable consistently.
	private static volatile ConfigManager_V3 instance;
	private String configData;

	private ConfigManager_V3() {
		System.out.println("ConfigManager object created with hashCode: " + instance.hashCode());
	}
	
	private ConfigManager_V3(String configData) {
		this.configData = configData;
	}

	public static ConfigManager_V3 getInstance() {

		if (instance == null) {
			
			synchronized (ConfigManager_V3.class) {
				if (instance == null) {
					instance = new ConfigManager_V3();
				}
			}
		}
		
		return instance;
	}
	
	public String getConfigData() {
		return configData;
	}

	
	/** 
	 
	 Alternative Approaches:
	 While synchronizing on the class is a common approach for Singletons, there are other ways to achieve thread safety:

	 1. Volatile Keyword: Marking the instance variable as volatile ensures visibility of changes across threads without needing a synchronized block in every access.
		
	 2. Initialization on Demand Holder: This is a more complex approach that utilizes a static inner class to create the Singleton instance only when it's first needed.
	 
	*/
	
}
