package pages;

import driver.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordFormPage extends Page {

    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 10);

    @FindBy(xpath = "//input[@type='password']")
    private WebElement element;

    private WebElement passwordInputField = wait.until(
            ExpectedConditions.visibilityOf(element));

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    public PasswordFormPage(){
        super();
    }

    public InboxPage continueLogin(String password) {
        passwordInputField.sendKeys(password);
        nextButton.click();

        System.out.println("Logged successfully");
        return new InboxPage();
    }

    public boolean isElementLoginInputFieldPresent(){
        return isElementPresent(passwordInputField);
    }
}
