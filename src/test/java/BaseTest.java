import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() throws MalformedURLException {
        String host = "localhost";
        DesiredCapabilities dc;
        if (System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = new DesiredCapabilities("firefox", "108.0", Platform.LINUX);
        }
        else {
            dc = new DesiredCapabilities("chrome", "108.0", Platform.LINUX);
        }
        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }
        driver = new RemoteWebDriver(new URL("http://"+host+":4444/wd/hub"), dc);
    }
}
