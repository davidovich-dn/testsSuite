package services;

import org.testng.Assert;
import pages.*;

public class InternalService {

    private InboxPage inboxPage;
    private PasswordFormPage passwordFormPage;

    public String emailForCheckThrowing(){
        inboxPage = new InboxPage();
        return inboxPage.getEmailAddress();
    }

    public void logoutFromEmailBox(){
        passwordFormPage = new InboxPage().doLogout();
    }

    public void checkIsLogoutSuccessful(){
        passwordFormPage = new PasswordFormPage();
        Assert.assertTrue(passwordFormPage.isElementPasswordInputFieldPresent(), "No such element: passwordInputField");
    }

    public boolean isElementPasswordInputFieldPresentThrowing(){
        return passwordFormPage.isElementPasswordInputFieldPresent();
    }

    public void sendNewLetter(String to, String subject, String body){
        inboxPage = new InboxPage()
                .createNewLetter()
                .fillNewMailToField(to)
                .fillNewMailSubjectField(subject)
                .fillNewMailBodyField(body)
                .clickNewMailSendButton();
    }

    public boolean checkIsNewLetterReceived(){
        inboxPage = new InboxPage();
        return inboxPage.isLetterSent();
    }

    public InboxPage cleanAfterTestThrow(){
        inboxPage = new InboxPage().cleanAfterTest();
        return inboxPage;
    }
}