package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.ExternalService;
import services.InternalService;

public class InboxTest extends BaseTest {

    private ExternalService externalService = new ExternalService();
    private InternalService internalService = new InternalService();

    private final String URL = "https://gmail.com/";
    private final String EMAIL = "davidovich.dn.tests@gmail.com";
    private final String PASSWORD = "n4nPLCzqit3wCv5";
    private final String SUBJECT = "test letter";
    private final String MAIL_BODY = "some text for mail body";

    @BeforeMethod(description = "Preparation for logout")
    public void logoutPreparations(){
        externalService.openPage(URL);
        externalService.loginToEmailBox(EMAIL, PASSWORD);
    }

    @Test(description = "Logout check", groups = "logout")
    public void tst_mailLogout(){
        internalService.logoutFromEmailBox();
        internalService.checkIsLogoutSuccessful();
    }

    @Test(description = "Letter sending test", groups = "letterSending")
    public void tst_mailLetterSending(){
        internalService.sendNewLetter(EMAIL, SUBJECT, MAIL_BODY);
    }

    @AfterGroups("letterSending")
    public void logoutAfterTest(){
        internalService.logoutFromEmailBox();
    }
}
