/**
 * 
 */
package designpattern._1_creational._001_singleton.example_02_config_manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tousif
 *
 */

public class ConfigManagerApp {

	public static void main(String[] args) {

		ConfigManager_V1 manager1 = ConfigManager_V1.getInstance();
		String data1 = manager1.getConfigData();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(() -> System.out.println(ConfigManager_V1.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V1.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V1.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V1.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V1.getInstance().hashCode()));
		
		
		ConfigManager_V2 manager2 = ConfigManager_V2.getInstance();
		String data2 = manager2.getConfigData();
		
		executor = Executors.newFixedThreadPool(2);
		executor.execute(() -> System.out.println(ConfigManager_V2.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V2.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V2.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V2.getInstance().hashCode()));
		executor.execute(() -> System.out.println(ConfigManager_V2.getInstance().hashCode()));
		
		
		
//		ConfigManager_V3 manager = ConfigManager_V3.getInstance();
//		String data = manager.getConfigData();
		
		
//		executor.execute(() -> ConfigManager_V1.getInstance());
//		executor.execute(() -> ConfigManager_V1.getInstance());
//		executor.execute(() -> ConfigManager_V1.getInstance());
//		executor.execute(() -> ConfigManager_V1.getInstance());
		
	}
}