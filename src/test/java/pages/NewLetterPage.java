package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewLetterPage extends Page {

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement newMailToField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement newMailSubjectField;

    @FindBy(xpath = "//div[@class ='Am Al editable LW-avf']")
    private WebElement newMailBodyField;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement newMailSendButton;

    public NewLetterPage(){
        super();
    }

    public NewLetterPage fillNewMailToField(String to){
        newMailToField.sendKeys(to);
        return this;
    }

    public NewLetterPage fillNewMailSubjectField(String subject){
        newMailSubjectField.sendKeys(subject);
        return this;
    }

    public NewLetterPage fillNewMailBodyField(String body){
        newMailBodyField.sendKeys(body);
        return this;
    }

    public InboxPage clickNewMailSendButton(){
        newMailSendButton.click();
        return new InboxPage();
    }
}
