package services;

import pages.LoginFormPage;
import pages.PasswordFormPage;

public class ExternalService {

    private LoginFormPage loginFormPage;

    public void loginToEmailBox(String url, String login, String password) {
        new LoginFormPage().openLoginPage(url).startLogin(login).continueLogin(password);
    }

    public void logoutFromEmailBox(){
        loginFormPage = new PasswordFormPage().goToLoginFormPage();
    }
}
