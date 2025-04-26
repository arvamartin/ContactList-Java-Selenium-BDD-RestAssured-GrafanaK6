package StepDefinitions.API;

import Utils.HeaderBuilder;
import Utils.JsonParser;
import Utils.UpdateUtil;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class UpdateContacts {
    private Response response;
    private Map<String, Object> reqBody;


    @When("update contact from {string} in {string} put request")
    public void updateFullContact(String fileName, String param) throws IOException {
        reqBody = JsonParser.jsonReader(fileName);
        Map<String, Object> headers = HeaderBuilder.buildAuthHeaders();
        Map<String, Object> reqBody = JsonParser.jsonReader(fileName);

        response = UpdateUtil.performUpdate("put", param, headers, reqBody);

        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        System.out.println(response.getBody().prettyPrint());
    }

    @When("update contact from {string} in {string} patch request")
    public void updatePartiallyContact(String fileName, String param) throws IOException {
        reqBody = JsonParser.jsonReader(fileName);
        Map<String, Object> headers = HeaderBuilder.buildAuthHeaders();

        response = UpdateUtil.performUpdate("patch", param, headers, reqBody);

        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        System.out.println(response.getBody().prettyPrint());
    }
}

