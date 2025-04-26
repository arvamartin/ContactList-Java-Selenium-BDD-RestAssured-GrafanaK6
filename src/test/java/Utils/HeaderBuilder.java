package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.HashMap;
import java.util.Map;


public class HeaderBuilder {

    private static Logger logger = (Logger) LogManager.getLogger(HeaderBuilder.class);

    public static Map<String, Object> buildAuthHeaders() {
        Map<String, Object> headers = new HashMap<>();
        try {
            String authToken = System.getProperty("authToken");
            if (authToken == null || authToken.isEmpty()) {
                logger.warn("AuthToken issue in header, token is null || empty");
                throw new IllegalStateException("Authentication token is missing or empty.");
            }
            headers.put("Authorization", "Bearer " + authToken);
        } catch (Exception e) {
            logger.warn("Error while building authorization headers:"  + e.getMessage());
            throw new RuntimeException("Failed to build authorization headers.", e);
        }
        return headers;
    }

}
