package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends Page {

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement createNewLetterButton;

    @FindBy(xpath = "//a[@class='gb_x gb_Da gb_f']")
    private WebElement accountMenu;

    @FindBy(xpath = "//div[@class='gb_db']")
    private WebElement emailAddress;

    @FindBy(xpath = "//a[@id='gb_71']")
    private WebElement exitButton;

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
        return new NewLetterPage();
    }
}