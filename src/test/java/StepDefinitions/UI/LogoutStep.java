package StepDefinitions.UI;

import Pages.HomePage;
import io.cucumber.java.en.When;

public class LogoutStep {

    private final HomePage homePage = new HomePage();

    @When("user clicks on the logout button")
    public void userClicksOnTheLogoutButton() {
        homePage.getCookie();
        homePage.clickOnLogoutBtn();
    }
}
