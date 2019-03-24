package pages;

import data.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends Page {

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

    @FindBy(xpath = "//div[@aria-label='Удалить']")// bad xpath
    private WebElement menuDeletePic;

    public InboxPage(){
        super();
    }

    public PasswordFormPage doLogout(){
        accountMenu.click();
        System.out.println("Go to account menu");
        exitButton.click();
        System.out.println("Press exit button");
        return new PasswordFormPage();
    }

    public String getEmailAddress(){
        String address;
        accountMenu.click();
        System.out.println("Go to account menu");
        address = emailAddress.getText();
        System.out.println("Checking account");
        return address;
    }

    public NewLetterPage createNewLetter(){
        createNewLetterButton.click();
        System.out.println("Create a new letter");
        return new NewLetterPage();
    }

    public boolean isLetterSent(){
        return isElementPresent(mailSubjectForCheck);
    }

    public InboxPage cleanAfterTest(){
        checkboxForDelete.click();
        menuDeletePic.click();
        return new InboxPage();
    }
}