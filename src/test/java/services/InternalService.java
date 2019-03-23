package services;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.InboxPage;
import pages.LoginFormPage;
import pages.PasswordFormPage;

public class InternalService {

    private InboxPage inboxPage;
    private PasswordFormPage passwordFormPage;

    public void checkIsLoginSuccessful(String email) {
        inboxPage = new InboxPage();
        Assert.assertEquals(inboxPage.getEmailAddress(), email, "Check has failed");
    }

    public void logoutFromEmailBox(){
        passwordFormPage = new InboxPage().doLogout();
    }

    public void checkIsLogoutSuccessful(){
        passwordFormPage = new PasswordFormPage();
        Assert.assertEquals(passwordFormPage.isElementLoginInputFieldPresent(), true, "No such element: loginInputField");
    }
}