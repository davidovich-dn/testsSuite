package services;

import driver.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InboxPage;
import pages.LoginFormPage;

public class Service {

    private static final Logger logger = LogManager.getRootLogger();

    private LoginFormPage loginFormPage;
    private InboxPage inboxPage;

    public void loginToEmailBox(String url, String login, String password) {
        logger.info("Start log in");
        new LoginFormPage().openLoginPage(url).startLogin(login).continueLogin(password);
    }

    public void logoutFromEmailBox() {
        logger.info("Start log out");
        loginFormPage = new InboxPage().doLogout().goToLoginFormPage();
    }

    public String emailForCheckThrowing(){
        inboxPage = new InboxPage();
        return inboxPage.getEmailAddress();
    }

    public boolean isElementLoginInputFieldPresentThrowing(){
        (new WebDriverWait(Driver.getDriver(), 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//input[@id='identifierId']")));
        return loginFormPage.isElementLoginInputFieldPresent();
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
