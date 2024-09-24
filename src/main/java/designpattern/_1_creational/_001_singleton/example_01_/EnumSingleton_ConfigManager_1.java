package designpattern._1_creational._001_singleton.example_01_;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum EnumSingleton_ConfigManager_1 {
	
    INSTANCE;
    
    private Properties config = new Properties();
    
    public void loadConfig(String path) throws IOException {
        try (InputStream input = new FileInputStream(path)) {
            config.load(input);
        }
    }
    
    public String getConfigValue(String key) {
        return config.getProperty(key);
    }
}
