package driver;

import data.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    public static WebDriver getDriver(){
        if (driver == null){
            setDriver();
        }
        return driver;
    }

    private static void setDriver(){
        System.setProperty(Data.WEBDRIVER_CHROME_DRIVER,
                Data.CHROMEDRIVER_EXE_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Browser started.");
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
        logger.info("Browser closed.");
    }
}