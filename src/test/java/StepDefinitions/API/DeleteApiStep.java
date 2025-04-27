package StepDefinitions.API;

import Utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

public class DeleteApiStep {
    private Response response;

    @When("send DELETE request to {string}")
    public void deleteContacts(String param){
        Map<String, Object> headers = RequestUtil.buildAuthHeaders();

        response = RequestUtil.sendRequest("delete", param, headers, null);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
    }
}
