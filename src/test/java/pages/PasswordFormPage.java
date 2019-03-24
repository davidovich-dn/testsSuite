package pages;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordFormPage extends Page {

    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 10);

    private WebElement passwordInputField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@class='Z4o1ee GyDlGb cd29Sd iiFyne']")
    private WebElement userChangeField;

    public PasswordFormPage(){
        super();
    }

    public InboxPage continueLogin(String password) {
        passwordInputField.sendKeys(password);
        nextButton.click();

        System.out.println("Logged successfully");
        return new InboxPage();
    }

    public boolean isElementPasswordInputFieldPresent(){
        return isElementPresent(passwordInputField);
    }

    public UsersListPage goToUserList(){
        userChangeField.click();
        return new UsersListPage();
    }
}
