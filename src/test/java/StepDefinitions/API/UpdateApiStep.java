package StepDefinitions.API;

import Utils.JsonParser;
import Utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

public class UpdateApiStep {

    @When("update contact from {string} in {string} {string} request")
    public void updateFullContact(String fileName, String param, String request) {
        Map<String, Object> reqBody = JsonParser.jsonReader(fileName);
        Map<String, Object> headers = RequestUtil.buildAuthHeaders();

        Response response = RequestUtil.sendRequest(request, param, headers, reqBody);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        response.getBody().prettyPrint();
    }
}

