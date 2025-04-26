package StepDefinitions.API;

import Utils.HeaderBuilder;
import Utils.JsonParser;
import Utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostContact {


    @When("send new contact from {string} in {string} post request")
    public void sendNewContact(String fileName, String param) throws IOException {
        Map<String, Object> reqBody = JsonParser.jsonReader(fileName);
        Map<String, Object> headers = HeaderBuilder.buildAuthHeaders();

        Response response = RequestUtil.sendRequest("post", param, headers, reqBody);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        System.out.println(response.jsonPath().getString("_id"));
    }
}
