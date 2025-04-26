package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Map;

public class RequestUtil {

    private static final String BASE_URI = "https://thinking-tester-contact-list.herokuapp.com";

    public static Response sendRequest(String method, String param, Map<String, Object> headers, Map<String, Object> reqBody) {
        RestAssured.baseURI = BASE_URI;

        Response response = switch (method.toLowerCase()) {
            case "put" -> RestAssured.given()
                    .contentType("application/json")
                    .headers(headers)
                    .body(reqBody)
                    .put(param);
            case "patch" -> RestAssured.given()
                    .contentType("application/json")
                    .headers(headers)
                    .body(reqBody)
                    .patch(param);
            case "post" -> RestAssured.given()
                    .contentType("application/json")
                    .headers(headers)
                    .body(reqBody)
                    .post(param);
            default -> throw new IllegalArgumentException("Unsupported method: " + method);
        };
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        System.out.println(response.getBody().prettyPrint());

        return response;
    }
}
