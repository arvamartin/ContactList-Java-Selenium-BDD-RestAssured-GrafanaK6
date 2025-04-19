package StepDefinitions.API;

import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetContactList {

        private RequestSpecification httpRequest;
    private Response response;
    private String authToken = null;
    private final String email = ConfigReader.getValue("user", "email");
    private final String password = ConfigReader.getValue("user", "password");


    @Given("get user's auth token")
    public void getUserSAuthToken() {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        Response loginResponse = RestAssured.given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");

       authToken = loginResponse.jsonPath().getString("token");
       System.setProperty("authToken", authToken);
    }


    @Given("hit the url with auth token")
    public void hitTheContactsGetUrl() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + authToken);
        httpRequest = RestAssured.given().headers(headers);
    }

    @When("pass the {string} url in the request")
    public void passTheUrlOfProductsInTheRequest(String param) {
        response = httpRequest.get(param);
        System.out.println(response.body().prettyPrint());
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
    }


    @Then("receive the {int} response code")
    public void receiveTheResponseCode(int statusCode) {
        int actualStatusCode = Integer.parseInt(System.getProperty("actualStatusCode"));
        System.out.println(actualStatusCode);
        assertThat(actualStatusCode, is(statusCode));
    }


}
