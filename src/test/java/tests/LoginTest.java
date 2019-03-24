package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import services.ExternalService;
import services.InternalService;

public class LoginTest extends BaseTest{

    private ExternalService externalService = new ExternalService();
    private InternalService internalService = new InternalService();

    @Test(description = "Login to gmail using e-mail address check", groups = "login")
    public void mailLogInUsingEmail(){
        externalService.openPage(Data.URL);
        externalService.loginToEmailBox(Data.EMAIL, Data.PASSWORD);
        Assert.assertEquals(Data.EMAIL, internalService.emailForCheckThrowing(), "Check has failed");
    }
}