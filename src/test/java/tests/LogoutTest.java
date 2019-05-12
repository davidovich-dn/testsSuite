package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @BeforeMethod(description = "Preparation for logout")
    public void logoutPreparations(){
        Data.SERVICE.loginToEmailBox(Data.URL, Data.EMAIL, Data.PASSWORD);
    }

    @Test(description = "Logout check")
    public void mailLogout() {
        Data.SERVICE.logoutFromEmailBox();
        Assert.assertTrue(Data.SERVICE.isElementLoginInputFieldPresentThrowing(), "No such element: loginInputField");
    }
}
