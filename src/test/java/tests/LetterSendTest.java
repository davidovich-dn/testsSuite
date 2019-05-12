package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LetterSendTest extends BaseTest{

    @BeforeMethod(description = "Preparation for letter sending")
    public void logoutPreparations(){
        Data.SERVICE.loginToEmailBox(Data.URL, Data.EMAIL, Data.PASSWORD);
    }

    @Test(description = "Letter sending test")
    public void mailLetterSending() {
        Data.SERVICE.sendNewLetter(Data.EMAIL, Data.SUBJECT, Data.MAIL_BODY);
        Assert.assertTrue(Data.SERVICE.checkIsNewLetterReceived(), "Letter has not been sent");
    }

    @AfterMethod(description = "Logout")
    public void logoutAfterTest() {
        Data.SERVICE.cleanAfterTestThrow();
        Data.SERVICE.logoutFromEmailBox();
    }
}
