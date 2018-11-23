package Page.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import Page.BasePage.baseXueQiuPage;
import org.openqa.selenium.WebElement;


public class xueqiu extends baseXueQiuPage {

    //个人中心小牛按钮
    @AndroidFindBy(id="user_profile_container")
    public  MobileElement user;

    //登陆按钮，测试用，理论上应该放在登陆Page
    @AndroidFindBy(id="tv_login")
    public  MobileElement login;

    //主页搜索按钮
    @AndroidFindBy(id="home_search")
    public MobileElement search;

    //输入文本框
    @AndroidFindBy(id="search_input_text")
    public MobileElement inputText;

    //选择股票
    @AndroidFindBy(xpath = "//*[@text=\"小米集团-W\" and @resource-id = \"com.xueqiu.android:id/stockName\"]")
    public MobileElement stock;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"行情\")")
    private WebElement btnFour;

    public QuotationPage clickQuotation(){
        btnFour.click();
        return new QuotationPage();
    }

}
