package StepDefinitions.API;

import Utils.JsonParser;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateContacts {
    private Response response;
    Map<String, Object> reqBody;
    Map<String, Object> headers;
    private final String BASE_URI = "https://thinking-tester-contact-list.herokuapp.com";

    @When("update contact from {string} in {string} put request")
    public void updateFullContact(String fileName, String param) throws IOException {
        reqBody = JsonParser.jsonReader(fileName);
        String authToken = System.getProperty("authToken");
        headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + authToken);

        RestAssured.baseURI = BASE_URI;
        response = RestAssured.given()
                .contentType("application/json")
                .headers(headers)
                .body(reqBody)
                .put(param);

        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        System.out.println(response.getBody().prettyPrint());
    }

    @When("update contact from {string} in {string} patch request")
        public void updatePartiallyContact(String fileName, String param) throws IOException {
            reqBody = JsonParser.jsonReader(fileName);
            String authToken = System.getProperty("authToken");
            headers = new HashMap<>();
            headers.put("Authorization", "Bearer " + authToken);

            RestAssured.baseURI = BASE_URI;
            response = RestAssured.given()
                    .contentType("application/json")
                    .headers(headers)
                    .body(reqBody)
                    .patch(param);

            System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
            System.out.println(response.getBody().prettyPrint());
        }
}

