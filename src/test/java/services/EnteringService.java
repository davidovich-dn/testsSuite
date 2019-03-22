package services;

import pages.InboxPage;
import pages.LoginPage;

public class EnteringService {

    private InboxPage inboxPage;

    public void openPage(String url) {
        new LoginPage().openLoginPage(url);
    }

    public void loginToEmailBox(String userName, String password) {
        inboxPage = new LoginPage().doLogin(userName, password);
    }
}
