package StepDefinitions.API;

import Utils.JsonParser;
import Utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

public class UpdateApiStep {
    private Response response;
    private Map<String, Object> reqBody;
    private Map<String, Object> headers;


    @When("update contact from {string} in {string} put request")
    public void updateFullContact(String fileName, String param) {
        reqBody = JsonParser.jsonReader(fileName);
        headers = RequestUtil.buildAuthHeaders();
        reqBody = JsonParser.jsonReader(fileName);

        response = RequestUtil.sendRequest("put", param, headers, reqBody);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        response.getBody().prettyPrint();
    }


    @When("update contact from {string} in {string} patch request")
    public void updatePartiallyContact(String fileName, String param) {
        reqBody = JsonParser.jsonReader(fileName);
        headers = RequestUtil.buildAuthHeaders();

        response = RequestUtil.sendRequest("patch", param, headers, reqBody);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        response.getBody().prettyPrint();
    }
}

