package pages;

import org.openqa.selenium.support.PageFactory;
import driver.DriverSingleton;

public abstract class AbstractPage {

    public AbstractPage()
    {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }
}