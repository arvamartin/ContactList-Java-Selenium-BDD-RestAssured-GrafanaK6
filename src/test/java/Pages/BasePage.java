package Pages;

import Utils.Browser;
import Utils.FormSelectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    protected final FormSelectors formSelectors;

    public BasePage() {
        this.driver = Browser.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
        logger = LogManager.getLogger(getClass());
        formSelectors = new FormSelectors(driver);
    }

    protected WebElement wait(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void fillEmailInput(String email) {
        formSelectors.getEmailInput().sendKeys(email);
    }

    public void fillPassword(String password) {
        formSelectors.getPasswordInput().sendKeys(password);
    }

    public void clickOnSubmitBtn() {
        formSelectors.getSubmitBtn().click();
    }


    public void fillFirstNameInput(String firstName) {
        formSelectors.getFirstNameInput().sendKeys(firstName);
    }

    public void fillLastNameInput(String lastName) {
        formSelectors.getLastNameInput().sendKeys(lastName);
    }


    public void clickOnCancelBtn() {
        formSelectors.getCancelBtn().click();
    }

    public boolean isCorrectPage(String url) {
        try {
            wait.until(ExpectedConditions.urlToBe(url));
            return Objects.equals(url, driver.getCurrentUrl());
        } catch (Exception e) {
            logger.warn("problem with url assertion");
            throw new RuntimeException(e);
        }
    }
}
