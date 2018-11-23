package Test;

import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class iosTest {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "IOS");
        desiredCapabilities.setCapability("deviceName", "iphone7");
        desiredCapabilities.setCapability("platformVersion", "12.0");
        desiredCapabilities.setCapability("bundleId", "com.meituan.itakeaway");
        desiredCapabilities.setCapability("automationName", "xcuitest");
        desiredCapabilities.setCapability("udid", "f473f8c1acb6d210ae41486d74b9268f2d5a4255");
        desiredCapabilities.setCapability("usePrebuiltWDA", "true");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new IOSDriver(remoteUrl, desiredCapabilities);
    }



    @Test
    public void testHomePage(){
        driver.findElementByAccessibilityId("闪购").click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
