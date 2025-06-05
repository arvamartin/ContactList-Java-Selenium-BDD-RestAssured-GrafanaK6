package StepDefinitions.UI;

import Pages.AddContactPage;
import Pages.HomePage;
import Utils.RandomGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AddContactStep {

    private final HomePage homePage = new HomePage();
    private final AddContactPage addContactPage = new AddContactPage();
    private final String phoneNumber = RandomGenerator.generateRandomNumber(10);

    @When("user clicks on add new contact button")
    public void userClicksOnAddNewContactButton() {
        homePage.getCookie();
        homePage.clickOnAddNewContactBtn();
        boolean isDisplayed = addContactPage.isTitleDisplayed();
        assertThat(isDisplayed, is(true));
    }

    @And("user enters acceptable phone number")
    public void userEntersAcceptablePhoneNumber() {
        addContactPage.fillPhoneNumberInput(phoneNumber);
    }

    @And("new contact is in the contact table")
    public void newContactIsInTheContactTable() {
        boolean isAppeared = homePage.isNewContactAppears(phoneNumber);
        assertThat(isAppeared, is(true));
    }
}
