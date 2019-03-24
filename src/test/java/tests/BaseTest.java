package tests;

import driver.DriverSingleton;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    @BeforeTest(description = "Add implicitly wait and maximize window")
    public void addImplicitly(){
        DriverSingleton.getDriver()
                .manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverSingleton.getDriver()
                .manage().window().maximize();
    }

    @AfterTest(description = "Close browser")
    public void afterSuite(){
        DriverSingleton.getDriver().quit();
    }
}