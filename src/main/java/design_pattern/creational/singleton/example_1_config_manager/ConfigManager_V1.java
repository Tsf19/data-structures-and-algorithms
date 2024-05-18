/**
 * 
 */
package design_pattern.creational.singleton.example_1_config_manager;

/**
 * @author Tousif
 *
 * @Resources:
 * https://www.youtube.com/watch?app=desktop&v=tAuRQs_d9F8
 * https://www.youtube.com/watch?v=tSZn4wkBIu8&t=1s
 * 
 */

public class ConfigManager_V1 {

	// The static ensures there's only one instance of this variable across all instances of the ConfigManager class.
	private static ConfigManager_V1 instance;
	private String configData;

	// Making constructor private prevents creating instances of the class directly using new ConfigManager()
	private ConfigManager_V1() {
		// Load configuration data
		// Optional logic for initialization
		System.out.println("ConfigManager object created once??");
	}
	
	// Private constructor to prevent creating objects from outside the class
	private ConfigManager_V1(String configData) {
		// Load configuration data
		this.configData = configData;
	}

	// Public static method to get the single instance
	// static because we're not allowing instantiation of the class, and initially the instance variable is null so we need it to be static
	// synchronized keyword ensures thread safety when multiple threads try to access the instance variable simultaneously
	public static synchronized ConfigManager_V1 getInstance() {

		// Check if instance exists, if not create it and assign it to the instance variable
		if (instance == null) {
			instance = new ConfigManager_V1();
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
