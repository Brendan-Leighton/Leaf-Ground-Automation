package utils;
// JAVA

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    private static Props PROPS;
    private static Properties props;

    private Props() {
        props = new Properties();
        try {
            // SITE URLS
            props.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\urls.properties"));
            // TEST CONFIGURATION
            props.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\testConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        if (PROPS == null) PROPS = new Props();
        return props.getProperty(key);
    }
}
