package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Urls {
    private static Urls URLS;
    private static Properties props;

    private Urls() {
        props = new Properties();
        try {
            // SITE URLS
            props.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\urls.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if (URLS == null) URLS = new Urls();
        return props.getProperty(key);
    }
}
