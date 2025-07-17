package Utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static Utils.Constants.JSON_FILE_PATH;

public class JsonParser {
    private static Logger logger = (Logger) LogManager.getLogger(JsonParser.class);

    public static Map<String, Object> jsonReader(String fileName) {
        Map<String, Object> result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = JsonParser.class.getClassLoader().getResourceAsStream(JSON_FILE_PATH + fileName);

            if (inputStream == null) {
                throw new IllegalArgumentException("Cannot find file: " + fileName);
            }
            result = mapper.readValue(inputStream, Map.class);
        } catch (IOException e) {
            logger.warn("Error while reading JSON file: " + fileName + " - " + e.getMessage());
            throw new RuntimeException("Failed to read JSON file: " + fileName, e);

        } catch (Exception e) {
            logger.warn("Unexpected error while reading JSON file: " + fileName + " - " + e.getMessage());
            throw new RuntimeException("Unexpected error while reading JSON: " + fileName, e);
        }
        return result;
    }


}
