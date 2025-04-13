package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getValue(String section, String key) {
        Properties properties = new Properties();
        try (InputStream fis = ConfigReader.class.getClassLoader().getResourceAsStream("Config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String prefixedKey = section + "." + key;

        return properties.getProperty(prefixedKey);

    }
}
