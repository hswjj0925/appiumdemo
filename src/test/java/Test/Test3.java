package Test; /**
 * 作业3：行情 -> 版块 -> 食品饮料(理解为第一个板块) -> 滚动到最后 -> 选择最后一个股票
 */

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Page.page.xueqiu;

public class Test3 {
    private AndroidDriver driver;
    xueqiu xx = new xueqiu();

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "aaa");
        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("app", "/Users/wangkai/wjjWorkSpace/xueqiu/com.xueqiu.android_11.7_182.apk");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
//        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
//        desiredCapabilities.setCapability("unicodeKeyboard", true);//设置允许中文输入
//        desiredCapabilities.setCapability("resetKeyboard", true);//重置输入法
//        desiredCapabilities.setCapability("avd", "hogwartz7");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");


        driver = new AndroidDriver(remoteUrl, desiredCapabilities);//url和capability生成driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver,10);
    }

    @Test
    public void Test() {
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"行情\")").click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='板块'and @resource-id='com.xueqiu.android:id/text']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.xueqiu.android:id/row_1_column_1' and @instance=14]"))).click();

        int height = driver.manage().window().getSize().getHeight();//获得屏幕高
        int width = driver.manage().window().getSize().getWidth();//获得屏幕宽

        System.out.println(height);
        System.out.println(width);

        //获得当前页面最后一只股票名
        List<MobileElement> list = driver.findElementsByXPath("//*[@resource-id='com.xueqiu.android:id/stock_name']");
        String lastStock = list.get(list.size()-1).getText();
        System.out.println(lastStock);

        //boolean flag = true;//是否继续滑动标记
        String nowLastStock;//新页面的最后一只股票名
        List<MobileElement> newList;//用于临存页面元素
        System.out.println("aaaaa");

//        System.out.println(driver.getPageSource());

        while(true)
        {
            System.out.println("bbbbb");
            new TouchAction(driver)
                    .press(PointOption.point(width/2,height*5/6))
                    .moveTo(PointOption.point(width/2,height/2))
                    .release()
                    .perform();
            System.out.println("cccc");

            newList=driver.findElementsByXPath("//*[@resource-id='com.xueqiu.android:id/stock_name']");
            nowLastStock = newList.get(newList.size()-1).getText();
            if(nowLastStock.equals(lastStock))//相等的话说明已经滑到底
            {
                System.out.println(nowLastStock);//打印底部最后一个股票名
                break;
            }
            lastStock=nowLastStock;//新的页面最后股票名赋值
        }


    }

    @Test
    public void teatlogin(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.xueqiu.android:id/user_profile_container"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.xueqiu.android:id/tv_login"))).click();
        AndroidElement element = (AndroidElement) driver.findElement(By.id("com.xueqiu.android:id/service_agreement"));
        Assert.assertEquals(element.getText(),"注册即代表同意 雪球服务协议");

    }



    @Test
    public void msg(){
        driver.sendSMS("18610648684","nihao");
//
    }

    @Test
    public void Cover(){

        driver.removeApp("com.xueqiu.android");//卸载
        driver.installApp("/Users/wangkai/wjjWorkSpace/xueqiu/com.xueqiu.android_11.8.2_185.apk");//安装
        driver.launchApp();

    }
    @Test
    public void testBrowser(){
        driver.get("https://testerh.ke.qq.com");

    }

    @After
    public void tearDown() {
        driver.quit();

    }

}
