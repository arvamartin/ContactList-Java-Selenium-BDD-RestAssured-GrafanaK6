package Utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JsonParser {

    public static Map<String, Object> jsonReader(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = JsonParser.class.getClassLoader().getResourceAsStream("Json/" + fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("Cannot find file: " + fileName);
        }
        return mapper.readValue(inputStream, Map.class);
    }


}
