package tests;

import org.testng.annotations.Test;
import services.ExternalService;
import services.InternalService;

public class LoginTest extends BaseTest{

    private ExternalService externalService = new ExternalService();
    private InternalService internalService = new InternalService();

    private final String URL = "https://gmail.com/";
    private final String LOGIN = "davidovich.dn.tests";
    private final String EMAIL = "davidovich.dn.tests@gmail.com";
    private final String PASSWORD = "n4nPLCzqit3wCv5";

    @Test(description = "Login to gmail with e-mail address check", groups = "login")
    public void tst_mailLogInWithEmail(){
        externalService.openPage(URL);
        externalService.loginToEmailBox(EMAIL, PASSWORD);
        internalService.checkIsLoginSuccessful(EMAIL);
    }

    @Test(description = "Login to gmail with login check", groups = "login")
    public void tst_mailLogInWithLogin(){
        externalService.openPage(URL);
        externalService.loginToEmailBox(LOGIN, PASSWORD);
        internalService.checkIsLoginSuccessful(EMAIL);
    }
}