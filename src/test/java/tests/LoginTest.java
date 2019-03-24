package tests;

import data.Data;
import org.testng.annotations.Test;
import services.ExternalService;
import services.InternalService;

public class LoginTest extends BaseTest{

    private ExternalService externalService = new ExternalService();
    private InternalService internalService = new InternalService();

    @Test(description = "Login to gmail with e-mail address check", groups = "login")
    public void tst_mailLogInWithEmail(){
        externalService.openPage(Data.URL);
        externalService.loginToEmailBox(Data.EMAIL, Data.PASSWORD);
        internalService.checkIsLoginSuccessful(Data.EMAIL);
    }

    @Test(description = "Login to gmail with login check", groups = "login")
    public void tst_mailLogInWithLogin(){
        externalService.openPage(Data.URL);
        externalService.loginToEmailBox(Data.LOGIN, Data.PASSWORD);
        internalService.checkIsLoginSuccessful(Data.EMAIL);
    }
}