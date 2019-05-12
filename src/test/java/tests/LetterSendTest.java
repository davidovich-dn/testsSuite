package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LetterSendTest extends BaseTest{

    @BeforeTest(description = "Preparation for letter sending")
    public void logoutPreparations(){
        Data.SERVICE.loginToEmailBox(Data.URL, Data.EMAIL, Data.PASSWORD);
    }

    @Test(description = "Letter sending test")
    public void mailLetterSending() {
        Data.SERVICE.sendNewLetter(Data.EMAIL, Data.SUBJECT, Data.MAIL_BODY);
        Assert.assertTrue(Data.SERVICE.checkIsNewLetterReceived(), "Letter has not been sent");
    }

    @AfterTest(description = "Logout")
    public void logoutAfterTest() {
        Data.SERVICE.cleanAfterTestThrow();
        Data.SERVICE.logoutFromEmailBox();
    }
}
