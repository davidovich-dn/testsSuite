package data;

import services.ExternalService;
import services.InternalService;

public class Data {

    public static final String URL = "https://gmail.com/";
    public static final String EMAIL = "davidovich.dn.tests@gmail.com";
    public static final String PASSWORD = "n4nPLCzqit3wCv5";
    public static final String SUBJECT = "test letter";
    public static final String MAIL_BODY = "some text for mail body";

    public static final ExternalService EXTERNAL_SERVICE = new ExternalService();
    public static final InternalService INTERNAL_SERVICE = new InternalService();
}
