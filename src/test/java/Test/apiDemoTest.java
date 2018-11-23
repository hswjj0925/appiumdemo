package Test; /**
 * Created by wangjiajia on 18/10/20.
 */

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class apiDemoTest {

    private AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "aaa");
        desiredCapabilities.setCapability("udid", "192.168.56.101:5555");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.example.android.apis");
        desiredCapabilities.setCapability("appActivity", ".ApiDemos");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("chromedriverExecutable", "/Users/wangkai/wjjWorkSpace/chromedriver/2.11/chromedriver");
//        desiredCapabilities.setCapability("chromedriverExecutableDir", "/Users/wangkai/wjjWorkSpace/chromedriver/2.12/");


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);//url和capability生成driver
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void testToast(){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"Views\")").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"Popup Menu\")").click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Make a Popup!']"))).click();

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Edit\")").click();
        System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
    }

    @Test
    public void testWebView(){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"Views\")").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"WebView\")").click();
        System.out.println(driver.getContextHandles());//获得上下文


        driver.context("WEBVIEW_com.example.android.apis");

        List<WebElement> list = driver.findElementsByXPath("//*");
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i).getTagName());
            System.out.println(list.get(i).getText());
        }

    }


    @After
    public void tearDown(){
        driver.quit();
    }

    public static class Test2 {

        private AndroidDriver driver;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("deviceName", "aaa");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("udid", "192.168.56.101:5555");
            desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
            desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
            desiredCapabilities.setCapability("unicodeKeyboard", true);//设置允许中文输入
    //        desiredCapabilities.setCapability("automationName", "UiAutomator2");
            desiredCapabilities.setCapability("resetKeyboard", true);//重置输入法

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        @Test
        public void Test() {
            driver.findElementById("home_search").click();
            driver.findElementById("search_input_text").sendKeys("小米");
            ((MobileElement)driver.findElementsByXPath("//*[@text='股票' and @instance='2']").get(0)).click();//返回的是个list
            ((MobileElement)driver.findElementsByXPath("//*[@text='小米集团-W']").get(0)).click();
        }

        @After
        public void tearDown() {
            driver.quit();

        }
    }
}
