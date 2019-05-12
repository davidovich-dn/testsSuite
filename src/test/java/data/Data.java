package data;

import services.Service;

public class Data {

    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String CHROMEDRIVER_EXE_PATH = "./src/test/resources/chromedriver.exe";

    public static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    public static final String GECKODRIVER_EXE_PATH = "./src/test/resources/geckodriver.exe";

    public static final String URL = "https://gmail.com/";
    public static final String EMAIL = "davidovich.dn.tests@gmail.com";
    public static final String PASSWORD = "n4nPLCzqit3wCv5";
    public static final String SUBJECT = "test letter";
    public static final String MAIL_BODY = "some text for mail body";

    public static final Service SERVICE = new Service();
}
