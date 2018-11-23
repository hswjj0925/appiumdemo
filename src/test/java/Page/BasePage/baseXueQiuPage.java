package Page.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;
import org.openqa.selenium.support.PageFactory;
import Page.Driver.DriverFactory;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class baseXueQiuPage {
    public static AppiumDriver driver;

    static {
        try {
            driver = DriverFactory.getXueQiuDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //超时时间
    private final int TIMEOUT = 10;
    TimeOutDuration timeOutDuration = new TimeOutDuration(10, TimeUnit.SECONDS);

    public baseXueQiuPage(){
        //初始化所有元素
        System.out.println("initEelments ");
        PageFactory.initElements(new AppiumFieldDecorator(driver,timeOutDuration) , this);
        System.out.println(this.getClass() + " init sucess");
    }

    public void quitPage(){
        driver.quit();
    }
}
