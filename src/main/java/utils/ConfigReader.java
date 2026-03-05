package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void loadConfig() throws IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/env.properties");
        prop.load(file);
    }
    public static String get(String url) {
        return prop.getProperty(url);
    }
}
