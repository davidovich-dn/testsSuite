package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends AbstractPage{

    @FindBy(xpath = "//a[@class='gb_x gb_Da gb_f']")
    private WebElement accountMenu;

    @FindBy(xpath = "//div[@class='gb_db']")
    private WebElement emailAddress;

    @FindBy(xpath = "")
    private WebElement exitButton;

    public InboxPage(){
        super();
    }

    public InboxPage goToAccountMenu(){
        accountMenu.click();
        System.out.println("Go to account menu");
        return this;
    }

    public String getEmailAddress(){
        String address;
        accountMenu.click();
        System.out.println("Go to account menu");
        address = emailAddress.getText();
        System.out.println("Checking account");
        return address;
    }
}