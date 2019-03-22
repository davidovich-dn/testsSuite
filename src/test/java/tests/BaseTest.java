package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import driver.DriverSingleton;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    @BeforeSuite(description = "Add implicitly wait and maximize window")
    public void addImplicitly(){
        DriverSingleton.getDriver()
                .manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverSingleton.getDriver()
                .manage().window().maximize();
    }

    @AfterSuite(description = "Stop browser")
    public void afterSuite(){
        DriverSingleton.getDriver().quit();
    }
}