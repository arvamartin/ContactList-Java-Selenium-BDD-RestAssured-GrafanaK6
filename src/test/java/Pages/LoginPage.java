package Pages;

import java.net.ConnectException;


public class LoginPage extends BasePage{

    public void navigate(String url) throws ConnectException {
        try {
            driver.get(url);
        } catch (Exception e) {
            logger.warn("Unable to load url");
            throw new ConnectException();
        }
    }

}
