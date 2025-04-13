package API.StepDefinitions;

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
    private final String authToken = ConfigReader.getValue("user","BearerAuth");

    @Given("hit the url of contacts api endpoint with auth token")
    public void hitTheContactsGetUrl() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + authToken);
        httpRequest = RestAssured.given().headers(headers);
    }

    @When("pass the url of contacts in the request")
    public void passTheUrlOfProductsInTheRequest() {
        response = httpRequest.get("/contacts");
    }


    @Then("receive the {int} response code")
    public void receiveTheResponseCode(int statusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println(actualStatusCode);
        assertThat(actualStatusCode, is(statusCode));
    }
}
