package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestUtil {

    private static final String BASE_URI = "https://thinking-tester-contact-list.herokuapp.com";

    public static Response sendRequest(String method, String param, Map<String, Object> headers, Map<String, Object> reqBody) {
        RestAssured.baseURI = BASE_URI;

        RequestSpecification httpRequest = RestAssured.given()
                .contentType("application/json")
                .body(reqBody);

        if (headers != null) {
            httpRequest.headers(headers);
        }

        Response response = switch (method.toLowerCase()) {
            case "put" -> httpRequest.put(param);
            case "patch" -> httpRequest.patch(param);
            case "post" -> httpRequest.post(param);
            default -> throw new IllegalArgumentException("Unsupported method: " + method);
        };
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));

        return response;
    }
}
