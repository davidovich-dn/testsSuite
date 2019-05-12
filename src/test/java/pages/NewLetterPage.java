package pages;

import driver.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLetterPage extends Page {

    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement newMailToField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement newMailSubjectField;

    @FindBy(xpath = "//div[@class ='Am Al editable LW-avf']")
    private WebElement newMailBodyField;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement newMailSendButton;

    @FindBy(xpath = "//span[@class='bAq'][contains(text(),'Письмо отправлено')]")//div[@class='b8 UC bAp']//div[@class='vh']
    private WebElement newMailSentMessage;

    NewLetterPage(){
        super();
    }

    public NewLetterPage fillNewMailToField(String to){
        newMailToField.sendKeys(to);
        logger.info("MailTo field filled");
        return this;
    }

    public NewLetterPage fillNewMailSubjectField(String subject){
        newMailSubjectField.sendKeys(subject);
        logger.info("Subject field filled");
        return this;
    }

    public NewLetterPage fillNewMailBodyField(String body){
        newMailBodyField.sendKeys(body);
        logger.info("MailBody field filled");
        return this;
    }

    public InboxPage clickNewMailSendButton(){
        newMailSendButton.click();
        logger.info("Send button click");
        logger.info("Waiting for message about successful sending");
        (new WebDriverWait(Driver.getDriver(), 5)).until(ExpectedConditions
                .visibilityOf(newMailSentMessage));
        logger.info("Message about successful sending appeared");
        return new InboxPage();
    }
}
