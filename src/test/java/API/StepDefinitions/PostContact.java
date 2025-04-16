package API.StepDefinitions;

import Utils.JsonParser;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostContact {
    private Response response;
    Map<String, Object> reqBody;
    Map<String, Object> headers;

    @When("send new contact from {string} in {string} post request")
    public void sendNewContact(String fileName, String param) throws IOException {
        reqBody = JsonParser.jsonReader(fileName);

        String authToken = System.getProperty("authToken");
        headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + authToken);

        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        response = RestAssured.given()
                .contentType("application/json")
                .headers(headers)
                .body(reqBody)
                .post(param);

        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
    }
}
