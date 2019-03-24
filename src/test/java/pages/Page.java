package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import driver.DriverSingleton;

abstract class Page {

    Page()
    {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }

    boolean isElementPresent(WebElement element) {
        boolean result;
        try {
            result = element.isDisplayed();
        } catch (NoSuchElementException e) {
            result = false;
        }
        return result;
    }
}