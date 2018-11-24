package Page.POTest;

import Page.page.QuotationPage;
import Page.page.stockDetailsPage;
import org.junit.After;
import org.junit.Test;
import Page.page.xueqiu;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class xueqiuPO {

   private xueqiu xq= new xueqiu();
   private stockDetailsPage details = new stockDetailsPage();
   private QuotationPage quotationPage = new QuotationPage();


   @Parameterized.Parameters()
   public static Collection<String []> getParams(){
       return Arrays.asList(new String[][]{
               {"中国平安","1"},
               {"",""}

       });
   }

    @Test
    public void testloginWithPO(){
       if(xq.ok !=null)
           xq.ok.click();
       xq.search.click();
       xq.inputText.sendKeys("小米");
       xq.stock.click();
       details.addZiXuan.click();
   }

   @Test
   public void testSwip(){
       if(xq.ok !=null)
           xq.ok.click();
       QuotationPage quotationPage = xq.clickQuotation();
       quotationPage.clickNewStockDetail();


   }

    @After
    public void tearDown(){
        xq.quitPage();
    }
}
