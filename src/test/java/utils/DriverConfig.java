package utils;
// JAVA

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverConfig {
    private static DriverConfig CONFIG;
    private static Properties props;

    private DriverConfig() {
        props = new Properties();
        try {
            // TEST CONFIGURATION
            props.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\testConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        if (CONFIG == null) CONFIG = new DriverConfig();
        return props.getProperty(key);
    }
}
