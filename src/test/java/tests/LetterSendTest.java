package tests;

import data.Data;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;
import services.ExternalService;
import services.InternalService;

public class LetterSendTest extends BaseTest{

    private ExternalService externalService = new ExternalService();
    private InternalService internalService = new InternalService();

    @Test(description = "Letter sending test", groups = "letterSending")
    public void mailLetterSending(){
        internalService.sendNewLetter(Data.EMAIL, Data.SUBJECT, Data.MAIL_BODY);
    }

    @AfterGroups(groups = "letterSending")
    public void logoutAfterTest(){
        internalService.logoutFromEmailBox();
    }
}
