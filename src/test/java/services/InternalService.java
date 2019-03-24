package services;

import org.testng.Assert;
import pages.*;

public class InternalService {

    private InboxPage inboxPage;
    private PasswordFormPage passwordFormPage;
    private LoginFormPage loginFormPage;

    public String emailForCheckThrowing(){
        inboxPage = new InboxPage();
        String s = inboxPage.getEmailAddress();
        return s;
    }

    public void logoutFromEmailBox(){
        passwordFormPage = new InboxPage().doLogout();
    }

    public void checkIsLogoutSuccessful(){
        passwordFormPage = new PasswordFormPage();
        Assert.assertEquals(passwordFormPage.isElementPasswordInputFieldPresent(), true, "No such element: loginInputField");
    }

    public void sendNewLetter(String to, String subject, String body){
        inboxPage = new InboxPage()
                .createNewLetter()
                .fillNewMailToField(to)
                .fillNewMailSubjectField(subject)
                .fillNewMailBodyField(body)
                .clickNewMailSendButton();
    }

    public void checkIsNewLetterReceived(){
        inboxPage = new InboxPage();
        //Assert.assertEquals(inboxPage.);
    }
}