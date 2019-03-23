package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import driver.DriverSingleton;

public class LoginFormPage extends AbstractPage{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginInputField;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    public LoginFormPage(){
        super();
    }

    public LoginFormPage openLoginPage(String url) {
        DriverSingleton.getDriver().navigate().to(url);
        System.out.println("Login page is opened");
        return this;
    }

    public PasswordFormPage startLogin(String login){
        loginInputField.sendKeys(login);
        nextButton.click();
        System.out.println("Login has entered");
        return new PasswordFormPage();
    }
}
