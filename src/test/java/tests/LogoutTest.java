package tests;

import data.Data;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.ExternalService;
import services.InternalService;

public class LogoutTest extends BaseTest{

    private ExternalService externalService = new ExternalService();
    private InternalService internalService = new InternalService();

    @BeforeMethod(description = "Preparation for logout")
    public void logoutPreparations(){
        externalService.openPage(Data.URL);
        externalService.loginToEmailBox(Data.EMAIL, Data.PASSWORD);
    }

    @Test(description = "Logout check", groups = "logout")
    public void mailLogout(){
        internalService.logoutFromEmailBox();
        internalService.checkIsLogoutSuccessful();
    }
}
