package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "Login to Gmail using e-mail address")
    public void mailLogIn(){
        Data.SERVICE.loginToEmailBox(Data.URL, Data.EMAIL, Data.PASSWORD);
        Assert.assertEquals(Data.EMAIL, Data.SERVICE.emailForCheckThrowing(), "Check has failed");
    }

    @AfterTest(description = "Logout")
    public void logoutAfterTest() {
        Data.SERVICE.logoutFromEmailBox();
    }
}