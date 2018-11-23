package Page.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory
{
    private static AppiumDriver driver;

    public static AppiumDriver getXueQiuDriver() throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "aaa");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        //desiredCapabilities.setCapability("udid", "Q8WDU16114009330");
        desiredCapabilities.setCapability("unicodeKeyboard", true);
        desiredCapabilities.setCapability("resetKeyboard", true);


        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        try {
            driver = new AndroidDriver(remoteUrl, desiredCapabilities);//url和capability生成driver
        }
        catch (Exception e){
            e.printStackTrace();
        }
        driver.manage().timeouts()
                .implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }


}
