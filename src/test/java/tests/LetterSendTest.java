package tests;

import data.Data;
import driver.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.ExternalService;
import services.InternalService;

import java.util.concurrent.TimeUnit;

public class LetterSendTest extends BaseTest{

    private ExternalService externalService = new ExternalService();
    private InternalService internalService = new InternalService();

    @BeforeMethod(description = "Preparation for logout")
    public void logoutPreparations(){
        externalService.openPage(Data.URL);
        externalService.loginToEmailBox(Data.EMAIL, Data.PASSWORD);
    }

    @Test(description = "Letter sending test", groups = "letterSending")
    public void mailLetterSending() throws InterruptedException {
        internalService.sendNewLetter(Data.EMAIL, Data.SUBJECT, Data.MAIL_BODY);
        Thread.sleep(2000);
        Assert.assertTrue(internalService.checkIsNewLetterReceived(), "Letter has not been sent");
    }

    @AfterGroups(groups = "letterSending")
    public void logoutAfterTest(){
        //internalService.cleanAfterTestThrow(); - think about cleaning
        internalService.logoutFromEmailBox();
    }
}
