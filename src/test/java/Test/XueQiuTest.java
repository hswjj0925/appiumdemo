package Test; /**
 * 搜索 -> 输入小米 -> 点击股票类型 -> 点击小米
 **/

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
//import appium.webdriver.common.touch_action;



import org.openqa.selenium.remote.DesiredCapabilities;

public class XueQiuTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "192.168.56.101:555");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("unicodeKeyBoard", "true");//允许中文输入
        desiredCapabilities.setCapability("resetKeyboard", "true");//重置输入法


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() {

        ((MobileElement) driver.findElementById("com.xueqiu.android:id/tab_icon")).click();

        ((MobileElement) driver.findElementById("com.xueqiu.android:id/text")).click();

        ((MobileElement) driver.findElementById("com.xueqiu.android:id/row_1_column_1")).click();





    }

    @After
    public void tearDown() {
        driver.quit();
    }
}