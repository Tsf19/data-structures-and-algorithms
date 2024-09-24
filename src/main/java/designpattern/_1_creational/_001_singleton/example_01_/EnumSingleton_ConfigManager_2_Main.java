package designpattern._1_creational._001_singleton.example_01_;

import java.io.IOException;

public class EnumSingleton_ConfigManager_2_Main {
	
    public static void main(String[] args) {
    	
    	EnumSingleton_ConfigManager_1 config = EnumSingleton_ConfigManager_1.INSTANCE;
        
    	try {
            config.loadConfig("config.properties");
            String value = config.getConfigValue("someKey");
            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
