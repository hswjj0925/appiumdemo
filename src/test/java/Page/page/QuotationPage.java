package Page.page;
import Page.BasePage.baseXueQiuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class QuotationPage extends baseXueQiuPage{

//@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"新股行情\")")

    @AndroidFindBy(xpath = "//*[@text=\"新股行情\"]")
    private WebElement newStockDetail;

public void clickNewStockDetail(){
    newStockDetail.click();
}


}
