package API.StepDefinitions;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class DeleteContacts {
    private Response response;
    Map<String, Object> headers;

    @When("send DELETE request to {string}")
    public void deleteContacts(String param){
        String authToken = System.getProperty("authToken");
        headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + authToken);

        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        response = RestAssured.given()
                .headers(headers)
                .delete(param);

        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
    }
}
