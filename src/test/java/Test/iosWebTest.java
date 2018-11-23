package Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class iosWebTest {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "IOS");
        desiredCapabilities.setCapability("deviceName", "iphone7");
        desiredCapabilities.setCapability("platformVersion", "12.0");
        //desiredCapabilities.setCapability("browserName", "Safari");
        desiredCapabilities.setCapability("bundleId", "com.xueqiu");

        desiredCapabilities.setCapability("automationName", "xcuitest");
        desiredCapabilities.setCapability("udid", "f473f8c1acb6d210ae41486d74b9268f2d5a4255");
        desiredCapabilities.setCapability("usePrebuiltWDA", "true");
//        desiredCapabilities.setCapability("startIWDP", "true");
        desiredCapabilities.setCapability("xcodeOrgId", "5C898952CK");
        desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new IOSDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testWeb()  {
        driver.get("http://testerhome.com");
        driver.findElementByXPath("//*[contains(@title,'广州沙龙')]").click();
    }

    @Test
    public void testWebView(){
        driver.findElementByXPath("//XCUIElementTypeButton[@name='交易']").click();
        System.out.println(driver.getContextHandles());
        driver.context("WEBVIEW_3");
        System.out.println(driver.getPageSource());
    }
    @After
    public void tearDown() {
//        driver.quit();
    }
}
