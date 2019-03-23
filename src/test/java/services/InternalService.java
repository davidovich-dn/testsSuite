package services;

import org.testng.Assert;
import pages.InboxPage;

public class InternalService {

    private InboxPage inboxPage;

    public void checkIsLoginSuccessful(String email) {
        inboxPage = new InboxPage();
        Assert.assertEquals(inboxPage.getEmail(), email, "Login has failed");
    }
}