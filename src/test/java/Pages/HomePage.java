package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class HomePage extends BasePage{

    @FindBy(id = "logout")
    private WebElement logoutBtn;
    @FindBy(id = "add-contact")
    private WebElement addNewContactBtn;
    @FindBy(id = "myTable")
    private List<WebElement> contactsInTable;


    public void clickOnLogoutBtn(){
        try {
            wait(logoutBtn).click();
        } catch (Exception e) {
            logger.warn("Problem during waiting for logoutBtn");
            throw new RuntimeException(e);
        }
    }

    public void clickOnAddNewContactBtn(){
        try {
            wait(addNewContactBtn).click();
        } catch (Exception e) {
            logger.warn("Problem during waiting for addNewContactBtn");
            throw new RuntimeException(e);
        }
    }

    public boolean isNewContactAppears(String contactPhoneNumber){
        wait.until(ExpectedConditions.visibilityOfAllElements(contactsInTable));
        for (WebElement contact : contactsInTable){
            if (contact.getText().contains(contactPhoneNumber)){
                return true;
            }
        }
        logger.warn("Problem with table loop");
        return false;
    }
}
