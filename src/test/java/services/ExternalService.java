package services;

import pages.InboxPage;
import pages.LoginFormPage;

public class ExternalService {

    private InboxPage inboxPage;

    public void openPage(String url) {
        new LoginFormPage().openLoginPage(url);
    }

    public void loginToEmailBox(String login, String password) {
        inboxPage = new LoginFormPage().startLogin(login).continueLogin(password);
    }
}
