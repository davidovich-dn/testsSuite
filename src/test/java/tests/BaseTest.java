package tests;

import driver.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {

    @BeforeSuite(description = "Start browser")
    public void beforeTest(){
        Driver.getDriver();
    }

    @AfterSuite(description = "Close browser")
    public void afterTest(){
        Driver.closeDriver();
    }
}