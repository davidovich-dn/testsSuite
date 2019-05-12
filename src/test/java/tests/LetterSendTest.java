package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LetterSendTest extends BaseTest{

    @BeforeMethod(description = "Preparation for letter sending")
    public void logoutPreparations(){
        Data.EXTERNAL_SERVICE.loginToEmailBox(Data.URL, Data.EMAIL, Data.PASSWORD);
    }

    @Test(description = "Letter sending test")
    public void mailLetterSending() throws InterruptedException {
        Data.INTERNAL_SERVICE.sendNewLetter(Data.EMAIL, Data.SUBJECT, Data.MAIL_BODY);
        Thread.sleep(2000);// not a good idea, but...
        Assert.assertTrue(Data.INTERNAL_SERVICE.checkIsNewLetterReceived(), "Letter has not been sent");
    }

    @AfterMethod(description = "Logout")
    public void logoutAfterTest(){
        //internalService.cleanAfterTestThrow(); - think about cleaning
        Data.INTERNAL_SERVICE.logoutFromEmailBox();
        //Data.EXTERNAL_SERVICE.logoutFromEmailBox();
    }
}
