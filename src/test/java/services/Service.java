package services;

import org.testng.Assert;
import pages.InboxPage;
import pages.LoginFormPage;
import pages.PasswordFormPage;

public class Service {

    private LoginFormPage loginFormPage;

    public void loginToEmailBox(String url, String login, String password) {
        new LoginFormPage().openLoginPage(url).startLogin(login).continueLogin(password);
    }

    public void logoutFromEmailBox(){
        loginFormPage = new PasswordFormPage().goToLoginFormPage();
    }


    private InboxPage inboxPage;
    private PasswordFormPage passwordFormPage;

    public String emailForCheckThrowing(){
        inboxPage = new InboxPage();
        return inboxPage.getEmailAddress();
    }

//    public void logoutFromEmailBox(){
//        passwordFormPage = new InboxPage().doLogout();
//    }

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
