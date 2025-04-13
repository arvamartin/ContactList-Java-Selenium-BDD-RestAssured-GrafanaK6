package Pages;


import Utils.ErrorHandling;


public class RegistrationPage extends BasePage{

    private final ErrorHandling errorHandling = new ErrorHandling(driver);


    public boolean isErrorMessageDisplayed(){
       return errorHandling.isErrorMessageDisplayed();
    }


}
