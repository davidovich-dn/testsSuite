package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='gb_db']")
    private WebElement email;

    public InboxPage(){
        super();
    }

    public String getEmail(){
        String address = email.getText();
        return address;
    }
}