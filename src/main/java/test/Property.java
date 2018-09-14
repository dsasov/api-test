package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {
    public static Properties readProperties() {
        Properties properties = new Properties();
        InputStream is;
        try {
            is = new FileInputStream("src\\main\\resources\\config.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
