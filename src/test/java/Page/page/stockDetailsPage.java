package Page.page;

import Page.BasePage.baseXueQiuPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class stockDetailsPage extends baseXueQiuPage {
    //加自选按钮
    @AndroidFindBy(xpath = "//*[@text=\"加自选\" and @class = \"android.widget.TextView\"]")
    public MobileElement addZiXuan;

}
