package Utils;

import io.cucumber.java.After;

public class Hook {

    @After
    public void tearDown(){
        Browser.quitDriver();
    }
}
