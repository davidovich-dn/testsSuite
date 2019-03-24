package services;

import pages.LoginFormPage;

public class ExternalService {

    public void loginToEmailBox(String url, String login, String password) {
        new LoginFormPage().openLoginPage(url).startLogin(login).continueLogin(password);
    }
}
