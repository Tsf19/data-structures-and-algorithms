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

public class ConfigManager_V2 {

	// volatile added for thread safety: guarantees that multiple threads can see the updated value of the instance variable consistently.
	// The primary purpose of volatile is to ensure visibility of changes to a variable across different threads.
	// It doesn't necessarily provide thread safety itself. The synchronized block is already handling that aspect.
	// If the Singleton instance itself holds mutable data that needs to be accessed by multiple threads,
	// we could declare those specific data fields within the Singleton class as volatile.
	// This would ensure that changes made by one thread to these fields are immediately visible to other threads.
	private static volatile ConfigManager_V2 instance;
	private String configData;

	private ConfigManager_V2() {
		System.out.println("ConfigManager object created without configData");
	}
	
	private ConfigManager_V2(String configData) {
		this.configData = configData;
		System.out.println("ConfigManager object created with configData: " + configData);
	}

	public static synchronized ConfigManager_V2 getInstance() {

		if (instance == null) { // double-checking improves performance by avoiding/skipping synchronization when retrieving already created instance
			
			// The inner synchronized with double-checking improves performance
			synchronized (ConfigManager_V2.class) { //(Concept of Reflection) // This synchronized block synchronizes entire class itself, not a specific variable
				
				// Check if instance exists, if not create it and assign it to the instance variable
				if (instance == null) {
					instance = new ConfigManager_V2("initial configs...");
				}
			}
		}
		
		return instance;
	}
	
	public String getConfigData() {
		return configData;
	}

	@Override
	public String toString() {
		return "ConfigManager_V2 [configData=" + configData + "]";
	}

	
	/** 
	 
	 Alternative Approaches:
	 While synchronizing on the class is a common approach for Singletons, there are other ways to achieve thread safety:

	 1. Volatile Keyword: Marking the instance variable as volatile ensures visibility of changes across threads without needing a synchronized block in every access.
		
	 2. Initialization on Demand Holder: This is a more complex approach that utilizes a static inner class to create the Singleton instance only when it's first needed.
	 
	*/
	
}
