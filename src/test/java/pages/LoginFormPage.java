package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import driver.Driver;

public class LoginFormPage extends Page {

    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement loginInputField;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    public LoginFormPage(){
        super();
    }

    public LoginFormPage openLoginPage(String url) {
        Driver.getDriver().navigate().to(url);
        logger.info("Login page is opened");
        return this;
    }

    public PasswordFormPage startLogin(String login){
        loginInputField.sendKeys(login);
        logger.info("Entering login");
        nextButton.click();
        logger.info("Next button click");
        return new PasswordFormPage();
    }

    public boolean isElementLoginInputFieldPresent(){
        logger.info("Checking presence of Login input field");
        return isElementPresent(loginInputField);
    }
}
