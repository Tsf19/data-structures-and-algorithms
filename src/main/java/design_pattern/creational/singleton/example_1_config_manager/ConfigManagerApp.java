/**
 * 
 */
package design_pattern.creational.singleton.example_1_config_manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tousif
 *
 */

public class ConfigManagerApp {

	public static void main(String[] args) {

//		ConfigManager_V3 manager = ConfigManager_V3.getInstance();
//		String data = manager.getConfigData();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(() -> ConfigManager_V1.getInstance());
//		executor.execute(() -> ConfigManager_V1.getInstance());
//		executor.execute(() -> ConfigManager_V1.getInstance());
//		executor.execute(() -> ConfigManager_V1.getInstance());
//		executor.execute(() -> ConfigManager_V1.getInstance());
		
	}
}