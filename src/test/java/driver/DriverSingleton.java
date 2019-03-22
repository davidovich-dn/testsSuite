package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            setDriver();
        }
        return driver;
    }

    private static void setDriver(){
        System.setProperty("webdriver.chrome.driver",
                "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
}