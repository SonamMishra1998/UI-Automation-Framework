package com.ui.utility.readers;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import com.ui.utility.constants.Environment;

public class PropertyReader {

    private static String env; 
    private final Properties prop = new Properties();

    // Private constructor loads properties
    private PropertyReader() {
        try {
            String filePath = System.getProperty("user.dir")
                    + File.separator+"config"+ File.separator
                    + env
                    + ".properties";
            prop.load(new FileReader(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties for env: " + env, e);
        }
    }

 
    private static class PropertyIntializer {
        private static final PropertyReader INSTANCE = new PropertyReader();
    }

    // Set environment and initialize singleton
    public static void setProperties(Environment environment) {
        env = environment.toString();
        // Trigger singleton creation
        PropertyIntializer.INSTANCE.prop.size();  // access INSTANCE to run constructor
    }

    // Access loaded properties
    public static Properties getProperties() {
        return PropertyIntializer.INSTANCE.prop;
    }
}
