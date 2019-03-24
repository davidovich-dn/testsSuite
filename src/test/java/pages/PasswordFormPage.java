package pages;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordFormPage extends Page {

    private final WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 10);

    private final WebElement passwordInputField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    public PasswordFormPage(){
        super();
    }

    public InboxPage continueLogin(String password) {
        passwordInputField.sendKeys(password);
        System.out.println("Password entered");
        nextButton.click();
        System.out.println("Next button click");
        return new InboxPage();
    }

    public boolean isElementPasswordInputFieldPresent(){
        return isElementPresent(passwordInputField);
    }
}
