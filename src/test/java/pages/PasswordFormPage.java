package pages;

import driver.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordFormPage extends Page {

    private static final Logger logger = LogManager.getRootLogger();

    private final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    private final WebElement passwordInputField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement nextButton;

    @FindBy(xpath = "//div[contains(@class,'vgHGpc RRP0oc')]")
    private WebElement userChangeMenu;

    @FindBy(xpath = "//div[@class='BHzsHc'][contains(.,'Сменить аккаунт')]")
    private WebElement toLoginFormPageLink;

    PasswordFormPage(){
        super();
    }

    public InboxPage continueLogin(String password) {
        passwordInputField.sendKeys(password);
        logger.info("Password entered");
        nextButton.click();
        logger.info("Next button click");
        return new InboxPage();
    }

    public LoginFormPage goToLoginFormPage() {
        userChangeMenu.click();
        logger.info("Go to User change menu");
        logger.info("Wait for enable clickable link 'change user'");
        (new WebDriverWait(Driver.getDriver(), 5)).until(ExpectedConditions
                .elementToBeClickable(toLoginFormPageLink));
        logger.info("Link is clickable");
        toLoginFormPageLink.click();
        logger.info("Click on link 'change user'");
        return new LoginFormPage();
    }
}
