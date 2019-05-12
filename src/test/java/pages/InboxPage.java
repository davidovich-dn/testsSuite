package pages;

import data.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends Page {

    private static final Logger logger = LogManager.getRootLogger();

    private final String lineToLoccator = "//div[@class='y6']/span[contains(.,'" + Data.SUBJECT + "')]";

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement createNewLetterButton;

    @FindBy(xpath = "//a[@class='gb_x gb_Da gb_f']")
    private WebElement accountMenu;

    @FindBy(xpath = "//div[@class='gb_db']")
    private WebElement emailAddress;

    @FindBy(xpath = "//a[@id='gb_71']")
    private WebElement exitButton;

    @FindBy(xpath = "//span[@email='davidovich.dn.tests@gmail.com']")
    private WebElement letter;

    @FindBy(xpath = lineToLoccator)
    private WebElement mailSubjectForCheck;

    @FindBy(xpath = "//div[@role='checkbox']")
    private WebElement checkboxForDelete;

    @FindBy(xpath = "//div[@class='asa']")
    private WebElement menuDeleteButton;

    public InboxPage(){
        super();
    }

    public PasswordFormPage doLogout(){
        accountMenu.click();
        logger.info("Go to account menu");
        exitButton.click();
        logger.info("Press exit button");
        return new PasswordFormPage();
    }

    public String getEmailAddress(){
        String address;
        accountMenu.click();
        logger.info("Go to account menu");
        address = emailAddress.getText();
        logger.info("Getting e-mail address");
        accountMenu.click();
        logger.info("Close account menu");
        return address;
    }

    public NewLetterPage createNewLetter(){
        createNewLetterButton.click();
        logger.info("Create a new letter");
        return new NewLetterPage();
    }

    public boolean isLetterSent(){
        logger.info("Looking for received letter");
        return isElementPresent(mailSubjectForCheck);
    }

    public InboxPage cleanAfterTest(){
        logger.info("Start cleaning");
        checkboxForDelete.click();
        logger.info("Check letter");
        menuDeleteButton.click();
        logger.info("The letter goes to a trash can");
        return new InboxPage();
    }
}