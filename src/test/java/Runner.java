import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();

        final XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("MySuite");
        xmlSuite.setSuiteFiles(new ArrayList<String>() {
            {
                add("./src/test/resources/suites/loginSuite.xml");
                add("./src/test/resources/suites/logoutSuite.xml");
                //add("./src/test/resources/suites/letterSendingSuite.xml");
            }
        });

        testNG.setXmlSuites(new ArrayList<XmlSuite>() {
            {
                add(xmlSuite);
            }
        });

        testNG.run();
    }
}