package Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class Browser {

    private static WebDriver driver;
    private static String browserType;
    static final Logger logger = LogManager.getLogger(Browser.class);

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static void initializeDriver() {
        if (browserType == null) {
            browserType = ConfigReader.getValue("basic_info", "browser");
        }

        String runMode = ConfigReader.getValue("basic_info", "runMode");
        if (runMode == null) {
            runMode = "local";
        }

        logger.info("Run mode: {}", runMode);

        String remoteUrl = "http://localhost:4444/wd/hub";

        try {
            if (runMode.equalsIgnoreCase("grid")) {
                switch (browserType.toLowerCase()) {
                    case "chrome":
                        driver = new RemoteWebDriver(new URL(remoteUrl), new ChromeOptions());
                        break;
                    case "firefox":
                        driver = new RemoteWebDriver(new URL(remoteUrl), new FirefoxOptions());
                        break;
                    case "edge":
                        driver = new RemoteWebDriver(new URL(remoteUrl), new EdgeOptions());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown browser: " + browserType);
                }
            } else {
                switch (browserType.toLowerCase()) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown browser: " + browserType);
                }
            }
        } catch (Exception e) {
            logger.error("Error initializing WebDriver", e);
            throw new RuntimeException(e);
        }
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
