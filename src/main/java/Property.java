import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class Property {
    static Properties readProperties() {
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
