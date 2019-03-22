package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.EnteringService;

public class LoginTest extends BaseTest{

    private EnteringService enteringService = new EnteringService();



    private final String URL = "https://gmail.com/";
    private final String LOGIN = "davidovich.dn.tests";
    private final String PASSWORD = "n4nPLCzqit3wCv5";
    private final String EMAIL = "davidovich.dn.tests@gmail.com";

    @Test(description = "Login to gmail")
    public void tst_mailSignIn(){
        enteringService.openPage(URL);
        enteringService.loginToEmailBox(LOGIN, PASSWORD);

        String userEmail = new LoginPage()
                .nameInput(LOGIN)
                .passwordInput(PASSWORD)
                .getUserAddressText();

        Assert.assertEquals(userEmail, LOGIN + "@gmail.com");
    }

}