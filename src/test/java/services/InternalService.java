package services;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.InboxPage;

public class InternalService {

    private InboxPage inboxPage;

    public void checkIsLoginSuccessful(String email) {
        inboxPage = new InboxPage();
        Assert.assertEquals(inboxPage.getEmailAddress(), email, "Check has failed");
    }

    public void logout(){

    }

    public void checkIsLogoutSuccessful(WebElement element){

    }
}