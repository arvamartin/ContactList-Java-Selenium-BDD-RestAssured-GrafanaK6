package StepDefinitions.API;

import Utils.ConfigReader;
import Utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Map;

public class PurgeStep {
    private final String BASE_URI = ConfigReader.getValue("base", "uri");
    private List<String> IDs;
    private Map<String, Object> headers;
    private final String PARAM = "/contacts/";
    private Logger logger = LogManager.getLogger(getClass());


    @When("get the ID of all the contacts")
    public void getIDOfContacts() {
            RestAssured.baseURI = BASE_URI;
            headers = RequestUtil.buildAuthHeaders();

            Response response = RestAssured.given()
                    .headers(headers)
                    .get(PARAM);

            IDs = response.jsonPath().getList("_id");
            System.out.println(IDs);
    }

    @When("delete the whole contact list")
    public void deleteWholeContactList() {
        if (IDs == null || IDs.isEmpty()) {
            logger.warn("No contacts to delete.");
            return;
        }

        for (String id : IDs) {
            try {
                Response deleteResponse = RequestUtil.sendRequest("delete", PARAM + id, headers, null);
                System.setProperty("actualStatusCode", String.valueOf(deleteResponse.getStatusCode()));
            } catch (Exception e) {
                logger.warn("Error occurred while deleting contact with ID {}: {}", id, e.getMessage(), e);
            }
        }
    }
}
