package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "Login to gmail using e-mail address check")
    public void mailLogInUsingEmail(){
        Data.EXTERNAL_SERVICE.loginToEmailBox(Data.URL, Data.EMAIL, Data.PASSWORD);
        Assert.assertEquals(Data.EMAIL, Data.INTERNAL_SERVICE.emailForCheckThrowing(), "Check has failed");
    }
}