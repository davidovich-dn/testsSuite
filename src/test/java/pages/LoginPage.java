package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import driver.DriverSingleton;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginInputField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    public LoginPage(){
        super();
    }

    public LoginPage openLoginPage(String url) {
        DriverSingleton.getDriver().navigate().to(url);
        System.out.println("Login page is opened");
        return this;
    }

    public InboxPage doLogin(String userName, String password) {
        loginInputField.sendKeys(userName);
        nextButton.click();
        passwordInputField.sendKeys(password);
        nextButton.click();

        System.out.println("Logged successfully");
        return new InboxPage();
    }
}
